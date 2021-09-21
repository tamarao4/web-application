package rs.ac.singidunum.isa.app.dto;

import java.util.Date;

public class ZvanjeDTO {
	private Long id;
	private Date datumIzbora;
	private Date datumPrestanka;
	
	private NastavnikDTO nastavnik;
	private TipZvanjaDTO tipZvanja;
	private NaucnaOblastDTO naucnaOblast;
	
	public ZvanjeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZvanjeDTO(Long id, Date datumIzbora, Date datumPrestanka, NastavnikDTO nastavnik, TipZvanjaDTO tipZvanja,
			NaucnaOblastDTO naucnaOblast) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
		this.nastavnik = nastavnik;
		this.tipZvanja = tipZvanja;
		this.naucnaOblast = naucnaOblast;
	}
	
	public ZvanjeDTO(Long id, Date datumIzbora, Date datumPrestanka) {
		this(id, datumIzbora, datumPrestanka, null, null, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(Date datumIzbora) {
		this.datumIzbora = datumIzbora;
	}

	public Date getDatumPrestanka() {
		return datumPrestanka;
	}

	public void setDatumPrestanka(Date datumPrestanka) {
		this.datumPrestanka = datumPrestanka;
	}

	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}

	public TipZvanjaDTO getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(TipZvanjaDTO tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	public NaucnaOblastDTO getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblastDTO naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}
	
	
}
