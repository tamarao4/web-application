package rs.ac.singidunum.isa.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class NastavnikNaRealizaciji {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double brojCasova;
	
	@OneToMany(mappedBy = "nastavnikNaRealizaciji")
	private Set<RealizacijaPredmeta> realizacijaPredmeta = new HashSet<RealizacijaPredmeta>();
	
	@OneToMany(mappedBy = "nastavnikNaRealizaciji")
	private Set<TipNastave> tipNastave = new HashSet<TipNastave>();
	
	

	public NastavnikNaRealizaciji() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NastavnikNaRealizaciji(Long id, double brojCasova, Set<RealizacijaPredmeta> realizacijaPredmeta,
			Set<TipNastave> tipNastave) {
		super();
		this.id = id;
		this.brojCasova = brojCasova;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.tipNastave = tipNastave;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBrojCasova() {
		return brojCasova;
	}

	public void setBrojCasova(double brojCasova) {
		this.brojCasova = brojCasova;
	}



	public Set<RealizacijaPredmeta> getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}



	public void setRealizacijaPredmeta(Set<RealizacijaPredmeta> realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}



	public Set<TipNastave> getTipNastave() {
		return tipNastave;
	}

	public void setTipNastave(Set<TipNastave> tipNastave) {
		this.tipNastave = tipNastave;
	}

	
	
}
	
	
	
