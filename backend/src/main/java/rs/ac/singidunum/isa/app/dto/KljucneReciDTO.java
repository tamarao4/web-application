package rs.ac.singidunum.isa.app.dto;

//OVO TREBA ZAVRSITI TREBA DA SE DODA JOIN COLUM
public class KljucneReciDTO {
	private Long id;
	private String reci;
	
	
	public KljucneReciDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KljucneReciDTO(Long id, String reci) {
		super();
		this.id = id;
		this.reci = reci;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReci() {
		return reci;
	}
	public void setReci(String reci) {
		this.reci = reci;
	}
	
	
}
