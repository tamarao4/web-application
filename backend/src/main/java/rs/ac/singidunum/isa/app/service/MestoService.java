package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Mesto;
import rs.ac.singidunum.isa.app.repository.MestoRepository;

@Service
public class MestoService extends GenerateService<MestoRepository, Mesto, Long>{

}
