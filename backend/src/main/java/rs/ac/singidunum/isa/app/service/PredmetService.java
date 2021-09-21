package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Predmet;
import rs.ac.singidunum.isa.app.repository.PredmetRepository;
@Service
public class PredmetService  extends GenerateService<PredmetRepository, Predmet, Long>{

}
