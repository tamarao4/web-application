package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;
import java.util.Date;


import rs.ac.singidunum.isa.app.model.StudijskiProgram;

public class GodinaStudijaDTO {
	private Long id;
	private Date godina;
	
	private StudijskiProgram studijskiProgram;
	private ArrayList<PredmetDTO> predmeti = new ArrayList<PredmetDTO>();
	
	public GodinaStudijaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public GodinaStudijaDTO(Long id, Date godina, StudijskiProgram studijskiProgram, ArrayList<PredmetDTO> predmeti) {
		super();
		this.id = id;
		this.godina = godina;
		this.studijskiProgram = studijskiProgram;
		this.predmeti = predmeti;
	}	
	
	public GodinaStudijaDTO(Long id, Date godina) {
		super();
		this.id = id;
		this.godina = godina;
		new ArrayList<StudijskiProgramDTO>();
	}


	public Date getGodina() {
		return godina;
	}
	public void setGodina(Date godina) {
		this.godina = godina;
	}
	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}
	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}
	public ArrayList<PredmetDTO> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(ArrayList<PredmetDTO> predmeti) {
		this.predmeti = predmeti;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
