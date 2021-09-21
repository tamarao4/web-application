package rs.ac.singidunum.isa.app.dto;

import java.util.Date;

public class StudentNaGodiniDTO {
	private Long id;
	private Date datumUpisa;
	private String brojIndeksa;
	
	private GodinaStudijaDTO godinaStudijaDTO;

	public StudentNaGodiniDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentNaGodiniDTO(Long id,Date datumUpisa, String brojIndeksa, GodinaStudijaDTO godinaStudijaDTO) {
		super();
		this.id=id;
		this.datumUpisa = datumUpisa;
		this.brojIndeksa = brojIndeksa;
		this.godinaStudijaDTO = godinaStudijaDTO;
	}
	
	public StudentNaGodiniDTO(Long id,Date datumUpisa, String brojIndeksa) {
		this(id,datumUpisa, brojIndeksa, null);
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public GodinaStudijaDTO getGodinaStudijaDTO() {
		return godinaStudijaDTO;
	}

	public void setGodinaStudijaDTO(GodinaStudijaDTO godinaStudijaDTO) {
		this.godinaStudijaDTO = godinaStudijaDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
