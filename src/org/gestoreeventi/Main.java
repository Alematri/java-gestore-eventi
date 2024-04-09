package org.gestoreeventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creiamo un nuovo programma di eventi
        ProgrammaEventi programma = new ProgrammaEventi("Programma Eventi");

        boolean continua = true;
        while (continua) {
            // Chiedi all'utente di scegliere il tipo di evento
            System.out.println("Che tipo di evento vuoi creare? (Evento/Concerto): ");
            String tipoEvento = scanner.nextLine();

            // Dati comuni a entrambi i tipi di eventi
            System.out.print("Titolo: ");
            String titolo = scanner.nextLine();
            System.out.print("Data (AAAA-MM-GG): ");
            LocalDate data = LocalDate.parse(scanner.nextLine());
            System.out.print("Numero posti totali: ");
            int numeroPostiTotali = Integer.parseInt(scanner.nextLine());

            if (tipoEvento.equalsIgnoreCase("Evento")) {
                // Istanzia un nuovo evento generico
                Evento evento = null;
                try {
                    evento = new Evento(titolo, data, numeroPostiTotali);
                    programma.aggiungiEvento(evento); // Aggiungi al programma
                    System.out.println("Evento creato con successo!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                    return; // Esce dal programma in caso di errore
                }

                // Gestire le prenotazioni e le disdette dell'evento generico
            } else if (tipoEvento.equalsIgnoreCase("Concerto")) {
                // Dati specifici per il concerto
                System.out.print("Ora (HH:mm): ");
                LocalTime ora = LocalTime.parse(scanner.nextLine());
                System.out.print("Prezzo: ");
                BigDecimal prezzo = new BigDecimal(scanner.nextLine());

                // Nuovo concerto
                Concerto concerto = null;
                try {
                    concerto = new Concerto(titolo, data, numeroPostiTotali, ora, prezzo);
                    programma.aggiungiEvento(concerto); // Aggiungi il concerto al programma
                    System.out.println("Concerto creato con successo!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                    return; // Esce dal programma in caso di errore
                }

                // Gestire le prenotazioni e le disdette del concerto

                // Chiedi all'utente se vuole effettuare delle prenotazioni per il concerto
                System.out.print("Vuoi effettuare delle prenotazioni per il concerto? (Sì/No): ");
                String risposta = scanner.nextLine();
                if (risposta.equalsIgnoreCase("Sì")) {
                    System.out.print("Quante prenotazioni vuoi effettuare per il concerto? ");
                    int numeroPrenotazioni = Integer.parseInt(scanner.nextLine());
                    try {
                        concerto.prenota(numeroPrenotazioni);
                        System.out.println("Prenotazioni effettuate con successo per il concerto!");
                    } catch (Exception e) {
                        System.out.println("Errore durante la prenotazione per il concerto: " + e.getMessage());
                    }
                }

                // Stampare il numero di posti prenotati e disponibili per il concerto
                System.out.println("Numero di posti prenotati per il concerto: " + concerto.getNumeroPostiPrenotati());
                System.out.println("Numero di posti disponibili per il concerto: " + (concerto.getNumeroPostiTotali() - concerto.getNumeroPostiPrenotati()));

                // Chiedi all'utente se vuole disdire delle prenotazioni per il concerto
                System.out.print("Vuoi disdire delle prenotazioni per il concerto? (Sì/No): ");
                risposta = scanner.nextLine();
                if (risposta.equalsIgnoreCase("Sì")) {
                    System.out.print("Quante prenotazioni vuoi disdire per il concerto? ");
                    int numeroDisdette = Integer.parseInt(scanner.nextLine());
                    try {
                        concerto.disdici(numeroDisdette);
                        System.out.println("Disdette effettuate con successo per il concerto!");
                    } catch (Exception e) {
                        System.out.println("Errore durante la disdetta per il concerto: " + e.getMessage());
                    }
                }

                // Stampa finale
                System.out.println("Numero di posti prenotati per il concerto dopo le disdette: " + concerto.getNumeroPostiPrenotati());
                System.out.println("Numero di posti disponibili per il concerto dopo le disdette: " + (concerto.getNumeroPostiTotali() - concerto.getNumeroPostiPrenotati()));
            } else {
                System.out.println("Tipo di evento non riconosciuto. Uscita...");
            }

            // Chiedi all'utente se vuole aggiungere altri eventi o concerti
            System.out.print("Vuoi aggiungere un altro evento o concerto? (Sì/No): ");
            String risposta = scanner.nextLine();
            if (!risposta.equalsIgnoreCase("Sì")) {
                continua = false; // Termina il ciclo
            }
        }

        // Stampa il programma degli eventi
        System.out.println("\nProgramma degli eventi:");
        System.out.println(programma);

        scanner.close();
    }
}
