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

import rs.ac.singidunum.isa.app.dto.NastavnikDTO;
import rs.ac.singidunum.isa.app.model.Nastavnik;
import rs.ac.singidunum.isa.app.service.NastavnikService;

@Controller
@RequestMapping(path = "/api/nastavnici")
public class NastavnikController {
	
	@Autowired
	private NastavnikService nastavnikService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<NastavnikDTO>> getAllNastavnici() {
		ArrayList<NastavnikDTO> nastavnici = new ArrayList<NastavnikDTO>();
		for(Nastavnik nastavnik : nastavnikService.findAll()) {
			nastavnici.add(new NastavnikDTO(nastavnik.getId(), nastavnik.getIme(), nastavnik.getJmbg(), nastavnik.getBiografija(), null, null, null, null, null, null));
		}
		return new ResponseEntity<Iterable<NastavnikDTO>>(nastavnici, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{nastavnikId}", method = RequestMethod.GET)
	public ResponseEntity<NastavnikDTO> getNastavnik(@PathVariable("nastavnikId") Long nastavnikId) {
		Optional<Nastavnik> nastavnik = nastavnikService.findOne(nastavnikId);

		NastavnikDTO nastavnikDTO;

		if (nastavnik.isPresent()) {
			nastavnikDTO = new NastavnikDTO(nastavnik.get().getId(), nastavnik.get().getIme(), nastavnik.get().getJmbg(), nastavnik.get().getBiografija(), null, null, null, null, null, null);
			return new ResponseEntity<NastavnikDTO>(nastavnikDTO, HttpStatus.OK);
		}
		return new ResponseEntity<NastavnikDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Nastavnik> createNastavnik(@RequestBody Nastavnik nastavnik) {
		try {
			nastavnikService.save(nastavnik);
			return new ResponseEntity<Nastavnik>(nastavnik, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Nastavnik>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{nastavnikId}", method = RequestMethod.PUT)
	public ResponseEntity<Nastavnik> updateNastavnik(@PathVariable("nastavnikId") Long nastavnikId,
			@RequestBody Nastavnik izmenjeniNastavnik) {
		Nastavnik nastavnik = nastavnikService.findOne(nastavnikId).orElse(null);
		if (nastavnik != null) {
			izmenjeniNastavnik.setId(nastavnikId);
			izmenjeniNastavnik = nastavnikService.save(izmenjeniNastavnik);
			return new ResponseEntity<Nastavnik>(izmenjeniNastavnik, HttpStatus.OK);
		}
		return new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{nastavnikId}", method = RequestMethod.DELETE)
	public ResponseEntity<Nastavnik> deleteStanica(@PathVariable("nastavnikId") Long nastavnikId) {
		if (nastavnikService.findOne(nastavnikId).isPresent()) {
			nastavnikService.delete(nastavnikId);
			return new ResponseEntity<Nastavnik>(HttpStatus.OK);
		}
		return new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
	}
}
