package rs.ac.singidunum.isa.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.singidunum.isa.app.dto.KategorijaDTO;
import rs.ac.singidunum.isa.app.model.Kategorija;
import rs.ac.singidunum.isa.app.service.KategorijaService;

@Controller
@RequestMapping(path = "/api/kategorija")
public class KategorijaController {
	@Autowired
	KategorijaService kategorijaService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<KategorijaDTO>> getAllPredmet() {
		ArrayList<KategorijaDTO> karte = new ArrayList<KategorijaDTO>();
		for(Kategorija predmet : kategorijaService.findAll()) {
			karte.add(new KategorijaDTO(predmet.getId(), predmet.getNaziv()));
		}
		return new ResponseEntity<Iterable<KategorijaDTO>>(karte, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/kategorijaId}", method = RequestMethod.GET)
	public ResponseEntity<KategorijaDTO> getKarta(@PathVariable("kategorijaId") Long kartaId) {
		Optional<Kategorija> karta = kategorijaService.findOne(kartaId);

		KategorijaDTO tipNastaveDTO;

		if (karta.isPresent()) {
			tipNastaveDTO = new KategorijaDTO(karta.get().getId(), karta.get().getNaziv());
			return new ResponseEntity<KategorijaDTO>(tipNastaveDTO, HttpStatus.OK);
		}
		return new ResponseEntity<KategorijaDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Kategorija> createKarta(@RequestBody Kategorija karta) {
		try {
			kategorijaService.save(karta);
			return new ResponseEntity<Kategorija>(karta, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Kategorija>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{kategorijaId}", method = RequestMethod.PUT)
	public ResponseEntity<Kategorija> updateKarta(@PathVariable("kategorijaId") Long kartaId,
			@RequestBody Kategorija izmenjenaKarta) {
		Kategorija karta = kategorijaService.findOne(kartaId).orElse(null);
		if (karta != null) {
			izmenjenaKarta.setId(kartaId);
			izmenjenaKarta = kategorijaService.save(izmenjenaKarta);
			return new ResponseEntity<Kategorija>(izmenjenaKarta, HttpStatus.OK);
		}
		return new ResponseEntity<Kategorija>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{kategorijaId}", method = RequestMethod.DELETE)
	public ResponseEntity<Kategorija> deleteKarta(@PathVariable("kategorijaId") Long kartaId) {
		if (kategorijaService.findOne(kartaId).isPresent()) {
			kategorijaService.delete(kartaId);
			return new ResponseEntity<Kategorija>(HttpStatus.OK);
		}
		return new ResponseEntity<Kategorija>(HttpStatus.NOT_FOUND);
	}
}