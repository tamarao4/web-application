package rs.ac.singidunum.isa.app.dto;




public class RealizacijaPredmetaDTO {
	
	private Long id;
	

	private PredmetDTO predmet;
	
	private NastavnikNaRealizacijiDTO nastavnikNaRealizaciji;
	
	private PohadjanjePredmetaDTO pohadjanjepredmeta;

	public RealizacijaPredmetaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public RealizacijaPredmetaDTO(Long id) {
		this(id,null,null,null);
	}



	public RealizacijaPredmetaDTO(Long id, PredmetDTO predmet, NastavnikNaRealizacijiDTO nastavnikNaRealizaciji,
			PohadjanjePredmetaDTO pohadjanjepredmeta) {
		super();
		this.id = id;
		this.predmet = predmet;
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
		this.pohadjanjepredmeta = pohadjanjepredmeta;
	}
	public RealizacijaPredmetaDTO(Long id, PredmetDTO predmet) {
		super();
		this.id = id;
		this.predmet = predmet;
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public PredmetDTO getPredmet() {
		return predmet;
	}



	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}



	public NastavnikNaRealizacijiDTO getNastavnikNaRealizaciji() {
		return nastavnikNaRealizaciji;
	}



	public void setNastavnikNaRealizaciji(NastavnikNaRealizacijiDTO nastavnikNaRealizaciji) {
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}



	public PohadjanjePredmetaDTO getPohadjanjepredmeta() {
		return pohadjanjepredmeta;
	}



	public void setPohadjanjepredmeta(PohadjanjePredmetaDTO pohadjanjepredmeta) {
		this.pohadjanjepredmeta = pohadjanjepredmeta;
	}
	
	

	

}
