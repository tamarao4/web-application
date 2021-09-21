package rs.ac.singidunum.isa.app.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Ishod;
import rs.ac.singidunum.isa.app.repository.IshodRepository;
@Service
public class IshodService  extends GenerateService<IshodRepository, Ishod, Long> {

}
