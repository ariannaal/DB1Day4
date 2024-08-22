package entities;

import enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_evento")
public class Evento {

    @Id // chiave primaria
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titolo")
    private String title;

    @Column(name = "data_evento")
    private LocalDate eventDate;

    @Column(name = "descrizione")
    private String eventDescription;


    @Column(name = "n_massimo_partecipanti")
    private int n_massimo_partecipanti;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;


    public Evento() {
    }

    public Evento(String title, LocalDate eventDate, String eventDescription, TipoEvento tipo_evento, int n_massimo_partecipanti, Location location) {
        this.title = title;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        
        this.n_massimo_partecipanti = n_massimo_partecipanti;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }


    public int getMaxParticipants() {
        return n_massimo_partecipanti;
    }

    public void setMaxParticipants(int n_massimo_partecipanti) {
        this.n_massimo_partecipanti = n_massimo_partecipanti;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", eventDescription='" + eventDescription + '\'' +
                ", maxParticipants=" + n_massimo_partecipanti +
                '}';
    }
}
