package rs.ac.singidunum.isa.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Autori {
	// AUTOR TRDBA DA BUDE KORISNIK KOJI JE STUDENT NASTAVNIK ILI KOR KOJI NIJE PRIJAVLJEN NA SISTEM
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	private Set<NaucniRad> naucniRadovi;
	
	@OneToMany(mappedBy = "autori")
	private Set<NeregistrovaniKorisnik> neregistrovaniKorisnik = new HashSet<NeregistrovaniKorisnik>();
	@OneToMany(mappedBy = "autori")
	private Set<Nastavnik> nastavnik = new HashSet<Nastavnik>();
	@OneToMany(mappedBy = "autori")
	private Set<Student> student = new HashSet<Student>();
	
	
	public Autori() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Autori(Long id, Set<NaucniRad> naucniRadovi, Set<NeregistrovaniKorisnik> neregistrovaniKorisnik,
			Set<Nastavnik> nastavnik, Set<Student> student){
		super();
		this.id = id;
		this.naucniRadovi = naucniRadovi;
		this.neregistrovaniKorisnik = neregistrovaniKorisnik;
		this.nastavnik = nastavnik;
		this.student = student;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<NaucniRad> getNaucniRadovi() {
		return naucniRadovi;
	}

	public void setNaucniRadovi(Set<NaucniRad> naucniRadovi) {
		this.naucniRadovi = naucniRadovi;
	}


	public Set<NeregistrovaniKorisnik> getNeregistrovaniKorisnik() {
		return neregistrovaniKorisnik;
	}


	public void setNeregistrovaniKorisnik(Set<NeregistrovaniKorisnik> neregistrovaniKorisnik) {
		this.neregistrovaniKorisnik = neregistrovaniKorisnik;
	}


	public Set<Nastavnik> getNastavnik() {
		return nastavnik;
	}


	public void setNastavnik(Set<Nastavnik> nastavnik) {
		this.nastavnik = nastavnik;
	}


	public Set<Student> getStudent() {
		return student;
	}


	public void setStudent(Set<Student> student) {
		this.student = student;
	}

}
