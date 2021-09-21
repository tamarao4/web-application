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

import rs.ac.singidunum.isa.app.dto.NeregistrovaniKorisnikDTO;
import rs.ac.singidunum.isa.app.model.NeregistrovaniKorisnik;
import rs.ac.singidunum.isa.app.service.NeregistrovaniKorisnikService;

@Controller
@RequestMapping(path = "/api/neregistrovaniKorisnik")
public class NeRegistrovaniKorisnikController {
	@Autowired
	NeregistrovaniKorisnikService neregistrovaniKorisnikService;
	
	
	/**
	 * prikaz svih fakultrta
	 * neprijavljeni korisnici
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<NeregistrovaniKorisnikDTO>> getAllStanice(){
		ArrayList<NeregistrovaniKorisnikDTO> drzave = new ArrayList<NeregistrovaniKorisnikDTO>();
		for(NeregistrovaniKorisnik adresa : neregistrovaniKorisnikService.findAll()) {
			drzave.add(new NeregistrovaniKorisnikDTO(adresa.getId(), adresa.getIme(), null, null ));
		}
	return new ResponseEntity<Iterable<NeregistrovaniKorisnikDTO>>(drzave, HttpStatus.OK);
	}
	
	/**
	 * pretraga po zadatom Idu 
	 * neregistrovani korisnici 
	 * @param adresaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{neregistrovaniKorisnikId}", method = RequestMethod.GET)
	public ResponseEntity<NeregistrovaniKorisnikDTO> getAdresa(@PathVariable("neregistrovaniKorisnikId") Long adresaId) {
		Optional<NeregistrovaniKorisnik> adresa = neregistrovaniKorisnikService.findOne(adresaId);
		NeregistrovaniKorisnikDTO adresaDto;
		if (adresa.isPresent()) {
			adresaDto = new NeregistrovaniKorisnikDTO(adresa.get().getId(), adresa.get().getIme(), null, null);
			return new ResponseEntity<NeregistrovaniKorisnikDTO>(adresaDto, HttpStatus.OK);
		}

		return new ResponseEntity<NeregistrovaniKorisnikDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * dodavanje novog adresaa
	 * administratori
	 * @param adresa
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<NeregistrovaniKorisnik> createAdresa(@RequestBody NeregistrovaniKorisnik adresa) {
		try {
			adresa.setId(null);
			neregistrovaniKorisnikService.save(adresa);
			return new ResponseEntity<NeregistrovaniKorisnik>(adresa, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<NeregistrovaniKorisnik>(HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * izmena
	 * administratori 
	 * @param adresaId
	 * @param izmenjeni
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{neregistrovaniKorisnikId}", method = RequestMethod.PUT)
	public ResponseEntity<NeregistrovaniKorisnikDTO> updateAdresa(@PathVariable("neregistrovaniKorisnikId") Long adresaId,
			@RequestBody NeregistrovaniKorisnik izmenjeni) {
		NeregistrovaniKorisnik adresa = neregistrovaniKorisnikService.findOne(adresaId).orElse(null);
		if (adresa != null) {
			izmenjeni.setId(adresaId);
			izmenjeni = neregistrovaniKorisnikService.save(izmenjeni);
			NeregistrovaniKorisnikDTO izmenjenDto = new NeregistrovaniKorisnikDTO(adresa.getId(), adresa.getIme(), null, null);
			return new ResponseEntity<NeregistrovaniKorisnikDTO>(izmenjenDto, HttpStatus.OK);
		}
		return new ResponseEntity<NeregistrovaniKorisnikDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * brisanje
	 * administratori
	 * @param adresaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{neregistrovaniKorisnikId}", method = RequestMethod.DELETE)
	public ResponseEntity<NeregistrovaniKorisnik> deleteKarta(@PathVariable("neregistrovaniKorisnikId") Long adresaId) {
		if (neregistrovaniKorisnikService.findOne(adresaId).isPresent()) {
			neregistrovaniKorisnikService.delete(adresaId);
			return new ResponseEntity<NeregistrovaniKorisnik>(HttpStatus.OK);
		}
		return new ResponseEntity<NeregistrovaniKorisnik>(HttpStatus.NOT_FOUND);
	}

}