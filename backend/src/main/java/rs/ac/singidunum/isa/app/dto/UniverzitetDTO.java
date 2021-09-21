package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;
import java.util.Date;

public class UniverzitetDTO {
	private Long id;
	private String naziv;
	private Date datumOsnivanja;
	private AdresaDTO adresa;
	
	private String telefon;
	private String email;
	private String opis;
	
	private ArrayList<FakultetDTO> fakulteti = new ArrayList<FakultetDTO>();
	private NastavnikDTO rektor;
	
	public UniverzitetDTO() {
		super();
	}



	public UniverzitetDTO(Long id, String naziv, Date datumOsnivanja, AdresaDTO adresa, String telefon, String email,
			String opis, ArrayList<FakultetDTO> fakulteti, NastavnikDTO rektor) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.opis = opis;
		this.fakulteti = fakulteti;
		this.rektor = rektor;
	}

	public UniverzitetDTO(Long id, String naziv, Date datumOsnivanja, AdresaDTO adresa, String telefon, String email,String opis, NastavnikDTO rektor) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.opis = opis;
		new ArrayList<FakultetDTO>();
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

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public ArrayList<FakultetDTO> getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(ArrayList<FakultetDTO> fakulteti) {
		this.fakulteti = fakulteti;
	}

	public NastavnikDTO getRektor() {
		return rektor;
	}

	public void setRektor(NastavnikDTO rektor) {
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



	public String getOpis() {
		return opis;
	}



	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
}
