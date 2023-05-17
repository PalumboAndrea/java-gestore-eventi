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
		private int getPostiTotali() {
			return postiTotali;
		}
		public void setPostiTotali(int postiTotali) throws Exception {
			
			if(postiTotali <= 0) {
				throw new Exception("Il numero di posti totali deve essere maggiore di 0");
			} 
			
			this.postiTotali = postiTotali;
		}
		private int getPostiPrenotati() {
			return postiPrenotati;
		}
		public void setPostiPrenotati(int postiPrenotati) {
			this.postiPrenotati = postiPrenotati;
		}
		
		public void prenota() {
			
			postiPrenotati = postiPrenotati + 1;
		}
		
		public void disdici() {
			
			postiPrenotati = postiPrenotati - 1;
		}
		
		protected String getEventoString() {
			
			return "Titolo: " + getTitolo() 
				+ "\nData: " + getData()
				+ "\nPosti Totali: " + getPostiTotali()
				+ "\nPosti Prenotati: " + getPostiPrenotati();
		}
		
		
		@Override
		public String toString() {
			
			return "(E) " + getEventoString();
		}

}
