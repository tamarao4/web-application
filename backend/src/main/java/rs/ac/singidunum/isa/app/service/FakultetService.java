package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Fakultet;
import rs.ac.singidunum.isa.app.repository.FakultetRepository;

@Service
public class FakultetService extends GenerateService<FakultetRepository, Fakultet, Long>{

}
