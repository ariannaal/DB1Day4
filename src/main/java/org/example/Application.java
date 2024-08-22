package org.example;

import DAO.EventoDAO;
import DAO.LocationDAO;
import DAO.PartecipazioneDAO;
import DAO.PersonaDAO;
import entities.Concerto;
import entities.Location;
import entities.PartitaDiCalcio;
import enums.GenereConcerto;
import enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB1D2");
//    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB1D2");

    public static void main(String[] args) {

//        System.out.println("Ciao");
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);

        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        // save
//        try {
//            Location location = new Location(1, "Teatro alla Scala", "Milano");
//            locationDAO.save(location);
//        } catch (Exception e) {
//            System.out.println("Errore nel salvataggio della location: " + e.getMessage());
//        }
//
//        try {
//            Location location = locationDAO.findById(1);
//            Evento evento = new Evento("Cena", LocalDate.of(2024, 4, 1), "degustazione", TipoEvento.PRIVATO, 10, location);
//            ed.save(evento);
//
//            Evento evento1 = new Evento("Proiezione film", LocalDate.of(2023, 1, 1), "film sci-fi", TipoEvento.PUBBLICO, 60, location);
//            ed.save(evento1);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        // Salvataggio di una persona
//        try {
//            Persona persona = new Persona(1, "Mario", "Rossi", "mario.rossi@mail.com", LocalDate.of(1990, 5, 15), 'M', null);
//            personaDAO.save(persona);
//        } catch (Exception e) {
//            System.out.println("Errore nel salvataggio della persona: " + e.getMessage());
//        }
//
//        try {
//            Evento eventoFromDb = ed.findById(7);
//            System.out.println(eventoFromDb);
//        } catch (NotFoundEx ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        try {
//            ed.findByIdAndDelete(8);
//        } catch (NotFoundEx ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        try {
//            Persona persona = personaDAO.findById(1);
//            Evento evento = ed.findById(1);
//            Partecipazione partecipazione = new Partecipazione(1, persona, evento, Stato.CONFERMATA);
//            partecipazioneDAO.save(partecipazione);
//        } catch (Exception e) {
//            System.out.println("Errore nel salvataggio della partecipazione: " + e.getMessage());
//        }

        //22/8/24

        try {

            Location location = new Location("San Siro", "Milano");
            locationDAO.save(location);


            // Inizia una nuova transazione per la creazione e salvataggio di Concerto e PartitaDiCalcio
            Concerto concerto = new Concerto("Concerto Guns N Roses", LocalDate.of(2024, 9, 15),
                    "Tour mondiale", TipoEvento.PUBBLICO, 8000, location, GenereConcerto.ROCK, true);

            Concerto concerto1 = new Concerto("Concerto Lana Del Rey", LocalDate.of(2024, 9, 15),
                    "Tour mondiale", TipoEvento.PUBBLICO, 5000, location, GenereConcerto.POP, true);

            Concerto concerto2 = new Concerto("Concerto Cesare Cremonini", LocalDate.of(2024, 9, 15),
                    "Tour mondiale", TipoEvento.PUBBLICO, 2000, location, GenereConcerto.POP, true);

//            ed.save(concerto);
//
//            ed.save(concerto1);

            ed.save(concerto2);
//            PartitaDiCalcio derby = new PartitaDiCalcio("Derby", LocalDate.of(2024, 8, 22),
//                    "La partita più attesa a Milano", TipoEvento.PUBBLICO, 70000, location, "Inter", "Milan", "Inter", 3, 2, 300);
//            ed.save(derby);

            List<Concerto> concerti = new ArrayList<>();
            concerti.add(concerto);
            concerti.add(concerto1);
            concerti.add(concerto2);


            Map<GenereConcerto, Long> concertiPerGenere = concerti.stream()
                    .collect(Collectors.groupingBy(Concerto::getGenere, Collectors.counting()));


            concertiPerGenere.forEach((genere, count) ->
                    System.out.println("Genere: " + genere + ", Numero di Concerti: " + count)
            );

//    public PartitaDiCalcio(String title, LocalDate eventDate, String eventDescription, TipoEvento tipo_evento, int n_massimo_partecipanti, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int nGolSquadraCasa, int nGolSquadraOspite, int id) {

            PartitaDiCalcio partita1 = new PartitaDiCalcio("partita 1", LocalDate.of(2024, 9, 15), "partita in casa", TipoEvento.PUBBLICO, 100, location, "lazio", "fiorentina", "lazio", 5, 3);
            List<PartitaDiCalcio> partiteVinteInCasa = new ArrayList<>();
            ed.save(partita1);
            partiteVinteInCasa.add(partita1);

            PartitaDiCalcio partita2 = new PartitaDiCalcio("partita 2", LocalDate.of(2024, 9, 15), "partita in casa", TipoEvento.PUBBLICO, 100, location, "milan", "inter", "inter", 5, 8);
            List<PartitaDiCalcio> partiteVinteFuoriCasa = new ArrayList<>();
            ed.save(partita2);
            partiteVinteFuoriCasa.add(partita1);


            // recupera e stampa le partite vinte in casa
            TypedQuery<PartitaDiCalcio> queryVinteInCasa = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa", PartitaDiCalcio.class);
//            List<PartitaDiCalcio> partiteVinteInCasa = queryVinteInCasa.getResultList();
            System.out.println("Partite vinte in casa:");
            for (PartitaDiCalcio partita : partiteVinteInCasa) {
                System.out.println(partita.getSquadraDiCasa() + " vs " + partita.getSquadraOspite() + " - Vincente: " + partita.getSquadraVincente());
            }

            // recupera e stampa le partite vinte in trasferta
            TypedQuery<PartitaDiCalcio> queryVinteInTrasferta = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class);
//            List<PartitaDiCalcio> partiteVinteInTrasferta = queryVinteInTrasferta.getResultList();
            System.out.println("Partite vinte in trasferta:");
            for (PartitaDiCalcio partita : partiteVinteFuoriCasa) {
                System.out.println(partita.getSquadraDiCasa() + " vs " + partita.getSquadraOspite() + " - Vincente: " + partita.getSquadraVincente());
            }


        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Errore: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }


    }
}



