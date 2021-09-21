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
public class Fakultet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	private String telefon;
	private String email;
	private String opis;
	
	@ManyToOne(optional = true)
	private Univerzitet univerzitet;
	
	@OneToOne
	private Adresa adresa;
	
	@OneToOne
	private Nastavnik dekan;
	
	@OneToMany(mappedBy = "fakultet")
	private Set<StudijskiProgram> studijskiProgrami = new HashSet<StudijskiProgram>();

	public Fakultet() {
		super();
	}

	public Fakultet(Long id, String naziv, String telefon, String email, String opis, Univerzitet univerzitet,
			Adresa adresa, Nastavnik dekan, Set<StudijskiProgram> studijskiProgrami) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.telefon = telefon;
		this.email = email;
		this.opis = opis;
		this.univerzitet = univerzitet;
		this.adresa = adresa;
		this.dekan = dekan;
		this.studijskiProgrami = studijskiProgrami;
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

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Nastavnik getDekan() {
		return dekan;
	}

	public void setDekan(Nastavnik dekan) {
		this.dekan = dekan;
	}

	public Set<StudijskiProgram> getStudijskiProgrami() {
		return studijskiProgrami;
	}

	public void setStudijskiProgrami(Set<StudijskiProgram> studijskiProgrami) {
		this.studijskiProgrami = studijskiProgrami;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	
}
