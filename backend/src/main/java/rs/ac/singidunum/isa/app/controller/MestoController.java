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

import rs.ac.singidunum.isa.app.dto.MestoDTO;
import rs.ac.singidunum.isa.app.model.Mesto;
import rs.ac.singidunum.isa.app.service.MestoService;

// mesta nisu povezana sa ostalim entitetima

@Controller
@RequestMapping(path = "/api/mesta")
public class MestoController {
	@Autowired
	MestoService mestoService;
	
	
	/**
	 * prikaz svih fakultrta
	 * neprijavljeni korisnici
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<MestoDTO>> getAllStanice(){
		ArrayList<MestoDTO> drzave = new ArrayList<MestoDTO>();
		for(Mesto mesto : mestoService.findAll()) {
			drzave.add(new MestoDTO(mesto.getId(), mesto.getNaziv(), null));
		}
	return new ResponseEntity<Iterable<MestoDTO>>(drzave, HttpStatus.OK);
	}
	
	/**
	 * pretraga po zadatom Idu 
	 * neregistrovani korisnici 
	 * @param mestoId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{mestoId}", method = RequestMethod.GET)
	public ResponseEntity<MestoDTO> getMesto(@PathVariable("mestoId") Long mestoId) {
		Optional<Mesto> mesto = mestoService.findOne(mestoId);
		MestoDTO mestoDto;
		if (mesto.isPresent()) {
			mestoDto = new MestoDTO(mesto.get().getId(), mesto.get().getNaziv(), null);
			return new ResponseEntity<MestoDTO>(mestoDto, HttpStatus.OK);
		}

		return new ResponseEntity<MestoDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * dodavanje novog mestoa
	 * administratori
	 * @param mesto
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Mesto> createMesto(@RequestBody Mesto mesto) {
		try {
			mesto.setId(null);
			mestoService.save(mesto);
			return new ResponseEntity<Mesto>(mesto, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Mesto>(HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * izmena
	 * administratori 
	 * @param mestoId
	 * @param izmenjeni
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{mestoId}", method = RequestMethod.PUT)
	public ResponseEntity<MestoDTO> updateMesto(@PathVariable("mestoId") Long mestoId,
			@RequestBody Mesto izmenjeni) {
		Mesto mesto = mestoService.findOne(mestoId).orElse(null);
		if (mesto != null) {
			izmenjeni.setId(mestoId);
			izmenjeni = mestoService.save(izmenjeni);
			MestoDTO izmenjenDto = new MestoDTO(mesto.getId(), mesto.getNaziv(), null);
			return new ResponseEntity<MestoDTO>(izmenjenDto, HttpStatus.OK);
		}
		return new ResponseEntity<MestoDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * brisanje
	 * administratori
	 * @param mestoId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{mestoId}", method = RequestMethod.DELETE)
	public ResponseEntity<Mesto> deleteKarta(@PathVariable("mestoId") Long mestoId) {
		if (mestoService.findOne(mestoId).isPresent()) {
			mestoService.delete(mestoId);
			return new ResponseEntity<Mesto>(HttpStatus.OK);
		}
		return new ResponseEntity<Mesto>(HttpStatus.NOT_FOUND);
	}

}
