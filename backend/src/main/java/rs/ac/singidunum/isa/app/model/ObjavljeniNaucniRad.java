package rs.ac.singidunum.isa.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class ObjavljeniNaucniRad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Temporal(TemporalType.TIMESTAMP)
	private Date datumObjave;
	
	@ManyToOne(optional = true)
	private NaucniRad naucniRad;
	
	@OneToMany(mappedBy = "objavljeniNaucniRad")
	private Set<Nastavnik> nastavnici = new HashSet<Nastavnik>();

	public ObjavljeniNaucniRad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObjavljeniNaucniRad(Long id, Date datumObjave, NaucniRad naucniRad, Set<Nastavnik> nastavnici) {
		super();
		this.id = id;
		this.datumObjave = datumObjave;
		this.naucniRad = naucniRad;
		this.nastavnici = nastavnici;
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

	public NaucniRad getNaucniRad() {
		return naucniRad;
	}

	public void setNaucniRad(NaucniRad naucniRad) {
		this.naucniRad = naucniRad;
	}

	public Set<Nastavnik> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(Set<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}
	
	
	
	
	
}
