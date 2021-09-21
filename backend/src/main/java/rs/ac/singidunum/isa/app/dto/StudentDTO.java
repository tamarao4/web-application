package rs.ac.singidunum.isa.app.dto;



public class StudentDTO {
	private Long id;
	private String jmbg;
	private String ime;
	private AdresaDTO adresaDTO;
	private PohadjanjePredmetaDTO pohadjanjePredmetaDTO;
	private StudentNaGodiniDTO studentNaGodiniDTO;
	private AutoriDTO autori;
	
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	






	public StudentDTO(Long id, String jmbg, String ime, AdresaDTO adresaDTO,
			PohadjanjePredmetaDTO pohadjanjePredmetaDTO, StudentNaGodiniDTO studentNaGodiniDTO, AutoriDTO autori) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.ime = ime;
		this.adresaDTO = adresaDTO;
		this.pohadjanjePredmetaDTO = pohadjanjePredmetaDTO;
		this.studentNaGodiniDTO = studentNaGodiniDTO;
		this.autori = autori;
	}











	public StudentDTO(Long id, String jmbg, String ime) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.ime = ime;
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

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public AdresaDTO getAdresaDTO() {
		return adresaDTO;
	}

	public void setAdresaDTO(AdresaDTO adresaDTO) {
		this.adresaDTO = adresaDTO;
	}

	public PohadjanjePredmetaDTO getPohadjanjePredmetaDTO() {
		return pohadjanjePredmetaDTO;
	}

	public void setPohadjanjePredmetaDTO(PohadjanjePredmetaDTO pohadjanjePredmetaDTO) {
		this.pohadjanjePredmetaDTO = pohadjanjePredmetaDTO;
	}

	public StudentNaGodiniDTO getStudentNaGodiniDTO() {
		return studentNaGodiniDTO;
	}

	public void setStudentNaGodiniDTO(StudentNaGodiniDTO studentNaGodiniDTO) {
		this.studentNaGodiniDTO = studentNaGodiniDTO;
	}
	
	
}
