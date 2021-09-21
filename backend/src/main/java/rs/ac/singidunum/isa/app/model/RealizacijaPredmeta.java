package rs.ac.singidunum.isa.app.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;



@Entity
public class RealizacijaPredmeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = true)
	private NastavnikNaRealizaciji nastavnikNaRealizaciji;
	
	@OneToOne
	private Predmet predmet;
	
	@ManyToOne(optional = true)
	private PohadjanjePredmeta pohadjanjePredmeta;


	public RealizacijaPredmeta() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RealizacijaPredmeta(Long id, NastavnikNaRealizaciji nastavnikNaRealizaciji, Predmet predmet,
			PohadjanjePredmeta pohadjanjePredmeta) {
		super();
		this.id = id;
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
		this.predmet = predmet;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public NastavnikNaRealizaciji getNastavnikNaRealizaciji() {
		return nastavnikNaRealizaciji;
	}


	public void setNastavnikNaRealizaciji(NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}


	public Predmet getPredmet() {
		return predmet;
	}


	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}


	public PohadjanjePredmeta getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}


	public void setPohadjanjePredmeta(PohadjanjePredmeta pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}






}
