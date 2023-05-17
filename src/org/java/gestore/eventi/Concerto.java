package org.java.gestore.eventi;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Concerto extends Evento{
	
	LocalTime ora;
	BigDecimal prezzo;

	public Concerto(String titolo, String data, LocalTime ora, BigDecimal prezzo) throws Exception {
		
		super(titolo, data);
		// TODO Auto-generated constructor stub
		setOra(ora);
		setPrezzo(prezzo);
	}
	
	public LocalTime getOra() {
		return ora;
	}
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	public LocalTime getLocalTimeFormat(String time) {
		
		String localTimeString = time;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		TemporalAccessor ta = dtf.parse(localTimeString);
		LocalTime lt = LocalTime.from(ta);
		
		return lt;
	}
	
	public String getPriceFormat(BigDecimal price) {
		
		String formattedPrice = "" + price + "€";
		
		return formattedPrice;
	}
	
	
	@Override
	public String toString() {
		
		return 	"\nTitolo: " + getTitolo()
				+"\nOra: " + getOra()
				+ "\nPrezzo: " + getPriceFormat(prezzo) + "\n";
	}
	
}
