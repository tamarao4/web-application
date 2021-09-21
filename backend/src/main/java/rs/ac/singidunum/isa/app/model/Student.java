package rs.ac.singidunum.isa.app.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String jmbg;
	
	@Lob
	private String ime;
	
	@OneToOne(optional = true)
	private StudentNaGodini studentNaGodini;
	
	@ManyToOne(optional = true)
	private Adresa adresa;
	
	@OneToOne(optional = true)
	private PohadjanjePredmeta pohadjanjePredmeta;
	
	@ManyToOne(optional = true)
	private Autori autori;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(Long id, String jmbg, String ime, StudentNaGodini studentNaGodini, Adresa adresa,
			PohadjanjePredmeta pohadjanjePredmeta, Autori autori) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.ime = ime;
		this.studentNaGodini = studentNaGodini;
		this.adresa = adresa;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
		this.autori = autori;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public StudentNaGodini getStudentNaGodini() {
		return studentNaGodini;
	}

	public void setStudentNaGodini(StudentNaGodini studentNaGodini) {
		this.studentNaGodini = studentNaGodini;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public PohadjanjePredmeta getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(PohadjanjePredmeta pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}

	public Autori getAutor() {
		return autori;
	}

	public void setAutor(Autori autori) {
		this.autori = autori;
	}
	
	
}
