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


import rs.ac.singidunum.isa.app.dto.PredmetDTO;

import rs.ac.singidunum.isa.app.model.Predmet;

import rs.ac.singidunum.isa.app.service.PredmetService;

@Controller
@RequestMapping(path = "/api/predmet")
public class PredmetController {
	@Autowired
	PredmetService predmetService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PredmetDTO>> getAllPredmet() {
		ArrayList<PredmetDTO> karte = new ArrayList<PredmetDTO>();
		for(Predmet predmet : predmetService.findAll()) {
			karte.add(new PredmetDTO(predmet.getId(), predmet.getNaziv(),predmet.getEspb(),predmet.isObavezan(),predmet.getBrojPredavanja(),predmet.getBrojVezbi(),predmet.getDrugiObliciNastave(),predmet.getIstazivackiRad(),predmet.getOstaliCasovi()));
		}
		return new ResponseEntity<Iterable<PredmetDTO>>(karte, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/predmetId}", method = RequestMethod.GET)
	public ResponseEntity<PredmetDTO> getKarta(@PathVariable("predmetId") Long kartaId) {
		Optional<Predmet> karta = predmetService.findOne(kartaId);

		PredmetDTO tipNastaveDTO;

		if (karta.isPresent()) {
			tipNastaveDTO = new PredmetDTO(karta.get().getId(), karta.get().getNaziv(), karta.get().getEspb(), karta.get().isObavezan(), karta.get().getBrojPredavanja(), karta.get().getBrojVezbi(), karta.get().getBrojVezbi(), karta.get().getIstazivackiRad(), karta.get().getOstaliCasovi());
			return new ResponseEntity<PredmetDTO>(tipNastaveDTO, HttpStatus.OK);
		}
		return new ResponseEntity<PredmetDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Predmet> createKarta(@RequestBody Predmet karta) {
		try {
			predmetService.save(karta);
			return new ResponseEntity<Predmet>(karta, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Predmet>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{predmetId}", method = RequestMethod.PUT)
	public ResponseEntity<Predmet> updateKarta(@PathVariable("predmetId") Long kartaId,
			@RequestBody Predmet izmenjenaKarta) {
		Predmet karta = predmetService.findOne(kartaId).orElse(null);
		if (karta != null) {
			izmenjenaKarta.setId(kartaId);
			izmenjenaKarta = predmetService.save(izmenjenaKarta);
			return new ResponseEntity<Predmet>(izmenjenaKarta, HttpStatus.OK);
		}
		return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{predmetId}", method = RequestMethod.DELETE)
	public ResponseEntity<Predmet> deleteKarta(@PathVariable("predmetId") Long kartaId) {
		if (predmetService.findOne(kartaId).isPresent()) {
			predmetService.delete(kartaId);
			return new ResponseEntity<Predmet>(HttpStatus.OK);
		}
		return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
	}
}
