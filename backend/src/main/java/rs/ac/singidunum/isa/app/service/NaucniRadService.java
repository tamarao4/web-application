package rs.ac.singidunum.isa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.KljucneReci;
import rs.ac.singidunum.isa.app.model.NaucniRad;
import rs.ac.singidunum.isa.app.repository.KljucneReciRepository;
import rs.ac.singidunum.isa.app.repository.NaucniRadRepository;
@Service
public class NaucniRadService extends GenerateService<NaucniRadRepository, NaucniRad, Long> {
	@Autowired
	KljucneReciRepository kljucneRecirepository;
	
	public List<NaucniRad> findByNazivStartingWith(String naziv){
		return repository.findByNazivStartingWith(naziv);
	}
	
	
//	public List<KljucneReci> findByReciStartingWith(String reci){
// kljucneRecirepository.findByReciStartingWith(reci);
//	}

}
