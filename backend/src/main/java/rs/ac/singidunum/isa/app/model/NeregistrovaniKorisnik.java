package rs.ac.singidunum.isa.app.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NeregistrovaniKorisnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ime;
	private String prezime;
	@ManyToOne(optional = true)
	private Autori autori;
	public NeregistrovaniKorisnik() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NeregistrovaniKorisnik(Long id, String ime, String prezime, Autori autori) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
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
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Autori getNautori() {
		return autori;
	}
	public void setNautori(Autori autori) {
		this.autori = autori;
	}
	
	
	
}
