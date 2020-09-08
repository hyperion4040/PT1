package com.example.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UzytkownikKontroler {

    private EntityManagerFactory emf;

    private EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(
                    "NewPersistenceUnit");
        }
        return emf.createEntityManager();
    }

    public boolean aktualizujUzytkownika(Uzytkownicy
                                                 uzytkownicy) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Uzytkownicy uzytkownikx = em.find(Uzytkownicy.class,
                    uzytkownicy.getIdUzytkownika());
            uzytkownikx.setNazwaUzytkownika
                    (uzytkownicy.getNazwaUzytkownika());
            uzytkownikx.setHaslo(uzytkownicy.getHaslo());
            uzytkownikx.setAdresEmail(uzytkownicy.getAdresEmail());
            em.getTransaction().commit();
        } finally {
            em.close();
            return false;
        }
    }

    public Uprawnienia[] getUprawnienia (short id){
        EntityManager em = getEntityManager();
        try {
            javax.persistence.Query q =
                    em.createQuery("select u from Uprawnienia u where u.uzytkownicy.idUzytkownika = :uzytkownicy");
            q.setParameter("uzytkownicy",id);
            return (Uprawnienia[]) q.getResultList().toArray(new Uprawnienia[0]);
        }finally {
            em.close();
        }
    }

    public Uzytkownicy[] getUzytkownicy() {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.Query q =
                    em.createQuery("select c from Uzytkownicy c");
            return (Uzytkownicy[])
                    q.getResultList().toArray(new Uzytkownicy[0]);
        } finally {
            em.close();
        }
    }

    public boolean dodajUzytkownika(Uzytkownicy uzytkownicy) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(uzytkownicy);
            em.getTransaction().commit();
        } finally {
            em.close();
            return false;
        }
    }

    public boolean usunUzytkownika(Uzytkownicy uzytkownicy) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Uzytkownicy uzytkownikx = em.find(Uzytkownicy.class,
                    uzytkownicy.getIdUzytkownika());
            em.remove(uzytkownikx);
            em.getTransaction().commit();
        } finally {
            em.close();
            return false;
        }
    }
}
