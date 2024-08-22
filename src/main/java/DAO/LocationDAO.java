package DAO;

import entities.Location;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {

    private final EntityManager em;

    // costruttore

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();

        System.out.println("La location numero " + location.getNome() + " in " + location.getCitta() + " e' stata salvata con successo!");
    }

    public Location findById(int id) {
        Location found = em.find(Location.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Location found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("La location numero " + found.getNome() + " in " + found.getCitta() + " e' stata eliminata con successo.");
    }


}
