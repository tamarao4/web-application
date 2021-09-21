package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.TipNastave;
import rs.ac.singidunum.isa.app.repository.TipNastaveRepository;

@Service
public class TipNastaveService extends GenerateService<TipNastaveRepository, TipNastave, Long>{

}
