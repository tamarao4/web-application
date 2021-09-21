package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class FakultetDTO {
	private Long id;
	private String naziv;
	private String telefon;
	private String email;
	private String opis;
	private UniverzitetDTO univerzitet;
	private AdresaDTO adresal;
	private NastavnikDTO dekan;
	private ArrayList<StudijskiProgramDTO> studijskiProgrami = new ArrayList<StudijskiProgramDTO>();
	
	public FakultetDTO() {
		super();
	}	

	public FakultetDTO(Long id, String naziv, String telefon, String email, String opis, UniverzitetDTO univerzitet,
			AdresaDTO adresal, NastavnikDTO dekan, ArrayList<StudijskiProgramDTO> studijskiProgrami) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.telefon = telefon;
		this.email = email;
		this.opis = opis;
		this.univerzitet = univerzitet;
		this.adresal = adresal;
		this.dekan = dekan;
		this.studijskiProgrami = studijskiProgrami;
	}

	public FakultetDTO(Long id, String naziv, String telefon, String email, String opis) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.telefon = telefon;
		this.email = email;
		this.opis = opis;
		new ArrayList<StudijskiProgramDTO>();
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

	public UniverzitetDTO getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(UniverzitetDTO univerzitet) {
		this.univerzitet = univerzitet;
	}

	public AdresaDTO getAdresal() {
		return adresal;
	}

	public void setAdresal(AdresaDTO adresal) {
		this.adresal = adresal;
	}

	public NastavnikDTO getDekan() {
		return dekan;
	}

	public void setDekan(NastavnikDTO dekan) {
		this.dekan = dekan;
	}

	public ArrayList<StudijskiProgramDTO> getStudijskiProgrami() {
		return studijskiProgrami;
	}

	public void setStudijskiProgrami(ArrayList<StudijskiProgramDTO> studijskiProgrami) {
		this.studijskiProgrami = studijskiProgrami;
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
