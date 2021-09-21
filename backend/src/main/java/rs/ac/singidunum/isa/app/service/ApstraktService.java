package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Apstrakt;
import rs.ac.singidunum.isa.app.repository.ApstraktRepository;

@Service
public class ApstraktService extends GenerateService<ApstraktRepository, Apstrakt, Long>{

}
