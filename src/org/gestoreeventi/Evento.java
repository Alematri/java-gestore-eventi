package org.gestoreeventi;

import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int numeroPostiTotali;
    private int numeroPostiPrenotati;

    // ** COSTRUTTORE **
    public Evento(String titolo, LocalDate data, int numeroPostiTotali) throws IllegalArgumentException {
        // Controllo se la data è precedente alla data corrente
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere precedente alla data corrente.");
        }

        // Controllo se il numero di posti totali è negativo
        if (numeroPostiTotali < 0) {
            throw new IllegalArgumentException("Il numero di posti totali non può essere negativo.");
        }

        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotali = numeroPostiTotali;
        this.numeroPostiPrenotati = 0; // Inizializzo il numero di posti prenotati a 0
    }

    // ** GETTER **
    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }

    // ** SETTER **
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    // Setter per il numero di posti totali
    public void setNumeroPostiTotali(int numeroPostiTotali) {
        this.numeroPostiTotali = numeroPostiTotali;
    }

    // Setter per il numero di posti prenotati
    public void setNumeroPostiPrenotati(int numeroPostiPrenotati) {
        this.numeroPostiPrenotati = numeroPostiPrenotati;
    }

    public void prenota(int numeroPostiDaPrenotare) throws Exception {
        // Verifica se l'evento è già passato
        if (data.isBefore(LocalDate.now())) {
            throw new Exception("Impossibile prenotare: l'evento è già passato.");
        }

        // Verifica se ci sono abbastanza posti disponibili
        int postiDisponibili = numeroPostiTotali - numeroPostiPrenotati;
        if (numeroPostiDaPrenotare > postiDisponibili) {
            throw new Exception("Impossibile prenotare: non ci sono abbastanza posti disponibili.");
        }

        // Aggiorna il numero di posti prenotati
        numeroPostiPrenotati += numeroPostiDaPrenotare;
    }

    public void disdici(int numeroPostiDaCancellare) throws Exception {
        // Verifica se l'evento è già passato
        if (data.isBefore(LocalDate.now())) {
            throw new Exception("Impossibile disdire: l'evento è già passato.");
        }

        // Verifica se ci sono abbastanza prenotazioni da cancellare
        if (numeroPostiDaCancellare > numeroPostiPrenotati) {
            throw new Exception("Impossibile disdire: non ci sono abbastanza prenotazioni da cancellare.");
        }

        // Aggiorna il numero di posti prenotati
        numeroPostiPrenotati -= numeroPostiDaCancellare;
    }

    @Override
    public String toString() {
        return data.toString() + " - " + titolo;
    }
}