package rs.ac.singidunum.isa.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Predmet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String naziv;
	private int espb;
	private boolean obavezan;
	private int brojPredavanja;
	private int brojVezbi;
	private int drugiObliciNastave;
	private int istazivackiRad;
	private int ostaliCasovi;
	
	@ManyToOne(optional=true)
	private GodinaStudija godinaStudija;
	
	@OneToOne(mappedBy = "predmet")
	private RealizacijaPredmeta realizacijPredmeta;
	
	@OneToMany(mappedBy ="predmet")
	private Set<Ishod> ishod = new HashSet<Ishod>();

	public Predmet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Predmet(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi,
			int drugiObliciNastave, int istazivackiRad, int ostaliCasovi, GodinaStudija godinaStudija,
			RealizacijaPredmeta realizacijPredmeta, Set<Ishod> ishod) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.obavezan = obavezan;
		this.brojPredavanja = brojPredavanja;
		this.brojVezbi = brojVezbi;
		this.drugiObliciNastave = drugiObliciNastave;
		this.istazivackiRad = istazivackiRad;
		this.ostaliCasovi = ostaliCasovi;
		this.godinaStudija = godinaStudija;
		this.realizacijPredmeta = realizacijPredmeta;
		this.ishod = ishod;
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

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public boolean isObavezan() {
		return obavezan;
	}

	public void setObavezan(boolean obavezan) {
		this.obavezan = obavezan;
	}

	public int getBrojPredavanja() {
		return brojPredavanja;
	}

	public void setBrojPredavanja(int brojPredavanja) {
		this.brojPredavanja = brojPredavanja;
	}

	public int getBrojVezbi() {
		return brojVezbi;
	}

	public void setBrojVezbi(int brojVezbi) {
		this.brojVezbi = brojVezbi;
	}

	public int getDrugiObliciNastave() {
		return drugiObliciNastave;
	}

	public void setDrugiObliciNastave(int drugiObliciNastave) {
		this.drugiObliciNastave = drugiObliciNastave;
	}

	public int getIstazivackiRad() {
		return istazivackiRad;
	}

	public void setIstazivackiRad(int istazivackiRad) {
		this.istazivackiRad = istazivackiRad;
	}

	public int getOstaliCasovi() {
		return ostaliCasovi;
	}

	public void setOstaliCasovi(int ostaliCasovi) {
		this.ostaliCasovi = ostaliCasovi;
	}

	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public RealizacijaPredmeta getRealizacijPredmeta() {
		return realizacijPredmeta;
	}

	public void setRealizacijPredmeta(RealizacijaPredmeta realizacijPredmeta) {
		this.realizacijPredmeta = realizacijPredmeta;
	}

	public Set<Ishod> getIshod() {
		return ishod;
	}

	public void setIshod(Set<Ishod> ishod) {
		this.ishod = ishod;
	}
	
}
