package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Student;
import rs.ac.singidunum.isa.app.repository.StudentRepository;

@Service
public class StudentService extends GenerateService<StudentRepository, Student, Long>{

}
