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

import rs.ac.singidunum.isa.app.dto.PohadjanjePredmetaDTO;
import rs.ac.singidunum.isa.app.model.PohadjanjePredmeta;
import rs.ac.singidunum.isa.app.service.PohadjanjepredmetaService;

@Controller
@RequestMapping(path = "/api/pohadjanjepredmeta")
public class PohadjanjePredmetaController {
	@Autowired
	PohadjanjepredmetaService pohadjanjepredmetaService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PohadjanjePredmetaDTO>> getAllKarte() {
		ArrayList<PohadjanjePredmetaDTO> karte = new ArrayList<PohadjanjePredmetaDTO>();
		for(PohadjanjePredmeta karta : pohadjanjepredmetaService.findAll()) {
			karte.add(new PohadjanjePredmetaDTO(karta.getId(), karta.getKonacnaOcena(),null));
		}
		return new ResponseEntity<Iterable<PohadjanjePredmetaDTO>>(karte, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/pohadjanjepredmetaId}", method = RequestMethod.GET)
	public ResponseEntity<PohadjanjePredmetaDTO> getKarta(@PathVariable("pohadjanjepredmetaId") Long kartaId) {
		Optional<PohadjanjePredmeta> karta = pohadjanjepredmetaService.findOne(kartaId);

		PohadjanjePredmetaDTO tipNastaveDTO;

		if (karta.isPresent()) {
			tipNastaveDTO = new PohadjanjePredmetaDTO(karta.get().getId(), karta.get().getKonacnaOcena());
			return new ResponseEntity<PohadjanjePredmetaDTO>(tipNastaveDTO, HttpStatus.OK);
		}
		return new ResponseEntity<PohadjanjePredmetaDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<PohadjanjePredmeta> createKarta(@RequestBody PohadjanjePredmeta karta) {
		try {
			pohadjanjepredmetaService.save(karta);
			return new ResponseEntity<PohadjanjePredmeta>(karta, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{pohadjanjepredmetaId}", method = RequestMethod.PUT)
	public ResponseEntity<PohadjanjePredmeta> updateKarta(@PathVariable("pohadjanjepredmetaId") Long kartaId,
			@RequestBody PohadjanjePredmeta izmenjenaKarta) {
		PohadjanjePredmeta karta = pohadjanjepredmetaService.findOne(kartaId).orElse(null);
		if (karta != null) {
			izmenjenaKarta.setId(kartaId);
			izmenjenaKarta = pohadjanjepredmetaService.save(izmenjenaKarta);
			return new ResponseEntity<PohadjanjePredmeta>(izmenjenaKarta, HttpStatus.OK);
		}
		return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{pohadjanjepredmetaId}", method = RequestMethod.DELETE)
	public ResponseEntity<PohadjanjePredmeta> deleteKarta(@PathVariable("pohadjanjepredmetaId") Long kartaId) {
		if (pohadjanjepredmetaService.findOne(kartaId).isPresent()) {
			pohadjanjepredmetaService.delete(kartaId);
			return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.OK);
		}
		return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.NOT_FOUND);
	}
}
