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

import rs.ac.singidunum.isa.app.dto.ApstraktDTO;
import rs.ac.singidunum.isa.app.model.Apstrakt;
import rs.ac.singidunum.isa.app.service.ApstraktService;

@Controller
@RequestMapping(path = "/api/apstrakt")
public class ApstraktController {
	@Autowired
	ApstraktService apstraktServiceService;
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<ApstraktDTO>> getAllStanice(){
		ArrayList<ApstraktDTO> drzave = new ArrayList<ApstraktDTO>();
		for(Apstrakt adresa : apstraktServiceService.findAll()) {
			drzave.add(new ApstraktDTO(adresa.getId(), adresa.getTekst(), null));
		}
	return new ResponseEntity<Iterable<ApstraktDTO>>(drzave, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{apstraktId}", method = RequestMethod.GET)
	public ResponseEntity<ApstraktDTO> getAdresa(@PathVariable("apstraktId") Long adresaId) {
		Optional<Apstrakt> adresa = apstraktServiceService.findOne(adresaId);
		ApstraktDTO adresaDto;
		if (adresa.isPresent()) {
			adresaDto = new ApstraktDTO(adresa.get().getId(), adresa.get().getTekst());
			return new ResponseEntity<ApstraktDTO>(adresaDto, HttpStatus.OK);
		}

		return new ResponseEntity<ApstraktDTO>(HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Apstrakt> createAdresa(@RequestBody Apstrakt adresa) {
		try {
			adresa.setId(null);
			apstraktServiceService.save(adresa);
			return new ResponseEntity<Apstrakt>(adresa, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Apstrakt>(HttpStatus.BAD_REQUEST);
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{apstraktId}", method = RequestMethod.PUT)
	public ResponseEntity<ApstraktDTO> updateAdresa(@PathVariable("apstraktId") Long adresaId,
			@RequestBody Apstrakt izmenjeni) {
		Apstrakt adresa = apstraktServiceService.findOne(adresaId).orElse(null);
		if (adresa != null) {
			izmenjeni.setId(adresaId);
			izmenjeni = apstraktServiceService.save(izmenjeni);
			ApstraktDTO izmenjenDto = new ApstraktDTO(adresa.getId(), adresa.getTekst(), null);
			return new ResponseEntity<ApstraktDTO>(izmenjenDto, HttpStatus.OK);
		}
		return new ResponseEntity<ApstraktDTO>(HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{apstraktId}", method = RequestMethod.DELETE)
	public ResponseEntity<Apstrakt> deleteKarta(@PathVariable("apstraktId") Long adresaId) {
		if (apstraktServiceService.findOne(adresaId).isPresent()) {
			apstraktServiceService.delete(adresaId);
			return new ResponseEntity<Apstrakt>(HttpStatus.OK);
		}
		return new ResponseEntity<Apstrakt>(HttpStatus.NOT_FOUND);
	}
}
