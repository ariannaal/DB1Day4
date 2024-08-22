package DAO;

import entities.Persona;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {

    private final EntityManager em;

    // costruttore

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();

        System.out.println("La " + persona.getNome() + persona.getCognome() + " e' stata salvata con successo!");
    }

    public Persona findById(int id) {
        Persona found = em.find(Persona.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Persona found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("La persona " + found.getNome() + found.getCognome() + " è stata eliminata con successo.");
    }
}
