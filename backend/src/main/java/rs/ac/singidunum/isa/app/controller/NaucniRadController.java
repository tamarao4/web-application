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
import org.springframework.web.bind.annotation.RequestParam;

import rs.ac.singidunum.isa.app.dto.ApstraktDTO;
import rs.ac.singidunum.isa.app.dto.AutoriDTO;
import rs.ac.singidunum.isa.app.dto.KategorijaDTO;
import rs.ac.singidunum.isa.app.dto.KljucneReciDTO;
import rs.ac.singidunum.isa.app.dto.NaucniRadDTO;
import rs.ac.singidunum.isa.app.model.Autori;
import rs.ac.singidunum.isa.app.model.NaucniRad;
import rs.ac.singidunum.isa.app.service.NaucniRadService;
@Controller
@RequestMapping(path = "/api/naucniRad")
public class NaucniRadController {
	@Autowired
	NaucniRadService naucniRadService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<NaucniRadDTO>> getAllnaucniRadovi() {
		ArrayList<NaucniRadDTO> naucniRadovi = new ArrayList<NaucniRadDTO>();
		// autor
		// kljucne reci
		// apstrakti
		// kategorije
		
		for(NaucniRad naucniRad : naucniRadService.findAll()) {
			ApstraktDTO apstrakt = new ApstraktDTO(naucniRad.getApstrakt().getId(), naucniRad.getApstrakt().getTekst(), null);
			KategorijaDTO kategoija = new KategorijaDTO(naucniRad.getKategorija().getId(), naucniRad.getKategorija().getNaziv(), null);
			ArrayList<AutoriDTO> autori = new ArrayList<AutoriDTO>();
			for(Autori autor : naucniRad.getAutori()) {
				// treba dodati neregistrovanog korisnka, nastavnika, studenta
				// autori.add(new AutoriDTO(autor.getId(), autor.getNeregistrovaniKorisnik(), autor.getNastavnik(), autor.getStudent()));
			}
			naucniRadovi.add(new NaucniRadDTO(naucniRad.getId(), naucniRad.getNaziv(), autori, null));
		}
		
		return new ResponseEntity<Iterable<NaucniRadDTO>>(naucniRadovi, HttpStatus.OK);	
	}
	
	// pretraga po nazivu
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/naziv", method = RequestMethod.GET)
	public ResponseEntity<Iterable<NaucniRadDTO>> getAllnaucniRadoviNaziv(@RequestParam(name = "naziv", required = false) String naziv) {
		ArrayList<NaucniRadDTO> naucniRadovi = new ArrayList<NaucniRadDTO>();
		if(naziv ==  null) {
			for(NaucniRad naucniRad : naucniRadService.findAll()) {
				naucniRadovi.add(new NaucniRadDTO(naucniRad.getId(), naucniRad.getNaziv(), null, null));
			}
		} else {
			for(NaucniRad naucniRad : naucniRadService.findByNazivStartingWith(naziv)) {
				naucniRadovi.add(new NaucniRadDTO(naucniRad.getId(), naucniRad.getNaziv(), null, null));
			}
		}
		return new ResponseEntity<Iterable<NaucniRadDTO>>(naucniRadovi, HttpStatus.OK);	
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/reci", method = RequestMethod.GET)
	public ResponseEntity<Iterable<NaucniRadDTO>> getAllnaucniRadoviReci(@RequestParam(name = "reci", required = false) String reci) {
		ArrayList<NaucniRadDTO> naucniRadovi = new ArrayList<NaucniRadDTO>();
		if(reci ==  null) {
			for(NaucniRad naucniRad : naucniRadService.findAll()) {
				naucniRadovi.add(new NaucniRadDTO(naucniRad.getId(), naucniRad.getNaziv(), null, null));
			}
		} else {
		//	for(NaucniRad naucniRad : naucniRadService.findAll()) {
		//		ArrayList<KljucneReciDTO> kljucneReci = new ArrayList<KljucneReciDTO>();
				// koliko sam ja shvatila za vezu vise treba join da bi se uvezalo
//				for (KljucneReci)
//				naucniRadovi.add(new NaucniRadDTO(naucniRad.getId(), naucniRad.getNaziv()));
		//	}
		}
		return new ResponseEntity<Iterable<NaucniRadDTO>>(naucniRadovi, HttpStatus.OK);	
	}
	

	/**
	 * pretraga po zadatom Idu 
	 * neregistrovani korisnici 
	 * @param adresaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{naucniRadId}", method = RequestMethod.GET)
	public ResponseEntity<NaucniRadDTO> getAdresa(@PathVariable("naucniRadId") Long adresaId) {
		Optional<NaucniRad> adresa = naucniRadService.findOne(adresaId);
		NaucniRadDTO adresaDto;
		if (adresa.isPresent()) {
			adresaDto = new NaucniRadDTO(adresa.get().getId(), adresa.get().getNaziv(), null, null);
			return new ResponseEntity<NaucniRadDTO>(adresaDto, HttpStatus.OK);
		}

		return new ResponseEntity<NaucniRadDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * dodavanje novog adresaa
	 * administratori
	 * @param adresa
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<NaucniRad> createAdresa(@RequestBody NaucniRad adresa) {
		try {
			adresa.setId(null);
			naucniRadService.save(adresa);
			return new ResponseEntity<NaucniRad>(adresa, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<NaucniRad>(HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * izmena
	 * administratori 
	 * @param adresaId
	 * @param izmenjeni
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{naucniRadId}", method = RequestMethod.PUT)
	public ResponseEntity<NaucniRadDTO> updateAdresa(@PathVariable("naucniRadId") Long adresaId,
			@RequestBody NaucniRad izmenjeni) {
		NaucniRad adresa = naucniRadService.findOne(adresaId).orElse(null);
		if (adresa != null) {
			izmenjeni.setId(adresaId);
			izmenjeni = naucniRadService.save(izmenjeni);
			NaucniRadDTO izmenjenDto = new NaucniRadDTO(adresa.getId(), adresa.getNaziv(), null, null);
			return new ResponseEntity<NaucniRadDTO>(izmenjenDto, HttpStatus.OK);
		}
		return new ResponseEntity<NaucniRadDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * brisanje
	 * administratori
	 * @param adresaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{naucniRadId}", method = RequestMethod.DELETE)
	public ResponseEntity<NaucniRad> deleteKarta(@PathVariable("naucniRadId") Long adresaId) {
		if (naucniRadService.findOne(adresaId).isPresent()) {
			naucniRadService.delete(adresaId);
			return new ResponseEntity<NaucniRad>(HttpStatus.OK);
		}
		return new ResponseEntity<NaucniRad>(HttpStatus.NOT_FOUND);
	}

}