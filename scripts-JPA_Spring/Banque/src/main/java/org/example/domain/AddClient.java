package org.example.domain;

import org.example.model.Agence;
import org.example.model.Client;
import org.example.model.Compte;

import javax.persistence.*;
import java.util.*;

public class AddClient {
    public static void exoadd() {

        System.out.println("-------- Init add --------");

        // INIT -----------------------------------------------------
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExoBanque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        Compte acc = new Compte();
        Client cli = new Client();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez les informations suivantes: ");
        System.out.println("Nom >");
        String Nom = scanner.next();
        System.out.println("Prenom >");
        String Prenom = scanner.next();
        System.out.println("IBAN >");
        String IBAN = scanner.next();
        System.out.println("Libel >");
        String Libel = scanner.next();

        System.out.println("Solde >");
        String balance= scanner.next();

        System.out.println("Date naissance >");
        String dateBirth = scanner.next();

        System.out.println("Choisissez une agence:");
        List<Agence> Agences = em.createQuery("SELECT a FROM Agence",Agence.class).getResultList();
        for(Agence a : Agences){
            System.out.println(String.format("%10s | %10s |",a.getId(),a.getAdresse()));
        }
        System.out.println("ID agence >");
        String id_agence = scanner.next();
        Query query = em.createQuery("select a from Agence a where a.id="+id_agence);
        Agence agenceSelect = (Agence)query.getSingleResult();


        cli.setPrenom(Prenom);
        cli.setNom(Nom);
        cli.setDateNaissance(new Date(dateBirth));
        acc.setIBAN(IBAN);
        acc.setLibel(Libel);
        acc.setSolde(Double.parseDouble(balance));
        acc.setAgence(agenceSelect);
        Collection<Client> collCli = new ArrayList();
        collCli.add(cli);
        acc.setClients(collCli);

        em.persist(acc);
        em.persist(cli);
        transac.commit();

        em.close();
        emf.close();
    }
}
