package rs.ac.singidunum.isa.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.isa.app.model.NaucniRad;

@Repository
public interface NaucniRadRepository extends CrudRepository<NaucniRad, Long> {
	List<NaucniRad> findByNazivStartingWith(String naziv);
}
