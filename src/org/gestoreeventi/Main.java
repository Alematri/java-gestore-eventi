package org.gestoreeventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chiedi all'utente di inserire i dettagli del nuovo evento
        System.out.println("Inserisci i dettagli del nuovo evento:");
        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Data (AAAA-MM-GG): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());
        System.out.print("Numero posti totali: ");
        int numeroPostiTotali = Integer.parseInt(scanner.nextLine());

        // Istanzia un nuovo evento
        Evento evento = null;
        try {
            evento = new Evento(titolo, data, numeroPostiTotali);
            System.out.println("Evento creato con successo!");
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
            return; // Esce dal programma in caso di errore
        }

        // Chiedi all'utente se vuole effettuare delle prenotazioni
        System.out.print("Vuoi effettuare delle prenotazioni? (Sì/No): ");
        String risposta = scanner.nextLine();
        if (risposta.equalsIgnoreCase("Sì")) {
            System.out.print("Quante prenotazioni vuoi effettuare? ");
            int numeroPrenotazioni = Integer.parseInt(scanner.nextLine());
            try {
                evento.prenota(numeroPrenotazioni);
                System.out.println("Prenotazioni effettuate con successo!");
            } catch (Exception e) {
                System.out.println("Errore durante la prenotazione: " + e.getMessage());
            }
        }

        // Stampare il numero di posti prenotati e disponibili
        System.out.println("Numero di posti prenotati: " + evento.getNumeroPostiPrenotati());
        System.out.println("Numero di posti disponibili: " + (evento.getNumeroPostiTotali() - evento.getNumeroPostiPrenotati()));

        // Chiedi all'utente se vuole disdire delle prenotazioni
        System.out.print("Vuoi disdire delle prenotazioni? (Sì/No): ");
        risposta = scanner.nextLine();
        if (risposta.equalsIgnoreCase("Sì")) {
            System.out.print("Quante prenotazioni vuoi disdire? ");
            int numeroDisdette = Integer.parseInt(scanner.nextLine());
            try {
                evento.disdici(numeroDisdette);
                System.out.println("Disdette effettuate con successo!");
            } catch (Exception e) {
                System.out.println("Errore durante la disdetta: " + e.getMessage());
            }
        }

        // Stampare il numero di posti prenotati e disponibili dopo le disdette
        System.out.println("Numero di posti prenotati dopo le disdette: " + evento.getNumeroPostiPrenotati());
        System.out.println("Numero di posti disponibili dopo le disdette: " + (evento.getNumeroPostiTotali() - evento.getNumeroPostiPrenotati()));

        scanner.close();
    }
}
