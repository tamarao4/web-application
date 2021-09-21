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

import rs.ac.singidunum.isa.app.dto.TipZvanjaDTO;
import rs.ac.singidunum.isa.app.model.TipZvanja;
import rs.ac.singidunum.isa.app.service.TipZvanjaService;

@Controller
@RequestMapping(path = "/api/tipovi_zvanja")
public class TipZvanjaController {
	@Autowired
	private TipZvanjaService tipZvanjaService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<TipZvanjaDTO>> getAllTipoviZvanja() {
		ArrayList<TipZvanjaDTO> tipoviZvanja = new ArrayList<TipZvanjaDTO>();
		for(TipZvanja tipZvanja : tipZvanjaService.findAll()) {
			tipoviZvanja.add(new TipZvanjaDTO(tipZvanja.getId(), tipZvanja.getNaziv()));
		}
		return new ResponseEntity<Iterable<TipZvanjaDTO>>(tipoviZvanja, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{tipZvanjaId}", method = RequestMethod.GET)
	public ResponseEntity<TipZvanjaDTO> getTipZvanja(@PathVariable("tipZvanjaId") Long tipZvanjaId) {
		Optional<TipZvanja> tipZvanja = tipZvanjaService.findOne(tipZvanjaId);

		TipZvanjaDTO tipZvanjaDTO;

		if (tipZvanja.isPresent()) {
			tipZvanjaDTO = new TipZvanjaDTO(tipZvanja.get().getId(), tipZvanja.get().getNaziv());
			return new ResponseEntity<TipZvanjaDTO>(tipZvanjaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<TipZvanjaDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{tipZvanjaId}", method = RequestMethod.PUT)
	public ResponseEntity<TipZvanja> updateTipZvanja(@PathVariable("tipZvanjaId") Long tipZvanjaId,
			@RequestBody TipZvanja izmenjeniTipZvanja) {
		TipZvanja tipZvanja = tipZvanjaService.findOne(tipZvanjaId).orElse(null);
		if (tipZvanja != null) {
			izmenjeniTipZvanja.setId(tipZvanjaId);
			izmenjeniTipZvanja = tipZvanjaService.save(izmenjeniTipZvanja);
			return new ResponseEntity<TipZvanja>(izmenjeniTipZvanja, HttpStatus.OK);
		}
		return new ResponseEntity<TipZvanja>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{tipZvanjaId}", method = RequestMethod.DELETE)
	public ResponseEntity<TipZvanja> deleteTipZvanja(@PathVariable("tipZvanjaId") Long tipZvanjaId) {
		if (tipZvanjaService.findOne(tipZvanjaId).isPresent()) {
			tipZvanjaService.delete(tipZvanjaId);
			return new ResponseEntity<TipZvanja>(HttpStatus.OK);
		}
		return new ResponseEntity<TipZvanja>(HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<TipZvanja> createTipZvanja(@RequestBody TipZvanja tipZvanja) {
		try {
			tipZvanjaService.save(tipZvanja);
			return new ResponseEntity<TipZvanja>(tipZvanja, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<TipZvanja>(HttpStatus.BAD_REQUEST);
	}
}
