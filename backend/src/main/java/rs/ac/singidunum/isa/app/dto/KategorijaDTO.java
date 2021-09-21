package rs.ac.singidunum.isa.app.dto;





public class KategorijaDTO {
	private Long id;
	private String naziv;
	private NaucniRadDTO naucniRad;

	public KategorijaDTO(Long id, String naziv, NaucniRadDTO naucniRad) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.naucniRad = naucniRad;
	}
	public KategorijaDTO(Long id, String naziv) {
		this(id, naziv,null);
	}
	public KategorijaDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public NaucniRadDTO getNaucniRad() {
		return naucniRad;
	}

	public void setNaucniRad(NaucniRadDTO naucniRad) {
		this.naucniRad = naucniRad;
	}
	
}
