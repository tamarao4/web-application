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

import rs.ac.singidunum.isa.app.dto.AdresaDTO;
import rs.ac.singidunum.isa.app.model.Adresa;
import rs.ac.singidunum.isa.app.service.AdresaService;

// nisu povezane sa ostalim entitetima

@Controller
@RequestMapping(path = "/api/adrese")
public class AdresaController {
	@Autowired
	AdresaService adresaService;
	
	
	/**
	 * prikaz svih fakultrta
	 * neprijavljeni korisnici
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<AdresaDTO>> getAllStanice(){
		ArrayList<AdresaDTO> drzave = new ArrayList<AdresaDTO>();
		for(Adresa adresa : adresaService.findAll()) {
			drzave.add(new AdresaDTO(adresa.getId(), adresa.getUlica(), adresa.getBroj(), null, null));
		}
	return new ResponseEntity<Iterable<AdresaDTO>>(drzave, HttpStatus.OK);
	}
	
	/**
	 * pretraga po zadatom Idu 
	 * neregistrovani korisnici 
	 * @param adresaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{adresaId}", method = RequestMethod.GET)
	public ResponseEntity<AdresaDTO> getAdresa(@PathVariable("adresaId") Long adresaId) {
		Optional<Adresa> adresa = adresaService.findOne(adresaId);
		AdresaDTO adresaDto;
		if (adresa.isPresent()) {
			adresaDto = new AdresaDTO(adresa.get().getId(), adresa.get().getUlica(), adresa.get().getBroj(), null, null);
			return new ResponseEntity<AdresaDTO>(adresaDto, HttpStatus.OK);
		}

		return new ResponseEntity<AdresaDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * dodavanje novog adresaa
	 * administratori
	 * @param adresa
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Adresa> createAdresa(@RequestBody Adresa adresa) {
		try {
			adresaService.save(adresa);
			return new ResponseEntity<Adresa>(adresa, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Adresa>(HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * izmena
	 * administratori 
	 * @param adresaId
	 * @param izmenjeni
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{adresaId}", method = RequestMethod.PUT)
	public ResponseEntity<AdresaDTO> updateAdresa(@PathVariable("adresaId") Long adresaId,
			@RequestBody Adresa izmenjeni) {
		Adresa adresa = adresaService.findOne(adresaId).orElse(null);
		if (adresa != null) {
			izmenjeni.setId(adresaId);
			izmenjeni = adresaService.save(izmenjeni);
			AdresaDTO izmenjenDto = new AdresaDTO(adresa.getId(), adresa.getUlica(), adresa.getBroj(), null, null);
			return new ResponseEntity<AdresaDTO>(izmenjenDto, HttpStatus.OK);
		}
		return new ResponseEntity<AdresaDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * brisanje
	 * administratori
	 * @param adresaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{adresaId}", method = RequestMethod.DELETE)
	public ResponseEntity<Adresa> deleteKarta(@PathVariable("adresaId") Long adresaId) {
		if (adresaService.findOne(adresaId).isPresent()) {
			adresaService.delete(adresaId);
			return new ResponseEntity<Adresa>(HttpStatus.OK);
		}
		return new ResponseEntity<Adresa>(HttpStatus.NOT_FOUND);
	}

}
