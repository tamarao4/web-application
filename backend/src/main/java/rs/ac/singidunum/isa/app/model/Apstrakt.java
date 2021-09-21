package rs.ac.singidunum.isa.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Apstrakt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String tekst;

	@OneToOne
	private NaucniRad naucniRad;


	public Apstrakt() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Apstrakt(Long id, String tekst, NaucniRad naucniRad) {
		super();
		this.id = id;
		this.tekst = tekst;
		this.naucniRad = naucniRad;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTekst() {
		return tekst;
	}


	public void setTekst(String tekst) {
		this.tekst = tekst;
	}


	public NaucniRad getNaucniRad() {
		return naucniRad;
	}


	public void setNaucniRad(NaucniRad naucniRad) {
		this.naucniRad = naucniRad;
	}
	
}
