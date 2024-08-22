package entities;

import enums.Stato;
import jakarta.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;


    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione() {
    }

    public Partecipazione(int id, Persona persona, Evento evento, Stato stato) {
        this.id = id;
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato_partecipazione() {
        return stato;
    }

    public void setStato_partecipazione(Stato stato_partecipazione) {
        this.stato = stato_partecipazione;
    }
}
