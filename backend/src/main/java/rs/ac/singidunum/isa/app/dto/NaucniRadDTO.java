package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;



public class NaucniRadDTO {
private Long id;
	private String naziv;
	private ArrayList<AutoriDTO> autori = new ArrayList<AutoriDTO>();
	private ArrayList<KljucneReciDTO> kljucneReci = new ArrayList<KljucneReciDTO>();
	
	private ApstraktDTO apstrakt;
	
	public NaucniRadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NaucniRadDTO(Long id, String naziv, ArrayList<AutoriDTO> autori, ArrayList<KljucneReciDTO> kljucneReci,
			ApstraktDTO apstrakt) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.autori = autori;
		this.kljucneReci = kljucneReci;
		this.apstrakt = apstrakt;
	}
	public NaucniRadDTO(Long id, String naziv, ArrayList<AutoriDTO> autori, ArrayList<KljucneReciDTO> kljucneReci) {
		this(  id,naziv,new ArrayList<AutoriDTO>(),new ArrayList<KljucneReciDTO>(),null     );
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

	public ArrayList<AutoriDTO> getAutori() {
		return autori;
	}

	public void setAutori(ArrayList<AutoriDTO> autori) {
		this.autori = autori;
	}

	public ArrayList<KljucneReciDTO> getKljucneReci() {
		return kljucneReci;
	}

	public void setKljucneReci(ArrayList<KljucneReciDTO> kljucneReci) {
		this.kljucneReci = kljucneReci;
	}

	public ApstraktDTO getApstrakt() {
		return apstrakt;
	}

	public void setApstrakt(ApstraktDTO apstrakt) {
		this.apstrakt = apstrakt;
	}
	
	
	
	
}
