package entities;

import enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "partita_di_calcio")
@NamedQueries({
        @NamedQuery(
                name = "PartitaDiCalcio.getPartiteVinteInCasa",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraDiCasa = p.squadraVincente"
        ),
        @NamedQuery(
                name = "PartitaDiCalcio.getPartiteVinteInTrasferta",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraOspite = p.squadraVincente"
        )
})
public class PartitaDiCalcio extends Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "squadradicasa")
    private String squadraDiCasa;

    @Column(name = "squadraospite")
    private String squadraOspite;

    @Column(name = "squadravincente")
    private String squadraVincente;

    @Column(name = "ngolsquadradicasa")
    private int nGolSquadraCasa;

    @Column(name = "ngolsquadraospite")
    private int nGolSquadraOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String title, LocalDate eventDate, String eventDescription, TipoEvento tipo_evento, int n_massimo_partecipanti, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int nGolSquadraCasa, int nGolSquadraOspite) {
        super(title, eventDate, eventDescription, tipo_evento, n_massimo_partecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.nGolSquadraCasa = nGolSquadraCasa;
        this.nGolSquadraOspite = nGolSquadraOspite;

    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getnGolSquadraCasa() {
        return nGolSquadraCasa;
    }

    public void setnGolSquadraCasa(int nGolSquadraCasa) {
        this.nGolSquadraCasa = nGolSquadraCasa;
    }

    public int getnGolSquadraOspite() {
        return nGolSquadraOspite;
    }

    public void setnGolSquadraOspite(int nGolSquadraOspite) {
        this.nGolSquadraOspite = nGolSquadraOspite;
    }
}
