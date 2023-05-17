package org.java.gestore.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class ProgrammEventi {
	
	String titolo;
	List<Evento> eventi;
	
	public ProgrammEventi (String titolo) {
		
		eventi = new ArrayList<Evento>();
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public List<Evento> getEventi() {
		return eventi;
	}
	public void addEvento(Evento evento) {
		this.eventi.add(evento);
	}
	
	public void eventListForDate(String date) {

		int index = 0;
		
		for (Evento event : eventi) {
			
			String actualData = event.getData();
			if (actualData.equals(date)) {
				index++;
				System.out.println("Evento numero " + index + ":");
				System.out.println(event);
				System.out.println("------------------------");
			}
		}
		
		if (index == 0) {
			
			System.out.println("Nessun evento trovato nella data selezionata.");
		}
		
	}
	
	public void eventList() {
		
		System.out.println("Nome del programma: " + titolo);

		int index = 0;
		
//		List<LocalDate> dates = new ArrayList<LocalDate>();
//		
//		for (Evento event : eventi) {
//			
//			LocalDate parsedDate = LocalDate.parse(event.getData());
//			dates.add(parsedDate);
//		}
//		
//		System.out.println(dates);
		
		for (Evento event : eventi) {
			
			index++;
			System.out.println("Evento numero " + index + ":");
			System.out.println(event.getData() + " - " + event.getTitolo());
			System.out.println("------------------------");
		}
		
		if (index == 0) {
			
			System.out.println("Nessun evento trovato.");
		}
		
	}
	
	public void numberOfEvents() {
		
		if (eventi.size() == 1) {
			System.out.println("C'è un solo evento nella lista");
		} else {
			System.out.println("Ci sono " + eventi.size() + " eventi nella lista.");
		}
		
	}
	
	public void removeAllEvents() {
		
		eventi.clear();
	}
	
	
	
}
