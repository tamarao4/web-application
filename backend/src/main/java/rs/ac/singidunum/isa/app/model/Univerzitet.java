package rs.ac.singidunum.isa.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Univerzitet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datumOsnivanja;
	
	private String telefon;
	private String email;
	private String opis;
	
	//@JoinColumn(name = "adresa_id")
	@OneToOne
	private Adresa adresa;
	
	@OneToMany(mappedBy = "univerzitet")
	private Set<Fakultet> fakulteti = new HashSet<Fakultet>();
	
	@OneToOne
	private Nastavnik rektor;

	public Univerzitet() {
		super();
	}



	public Univerzitet(Long id, String naziv, Date datumOsnivanja, String telefon, String email, String opis,
			Adresa adresa, Set<Fakultet> fakulteti, Nastavnik rektor) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.telefon = telefon;
		this.email = email;
		this.opis = opis;
		this.adresa = adresa;
		this.fakulteti = fakulteti;
		this.rektor = rektor;
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

	public Date getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Set<Fakultet> getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(Set<Fakultet> fakulteti) {
		this.fakulteti = fakulteti;
	}

	public Nastavnik getDekan() {
		return rektor;
	}

	public void setDekan(Nastavnik rektor) {
		this.rektor = rektor;
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



	public Nastavnik getRektor() {
		return rektor;
	}



	public void setRektor(Nastavnik rektor) {
		this.rektor = rektor;
	}



	public String getOpis() {
		return opis;
	}



	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	
}
