package rs.ac.singidunum.isa.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class GodinaStudija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date godina;
	
	@OneToMany(mappedBy = "godinaStudija")
	private Set<Predmet> predmeti = new HashSet<Predmet>();
	
	@OneToOne
	private StudijskiProgram studijskiProgram;

	public GodinaStudija() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GodinaStudija(Long id, Date godina, Set<Predmet> predmeti, StudijskiProgram studijskiProgram) {
		super();
		this.id = id;
		this.godina = godina;
		this.predmeti = predmeti;
		this.studijskiProgram = studijskiProgram;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGodina() {
		return godina;
	}

	public void setGodina(Date godina) {
		this.godina = godina;
	}

	public Set<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}
}
