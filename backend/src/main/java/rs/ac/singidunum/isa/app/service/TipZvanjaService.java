package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.TipZvanja;
import rs.ac.singidunum.isa.app.repository.TipZvanjaRepository;

@Service
public class TipZvanjaService extends GenerateService<TipZvanjaRepository, TipZvanja, Long>{

}
