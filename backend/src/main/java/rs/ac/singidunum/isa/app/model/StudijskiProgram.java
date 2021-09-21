package rs.ac.singidunum.isa.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class StudijskiProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	
	@OneToOne(optional = true)
	private Nastavnik nastavnik;
	
	@ManyToOne(optional = true)
	private Fakultet fakultet;
	
	@OneToOne(mappedBy = "studijskiProgram")
	private GodinaStudija godinaStudija;

	public StudijskiProgram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudijskiProgram(Long id, String naziv, Nastavnik nastavnik, Fakultet fakultet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nastavnik = nastavnik;
		this.fakultet = fakultet;
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

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	
	
}
