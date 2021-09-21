package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Nastavnik;
import rs.ac.singidunum.isa.app.repository.NastavnikRepository;

@Service
public class NastavnikService extends GenerateService<NastavnikRepository, Nastavnik, Long>{

}
