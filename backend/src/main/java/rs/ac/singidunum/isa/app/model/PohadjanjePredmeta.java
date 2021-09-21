package rs.ac.singidunum.isa.app.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.OneToMany;

@Entity
public class PohadjanjePredmeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double konacnaOcena;
	
	@OneToMany(mappedBy = "pohadjanjePredmeta")
	private Set<RealizacijaPredmeta> realizacijaPredmeta = new HashSet<RealizacijaPredmeta>();

	public PohadjanjePredmeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PohadjanjePredmeta(Long id, double konacnaOcena, Set<RealizacijaPredmeta> realizacijaPredmeta) {
		super();
		this.id = id;
		this.konacnaOcena = konacnaOcena;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getKonacnaOcena() {
		return konacnaOcena;
	}

	public void setKonacnaOcena(double konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}

	public Set<RealizacijaPredmeta> getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(Set<RealizacijaPredmeta> realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	

	
	
}
