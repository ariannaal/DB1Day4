package DAO;

import entities.Partecipazione;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {

    private final EntityManager em;

    // costruttore

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();

        System.out.println("La partecipazione numero " + partecipazione.getId() + " all'evento " + partecipazione.getEvento() + " e' stata salvata con successo!");
    }

    public Partecipazione findById(int id) {
        Partecipazione found = em.find(Partecipazione.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Partecipazione found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("La partecipazione numero " + found.getId() + " all'evento " + found.getEvento() + " e' stata eliminata con successo.");
    }

}
