package com.example.model;

import com.example.model.Uprawnienia;
import com.example.model.Uzytkownicy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UprawnieniaKontroler {
    private EntityManagerFactory emf;

    private EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(
                    "NewPersistenceUnit");
        }
        return emf.createEntityManager();
    }

    public boolean aktualizujUprawnienie( Uprawnienia uprawnienia) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Uprawnienia uzytkownikx = em.find(Uprawnienia.class, uprawnienia.getIdUprawnienia());
            uzytkownikx.setNazwa
                    (uprawnienia.getNazwa());
            uzytkownikx.setOpis(uprawnienia.getOpis());
            em.getTransaction().commit();
        } finally {
            em.close();
            return false;
        }
    }

    public Uprawnienia[] getUprawnienia (){
        EntityManager em = getEntityManager();
        try {
            javax.persistence.Query q =
                    em.createQuery("select u from Uprawnienia u");
            return (Uprawnienia[]) q.getResultList().toArray(new Uprawnienia[0]);
        }finally {
            em.close();
        }
    }


    public boolean dodajUprawnienie(Uprawnienia uprawnienia) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(uprawnienia);
            em.getTransaction().commit();
        } finally {
            em.close();
            return false;
        }
    }

    public boolean usunUprawnienie(Uprawnienia uprawnienia) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Uprawnienia uzytkownikx = em.find(Uprawnienia.class,
                    uprawnienia.getIdUprawnienia());
            em.remove(uzytkownikx);
            em.getTransaction().commit();
        } finally {
            em.close();
            return false;
        }
    }
}
