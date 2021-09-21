package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;
import java.util.Date;

public class ObjavljeniNaucniRadDTO {
	private Long id;
	private Date datumObjave;
	private NaucniRadDTO naucniRad;	
	private ArrayList<NastavnikDTO> nastavnici = new ArrayList<NastavnikDTO>();


	public ObjavljeniNaucniRadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ObjavljeniNaucniRadDTO(Long id, Date datumObjave, NaucniRadDTO naucniRad, ArrayList<NastavnikDTO> nastavnici) {
		super();
		this.id = id;
		this.datumObjave = datumObjave;
		this.naucniRad = naucniRad;
		this.nastavnici = nastavnici;
	}
	
	public ObjavljeniNaucniRadDTO(Long id, Date datumObjave, ArrayList<NastavnikDTO> nastavnici) {
		super();
		this.id = id;
		this.datumObjave = datumObjave;
		new ArrayList<MestoDTO>();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDatumObjave() {
		return datumObjave;
	}


	public void setDatumObjave(Date datumObjave) {
		this.datumObjave = datumObjave;
	}


	public NaucniRadDTO getNaucniRad() {
		return naucniRad;
	}


	public void setNaucniRad(NaucniRadDTO naucniRad) {
		this.naucniRad = naucniRad;
	}


	public ArrayList<NastavnikDTO> getNastavnici() {
		return nastavnici;
	}


	public void setNastavnici(ArrayList<NastavnikDTO> nastavnici) {
		this.nastavnici = nastavnici;
	}
	
	
	
	
}
