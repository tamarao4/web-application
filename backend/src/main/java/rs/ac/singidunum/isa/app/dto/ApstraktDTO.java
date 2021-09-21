package rs.ac.singidunum.isa.app.dto;

public class ApstraktDTO {
	private Long id;
	private String tekst;
	private NaucniRadDTO naucniRad;
	
	public ApstraktDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ApstraktDTO(Long id, String tekst, NaucniRadDTO naucniRad) {
		super();
		this.id = id;
		this.tekst = tekst;
		this.naucniRad = naucniRad;
	}
	public ApstraktDTO(Long id, String tekst) {
		super();
		this.id = id;
		this.tekst = tekst;
	
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTekst() {
		return tekst;
	}
	
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
	public NaucniRadDTO getNaucniRadDTO() {
		return naucniRad;
	}
	
	public void setNaucniRadDTO(NaucniRadDTO naucniRad) {
		this.naucniRad = naucniRad;
	}

}
