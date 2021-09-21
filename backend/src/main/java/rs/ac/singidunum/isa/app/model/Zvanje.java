package rs.ac.singidunum.isa.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Zvanje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datumIzbora;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datumPrestanka;

	@ManyToOne(optional = true)
	private Nastavnik nastavnik;
	
	@ManyToOne(optional = true)
	private TipZvanja tipZvanja;
	
	@ManyToOne(optional = true)
	private NaucnaOblast naucnaOblast;
	
	public Zvanje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Zvanje(Long id, Date datumIzbora, Date datumPrestanka) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
	}
	
	public Zvanje(Long id, Date datumIzbora, Date datumPrestanka, Nastavnik nastavnik, TipZvanja tipZvanja, NaucnaOblast naucnaOblast) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
		this.nastavnik = nastavnik;
		this.naucnaOblast = naucnaOblast;
		this.tipZvanja = tipZvanja;
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
	
	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public TipZvanja getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(TipZvanja tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	public NaucnaOblast getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblast naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}
}
