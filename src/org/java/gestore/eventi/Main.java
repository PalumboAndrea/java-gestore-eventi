package org.java.gestore.eventi;

import java.util.Scanner;

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
					
					Evento e = new Evento (titolo, data);
					
					System.out.println("Hai a disposizione: " + e.getPostiTotali() + " posti." + " Quanti ne vuoi riservare?");
					int postiPrenotati = sc.nextInt();
					sc.nextLine();
					e.prenotare(postiPrenotati);
					
					System.out.println(e.toString());
					
					while (true) {
						System.out.println("Premi 1 per disdire, 2 per aggiungere prenotazioni e 3 per uscire:");
						choice = sc.nextInt();
						sc.nextLine();
						switch(choice) {
						
							case 1: {
								
								System.out.println("Inserire il numero di persone da disdire:");
								int postiDisdetti = sc.nextInt();
								sc.nextLine();
								e.disdire(postiDisdetti);
								
								System.out.println(e.toString());
								break;
							}
							
							case 2: {
								
								System.out.println("Inserire il numero di persone da aggiungere:");
								int postiAggiunti = sc.nextInt();
								sc.nextLine();
								e.prenotare(postiAggiunti);
								
								System.out.println(e.toString());
								break;
							}
							
							case 3: {
								System.out.println(e.toString());
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
