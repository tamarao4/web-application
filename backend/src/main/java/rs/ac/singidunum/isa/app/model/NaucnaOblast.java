package rs.ac.singidunum.isa.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class NaucnaOblast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	
	@OneToMany(mappedBy = "naucnaOblast")
	private Set<Zvanje> zvanja = new HashSet<Zvanje>();

	public NaucnaOblast() {
		super();
	}

	public NaucnaOblast(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
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
	
	public Set<Zvanje> getZvanja() {
		return zvanja;
	}
	
	public void setZvanja(Set<Zvanje> zvanja) {
		this.zvanja = zvanja;
	}
}
