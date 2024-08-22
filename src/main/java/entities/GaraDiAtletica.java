package entities;

import enums.TipoEvento;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "gara_di_atletica")

public class GaraDiAtletica extends Evento {

    @OneToMany
    private List<Persona> atleti;

    @OneToOne
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String title, LocalDate eventDate, String eventDescription, TipoEvento tipo_evento, int n_massimo_partecipanti, Location location, List<Persona> atleti, Persona vincitore) {
        super(title, eventDate, eventDescription, tipo_evento, n_massimo_partecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public List<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(List<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
