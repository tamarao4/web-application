package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class PredmetDTO {
	private Long id;
	private String naziv;
	private int espb;
	private boolean obavezan;
	private int brojPredavanja;
	private int brojVezbi;
	private int drugiObliciNastave;
	private int istazivackiRad;
	private int ostaliCasovi;
	private GodinaStudijaDTO godinaStudija;
	private RealizacijaPredmetaDTO realizacijPredmeta;
	private ArrayList<IshodDTO> ishod = new ArrayList<IshodDTO>();
	public PredmetDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PredmetDTO(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi,
			int drugiObliciNastave, int istazivackiRad, int ostaliCasovi, GodinaStudijaDTO godinaStudija,
			RealizacijaPredmetaDTO realizacijPredmeta, ArrayList<IshodDTO> ishod) {
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
	
	public PredmetDTO(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi,
			int drugiObliciNastave, int istazivackiRad, int ostaliCasovi) {
		this(id,  naziv,  espb,  obavezan,  brojPredavanja,  brojVezbi,
			 drugiObliciNastave,  istazivackiRad,  ostaliCasovi,null,null,new ArrayList<IshodDTO>());
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
	public GodinaStudijaDTO getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(GodinaStudijaDTO godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public RealizacijaPredmetaDTO getRealizacijPredmeta() {
		return realizacijPredmeta;
	}
	public void setRealizacijPredmeta(RealizacijaPredmetaDTO realizacijPredmeta) {
		this.realizacijPredmeta = realizacijPredmeta;
	}
	public ArrayList<IshodDTO> getIshod() {
		return ishod;
	}
	public void setIshod(ArrayList<IshodDTO> ishod) {
		this.ishod = ishod;
	}
	
	
	

}
