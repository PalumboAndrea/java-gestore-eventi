package org.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import java.math.BigDecimal;

public class Main{
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Premi 1 per creare un programma di eventi, 2 per un evento singolo o 3 per uscire");
			int choice = sc.nextInt();
			sc.nextLine();

			try {
				
				switch(choice) {
				
					case 1: {
						
						Helper.programsQuestions();
						System.out.println("\nGrazie e buona giornata");
						return;
					}
					
					case 2: {
						
						Helper.eventQuestions();
						System.out.println("\nGrazie e buona giornata");
						return;
					}
					
					case 3: {
						
						System.out.println("\nGrazie e buona giornata");
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
}
