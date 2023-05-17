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
					System.out.println(e.toString());
					System.out.println("Quanti posti vuoi prenotare?");
					int postiPrenotati = sc.nextInt();
					sc.nextLine();
				}
			
			
			}	
			
		} catch (Exception e){

			System.err.println("Errore: \n" + e.getMessage());
		}
		

	}
}
