package rs.ac.singidunum.isa.app.dto;



public class TipNastaveDTO {
	private Long id;
	private String naziv;
	private NastavnikNaRealizacijiDTO nastavnikNaRealizaciji;
	
	public TipNastaveDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipNastaveDTO(Long id, String naziv, NastavnikNaRealizacijiDTO nastavnikNaRealizaciji) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}
	public TipNastaveDTO(Long id, String naziv) {
		this(id, naziv, null);
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
	public NastavnikNaRealizacijiDTO getNastavnikNaRealizaciji() {
		return nastavnikNaRealizaciji;
	}
	public void setNastavnikNaRealizaciji(NastavnikNaRealizacijiDTO nastavnikNaRealizaciji) {
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}
	

}
