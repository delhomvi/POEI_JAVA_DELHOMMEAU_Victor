package org.example;
import org.example.model.Agence;
import org.example.model.Client;
import org.example.model.Compte;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExoBanque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();
        transac.begin();


        // -------------------------------------------------------------------------------- Remplissage des tables
        // Création des agences
        Agence ag1 = new Agence();
        ag1.setId(1);
        ag1.setAdresse("01 rue des lilas");

        Agence ag2 = new Agence();
        ag2.setId(2);
        ag2.setAdresse("02 rue des lilas");

        Agence ag3 = new Agence();
        ag3.setId(3);
        ag3.setAdresse("03 rue des lilas");

        // Création de client
        Client cl1 = new Client();
        cl1.setId(1);
        cl1.setNom("Toto");
        cl1.setPrenom("Toto");
        cl1.setDateNaissance(new Date("01/01/2000"));

        System.out.println("Agence done");

        Client cl2 = new Client();
        cl2.setId(2);
        cl2.setNom("Tata");
        cl2.setPrenom("Tata");
        cl2.setDateNaissance(new Date("02/02/2000"));

        Client cl3 = new Client();
        cl3.setId(3);
        cl3.setNom("Titi");
        cl3.setPrenom("Titi");
        cl3.setDateNaissance(new Date("03/03/2000"));

        Client cl4 = new Client();
        cl4.setId(4);
        cl4.setNom("Tutu");
        cl4.setPrenom("Tutu");
        cl4.setDateNaissance(new Date("04/04/2000"));


        System.out.println("Client done");
        // Creation de compte
        Compte co1 = new Compte();
        co1.setId(1);
        co1.setLibel("Toto");
        co1.setIBAN("1234567891234567498FRFR");
        co1.setSolde(0.0);
        co1.setAgence(ag1);

        Compte co2 = new Compte();
        co2.setId(2);
        co2.setLibel("Tata");
        co2.setIBAN("1234567891234567498FRFR");
        co2.setSolde(0.0);
        co2.setAgence(ag2);

        Compte co3 = new Compte();
        co3.setId(3);
        co3.setLibel("Titi");
        co3.setIBAN("1234567891234567498FRFR");
        co3.setSolde(0.0);
        co3.setAgence(ag3);

        Compte co4 = new Compte();
        co4.setId(4);
        co4.setLibel("Toto");
        co4.setIBAN("1234567891234567498FRFR");
        co4.setSolde(0.0);
        co4.setAgence(ag1);

        Compte co5 = new Compte();
        co5.setId(5);
        co5.setLibel("Tutu");
        co5.setIBAN("1234567891234567498FRFR");
        co5.setSolde(0.0);
        co5.setAgence(ag1);

        System.out.println("Client done");
        // Liaison des objets
        Collection<Compte> cl11Acc = new ArrayList<>();
        cl11Acc.add(co1);
        cl11Acc.add(co4);
        cl1.setListeCompte(cl11Acc);

        Collection<Compte> cl12Acc = new ArrayList<>();
        cl12Acc.add(co2);
        cl2.setListeCompte(cl12Acc);

        Collection<Compte> cl13Acc = new ArrayList<>();
        cl13Acc.add(co3);
        cl3.setListeCompte(cl13Acc);

        Collection<Compte> cl14Acc = new ArrayList<>();
        cl14Acc.add(co5);
        cl4.setListeCompte(cl14Acc);

        // Commit des ajouts
        em.persist(ag1);
        em.persist(ag2);
        em.persist(ag3);

        em.persist(co1);
        em.persist(co2);
        em.persist(co3);
        em.persist(co4);

        em.persist(cl1);
        em.persist(cl2);
        em.persist(cl3);
        em.persist(cl4);

        transac.commit();


        // -------------------------------------------------------------------------------- Affichage des données


        //End clause
        em.close();
        emf.close();
    }
}