package org.java.gestore.eventi;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Helper {
	
	
	
	public static void programsQuestions() throws Exception {
		
		int choice = 1;

		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci il nome del programma di eventi");
		String titoloProgramma = sc.nextLine();
		ProgrammEventi pE = new ProgrammEventi(titoloProgramma);
		
		while(true) {
			
			System.out.println("Inserisci il nome dell'evento");
			String titolo = sc.nextLine();
			System.out.println("Inserisci la data dell'evento (formato anno-mese-giorno)");
			String data = sc.nextLine();
			System.out.println("Inserisci l'ora dell'evento (formato ore:minuti)");
			String orario = sc.nextLine();
			System.out.println("Inserisci il prezzo dell'evento");
			String prezzo = sc.nextLine();
			
			BigDecimal a = new BigDecimal(prezzo);
			
			Evento e = new Evento(titolo, data);
			
			Concerto c = new Concerto(titolo, data, LocalTime.from(DateTimeFormatter.ofPattern("HH:mm").parse(orario)), a);
			
			System.out.println("Hai a disposizione: " + e.getPostiTotali() + " posti." + " Quanti ne vuoi riservare?");
			int postiPrenotati = sc.nextInt();
			sc.nextLine();
			e.prenotare(postiPrenotati);
			
			System.out.println(e.toString());
			
			pE.addEvento(e);
			
			System.out.println("Premi 1 per continuare ad aggiungere eventi o 2 per uscire");
			choice = sc.nextInt();
			sc.nextLine();
			
			if(choice == 2) {

				break;
			}
			
		}
		
		System.out.println("Ecco la list degli eventi aggiunti al programma " + titoloProgramma);
		pE.eventList();
		
		return;
	}
	
	public static void eventQuestions() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci il nome del singolo evento");
		String titolo = sc.nextLine();
		System.out.println("Inserisci la data dell'evento (formato anno-mese-giorno)");
		String data = sc.nextLine();
		System.out.println("Inserisci l'ora dell'evento (formato ore:minuti)");
		String orario = sc.nextLine();
		System.out.println("Inserisci il prezzo dell'evento");
		String prezzo = sc.nextLine();
		
		BigDecimal a = new BigDecimal(prezzo);
		
		Evento e = new Evento(titolo, data);
		
		Concerto c = new Concerto(titolo, data, LocalTime.from(DateTimeFormatter.ofPattern("HH:mm").parse(orario)), a);
		
		System.out.println("Hai a disposizione: " + e.getPostiTotali() + " posti." + " Quanti ne vuoi riservare?");
		int postiPrenotati = sc.nextInt();
		sc.nextLine();
		e.prenotare(postiPrenotati);
		
		System.out.println(e.toString());
		
		while (true) {
			System.out.println("Premi 1 per disdire, 2 per aggiungere prenotazioni e 3 per uscire:");
			int choice2 = sc.nextInt();
			sc.nextLine();
			switch(choice2) {
			
				case 1: {
					
					System.out.println("Inserire il numero di persone da disdire:");
					int postiDisdetti = sc.nextInt();
					sc.nextLine();
					c.disdire(postiDisdetti);
					
					System.out.println(c.getEventoString());
					break;
				}
				
				case 2: {
					
					System.out.println("Inserire il numero di persone da aggiungere:");
					int postiAggiunti = sc.nextInt();
					sc.nextLine();
					c.prenotare(postiAggiunti);
					
					System.out.println(c.getEventoString());
					break;
				}
				
				case 3: {
					
					System.out.println("Per l'evento:" + c.toString() + " del " + e.getData()
										+ "\nHai prenotato: " + e.getPostiPrenotati()
										+ " posti su " + e.getPostiTotali() + " disponibili.");
					return;
				}
	
			}
			
		}
	}
}
