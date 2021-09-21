package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.KljucneReci;
import rs.ac.singidunum.isa.app.repository.KljucneReciRepository;
@Service
public class KljucneReciService extends GenerateService<KljucneReciRepository, KljucneReci, Long> {

}
