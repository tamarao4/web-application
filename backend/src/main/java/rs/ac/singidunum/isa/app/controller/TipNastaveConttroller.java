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

import rs.ac.singidunum.isa.app.dto.TipNastaveDTO;
import rs.ac.singidunum.isa.app.model.TipNastave;
import rs.ac.singidunum.isa.app.service.TipNastaveService;

@Controller
@RequestMapping(path = "/api/tipNastave")
public class TipNastaveConttroller {
	@Autowired
	TipNastaveService tipNastaveService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<TipNastaveDTO>> getAllKarte() {
		ArrayList<TipNastaveDTO> karte = new ArrayList<TipNastaveDTO>();
		for(TipNastave karta : tipNastaveService.findAll()) {
			karte.add(new TipNastaveDTO(karta.getId(), karta.getNaziv()));
		}
		return new ResponseEntity<Iterable<TipNastaveDTO>>(karte, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/tipNastaveId}", method = RequestMethod.GET)
	public ResponseEntity<TipNastaveDTO> getKarta(@PathVariable("kartaId") Long kartaId) {
		Optional<TipNastave> karta = tipNastaveService.findOne(kartaId);

		TipNastaveDTO tipNastaveDTO;

		if (karta.isPresent()) {
			tipNastaveDTO = new TipNastaveDTO(karta.get().getId(), karta.get().getNaziv());
			return new ResponseEntity<TipNastaveDTO>(tipNastaveDTO, HttpStatus.OK);
		}
		return new ResponseEntity<TipNastaveDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<TipNastave> createKarta(@RequestBody TipNastave karta) {
		try {
			tipNastaveService.save(karta);
			return new ResponseEntity<TipNastave>(karta, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<TipNastave>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{kartaId}", method = RequestMethod.PUT)
	public ResponseEntity<TipNastave> updateKarta(@PathVariable("kartaId") Long kartaId,
			@RequestBody TipNastave izmenjenaKarta) {
		TipNastave karta = tipNastaveService.findOne(kartaId).orElse(null);
		if (karta != null) {
			izmenjenaKarta.setId(kartaId);
			izmenjenaKarta = tipNastaveService.save(izmenjenaKarta);
			return new ResponseEntity<TipNastave>(izmenjenaKarta, HttpStatus.OK);
		}
		return new ResponseEntity<TipNastave>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{kartaId}", method = RequestMethod.DELETE)
	public ResponseEntity<TipNastave> deleteKarta(@PathVariable("kartaId") Long kartaId) {
		if (tipNastaveService.findOne(kartaId).isPresent()) {
			tipNastaveService.delete(kartaId);
			return new ResponseEntity<TipNastave>(HttpStatus.OK);
		}
		return new ResponseEntity<TipNastave>(HttpStatus.NOT_FOUND);
	}
}
