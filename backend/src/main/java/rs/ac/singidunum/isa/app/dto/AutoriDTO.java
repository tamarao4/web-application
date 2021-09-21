package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class AutoriDTO {
	private Long id;
	private ArrayList<NaucniRadDTO> naucniRadovi;
	private ArrayList<NeregistrovaniKorisnikDTO> nregistrovaniKorisnik;
	private ArrayList<NastavnikDTO> nastavnik;
	private ArrayList<StudentDTO> student;
	public AutoriDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AutoriDTO(Long id, ArrayList<NaucniRadDTO> naucniRadovi,
			ArrayList<NeregistrovaniKorisnikDTO> nregistrovaniKorisnik, ArrayList<NastavnikDTO> nastavnik,
			ArrayList<StudentDTO> student) {
		super();
		this.id = id;
		this.naucniRadovi = naucniRadovi;
		this.nregistrovaniKorisnik = nregistrovaniKorisnik;
		this.nastavnik = nastavnik;
		this.student = student;
	}
	public AutoriDTO(Long id) {
		this(id,new ArrayList<NaucniRadDTO>(),new ArrayList<NeregistrovaniKorisnikDTO>(),new ArrayList<NastavnikDTO>(),new ArrayList<StudentDTO>());
	}

	public ArrayList<NeregistrovaniKorisnikDTO> getNregistrovaniKorisnik() {
		return nregistrovaniKorisnik;
	}




	public void setNregistrovaniKorisnik(ArrayList<NeregistrovaniKorisnikDTO> nregistrovaniKorisnik) {
		this.nregistrovaniKorisnik = nregistrovaniKorisnik;
	}




	public ArrayList<NastavnikDTO> getNastavnik() {
		return nastavnik;
	}




	public void setNastavnik(ArrayList<NastavnikDTO> nastavnik) {
		this.nastavnik = nastavnik;
	}




	public ArrayList<StudentDTO> getStudent() {
		return student;
	}




	public void setStudent(ArrayList<StudentDTO> student) {
		this.student = student;
	}




	




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public ArrayList<NaucniRadDTO> getNaucniRadovi() {
		return naucniRadovi;
	}


	public void setNaucniRadovi(ArrayList<NaucniRadDTO> naucniRadovi) {
		this.naucniRadovi = naucniRadovi;
	}
	
}
