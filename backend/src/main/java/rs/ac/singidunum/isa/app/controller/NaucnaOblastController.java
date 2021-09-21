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

import rs.ac.singidunum.isa.app.dto.NaucnaOblastDTO;
import rs.ac.singidunum.isa.app.model.NaucnaOblast;
import rs.ac.singidunum.isa.app.service.NaucnaOblastService;

@Controller
@RequestMapping(path = "/api/naucne_oblasti")
public class NaucnaOblastController {
	@Autowired
	private NaucnaOblastService naucnaOblastService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<NaucnaOblastDTO>> getAllNaucneOblasti() {
		ArrayList<NaucnaOblastDTO> naucneOblasti = new ArrayList<NaucnaOblastDTO>();
		for(NaucnaOblast naucnaOblast : naucnaOblastService.findAll()) {
			naucneOblasti.add(new NaucnaOblastDTO(naucnaOblast.getId(), naucnaOblast.getNaziv()));
		}
		return new ResponseEntity<Iterable<NaucnaOblastDTO>>(naucneOblasti, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{naucnaOblastId}", method = RequestMethod.GET)
	public ResponseEntity<NaucnaOblastDTO> getNaucnaOblast(@PathVariable("naucnaOblastId") Long naucnaOblastId) {
		Optional<NaucnaOblast> naucnaOblast = naucnaOblastService.findOne(naucnaOblastId);

		NaucnaOblastDTO naucnaOblastDTO;

		if (naucnaOblast.isPresent()) {
			naucnaOblastDTO = new NaucnaOblastDTO(naucnaOblast.get().getId(), naucnaOblast.get().getNaziv());
			return new ResponseEntity<NaucnaOblastDTO>(naucnaOblastDTO, HttpStatus.OK);
		}
		return new ResponseEntity<NaucnaOblastDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<NaucnaOblast> createNaucnaOblast(@RequestBody NaucnaOblast naucnaOblast) {
		try {
			naucnaOblastService.save(naucnaOblast);
			return new ResponseEntity<NaucnaOblast>(naucnaOblast, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<NaucnaOblast>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{naucnaOblastId}", method = RequestMethod.PUT)
	public ResponseEntity<NaucnaOblast> updateNaucnaOblast(@PathVariable("naucnaOblastId") Long naucnaOblastId,
			@RequestBody NaucnaOblast izmenjenaNaucnaOblast) {
		NaucnaOblast naucnaOblast = naucnaOblastService.findOne(naucnaOblastId).orElse(null);
		if (naucnaOblast != null) {
			izmenjenaNaucnaOblast.setId(naucnaOblastId);
			izmenjenaNaucnaOblast = naucnaOblastService.save(izmenjenaNaucnaOblast);
			return new ResponseEntity<NaucnaOblast>(izmenjenaNaucnaOblast, HttpStatus.OK);
		}
		return new ResponseEntity<NaucnaOblast>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{naucnaOblastId}", method = RequestMethod.DELETE)
	public ResponseEntity<NaucnaOblast> deleteNaucnaOblast(@PathVariable("naucnaOblastId") Long naucnaOblastId) {
		if (naucnaOblastService.findOne(naucnaOblastId).isPresent()) {
			naucnaOblastService.delete(naucnaOblastId);
			return new ResponseEntity<NaucnaOblast>(HttpStatus.OK);
		}
		return new ResponseEntity<NaucnaOblast>(HttpStatus.NOT_FOUND);
	}
}
