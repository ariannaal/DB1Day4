package org.example;

import DAO.EventoDAO;
import DAO.LocationDAO;
import DAO.PartecipazioneDAO;
import DAO.PersonaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB1D2");
//    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB1D2");

    public static void main(String[] args) {

        System.out.println("Ciao");
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
    }
}

