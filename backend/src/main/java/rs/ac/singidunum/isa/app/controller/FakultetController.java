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
import rs.ac.singidunum.isa.app.dto.DrzavaDTO;
import rs.ac.singidunum.isa.app.dto.FakultetDTO;
import rs.ac.singidunum.isa.app.dto.MestoDTO;
import rs.ac.singidunum.isa.app.dto.NastavnikDTO;

import rs.ac.singidunum.isa.app.model.Fakultet;
import rs.ac.singidunum.isa.app.service.FakultetService;

@Controller
@RequestMapping(path = "/api/fakulteti")
public class FakultetController {
	@Autowired
	private FakultetService fakultetService;
	
	/**
	 * prikaz svih fakultrta
	 * neprijavljeni korisnici
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<FakultetDTO>> getAllStanice(){
		ArrayList<FakultetDTO> fakulteti = new ArrayList<FakultetDTO>();
		for(Fakultet fakultet : fakultetService.findAll()) {
			// adresa
			DrzavaDTO drzava = new DrzavaDTO(fakultet.getUniverzitet().getAdresa().getMesto().getDrzava().getId(),
					fakultet.getUniverzitet().getAdresa().getMesto().getDrzava().getNaziv(), null);
			MestoDTO mesto = new MestoDTO(fakultet.getUniverzitet().getAdresa().getMesto().getId(), 
					fakultet.getUniverzitet().getAdresa().getMesto().getNaziv(), drzava);
			AdresaDTO adresa = new AdresaDTO(fakultet.getUniverzitet().getAdresa().getId(),
					fakultet.getUniverzitet().getAdresa().getUlica(), fakultet.getUniverzitet().getAdresa().getBroj(), mesto, null);
			
			// dekan
			NastavnikDTO dekan = new NastavnikDTO(fakultet.getDekan().getId(), fakultet.getDekan().getIme(), fakultet.getDekan().getBiografija(), fakultet.getDekan().getBiografija(), null, null, null, null, null, null);
			
			fakulteti.add(new FakultetDTO(fakultet.getId(), fakultet.getNaziv(), fakultet.getEmail(), fakultet.getEmail(), fakultet.getOpis(), null, adresa, dekan, null));
		
		}
	return new ResponseEntity<Iterable<FakultetDTO>>(fakulteti, HttpStatus.OK);
	}
	
	/**
	 * pretraga po zadatom Idu 
	 * neregistrovani korisnici 
	 * @param fakultetId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{fakultetId}", method = RequestMethod.GET)
	public ResponseEntity<FakultetDTO> getFakultet(@PathVariable("fakultetId") Long fakultetId) {
		Optional<Fakultet> fakultet = fakultetService.findOne(fakultetId);
		FakultetDTO fakultetDto;
		if (fakultet.isPresent()) {
			DrzavaDTO drzava = new DrzavaDTO(fakultet.get().getUniverzitet().getAdresa().getMesto().getDrzava().getId(),
					fakultet.get().getUniverzitet().getAdresa().getMesto().getDrzava().getNaziv(), null);
			MestoDTO mesto = new MestoDTO(fakultet.get().getUniverzitet().getAdresa().getMesto().getId(), 
					fakultet.get().getUniverzitet().getAdresa().getMesto().getNaziv(), drzava);
			AdresaDTO adresa = new AdresaDTO(fakultet.get().getUniverzitet().getAdresa().getId(),
					fakultet.get().getUniverzitet().getAdresa().getUlica(), fakultet.get().getUniverzitet().getAdresa().getBroj(), mesto, null);
			
			fakultetDto = new FakultetDTO(fakultet.get().getId(), fakultet.get().getNaziv(), fakultet.get().getEmail(), 
					fakultet.get().getEmail(), fakultet.get().getOpis(), null, adresa, null, null);
			return new ResponseEntity<FakultetDTO>(fakultetDto, HttpStatus.OK);
		}

		return new ResponseEntity<FakultetDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * dodavanje novog fakulteta
	 * administratori
	 * @param fakultet
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Fakultet> createFakultet(@RequestBody Fakultet fakultet) {
		try {
			fakultet.setId(null);
			fakultetService.save(fakultet);
			return new ResponseEntity<Fakultet>(fakultet, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Fakultet>(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * izmena
	 * administratori 
	 * @param fakultetId
	 * @param izmenjeni
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{fakultetId}", method = RequestMethod.PUT)
	public ResponseEntity<FakultetDTO> updateFakultet(@PathVariable("fakultetId") Long fakultetId,
			@RequestBody Fakultet izmenjeni) {
		Fakultet fakultet = fakultetService.findOne(fakultetId).orElse(null);
		if (fakultet != null) {
			izmenjeni.setId(fakultetId);
			izmenjeni = fakultetService.save(izmenjeni);
			DrzavaDTO drzava = new DrzavaDTO(fakultet.getUniverzitet().getAdresa().getMesto().getDrzava().getId(),
					fakultet.getUniverzitet().getAdresa().getMesto().getDrzava().getNaziv(), null);
			MestoDTO mesto = new MestoDTO(fakultet.getUniverzitet().getAdresa().getMesto().getId(), 
					fakultet.getUniverzitet().getAdresa().getMesto().getNaziv(), drzava);
			AdresaDTO adresa = new AdresaDTO(fakultet.getUniverzitet().getAdresa().getId(),
					fakultet.getUniverzitet().getAdresa().getUlica(), fakultet.getUniverzitet().getAdresa().getBroj(), mesto, null);
			FakultetDTO izmenjenDto = new FakultetDTO(fakultet.getId(), fakultet.getNaziv(), fakultet.getEmail(), fakultet.getEmail(), fakultet.getOpis(), null, adresa, null, null);
			return new ResponseEntity<FakultetDTO>(izmenjenDto, HttpStatus.OK);
		}
		return new ResponseEntity<FakultetDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * brisanje
	 * administratori
	 * @param fakultetId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{fakultetId}", method = RequestMethod.DELETE)
	public ResponseEntity<Fakultet> deleteKarta(@PathVariable("fakultetId") Long fakultetId) {
		if (fakultetService.findOne(fakultetId).isPresent()) {
			fakultetService.delete(fakultetId);
			return new ResponseEntity<Fakultet>(HttpStatus.OK);
		}
		return new ResponseEntity<Fakultet>(HttpStatus.NOT_FOUND);
	}
	
}
