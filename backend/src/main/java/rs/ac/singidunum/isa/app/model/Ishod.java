package rs.ac.singidunum.isa.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Ishod {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String opis;
		@ManyToOne(optional=true)
		private Predmet predmet;
		public Ishod() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Ishod(Long id, String opis, Predmet predmet) {
			super();
			this.id = id;
			this.opis = opis;
			this.predmet = predmet;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getOpis() {
			return opis;
		}
		public void setOpis(String opis) {
			this.opis = opis;
		}
		public Predmet getPredmet() {
			return predmet;
		}
		public void setPredmet(Predmet predmet) {
			this.predmet = predmet;
		}
		
}
