package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class PohadjanjePredmetaDTO {
	private Long id;
	
	private double konacnaOcena;
	private ArrayList<RealizacijaPredmetaDTO> realizacijaPredmeta = new ArrayList<RealizacijaPredmetaDTO>();
	public PohadjanjePredmetaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PohadjanjePredmetaDTO(Long id, double konacnaOcena, ArrayList<RealizacijaPredmetaDTO> realizacijaPredmeta) {
		super();
		this.id = id;
		this.konacnaOcena = konacnaOcena;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}
	public PohadjanjePredmetaDTO(Long id, double konacnaOcena) {
		this(id,konacnaOcena,new ArrayList<RealizacijaPredmetaDTO>());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getKonacnaOcena() {
		return konacnaOcena;
	}
	public void setKonacnaOcena(double konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}
	public ArrayList<RealizacijaPredmetaDTO> getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}
	public void setRealizacijaPredmeta(ArrayList<RealizacijaPredmetaDTO> realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}
	
	
	
	
}
