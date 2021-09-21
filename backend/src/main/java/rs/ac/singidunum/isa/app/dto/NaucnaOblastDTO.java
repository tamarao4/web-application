package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class NaucnaOblastDTO {
	private Long id;
	private String naziv;
	
	private ArrayList<ZvanjeDTO> zvanja = new ArrayList<ZvanjeDTO>();

	public NaucnaOblastDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NaucnaOblastDTO(Long id, String naziv, ArrayList<ZvanjeDTO> zvanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.zvanja = zvanja;
	}
	
	public NaucnaOblastDTO(Long id, String naziv) {
		this(id, naziv, new ArrayList<ZvanjeDTO>());
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

	public ArrayList<ZvanjeDTO> getZvanja() {
		return zvanja;
	}

	public void setZvanja(ArrayList<ZvanjeDTO> zvanja) {
		this.zvanja = zvanja;
	}
	
	
}
