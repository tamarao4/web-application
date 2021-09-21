package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Zvanje;
import rs.ac.singidunum.isa.app.repository.ZvanjeRepository;

@Service
public class ZvanjeService extends GenerateService<ZvanjeRepository, Zvanje, Long>{

}
