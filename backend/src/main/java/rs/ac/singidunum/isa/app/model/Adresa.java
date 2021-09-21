package rs.ac.singidunum.isa.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Adresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String ulica;
	@Lob
	private String broj;
	
	@ManyToOne(optional = true)
	private Mesto mesto;
	
	@OneToOne(mappedBy = "adresa")
	private Univerzitet univerzitet;
	
	@OneToOne(mappedBy = "adresa")
	private Fakultet fakultet;
	
	@OneToMany(mappedBy = "adresa")
	private Set<Nastavnik> nastavnici = new HashSet<Nastavnik>();
	
	@OneToMany(mappedBy = "adresa")
	private Set<Student> studenti = new HashSet<Student>();
	
	public Adresa() {
		super();
	}

	public Adresa(Long id, String ulica, String broj, Mesto mesto, Univerzitet univerzitet, Fakultet fakultet,
			Set<Nastavnik> nastavnici, Set<Student> studenti) {
		super();
		this.id = id;
		this.ulica = ulica;
		this.broj = broj;
		this.mesto = mesto;
		this.univerzitet = univerzitet;
		this.fakultet = fakultet;
		this.nastavnici = nastavnici;
		this.studenti = studenti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public Set<Nastavnik> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(Set<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}

	public Set<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<Student> studenti) {
		this.studenti = studenti;
	}

	

}
