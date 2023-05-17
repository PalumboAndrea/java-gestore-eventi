package org.java.gestore.eventi;

import java.time.LocalDate;
import java.util.Random;

public class Evento {
		
		private String titolo;
		private String data;
		private int postiTotali;
		private int postiPrenotati;
		
		public Evento (String titolo, String data) throws Exception {
			
			Random rnd = new Random();
			
			setTitolo(titolo);
			setData(data);
			setPostiTotali(rnd.nextInt(10, 31));
			setPostiPrenotati(0);
			
		}

		public String getTitolo() {
			return titolo;
		}
		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) throws Exception {
			
			LocalDate parsedDate = LocalDate.parse(data);
			
			if(parsedDate.isBefore(LocalDate.now()) ) {
				throw new Exception("Inserire una data successiva ad oggi: " + LocalDate.now());
			}
			
			this.data = data;
		}
		public int getPostiTotali() {
			return postiTotali;
		}
		private void setPostiTotali(int postiTotali) throws Exception {
			
			if(postiTotali <= 0) {
				throw new Exception("Il numero di posti totali deve essere maggiore di 0");
			} 
			
			this.postiTotali = postiTotali;
		}
		public int getPostiPrenotati() {
			return postiPrenotati;
		}
		private void setPostiPrenotati(int postiPrenotati) {
			this.postiPrenotati = postiPrenotati;
		}
		
		public void prenotare(int postiPrenotati) throws Exception {
			
			if ((this.postiPrenotati + postiPrenotati) <= this.postiTotali) {

				this.postiPrenotati = this.postiPrenotati + postiPrenotati;
			} else {
				
				throw new Exception("Non ci sono abbastaza posti diponibili, ne hai a disposizione: " + getPostiTotali());
			}
		}
		
		public void disdire(int postiDisdetti) throws Exception {
			
			if (postiDisdetti <= this.postiPrenotati) {
				
				this.postiPrenotati = this.postiPrenotati - postiDisdetti;
			} else {
				
				throw new Exception("Hai disdetto per troppe persone, hai prenotato per: " + getPostiPrenotati());
			}
		}
		
		protected String getEventoString() {
			
			return "\nNome evento: " + getTitolo() 
				+ "\nData: " + getData()
				+ "\nPosti Totali: " + getPostiTotali()
				+ "\nPosti Prenotati: " + getPostiPrenotati() + "\n";
		}
		
		
		@Override
		public String toString() {
			
			return getEventoString();
		}

}
