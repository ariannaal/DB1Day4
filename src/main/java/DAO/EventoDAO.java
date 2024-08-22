package DAO;

import entities.Concerto;
import entities.Evento;
import entities.PartitaDiCalcio;
import enums.GenereConcerto;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    // 22/8/24
    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class); // specifico il tipo di oggetto che mi viene restituito
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c.genere, COUNT(c) FROM Concerto c WHERE c.genere = :genere GROUP BY c.genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }
}
