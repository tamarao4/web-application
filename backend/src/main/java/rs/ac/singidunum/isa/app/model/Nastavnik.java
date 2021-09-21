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
public class Nastavnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String ime;
	@Lob
	private String biografija;
	@Lob
	private String jmbg;
	
	@OneToMany(mappedBy = "nastavnik")
	private Set<Zvanje> zvanja = new HashSet<Zvanje>();
	
	@ManyToOne(optional = true)
	private Adresa adresa;
	
	@ManyToOne(optional = true)
	private ObjavljeniNaucniRad objavljeniNaucniRad;
	
	@OneToOne(mappedBy = "rektor")
	private Univerzitet univerzitet;
	
	@OneToOne(mappedBy = "dekan")
	private Fakultet fakultet;
	
	@ManyToOne(optional = true)
	private Autori autori;
	
	public Nastavnik() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Nastavnik(Long id, String ime, String biografija, String jmbg, Set<Zvanje> zvanja, Adresa adresa,
			ObjavljeniNaucniRad objavljeniNaucniRad, Univerzitet univerzitet, Fakultet fakultet, Autori autori) {
		super();
		this.id = id;
		this.ime = ime;
		this.biografija = biografija;
		this.jmbg = jmbg;
		this.zvanja = zvanja;
		this.adresa = adresa;
		this.objavljeniNaucniRad = objavljeniNaucniRad;
		this.univerzitet = univerzitet;
		this.fakultet = fakultet;
		this.autori = autori;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	public Set<Zvanje> getZvanje() {
		return zvanja;
	}
	
	public void setZvanja(Set<Zvanje> zvanja) {
		this.zvanja = zvanja;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	
	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Set<Zvanje> getZvanja() {
		return zvanja;
	}

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}

	public ObjavljeniNaucniRad getObjavljeniNaucniRad() {
		return objavljeniNaucniRad;
	}

	public void setObjavljeniNaucniRad(ObjavljeniNaucniRad objavljeniNaucniRad) {
		this.objavljeniNaucniRad = objavljeniNaucniRad;
	}

	public Autori getAutor() {
		return autori;
	}

	public void setAutor(Autori autori) {
		this.autori = autori;
	}
	
	
	
}
