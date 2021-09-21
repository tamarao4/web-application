package rs.ac.singidunum.isa.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class TipNastave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true)
	private String naziv;
	
	@ManyToOne(optional = true)
	private NastavnikNaRealizaciji nastavnikNaRealizaciji;

	public TipNastave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipNastave(Long id, String naziv, NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
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

	public NastavnikNaRealizaciji getNastavnikNaRealizaciji() {
		return nastavnikNaRealizaciji;
	}

	public void setNastavnikNaRealizaciji(NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}
	
	


}
