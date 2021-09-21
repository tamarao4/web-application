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

import rs.ac.singidunum.isa.app.dto.KljucneReciDTO;
import rs.ac.singidunum.isa.app.model.KljucneReci;
import rs.ac.singidunum.isa.app.service.KljucneReciService;

@Controller
@RequestMapping(path = "/api/kljucneReci")
public class KljucneReciController {
	@Autowired
	KljucneReciService kljucneReciService;
	
	
	/**
	 * prikaz svih fakultrta
	 * neprijavljeni korisnici
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<KljucneReciDTO>> getAllStanice(){
		ArrayList<KljucneReciDTO> drzave = new ArrayList<KljucneReciDTO>();
		for(KljucneReci adresa : kljucneReciService.findAll()) {
			drzave.add(new KljucneReciDTO(adresa.getId(), adresa.getReci()));
		}
	return new ResponseEntity<Iterable<KljucneReciDTO>>(drzave, HttpStatus.OK);
	}
	
	/**
	 * pretraga po zadatom Idu 
	 * neregistrovani korisnici 
	 * @param adresaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{kljucneReciId}", method = RequestMethod.GET)
	public ResponseEntity<KljucneReciDTO> getAdresa(@PathVariable("kljucneReciId") Long adresaId) {
		Optional<KljucneReci> adresa = kljucneReciService.findOne(adresaId);
		KljucneReciDTO adresaDto;
		if (adresa.isPresent()) {
			adresaDto = new KljucneReciDTO(adresa.get().getId(), adresa.get().getReci());
			return new ResponseEntity<KljucneReciDTO>(adresaDto, HttpStatus.OK);
		}

		return new ResponseEntity<KljucneReciDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * dodavanje novog adresaa
	 * administratori
	 * @param adresa
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<KljucneReci> createAdresa(@RequestBody KljucneReci adresa) {
		try {
			adresa.setId(null);
			kljucneReciService.save(adresa);
			return new ResponseEntity<KljucneReci>(adresa, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<KljucneReci>(HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * izmena
	 * administratori 
	 * @param adresaId
	 * @param izmenjeni
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{kljucneReciId}", method = RequestMethod.PUT)
	public ResponseEntity<KljucneReciDTO> updateAdresa(@PathVariable("kljucneReciId") Long adresaId,
			@RequestBody KljucneReci izmenjeni) {
		KljucneReci adresa = kljucneReciService.findOne(adresaId).orElse(null);
		if (adresa != null) {
			izmenjeni.setId(adresaId);
			izmenjeni = kljucneReciService.save(izmenjeni);
			KljucneReciDTO izmenjenDto = new KljucneReciDTO(adresa.getId(), adresa.getReci());
			return new ResponseEntity<KljucneReciDTO>(izmenjenDto, HttpStatus.OK);
		}
		return new ResponseEntity<KljucneReciDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * brisanje
	 * administratori
	 * @param adresaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{kljucneReciId}", method = RequestMethod.DELETE)
	public ResponseEntity<KljucneReci> deleteKarta(@PathVariable("kljucneReciId") Long adresaId) {
		if (kljucneReciService.findOne(adresaId).isPresent()) {
			kljucneReciService.delete(adresaId);
			return new ResponseEntity<KljucneReci>(HttpStatus.OK);
		}
		return new ResponseEntity<KljucneReci>(HttpStatus.NOT_FOUND);
	}

}