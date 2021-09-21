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

import rs.ac.singidunum.isa.app.dto.AutoriDTO;
import rs.ac.singidunum.isa.app.model.Autori;
import rs.ac.singidunum.isa.app.service.AutoriService;

@Controller
@RequestMapping(path = "/api/autori")
public class AutoriController {
	@Autowired
	AutoriService autoriService;
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<AutoriDTO>> getAllStanice(){
		ArrayList<AutoriDTO> drzave = new ArrayList<AutoriDTO>();
		for(Autori adresa : autoriService.findAll()) {
			drzave.add(new AutoriDTO(adresa.getId()));
		}
	return new ResponseEntity<Iterable<AutoriDTO>>(drzave, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{autoriId}", method = RequestMethod.GET)
	public ResponseEntity<AutoriDTO> getAdresa(@PathVariable("autoriId") Long adresaId) {
		Optional<Autori> adresa = autoriService.findOne(adresaId);
		AutoriDTO adresaDto;
		if (adresa.isPresent()) {
			adresaDto = new AutoriDTO(adresa.get().getId());
			return new ResponseEntity<AutoriDTO>(adresaDto, HttpStatus.OK);
		}

		return new ResponseEntity<AutoriDTO>(HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Autori> createAdresa(@RequestBody Autori adresa) {
		try {
			adresa.setId(null);
			autoriService.save(adresa);
			return new ResponseEntity<Autori>(adresa, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Autori>(HttpStatus.BAD_REQUEST);
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{autoriId}", method = RequestMethod.PUT)
	public ResponseEntity<AutoriDTO> updateAdresa(@PathVariable("autoriId") Long adresaId,
			@RequestBody Autori izmenjeni) {
		Autori adresa = autoriService.findOne(adresaId).orElse(null);
		if (adresa != null) {
			izmenjeni.setId(adresaId);
			izmenjeni = autoriService.save(izmenjeni);
			AutoriDTO izmenjenDto = new AutoriDTO(adresa.getId());
			return new ResponseEntity<AutoriDTO>(izmenjenDto, HttpStatus.OK);
		}
		return new ResponseEntity<AutoriDTO>(HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{autoriId}", method = RequestMethod.DELETE)
	public ResponseEntity<Autori> deleteKarta(@PathVariable("autoriId") Long adresaId) {
		if (autoriService.findOne(adresaId).isPresent()) {
			autoriService.delete(adresaId);
			return new ResponseEntity<Autori>(HttpStatus.OK);
		}
		return new ResponseEntity<Autori>(HttpStatus.NOT_FOUND);
	}
}