package rs.ac.singidunum.isa.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.isa.app.model.Fakultet;

@Repository
public interface FakultetRepository extends CrudRepository<Fakultet, Long> {
	
}
