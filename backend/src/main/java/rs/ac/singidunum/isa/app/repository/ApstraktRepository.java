package rs.ac.singidunum.isa.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.isa.app.model.Apstrakt;
@Repository
public interface ApstraktRepository extends CrudRepository<Apstrakt, Long> {
}
