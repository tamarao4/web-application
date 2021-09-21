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

import rs.ac.singidunum.isa.app.dto.IshodDTO;
import rs.ac.singidunum.isa.app.model.Ishod;
import rs.ac.singidunum.isa.app.service.IshodService;
@Controller
@RequestMapping(path = "/api/ishod")
public class IshodController {
	@Autowired
	IshodService predmetService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<IshodDTO>> getAllPredmet() {
		ArrayList<IshodDTO> karte = new ArrayList<IshodDTO>();
		for(Ishod predmet : predmetService.findAll()) {
			karte.add(new IshodDTO(predmet.getId(), predmet.getOpis()));
		}
		return new ResponseEntity<Iterable<IshodDTO>>(karte, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/ishodId}", method = RequestMethod.GET)
	public ResponseEntity<IshodDTO> getKarta(@PathVariable("ishodId") Long kartaId) {
		Optional<Ishod> karta = predmetService.findOne(kartaId);

		IshodDTO tipNastaveDTO;

		if (karta.isPresent()) {
			tipNastaveDTO = new IshodDTO(karta.get().getId(), karta.get().getOpis());
			return new ResponseEntity<IshodDTO>(tipNastaveDTO, HttpStatus.OK);
		}
		return new ResponseEntity<IshodDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Ishod> createKarta(@RequestBody Ishod karta) {
		try {
			predmetService.save(karta);
			return new ResponseEntity<Ishod>(karta, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Ishod>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{ishodId}", method = RequestMethod.PUT)
	public ResponseEntity<Ishod> updateKarta(@PathVariable("predmetId") Long kartaId,
			@RequestBody Ishod izmenjenaKarta) {
		Ishod karta = predmetService.findOne(kartaId).orElse(null);
		if (karta != null) {
			izmenjenaKarta.setId(kartaId);
			izmenjenaKarta = predmetService.save(izmenjenaKarta);
			return new ResponseEntity<Ishod>(izmenjenaKarta, HttpStatus.OK);
		}
		return new ResponseEntity<Ishod>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{ishodId}", method = RequestMethod.DELETE)
	public ResponseEntity<Ishod> deleteKarta(@PathVariable("ishodId") Long kartaId) {
		if (predmetService.findOne(kartaId).isPresent()) {
			predmetService.delete(kartaId);
			return new ResponseEntity<Ishod>(HttpStatus.OK);
		}
		return new ResponseEntity<Ishod>(HttpStatus.NOT_FOUND);
	}
}
