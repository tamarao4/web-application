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

import rs.ac.singidunum.isa.app.dto.MestoDTO;
import rs.ac.singidunum.isa.app.dto.NastavnikDTO;
import rs.ac.singidunum.isa.app.dto.UniverzitetDTO;

import rs.ac.singidunum.isa.app.model.Univerzitet;
import rs.ac.singidunum.isa.app.service.UniverzitetService;

@Controller
@RequestMapping(path = "/api/univerziteti")
public class UniverzitetController {
	@Autowired
	UniverzitetService univerzitetService;
	
	/** 
	 * Prikaz svih univerziteta 
	 * podaci ukljucuju kontakt podatke, lokaciiju, opis i podatke o rektoru
	 * neregistrovani korisnici 
	 * */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<UniverzitetDTO>> getAllUniverzitet(){
		ArrayList<UniverzitetDTO> univerziteti = new ArrayList<UniverzitetDTO>();
		for(Univerzitet univerzitet : univerzitetService.findAll()) {
//			ArrayList<FakultetDTO> fakulteti = new ArrayList<FakultetDTO>();
//			for (Fakultet fakultet : univerzitet.getFakulteti()) {
//				fakulteti.add(new FakultetDTO(fakultet.getId(), fakultet.getNaziv(), null));
//			}
			// adresa
			DrzavaDTO drzava = new DrzavaDTO(univerzitet.getAdresa().getMesto().getDrzava().getId()
					, univerzitet.getAdresa().getMesto().getDrzava().getNaziv(), null);
			MestoDTO mesto = new MestoDTO(univerzitet.getAdresa().getMesto().getId(), 
					univerzitet.getAdresa().getMesto().getNaziv(), drzava);
			AdresaDTO adresa = new AdresaDTO(univerzitet.getAdresa().getId(), univerzitet.
					getAdresa().getUlica(), univerzitet.getAdresa().getBroj(), mesto, null);
			// rektor
			NastavnikDTO rektor = new NastavnikDTO(univerzitet.getRektor().getId(), univerzitet.getRektor().getIme(), univerzitet.getRektor().getBiografija(), univerzitet.getRektor().getJmbg(), null, null, adresa, null, null, null);
			univerziteti.add(new UniverzitetDTO(univerzitet.getId(), univerzitet.getNaziv(), univerzitet.getDatumOsnivanja(), adresa, univerzitet.getTelefon(), univerzitet.getEmail(), univerzitet.getOpis(), null, rektor));
		}
		return new ResponseEntity<Iterable<UniverzitetDTO>>(univerziteti, HttpStatus.OK);
	}


	/** 
	 * Prikaz niverziteta po zadoatom Id-u 
	 * neriegistrovani korisnici
	 * */
	// pretraga po idju
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{univerzitetId}", method = RequestMethod.GET)
	public ResponseEntity<UniverzitetDTO> getUniverzitet(@PathVariable("univerzitetId") Long univerzitetId) {
		Optional<Univerzitet> univerzitet = univerzitetService.findOne(univerzitetId);
		UniverzitetDTO univerzitetDTO;
		if (univerzitet.isPresent()) {
//			ArrayList<FakultetDTO> fakulteti = new ArrayList<FakultetDTO>();
//			for (Fakultet fakultet : univerzitet.get().getFakulteti()) {
//				fakulteti.add(new FakultetDTO(fakultet.getId(), fakultet.getNaziv(), null));
//			}
			DrzavaDTO drzava = new DrzavaDTO(univerzitet.get().getAdresa().getMesto().getDrzava().getId()
					, univerzitet.get().getAdresa().getMesto().getDrzava().getNaziv(), null);
			MestoDTO mesto = new MestoDTO(univerzitet.get().getAdresa().getMesto().getId(), 
					univerzitet.get().getAdresa().getMesto().getNaziv(), drzava);
			AdresaDTO adresa = new AdresaDTO(univerzitet.get().getAdresa().getId(), univerzitet.get().
					getAdresa().getUlica(), univerzitet.get().getAdresa().getBroj(), mesto, null);
			univerzitetDTO = new UniverzitetDTO(univerzitet.get().getId(), univerzitet.get().getNaziv(), univerzitet.get().getDatumOsnivanja(), 
					adresa, univerzitet.get().getTelefon(), univerzitet.get().getEmail(), univerzitet.get().getOpis(), null, null);
			return new ResponseEntity<UniverzitetDTO>(univerzitetDTO, HttpStatus.OK);
		}
		return new ResponseEntity<UniverzitetDTO>(HttpStatus.NOT_FOUND);
	}
	
	/** 
	 * dodavanje univerziteta
	 * administrator
	 * @param univerzitetId
	 * @param izmenjeni
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Univerzitet> createUniverzitet(@RequestBody Univerzitet univerzitet) {
		try {
			univerzitet.setId(null);
			univerzitetService.save(univerzitet);
			return new ResponseEntity<Univerzitet>(univerzitet, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Univerzitet>(HttpStatus.BAD_REQUEST);
	}
	
	/** 
	 * izmena univerziteta
	 * administrator
	 * @param univerzitetId
	 * @param izmenjeni
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{univerzitetId}", method = RequestMethod.PUT)
	public ResponseEntity<UniverzitetDTO> updateUniverzitet(@PathVariable("univerzitetId") Long univerzitetId,
			@RequestBody Univerzitet izmenjeni) {
		Univerzitet univerzitet = univerzitetService.findOne(univerzitetId).orElse(null);
		if (univerzitet != null) {
			izmenjeni.setId(univerzitetId);
			izmenjeni = univerzitetService.save(izmenjeni);
//			ArrayList<FakultetDTO> fakulteti = new ArrayList<FakultetDTO>();
//			for (Fakultet fakultet : univerzitet.getFakulteti()) {
//				fakulteti.add(new FakultetDTO(fakultet.getId(), fakultet.getNaziv(), null));
//			}
			DrzavaDTO drzava = new DrzavaDTO(univerzitet.getAdresa().getMesto().getDrzava().getId()
					, univerzitet.getAdresa().getMesto().getDrzava().getNaziv(), null);
			MestoDTO mesto = new MestoDTO(univerzitet.getAdresa().getMesto().getId(), 
					univerzitet.getAdresa().getMesto().getNaziv(), drzava);
			AdresaDTO adresa = new AdresaDTO(univerzitet.getAdresa().getId(), univerzitet.getAdresa().getUlica(), 
					univerzitet.getAdresa().getBroj(), mesto, null);
			UniverzitetDTO izmenjenDto = new UniverzitetDTO(univerzitet.getId(), univerzitet.getNaziv(), univerzitet.getDatumOsnivanja(),
					adresa, univerzitet.getTelefon(), univerzitet.getEmail(), univerzitet.getOpis(), null, null);
			return new ResponseEntity<UniverzitetDTO>(izmenjenDto, HttpStatus.OK);
		}
		return new ResponseEntity<UniverzitetDTO>(HttpStatus.NOT_FOUND);
	}
	
	/** 
	 * bisanje univerziteta
	 * aministator
	 * @param univerzitetId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{univerzitetId}", method = RequestMethod.DELETE)
	public ResponseEntity<Univerzitet> deleteKarta(@PathVariable("univerzitetId") Long univerzitetId) {
		if (univerzitetService.findOne(univerzitetId).isPresent()) {
			univerzitetService.delete(univerzitetId);
			return new ResponseEntity<Univerzitet>(HttpStatus.OK);
		}
		return new ResponseEntity<Univerzitet>(HttpStatus.NOT_FOUND);
	}
}
