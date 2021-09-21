package rs.ac.singidunum.isa.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class NaucniRad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	
	// autori mogu biti drugi nastavnici ili osobe koje nisu nastavnici registrovani  sistemu
	// neka veza sa korisnikom
	@ManyToMany
	private Set<Autori> autori;
	
	// kljucne reci
	@ManyToMany
	private Set<KljucneReci> kljucneReci = new HashSet<KljucneReci>();
	
	// apstrakt
	@OneToOne(mappedBy = "naucniRad")
	private Apstrakt apstrakt;
	
	// kategorijaa
	@OneToOne(mappedBy = "naucniRad")
	private Kategorija kategorija;

	public NaucniRad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NaucniRad(Long id, String naziv, Set<Autori> autori, Set<KljucneReci> kljucneReci, Apstrakt apstrakt,
			Kategorija kategorija) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.autori = autori;
		this.kljucneReci = kljucneReci;
		this.apstrakt = apstrakt;
		this.kategorija = kategorija;
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

	public Set<Autori> getAutori() {
		return autori;
	}

	public void setAutori(Set<Autori> autori) {
		this.autori = autori;
	}

	public Set<KljucneReci> getKljucneReci() {
		return kljucneReci;
	}

	public void setKljucneReci(Set<KljucneReci> kljucneReci) {
		this.kljucneReci = kljucneReci;
	}

	public Apstrakt getApstrakt() {
		return apstrakt;
	}

	public void setApstrakt(Apstrakt apstrakt) {
		this.apstrakt = apstrakt;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}


	
}
