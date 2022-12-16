package org.example;

import org.example.model.Personne;
import org.example.model.PersonneWithPK;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJpa");
        EntityManager em = emf.createEntityManager();



        EntityTransaction transac = em.getTransaction();
        transac.begin();
        Personne nouvellePersonne = new Personne();
        nouvellePersonne.setNom("titi");
        nouvellePersonne.setPrenom("tutu");
        em.persist(nouvellePersonne);
        transac.commit();

        transac.begin();
        PersonneWithPK personneWithPK = new PersonneWithPK();
        personneWithPK.setNom("titiwithPK");
        personneWithPK.setPrenom("titiwithPK");
        em.merge(personneWithPK);
        transac.commit();

        transac.begin();
        // Création de nouvelles personens
        Personne personneCreate;
        for(int i=0;i<=20;i++){
            personneCreate= new Personne();
            personneCreate.setNom("nom"+(i+1));
            personneCreate.setPrenom("prenom"+(i+1));
            em.persist(personneCreate);
            transac.commit();
            transac.begin();
            personneCreate=null;
        }
        transac.commit();

        // Recup de personne find
        transac.begin();
        Personne personne = em.find(Personne.class,1);
        System.out.println("avec find: "+personne.getNom()+" "+personne.getPrenom());

        Personne personne1 = em.getReference(Personne.class,1);
        System.out.println("avec get reference: "+personne.getNom()+" "+personne.getPrenom());
        transac.commit();

        // Recup avec query
        // Create Query single result
        Query query = em.createQuery("select p from Personne p where p.nom='titi'");
        Personne personne2 = (Personne)query.getSingleResult();
        System.out.println("avec query single result: "+personne2.getNom()+" "+personne2.getPrenom());

        // Create query result list
        System.out.println("Liste des personnes avec id>5");
        Query query1 = em.createQuery("select p from Personne p where p.id>5");
        List noms = query1.getResultList();
        for(Object nom: noms){
            Personne tmp = (Personne) nom;
            System.out.println("avec query list result: "+tmp.getPrenom());
        }

        // Utilisation du setParameter
        System.out.println("Liste de personne avec id superieur au parametre set");
        Query query2=em.createQuery("select p from Personne p where p.id > :id");
        query2.setParameter("id",15);
        List noms2 = query2.getResultList();
        //on recupere une liste d'objet
        for(Object nom : noms2){
            Personne tmp =(Personne) nom;
            System.out.println("nom = "+tmp.getNom());
        }

        // Modification
        transac.begin();
        System.out.println("Modifier un occurence");
        Personne personne3 = em.find(Personne.class,1);
        System.out.println("Personne avec l'id 1 (avant modif): "+personne3.getPrenom()+" "+personne3.getNom());
        personne3.setPrenom("Théo");
        personne3.setNom("Dorres");
        em.flush();
        transac.commit();

        Personne personne4 = em.find(Personne.class,1);
        System.out.println("Personne avec l'id 1 (après modif): "+personne4.getPrenom()+" "+personne4.getNom());

        //Suppression
        transac.begin();
        System.out.println("Suppression d'une occurence");
        Personne personne5 = em.find(Personne.class,6);
        em.remove(personne5);
        transac.commit();

        Query query3 = em.createQuery("select p from Personne p where p.id between 5 and 7");
        List noms1 = query3.getResultList();
        for(Object nom : noms1){
            Personne tmp = (Personne) nom;
            System.out.println(" nom : "+tmp.getNom());
        }

        // Native query
        System.out.println("Native query");
        List<Personne> results = em.createNativeQuery("SELECT * FROM personne",Personne.class).getResultList();
        for(Personne p : results){
            System.out.println("nom: "+p.getNom());
        }


        //End clause
        em.close();
        emf.close();
    }
}