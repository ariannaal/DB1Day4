package entities;

import enums.GenereConcerto;
import enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "concerto")
public class Concerto extends Evento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "genere")
    private GenereConcerto genere;

    @Column(name = "instreaming")
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String title, LocalDate eventDate, String eventDescription, TipoEvento tipo_evento, int n_massimo_partecipanti, Location location,
                    GenereConcerto genere, boolean inStreaming) {
        super(title, eventDate, eventDescription, tipo_evento, n_massimo_partecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
