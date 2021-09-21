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

import rs.ac.singidunum.isa.app.dto.ObjavljeniNaucniRadDTO;
import rs.ac.singidunum.isa.app.model.ObjavljeniNaucniRad;
import rs.ac.singidunum.isa.app.service.ObjavljeniNaucniRadService;

@Controller
@RequestMapping(path = "/api/objavljeniNaucniRad")
public class ObjavljeniNaucniRadController {
	@Autowired
	ObjavljeniNaucniRadService objavljeniNaucniRadServiceService;
	
	
	/**
	 * prikaz svih fakultrta
	 * neprijavljeni korisnici
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<ObjavljeniNaucniRadDTO>> getAllStanice(){
		ArrayList<ObjavljeniNaucniRadDTO> drzave = new ArrayList<ObjavljeniNaucniRadDTO>();
		for(ObjavljeniNaucniRad adresa : objavljeniNaucniRadServiceService.findAll()) {
			drzave.add(new ObjavljeniNaucniRadDTO(adresa.getId(), adresa.getDatumObjave(), null ));
		}
	return new ResponseEntity<Iterable<ObjavljeniNaucniRadDTO>>(drzave, HttpStatus.OK);
	}
	
	/**
	 * pretraga po zadatom Idu 
	 * neregistrovani korisnici 
	 * @param adresaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{objavljeniNaucniRadId}", method = RequestMethod.GET)
	public ResponseEntity<ObjavljeniNaucniRadDTO> getAdresa(@PathVariable("objavljeniNaucniRadId") Long adresaId) {
		Optional<ObjavljeniNaucniRad> adresa = objavljeniNaucniRadServiceService.findOne(adresaId);
		ObjavljeniNaucniRadDTO adresaDto;
		if (adresa.isPresent()) {
			adresaDto = new ObjavljeniNaucniRadDTO(adresa.get().getId(), adresa.get().getDatumObjave(), null, null);
			return new ResponseEntity<ObjavljeniNaucniRadDTO>(adresaDto, HttpStatus.OK);
		}

		return new ResponseEntity<ObjavljeniNaucniRadDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * dodavanje novog adresaa
	 * administratori
	 * @param adresa
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<ObjavljeniNaucniRad> createAdresa(@RequestBody ObjavljeniNaucniRad adresa) {
		try {
			adresa.setId(null);
			objavljeniNaucniRadServiceService.save(adresa);
			return new ResponseEntity<ObjavljeniNaucniRad>(adresa, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ObjavljeniNaucniRad>(HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * izmena
	 * administratori 
	 * @param adresaId
	 * @param izmenjeni
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{objavljeniNaucniRadId}", method = RequestMethod.PUT)
	public ResponseEntity<ObjavljeniNaucniRadDTO> updateAdresa(@PathVariable("objavljeniNaucniRadId") Long adresaId,
			@RequestBody ObjavljeniNaucniRad izmenjeni) {
		ObjavljeniNaucniRad adresa = objavljeniNaucniRadServiceService.findOne(adresaId).orElse(null);
		if (adresa != null) {
			izmenjeni.setId(adresaId);
			izmenjeni = objavljeniNaucniRadServiceService.save(izmenjeni);
			ObjavljeniNaucniRadDTO izmenjenDto = new ObjavljeniNaucniRadDTO(adresa.getId(), adresa.getDatumObjave(), null, null);
			return new ResponseEntity<ObjavljeniNaucniRadDTO>(izmenjenDto, HttpStatus.OK);
		}
		return new ResponseEntity<ObjavljeniNaucniRadDTO>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * brisanje
	 * administratori
	 * @param adresaId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{objavljeniNaucniRadId}", method = RequestMethod.DELETE)
	public ResponseEntity<ObjavljeniNaucniRad> deleteKarta(@PathVariable("objavljeniNaucniRadId") Long adresaId) {
		if (objavljeniNaucniRadServiceService.findOne(adresaId).isPresent()) {
			objavljeniNaucniRadServiceService.delete(adresaId);
			return new ResponseEntity<ObjavljeniNaucniRad>(HttpStatus.OK);
		}
		return new ResponseEntity<ObjavljeniNaucniRad>(HttpStatus.NOT_FOUND);
	}

}