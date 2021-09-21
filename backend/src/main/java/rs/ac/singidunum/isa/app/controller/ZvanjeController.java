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

import rs.ac.singidunum.isa.app.dto.ZvanjeDTO;
import rs.ac.singidunum.isa.app.model.Zvanje;
import rs.ac.singidunum.isa.app.service.ZvanjeService;

@Controller
@RequestMapping(path = "/api/zvanja")
public class ZvanjeController {
	@Autowired
	private ZvanjeService zvanjeService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<ZvanjeDTO>> getAllZvanja() {
		ArrayList<ZvanjeDTO> zvanja = new ArrayList<ZvanjeDTO>();
		for(Zvanje zvanje : zvanjeService.findAll()) {
			zvanja.add(new ZvanjeDTO(zvanje.getId(), zvanje.getDatumIzbora(), zvanje.getDatumPrestanka()));
		}
		return new ResponseEntity<Iterable<ZvanjeDTO>>(zvanja, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{zvanjeId}", method = RequestMethod.GET)
	public ResponseEntity<ZvanjeDTO> getZvanje(@PathVariable("zvanjeId") Long zvanjeId) {
		Optional<Zvanje> zvanje = zvanjeService.findOne(zvanjeId);

		ZvanjeDTO zvanjeDTO;

		if (zvanje.isPresent()) {
			zvanjeDTO = new ZvanjeDTO(zvanje.get().getId(), zvanje.get().getDatumIzbora(), zvanje.get().getDatumPrestanka());
			return new ResponseEntity<ZvanjeDTO>(zvanjeDTO, HttpStatus.OK);
		}
		return new ResponseEntity<ZvanjeDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Zvanje> createZvanje(@RequestBody Zvanje zvanje) {
		try {
			zvanjeService.save(zvanje);
			return new ResponseEntity<Zvanje>(zvanje, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Zvanje>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{zvanjeId}", method = RequestMethod.PUT)
	public ResponseEntity<Zvanje> updateZvanje(@PathVariable("zvanjeId") Long zvanjeId,
			@RequestBody Zvanje izmenjenoZvanje) {
		Zvanje zvanje = zvanjeService.findOne(zvanjeId).orElse(null);
		if (zvanje != null) {
			izmenjenoZvanje.setId(zvanjeId);
			izmenjenoZvanje = zvanjeService.save(izmenjenoZvanje);
			return new ResponseEntity<Zvanje>(izmenjenoZvanje, HttpStatus.OK);
		}
		return new ResponseEntity<Zvanje>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{zvanjeId}", method = RequestMethod.DELETE)
	public ResponseEntity<Zvanje> deleteZvanje(@PathVariable("zvanjeId") Long zvanjeId) {
		if (zvanjeService.findOne(zvanjeId).isPresent()) {
			zvanjeService.delete(zvanjeId);
			return new ResponseEntity<Zvanje>(HttpStatus.OK);
		}
		return new ResponseEntity<Zvanje>(HttpStatus.NOT_FOUND);
	}
}
