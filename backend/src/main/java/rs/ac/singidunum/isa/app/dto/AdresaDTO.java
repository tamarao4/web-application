package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class AdresaDTO {
	private Long id;
	private String ulica;
	private String broj;
	private MestoDTO mesto;
	private UniverzitetDTO univerzitet;
	private FakultetDTO fakultet;
	private ArrayList<NastavnikDTO> nastavnici = new ArrayList<NastavnikDTO>();
	private ArrayList<StudentDTO> studenti = new ArrayList<StudentDTO>();
	
	public AdresaDTO() {
		super();
	}

	public AdresaDTO(Long id, String ulica, String broj, MestoDTO mesto, UniverzitetDTO univerzitet) {
		super();
		this.id = id;
		this.ulica = ulica;
		this.broj = broj;
		this.mesto = mesto;
		this.univerzitet = univerzitet;
	}

	public AdresaDTO(Long id, String ulica, String broj, MestoDTO mesto, UniverzitetDTO univerzitet,
			FakultetDTO fakultet, ArrayList<NastavnikDTO> nastavnici, ArrayList<StudentDTO> studenti) {
		super();
		this.id = id;
		this.ulica = ulica;
		this.broj = broj;
		this.mesto = mesto;
		this.univerzitet = univerzitet;
		this.fakultet = fakultet;
		this.nastavnici = nastavnici;
		this.studenti = studenti;
	}

	public AdresaDTO(Long id, String ulica, String broj, MestoDTO mesto) {
		this(id,ulica,broj,null,null,null,new ArrayList<NastavnikDTO>(),new ArrayList<StudentDTO>()) ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public MestoDTO getMesto() {
		return mesto;
	}

	public void setMesto(MestoDTO mesto) {
		this.mesto = mesto;
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

	public ArrayList<NastavnikDTO> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(ArrayList<NastavnikDTO> nastavnici) {
		this.nastavnici = nastavnici;
	}

	public ArrayList<StudentDTO> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<StudentDTO> studenti) {
		this.studenti = studenti;
	}

	
	
}
