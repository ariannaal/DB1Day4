package DAO;

import entities.Evento;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;

    // costruttore

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        // scrivo transazione
        EntityTransaction transaction = em.getTransaction();
        // faccio partire la transazione
        transaction.begin();
        //aggiungo evento al persistence context
        em.persist(evento);
        //evento viene salvato al concludersi della transazione
        transaction.commit();

        System.out.println("L'evento " + evento.getTitle() + " e' stato salvato con successo!");
    }

    public Evento findById(int id) {
        Evento found = em.find(Evento.class, id); // classe dell'identia e id da cercare
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Evento found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento' " + found.getTitle() + " è stato eliminato con successo.");
    }
}
