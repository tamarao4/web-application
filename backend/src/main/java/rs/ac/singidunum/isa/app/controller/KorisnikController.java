package rs.ac.singidunum.isa.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.singidunum.isa.app.dto.KorisnikDTO;
import rs.ac.singidunum.isa.app.model.Korisnik;
import rs.ac.singidunum.isa.app.service.KorisnikService;

@Controller
@RequestMapping(path = "/api/korisnici")
public class KorisnikController {
	
	@Autowired
	KorisnikService korisnikService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<KorisnikDTO>> getAllKorisnici() {
		ArrayList<KorisnikDTO> korisnici = new ArrayList<KorisnikDTO>();
		for (Korisnik korisnik : korisnikService.findAll()) {
			korisnici.add(new KorisnikDTO(korisnik.getId(), korisnik.getKorisnickoIme(), korisnik.getLozinka(), korisnik.getIme(), korisnik.getPrezime()));
		}

		return new ResponseEntity<Iterable<KorisnikDTO>>(korisnici, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{korisnikId}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<KorisnikDTO> getKorisnik(@PathVariable("korisnikId") Long korisnikId) {
		Optional<Korisnik> korisnik = korisnikService.findOne(korisnikId);

		KorisnikDTO korisnikDTO;

		if (korisnik.isPresent()) {
			korisnikDTO = new KorisnikDTO(korisnik.get().getId(), korisnik.get().getKorisnickoIme(),
					korisnik.get().getLozinka(), korisnik.get().getIme(), korisnik.get().getPrezime());
			return new ResponseEntity<KorisnikDTO>(korisnikDTO, HttpStatus.OK);
		}
		return new ResponseEntity<KorisnikDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Korisnik> createKorisnik(@RequestBody Korisnik korisnik) {
		try {
			korisnikService.save(korisnik);
			return new ResponseEntity<Korisnik>(korisnik, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Korisnik>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(path = "/{korisnikId}", method = RequestMethod.PUT)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Korisnik> updateKorisnik(@PathVariable("korisnikId") Long korisnikId,
			@RequestBody Korisnik izmenjeniKorisnik) {
		Korisnik korisnik = korisnikService.findOne(korisnikId).orElse(null);
		if (korisnik != null) {
			izmenjeniKorisnik.setId(korisnikId);
			izmenjeniKorisnik = korisnikService.save(izmenjeniKorisnik);
			return new ResponseEntity<Korisnik>(izmenjeniKorisnik, HttpStatus.OK);
		}
		return new ResponseEntity<Korisnik>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/{korisnikId}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Korisnik> deleteKorisnik(@PathVariable("korisnikId") Long korisnikId) {
		if (korisnikService.findOne(korisnikId).isPresent()) {
			korisnikService.delete(korisnikId);
			return new ResponseEntity<Korisnik>(HttpStatus.OK);
		}
		return new ResponseEntity<Korisnik>(HttpStatus.NOT_FOUND);
	}
	
}
