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

import rs.ac.singidunum.isa.app.dto.GodinaStudijaDTO;
import rs.ac.singidunum.isa.app.model.GodinaStudija;
import rs.ac.singidunum.isa.app.service.GodinaStudijaService;

@Controller
@RequestMapping(path = "/api/godinestudija")
public class GodinaStudijaController {
	
	@Autowired
	private GodinaStudijaService godinaStudijaService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<GodinaStudijaDTO>> getAllGodineStudija() {
		ArrayList<GodinaStudijaDTO> godineStudija = new ArrayList<GodinaStudijaDTO>();
		for(GodinaStudija godinaStudija : godinaStudijaService.findAll()) {
			godineStudija.add(new GodinaStudijaDTO(godinaStudija.getId(), godinaStudija.getGodina()));
		}
		return new ResponseEntity<Iterable<GodinaStudijaDTO>>(godineStudija, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{godinaStudijaId}", method = RequestMethod.GET)
	public ResponseEntity<GodinaStudijaDTO> getGodinaStudija(@PathVariable("godinaStudijaId") Long godinaStudijaId) {
		Optional<GodinaStudija> godinaStudija = godinaStudijaService.findOne(godinaStudijaId);

		GodinaStudijaDTO godinaStudijaDTO;

		if (godinaStudija.isPresent()) {
			godinaStudijaDTO = new GodinaStudijaDTO(godinaStudija.get().getId(), godinaStudija.get().getGodina());
			return new ResponseEntity<GodinaStudijaDTO>(godinaStudijaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<GodinaStudijaDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<GodinaStudija> createGodinaStudija(@RequestBody GodinaStudija godinaStudija) {
		try {
			godinaStudijaService.save(godinaStudija);
			return new ResponseEntity<GodinaStudija>(godinaStudija, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<GodinaStudija>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{godinaStudijaId}", method = RequestMethod.PUT)
	public ResponseEntity<GodinaStudija> updateGodinaStudija(@PathVariable("godinaStudijaId") Long godinaStudijaId,
			@RequestBody GodinaStudija izmenjenaGodinaStudija) {
		GodinaStudija godinaStudija = godinaStudijaService.findOne(godinaStudijaId).orElse(null);
		if (godinaStudija != null) {
			izmenjenaGodinaStudija.setId(godinaStudijaId);
			izmenjenaGodinaStudija = godinaStudijaService.save(izmenjenaGodinaStudija);
			return new ResponseEntity<GodinaStudija>(izmenjenaGodinaStudija, HttpStatus.OK);
		}
		return new ResponseEntity<GodinaStudija>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{godinaStudijaId}", method = RequestMethod.DELETE)
	public ResponseEntity<GodinaStudija> deleteStanica(@PathVariable("godinaStudijaId") Long godinaStudijaId) {
		if (godinaStudijaService.findOne(godinaStudijaId).isPresent()) {
			godinaStudijaService.delete(godinaStudijaId);
			return new ResponseEntity<GodinaStudija>(HttpStatus.OK);
		}
		return new ResponseEntity<GodinaStudija>(HttpStatus.NOT_FOUND);
	}
}
