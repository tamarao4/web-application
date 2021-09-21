package rs.ac.singidunum.isa.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Drzava {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	
	// u jednoj drzavi postji vise mesta
	@OneToMany(mappedBy = "drzava")
	private Set<Mesto> mesta = new HashSet<Mesto>();

	public Drzava() {
		super();
	}
	
	public Drzava(Long id, String naziv, Set<Mesto> mesta) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.mesta = mesta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Mesto> getMesta() {
		return mesta;
	}

	public void setMesta(Set<Mesto> mesta) {
		this.mesta = mesta;
	}
	
	
}
