package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;


public class NastavnikNaRealizacijiDTO {
	
    private Long id;
	

	private double brojCasova;
	

	private ArrayList<RealizacijaPredmetaDTO> realizacijaPredmeta = new ArrayList<RealizacijaPredmetaDTO>();
	
	private ArrayList<TipNastaveDTO> tipNastave = new ArrayList<TipNastaveDTO>();

	public NastavnikNaRealizacijiDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NastavnikNaRealizacijiDTO(Long id, double brojCasova, ArrayList<RealizacijaPredmetaDTO> realizacijaPredmeta,
			ArrayList<TipNastaveDTO> tipNastave) {
		super();
		this.id = id;
		this.brojCasova = brojCasova;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.tipNastave = tipNastave;
	}


	public NastavnikNaRealizacijiDTO(Long id, double brojCasova) {
		this(id, brojCasova,new ArrayList<RealizacijaPredmetaDTO>(),new ArrayList<TipNastaveDTO>());
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBrojCasova() {
		return brojCasova;
	}

	public void setBrojCasova(double brojCasova) {
		this.brojCasova = brojCasova;
	}


	public ArrayList<RealizacijaPredmetaDTO> getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}


	public void setRealizacijaPredmeta(ArrayList<RealizacijaPredmetaDTO> realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}


	public ArrayList<TipNastaveDTO> getTipNastave() {
		return tipNastave;
	}

	public void setTipNastave(ArrayList<TipNastaveDTO> tipNastave) {
		this.tipNastave = tipNastave;
	}

	
	
	
	
	

}
