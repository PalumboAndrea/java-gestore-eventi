package org.java.gestore.eventi;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Scanner;

import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Premi 1 per creare un evento, 2 per uscire");
		int choice = sc.nextInt();
		sc.nextLine();

		try {
			
			switch(choice) {
			
				case 1: {
					System.out.println("Inserisci il nome dell'evento");
					String titolo = sc.nextLine();
					System.out.println("Inserisci la data dell'evento (formato anno-mese-giorno)");
					String data = sc.nextLine();
					System.out.println("Inserisci l'ora dell'evento (formato ore:minuti)");
					String orario = sc.nextLine();
					System.out.println("Inserisci il prezzo dell'evento");
					String prezzo = sc.nextLine();
					
					BigDecimal a = new BigDecimal(prezzo);
					
					Concerto c = new Concerto(titolo, data, LocalTime.from(DateTimeFormatter.ofPattern("HH:mm").parse(orario)), a);
					
					System.out.println("Hai a disposizione: " + c.getPostiTotali() + " posti." + " Quanti ne vuoi riservare?");
					int postiPrenotati = sc.nextInt();
					sc.nextLine();
					c.prenotare(postiPrenotati);
					
					System.out.println(c.toString());
					
					while (true) {
						System.out.println("Premi 1 per disdire, 2 per aggiungere prenotazioni e 3 per uscire:");
						choice = sc.nextInt();
						sc.nextLine();
						switch(choice) {
						
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
								System.out.println(c.toString());
								return;
							}
				
						}
						
					}
					
				}
				case 2: {
					
					System.out.println("Grazie e buona giornata");
					sc.close();
					return;
				}
				
			
			}	
			
		} catch (Exception e){

			System.err.println("Errore: \n" + e.getMessage());
		}
		
		sc.close();
		

	}
}
