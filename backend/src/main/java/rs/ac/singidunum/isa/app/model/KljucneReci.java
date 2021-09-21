package rs.ac.singidunum.isa.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class KljucneReci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String reci;

	public KljucneReci() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KljucneReci(Long id, String reci) {
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
