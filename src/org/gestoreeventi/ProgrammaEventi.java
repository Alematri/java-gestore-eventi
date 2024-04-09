package org.gestoreeventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    public List<Evento> eventiInData(LocalDate data) {
        List<Evento> eventiInData = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().isEqual(data)) {
                eventiInData.add(evento);
            }
        }
        return eventiInData;
    }

    public int numeroEventi() {
        return eventi.size();
    }

    public void svuotaProgramma() {
        eventi.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(titolo).append("\n");
        eventi.stream()
                .sorted((e1, e2) -> e1.getData().compareTo(e2.getData()))
                .forEach(e -> sb.append(e.getData()).append(" - ").append(e.getTitolo()).append("\n"));
        return sb.toString();
    }
}