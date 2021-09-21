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

import rs.ac.singidunum.isa.app.dto.GodinaStudijaDTO;
import rs.ac.singidunum.isa.app.dto.NastavnikDTO;
import rs.ac.singidunum.isa.app.dto.PredmetDTO;
import rs.ac.singidunum.isa.app.dto.StudijskiProgramDTO;

import rs.ac.singidunum.isa.app.model.Predmet;
import rs.ac.singidunum.isa.app.model.StudijskiProgram;
import rs.ac.singidunum.isa.app.service.StudijskiProgramService;

@Controller
@RequestMapping(path = "/api/studijskiprogrami")
public class StudijskiProgramController {
	
	@Autowired
	private StudijskiProgramService studijskiProgramService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<StudijskiProgramDTO>> getAllStudijskiProgrami() {
		ArrayList<StudijskiProgramDTO> studijskiProgrami = new ArrayList<StudijskiProgramDTO>();
		for(StudijskiProgram studijskiProgram : studijskiProgramService.findAll()) {
			// podaci o rukovodiocu
			NastavnikDTO rukovodilac = new NastavnikDTO(studijskiProgram.getNastavnik().getId(), studijskiProgram.getNastavnik().getIme(), 
					studijskiProgram.getNastavnik().getBiografija(), studijskiProgram.getNastavnik().getJmbg(), null, null, null, null, null, null);
			// podaci o predmeti, po godinama studija, zato ide preko godine studija
			ArrayList<PredmetDTO> predmeti = new ArrayList<PredmetDTO>();
			for (Predmet predmet : studijskiProgram.getGodinaStudija().getPredmeti()) {
				
				// Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi,
				//int drugiObliciNastave, int istazivackiRad, int ostaliCasovi
				predmeti.add(new PredmetDTO(predmet.getId(), predmet.getNaziv(), predmet.getEspb(), predmet.isObavezan(), predmet.getBrojPredavanja(), predmet.getBrojVezbi(),
						predmet.getDrugiObliciNastave(), predmet.getIstazivackiRad(), predmet.getOstaliCasovi(), null, null, null));
			}
			GodinaStudijaDTO godina = new GodinaStudijaDTO(studijskiProgram.getGodinaStudija().getId(), studijskiProgram.getGodinaStudija().getGodina(),
					null, predmeti);
			studijskiProgrami.add(new StudijskiProgramDTO(studijskiProgram.getId(), studijskiProgram.getNaziv(), rukovodilac, null, godina));
		}
		return new ResponseEntity<Iterable<StudijskiProgramDTO>>(studijskiProgrami, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{studijskiProgramId}", method = RequestMethod.GET)
	public ResponseEntity<StudijskiProgramDTO> getStudijskiProgram(@PathVariable("studijskiProgramId") Long studijskiProgramId) {
		Optional<StudijskiProgram> studijskiProgram = studijskiProgramService.findOne(studijskiProgramId);

		StudijskiProgramDTO studijskiProgramDTO;

		if (studijskiProgram.isPresent()) {
			studijskiProgramDTO = new StudijskiProgramDTO(studijskiProgram.get().getId(), studijskiProgram.get().getNaziv());
			return new ResponseEntity<StudijskiProgramDTO>(studijskiProgramDTO, HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgramDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<StudijskiProgram> createStudijskiProgram(@RequestBody StudijskiProgram studijskiProgram) {
		try {
			studijskiProgramService.save(studijskiProgram);
			return new ResponseEntity<StudijskiProgram>(studijskiProgram, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<StudijskiProgram>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{studijskiProgramId}", method = RequestMethod.PUT)
	public ResponseEntity<StudijskiProgram> updateStudijskiProgram(@PathVariable("studijskiProgramId") Long studijskiProgramId,
			@RequestBody StudijskiProgram izmenjeniStudijskiProgram) {
		StudijskiProgram studijskiProgram = studijskiProgramService.findOne(studijskiProgramId).orElse(null);
		if (studijskiProgram != null) {
			izmenjeniStudijskiProgram.setId(studijskiProgramId);
			izmenjeniStudijskiProgram = studijskiProgramService.save(izmenjeniStudijskiProgram);
			return new ResponseEntity<StudijskiProgram>(izmenjeniStudijskiProgram, HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgram>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{studijskiProgramId}", method = RequestMethod.DELETE)
	public ResponseEntity<StudijskiProgram> deleteStudijskiProgram(@PathVariable("studijskiProgramId") Long studijskiProgramId) {
		if (studijskiProgramService.findOne(studijskiProgramId).isPresent()) {
			studijskiProgramService.delete(studijskiProgramId);
			return new ResponseEntity<StudijskiProgram>(HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgram>(HttpStatus.NOT_FOUND);
	}
}
