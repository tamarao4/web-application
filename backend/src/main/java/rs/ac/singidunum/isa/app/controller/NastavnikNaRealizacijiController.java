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

import rs.ac.singidunum.isa.app.dto.NastavnikNaRealizacijiDTO;
import rs.ac.singidunum.isa.app.model.NastavnikNaRealizaciji;
import rs.ac.singidunum.isa.app.service.NastavnikNaRealizacijiService;

@Controller
@RequestMapping(path = "/api/nastavnikNaRealizaciji")
public class NastavnikNaRealizacijiController {
	@Autowired
	NastavnikNaRealizacijiService nastavnikNaRealizacijiService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<NastavnikNaRealizacijiDTO>> getAllKarte() {
		ArrayList<NastavnikNaRealizacijiDTO> karte = new ArrayList<NastavnikNaRealizacijiDTO>();
		for(NastavnikNaRealizaciji karta : nastavnikNaRealizacijiService.findAll()) {
			karte.add(new NastavnikNaRealizacijiDTO(karta.getId(), karta.getBrojCasova(),null,null));
		}
		return new ResponseEntity<Iterable<NastavnikNaRealizacijiDTO>>(karte, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/nastavnikNaRealizacijiId}", method = RequestMethod.GET)
	public ResponseEntity<NastavnikNaRealizacijiDTO> getKarta(@PathVariable("kartaId") Long kartaId) {
		Optional<NastavnikNaRealizaciji> karta = nastavnikNaRealizacijiService.findOne(kartaId);

		NastavnikNaRealizacijiDTO tipNastaveDTO;

		if (karta.isPresent()) {
			tipNastaveDTO = new NastavnikNaRealizacijiDTO(karta.get().getId(), karta.get().getBrojCasova());
			return new ResponseEntity<NastavnikNaRealizacijiDTO>(tipNastaveDTO, HttpStatus.OK);
		}
		return new ResponseEntity<NastavnikNaRealizacijiDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<NastavnikNaRealizaciji> createKarta(@RequestBody NastavnikNaRealizaciji karta) {
		try {
			nastavnikNaRealizacijiService.save(karta);
			return new ResponseEntity<NastavnikNaRealizaciji>(karta, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{nastavnikNaRealizacijiId}", method = RequestMethod.PUT)
	public ResponseEntity<NastavnikNaRealizaciji> updateKarta(@PathVariable("nastavnikNaRealizacijiId") Long kartaId,
			@RequestBody NastavnikNaRealizaciji izmenjenaKarta) {
		NastavnikNaRealizaciji karta = nastavnikNaRealizacijiService.findOne(kartaId).orElse(null);
		if (karta != null) {
			izmenjenaKarta.setId(kartaId);
			izmenjenaKarta = nastavnikNaRealizacijiService.save(izmenjenaKarta);
			return new ResponseEntity<NastavnikNaRealizaciji>(izmenjenaKarta, HttpStatus.OK);
		}
		return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{tipNastaveaId}", method = RequestMethod.DELETE)
	public ResponseEntity<NastavnikNaRealizaciji> deleteKarta(@PathVariable("nastavnikNaRealizacijiId") Long kartaId) {
		if (nastavnikNaRealizacijiService.findOne(kartaId).isPresent()) {
			nastavnikNaRealizacijiService.delete(kartaId);
			return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.OK);
		}
		return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.NOT_FOUND);
	}
}
