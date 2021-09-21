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

import rs.ac.singidunum.isa.app.dto.RealizacijaPredmetaDTO;
import rs.ac.singidunum.isa.app.model.RealizacijaPredmeta;
import rs.ac.singidunum.isa.app.service.RealizacijaPredmetaService;
@Controller
@RequestMapping(path = "/api/realizacijaPredmeta")
public class RealizacijaPredmetaController {
	@Autowired
	RealizacijaPredmetaService realizacijaPredmetaService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<RealizacijaPredmetaDTO>> getAllKarte() {
		ArrayList<RealizacijaPredmetaDTO> karte = new ArrayList<RealizacijaPredmetaDTO>();
		for(RealizacijaPredmeta karta : realizacijaPredmetaService.findAll()) {
			karte.add(new RealizacijaPredmetaDTO(karta.getId()));
		}
		return new ResponseEntity<Iterable<RealizacijaPredmetaDTO>>(karte, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/realizacijaPredmetaId}", method = RequestMethod.GET)
	public ResponseEntity<RealizacijaPredmetaDTO> getKarta(@PathVariable("realizacijaPredmetaId") Long kartaId) {
		Optional<RealizacijaPredmeta> karta = realizacijaPredmetaService.findOne(kartaId);

		RealizacijaPredmetaDTO tipNastaveDTO;

		if (karta.isPresent()) {
			tipNastaveDTO = new RealizacijaPredmetaDTO(karta.get().getId());
			return new ResponseEntity<RealizacijaPredmetaDTO>(tipNastaveDTO, HttpStatus.OK);
		}
		return new ResponseEntity<RealizacijaPredmetaDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<RealizacijaPredmeta> createKarta(@RequestBody RealizacijaPredmeta karta) {
		try {
			realizacijaPredmetaService.save(karta);
			return new ResponseEntity<RealizacijaPredmeta>(karta, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<RealizacijaPredmeta>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{realizacijaPredmetaId}", method = RequestMethod.PUT)
	public ResponseEntity<RealizacijaPredmeta> updateKarta(@PathVariable("realizacijaPredmetaId") Long kartaId,
			@RequestBody RealizacijaPredmeta izmenjenaKarta) {
		RealizacijaPredmeta karta = realizacijaPredmetaService.findOne(kartaId).orElse(null);
		if (karta != null) {
			izmenjenaKarta.setId(kartaId);
			izmenjenaKarta = realizacijaPredmetaService.save(izmenjenaKarta);
			return new ResponseEntity<RealizacijaPredmeta>(izmenjenaKarta, HttpStatus.OK);
		}
		return new ResponseEntity<RealizacijaPredmeta>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{realizacijaPredmetaId}", method = RequestMethod.DELETE)
	public ResponseEntity<RealizacijaPredmeta> deleteKarta(@PathVariable("realizacijaPredmetaId") Long kartaId) {
		if (realizacijaPredmetaService.findOne(kartaId).isPresent()) {
			realizacijaPredmetaService.delete(kartaId);
			return new ResponseEntity<RealizacijaPredmeta>(HttpStatus.OK);
		}
		return new ResponseEntity<RealizacijaPredmeta>(HttpStatus.NOT_FOUND);
	}
}
