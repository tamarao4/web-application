package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class NastavnikDTO {
	private Long id;
	private String ime;
	private String biografija;
	private String jmbg;
	
	private ArrayList<ZvanjeDTO> zvanja = new ArrayList<ZvanjeDTO>();
	private ObjavljeniNaucniRadDTO objavljeniNaucniRad;
	
	private AdresaDTO adresa;
	private UniverzitetDTO univerzitet;
	private FakultetDTO fakultet;
	
	private AutoriDTO autori;
	
	public NastavnikDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



	public NastavnikDTO(Long id, String ime, String biografija, String jmbg, ArrayList<ZvanjeDTO> zvanja,
			ObjavljeniNaucniRadDTO objavljeniNaucniRad, AdresaDTO adresa, UniverzitetDTO univerzitet,
			FakultetDTO fakultet, AutoriDTO autori) {
		super();
		this.id = id;
		this.ime = ime;
		this.biografija = biografija;
		this.jmbg = jmbg;
		this.zvanja = zvanja;
		this.objavljeniNaucniRad = objavljeniNaucniRad;
		this.adresa = adresa;
		this.univerzitet = univerzitet;
		this.fakultet = fakultet;
		this.autori = autori;
	}

	public NastavnikDTO(Long id, String ime, String biografija) {
		
		super();
		this.id = id;
		this.ime = ime;
		this.biografija = biografija;
		new ArrayList<ZvanjeDTO>();
	}






	public ObjavljeniNaucniRadDTO getObjavljeniNaucniRad() {
		return objavljeniNaucniRad;
	}






	public void setObjavljeniNaucniRad(ObjavljeniNaucniRadDTO objavljeniNaucniRad) {
		this.objavljeniNaucniRad = objavljeniNaucniRad;
	}






	public AutoriDTO getAutori() {
		return autori;
	}






	public void setAutori(AutoriDTO autori) {
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

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public ArrayList<ZvanjeDTO> getZvanja() {
		return zvanja;
	}

	public void setZvanja(ArrayList<ZvanjeDTO> zvanja) {
		this.zvanja = zvanja;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public UniverzitetDTO getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(UniverzitetDTO univerzitet) {
		this.univerzitet = univerzitet;
	}

	public FakultetDTO getFakultet() {
		return fakultet;
	}

	public void setFakultet(FakultetDTO fakultet) {
		this.fakultet = fakultet;
	}
	
}
