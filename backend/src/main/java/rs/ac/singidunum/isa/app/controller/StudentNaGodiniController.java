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

import rs.ac.singidunum.isa.app.dto.StudentNaGodiniDTO;
import rs.ac.singidunum.isa.app.model.StudentNaGodini;
import rs.ac.singidunum.isa.app.service.StudentNaGodiniService;

@Controller
@RequestMapping(path = "/api/studentinagodini")
public class StudentNaGodiniController {
	
	@Autowired
	private StudentNaGodiniService studentNaGodiniService;
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<StudentNaGodiniDTO>> getAllStudentiNaGodini() {
		ArrayList<StudentNaGodiniDTO> studentiNaGodini = new ArrayList<StudentNaGodiniDTO>();
		for(StudentNaGodini studentNaGodini : studentNaGodiniService.findAll()) {
			studentiNaGodini.add(new StudentNaGodiniDTO(studentNaGodini.getId(), studentNaGodini.getDatumUpisa(), studentNaGodini.getBrojIndeksa()));
		}
		return new ResponseEntity<Iterable<StudentNaGodiniDTO>>(studentiNaGodini, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{studentNaGodiniId}", method = RequestMethod.GET)
	public ResponseEntity<StudentNaGodiniDTO> getStudentNaGodini(@PathVariable("studentNaGodiniId") Long studentNaGodiniId) {
		Optional<StudentNaGodini> studentNaGodini = studentNaGodiniService.findOne(studentNaGodiniId);

		StudentNaGodiniDTO studentNaGodiniDTO;

		if (studentNaGodini.isPresent()) {
			studentNaGodiniDTO = new StudentNaGodiniDTO(studentNaGodini.get().getId(), studentNaGodini.get().getDatumUpisa(), studentNaGodini.get().getBrojIndeksa());
			return new ResponseEntity<StudentNaGodiniDTO>(studentNaGodiniDTO, HttpStatus.OK);
		}
		return new ResponseEntity<StudentNaGodiniDTO>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<StudentNaGodini> createStudentNaGodini(@RequestBody StudentNaGodini studentNaGodini) {
		try {
			studentNaGodiniService.save(studentNaGodini);
			return new ResponseEntity<StudentNaGodini>(studentNaGodini, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<StudentNaGodini>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{studentNaGodiniId}", method = RequestMethod.PUT)
	public ResponseEntity<StudentNaGodini> updateStudentNaGodini(@PathVariable("studentNaGodiniId") Long studentNaGodiniId,
			@RequestBody StudentNaGodini izmenjeniStudentNaGodini) {
		StudentNaGodini studentNaGodini = studentNaGodiniService.findOne(studentNaGodiniId).orElse(null);
		if (studentNaGodini != null) {
			izmenjeniStudentNaGodini.setId(studentNaGodiniId);
			izmenjeniStudentNaGodini = studentNaGodiniService.save(izmenjeniStudentNaGodini);
			return new ResponseEntity<StudentNaGodini>(izmenjeniStudentNaGodini, HttpStatus.OK);
		}
		return new ResponseEntity<StudentNaGodini>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/{studentNaGodiniId}", method = RequestMethod.DELETE)
	public ResponseEntity<StudentNaGodini> deleteStudentNaGodini(@PathVariable("studentNaGodiniId") Long studentNaGodiniId) {
		if (studentNaGodiniService.findOne(studentNaGodiniId).isPresent()) {
			studentNaGodiniService.delete(studentNaGodiniId);
			return new ResponseEntity<StudentNaGodini>(HttpStatus.OK);
		}
		return new ResponseEntity<StudentNaGodini>(HttpStatus.NOT_FOUND);
	}
}
