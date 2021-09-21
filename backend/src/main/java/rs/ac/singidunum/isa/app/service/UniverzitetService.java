package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Univerzitet;
import rs.ac.singidunum.isa.app.repository.UniverzitetRepository;

@Service
public class UniverzitetService extends GenerateService<UniverzitetRepository, Univerzitet, Long>{

}
