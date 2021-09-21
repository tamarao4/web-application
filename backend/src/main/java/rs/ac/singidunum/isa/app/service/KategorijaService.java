package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Kategorija;
import rs.ac.singidunum.isa.app.repository.KategorijaRepository;
@Service
public class KategorijaService extends GenerateService<KategorijaRepository, Kategorija, Long> {

}
