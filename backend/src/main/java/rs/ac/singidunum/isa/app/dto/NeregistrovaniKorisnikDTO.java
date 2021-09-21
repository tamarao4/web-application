package rs.ac.singidunum.isa.app.dto;


public class NeregistrovaniKorisnikDTO {
	private Long id;
	private String ime;
	private String prezime;
	
	private AutoriDTO autori;

	public NeregistrovaniKorisnikDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NeregistrovaniKorisnikDTO(Long id, String ime, String prezime, AutoriDTO autori) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.autori = autori;
	}
	public NeregistrovaniKorisnikDTO(Long id, String ime, String prezime) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public AutoriDTO getAutori() {
		return autori;
	}

	public void setAutori(AutoriDTO autori) {
		this.autori = autori;
	}
	
}
