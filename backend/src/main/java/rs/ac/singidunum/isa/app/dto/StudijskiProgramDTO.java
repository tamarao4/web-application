package rs.ac.singidunum.isa.app.dto;

public class StudijskiProgramDTO {
	private Long id;
	private String naziv;
	
	private NastavnikDTO nastavnik;
	private FakultetDTO fakultet;
	private GodinaStudijaDTO godinaStudijaDTO;
	
	public StudijskiProgramDTO() {
		super();
	}
	
	public StudijskiProgramDTO(Long id, String naziv, NastavnikDTO nastavnik, FakultetDTO fakultet,
			GodinaStudijaDTO godinaStudijaDTO) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nastavnik = nastavnik;
		this.fakultet = fakultet;
		this.godinaStudijaDTO = godinaStudijaDTO;
	}

	public StudijskiProgramDTO(Long id, String naziv) {
		// dodato zbog kontrolera
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public NastavnikDTO getNastavnikDTO() {
		return nastavnik;
	}

	public void setNastavnikDTO(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}

	public FakultetDTO getFakultetDTO() {
		return fakultet;
	}

	public void setFakultetDTO(FakultetDTO fakultet) {
		this.fakultet = fakultet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FakultetDTO getFakultet() {
		return fakultet;
	}

	public void setFakultet(FakultetDTO fakultet) {
		this.fakultet = fakultet;
	}

	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}

	public GodinaStudijaDTO getGodinaStudijaDTO() {
		return godinaStudijaDTO;
	}

	public void setGodinaStudijaDTO(GodinaStudijaDTO godinaStudijaDTO) {
		this.godinaStudijaDTO = godinaStudijaDTO;
	}
	
	
	
}
