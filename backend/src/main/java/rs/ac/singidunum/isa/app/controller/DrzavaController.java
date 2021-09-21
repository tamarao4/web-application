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

import rs.ac.singidunum.isa.app.dto.DrzavaDTO;
import rs.ac.singidunum.isa.app.dto.MestoDTO;
import rs.ac.singidunum.isa.app.model.Drzava;
import rs.ac.singidunum.isa.app.model.Mesto;
import rs.ac.singidunum.isa.app.service.DrzavaService;

@Controller
@RequestMapping(path = "/api/drzave")
public class DrzavaController {
	@Autowired
	private DrzavaService drzavaService;
	
	/**
	 * prikaz svih fakultrta
	 * neprijavljeni korisnici
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<DrzavaDTO>> getAllStanice(){
		ArrayList<DrzavaDTO> drzave = new ArrayList<DrzavaDTO>();
		for(Drzava drzava : drzavaService.findAll()) {
			ArrayList<MestoDTO> mesta = new ArrayList<MestoDTO>();
			for (Mesto mesto : drzava.getMesta()) {
				mesta.add(new MestoDTO(mesto.getId(), mesto.getNaziv(), null));
			}
			drzave.add(new DrzavaDTO(drzava.getId(), drzava.getNaziv(), mesta));
		}
	return new ResponseEntity<Iterable<DrzavaDTO>>(drzave, HttpStatus.OK);
	}
	
	/**
	 * pretraga po zadatom Idu 
	 * neregistrovani korisnici 
	 * @param drzavaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{drzavaId}", method = RequestMethod.GET)
	public ResponseEntity<DrzavaDTO> getDrzava(@PathVariable("drzavaId") Long drzavaId) {
		Optional<Drzava> drzava = drzavaService.findOne(drzavaId);
		DrzavaDTO drzavaDto;
		if (drzava.isPresent()) {
			ArrayList<MestoDTO> mesta = new ArrayList<MestoDTO>();
			for (Mesto mesto : drzava.get().getMesta()) {
				mesta.add(new MestoDTO(mesto.getId(), mesto.getNaziv(), null));
			}
			drzavaDto = new DrzavaDTO(drzava.get().getId(), drzava.get().getNaziv(), mesta);
			return new ResponseEntity<DrzavaDTO>(drzavaDto, HttpStatus.OK);
		}

		return new ResponseEntity<DrzavaDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * dodavanje novog drzavaa
	 * administratori
	 * @param drzava
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Drzava> createDrzava(@RequestBody Drzava drzava) {
		try {
			drzava.setId(null);
			drzavaService.save(drzava);
			return new ResponseEntity<Drzava>(drzava, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Drzava>(HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * izmena
	 * administratori 
	 * @param drzavaId
	 * @param izmenjeni
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{drzavaId}", method = RequestMethod.PUT)
	public ResponseEntity<DrzavaDTO> updateDrzava(@PathVariable("drzavaId") Long drzavaId,
			@RequestBody Drzava izmenjeni) {
		Drzava drzava = drzavaService.findOne(drzavaId).orElse(null);
		if (drzava != null) {
			izmenjeni.setId(drzavaId);
			izmenjeni = drzavaService.save(izmenjeni);
			ArrayList<MestoDTO> mesta = new ArrayList<MestoDTO>();
			for (Mesto mesto : drzava.getMesta()) {
				mesta.add(new MestoDTO(mesto.getId(), mesto.getNaziv(), null));
			}
			DrzavaDTO izmenjenDto = new DrzavaDTO(drzava.getId(), drzava.getNaziv(), mesta);
			return new ResponseEntity<DrzavaDTO>(izmenjenDto, HttpStatus.OK);
		}
		return new ResponseEntity<DrzavaDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * brisanje
	 * administratori
	 * @param drzavaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{drzavaId}", method = RequestMethod.DELETE)
	public ResponseEntity<Drzava> deleteKarta(@PathVariable("drzavaId") Long drzavaId) {
		if (drzavaService.findOne(drzavaId).isPresent()) {
			drzavaService.delete(drzavaId);
			return new ResponseEntity<Drzava>(HttpStatus.OK);
		}
		return new ResponseEntity<Drzava>(HttpStatus.NOT_FOUND);
	}
}
