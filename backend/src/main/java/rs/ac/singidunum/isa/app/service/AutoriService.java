package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Autori;
import rs.ac.singidunum.isa.app.repository.AutoriRepository;
@Service
public class AutoriService extends GenerateService<AutoriRepository, Autori, Long> {

}
