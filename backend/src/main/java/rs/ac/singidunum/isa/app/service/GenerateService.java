package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/*
 * Ova klasa predstavlja Genericki servis. Njega bi trebalo da nasledi svaki drugi servis.
 * Da bi se moglo raditi sa njom, potrebno je da se prosledi Repository. Svaki servis radi sa repository, 
 * tako je slucaj i ovde jer ce onda moci da nasledjuje sve druge. ArtikalRepository itd.
 * Takodje, potreban je Entity.
 * Na kraju je neophodan ID za taj Entiti (tip ID-a).
 * 
 * Ovo su sve osnovne metode poslovne logike.
 * Sve ostale metode, kao sto su npr. findByPrice ili slicno, dodaju se kao posebna metoda u servisima.
 */

@Service
public class GenerateService<Repository extends CrudRepository<Entity, ID>, Entity, ID> {
	
	@Autowired
	Repository repository;

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public Iterable<Entity> findAll() {
		return repository.findAll();
	}
	
	public Optional<Entity> findOne(ID id) {
		return repository.findById(id);
	}
	
	public Entity save(Entity model) {
		return repository.save(model);
	}
	
	public void delete(ID id) {
		repository.deleteById(id);
	}
}
