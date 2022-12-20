package org.example.domain;

import org.example.model.Agence;
import org.example.model.Client;
import org.example.model.Compte;

import javax.persistence.*;
import java.util.*;

public class Menu {
    public static void exo(){

        System.out.println("-------- Init exo --------");

        // INIT -----------------------------------------------------
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExoBanque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        // AGENCE -----------------------------------------------------
        transac.begin();
        Agence agence = new Agence();
        agence.setAdresse("01 rue de la Moselle");
        em.persist(agence);
        Agence agence1 = new Agence();
        agence1.setAdresse("02 rue de la Moselle");
        em.persist(agence1);
        Agence agence2 = new Agence();
        agence2.setAdresse("03 rue de la Moselle");
        em.persist(agence);
        transac.commit();

        // CLIENTS -----------------------------------------------------
        transac.begin();
        Client client = new Client();
        client.setNom("Toto");
        client.setPrenom("Toto");
        client.setDateNaissance(new Date("01/01/2000"));
        em.persist(client);
        Client client1 = new Client();
        client1.setNom("Tata");
        client1.setPrenom("Tata");
        client1.setDateNaissance(new Date("01/01/2000"));
        em.persist(client1);
        Client client2 = new Client();
        client2.setNom("Titi");
        client2.setPrenom("Titi");
        client2.setDateNaissance(new Date("01/01/2000"));
        em.persist(client2);
        transac.commit();

        // COMPTES ----------------------------------------------------
        transac.begin();
        Compte compte = new Compte();
        compte.setLibel("Compte Toto 1");
        compte.setSolde(0.0);
        compte.setIBAN("123465798123456789FRFR");
        em.persist(compte);
        Compte compte1 = new Compte();
        compte1.setLibel("Compte Toto 2");
        compte1.setSolde(0.0);
        compte1.setIBAN("123465798123456789FRFR");
        em.persist(compte1);
        Compte compte2 = new Compte();
        compte2.setLibel("Compte Tata");
        compte2.setSolde(0.0);
        compte2.setIBAN("123465798123456789FRFR");
        em.persist(compte2);
        Compte compte3 = new Compte();
        compte3.setLibel("Compte Titi");
        compte3.setSolde(0.0);
        compte3.setIBAN("123465798123456789FRFR");
        em.persist(compte3);
        transac.commit();

        // COLLECTEURS ----------------------------------------------------
        // Comptes agence 1
        Collection<Compte> listComptes = new ArrayList<>();
        listComptes.add(compte);
        listComptes.add(compte1);
        // Comptes agence 2
        Collection<Compte> listComptes1 = new ArrayList<>();
        listComptes1.add(compte2);
        // Comptes agence 3
        Collection<Compte> listComptes2 = new ArrayList<>();
        listComptes2.add(compte3);
        // Clients compte 1
        Collection<Client> listClients = new ArrayList<>();
        listClients.add(client);
        // Clients compte 2
        Collection<Client> listClients1 = new ArrayList<>();
        listClients1.add(client);
        // Clients compte 3
        Collection<Client> listClients2 = new ArrayList<>();
        listClients2.add(client1);
        // Clients compte 4
        Collection<Client> listClients3 = new ArrayList<>();
        listClients3.add(client2);
        // Client 1 liste comptes
        Collection<Compte> listCompteClients = new ArrayList<>();
        listCompteClients.add(compte);
        listCompteClients.add(compte1);
        // Client 2 liste comptes
        Collection<Compte> listCompteClients1 = new ArrayList<>();
        listCompteClients1.add(compte2);
        // Client 3 liste comptes
        Collection<Compte> listCompteClients2 = new ArrayList<>();
        listCompteClients2.add(compte3);
        // Attribution des comptes aux agences
        transac.begin();
        agence.setComptes(listComptes);
        agence1.setComptes(listComptes1);
        agence2.setComptes(listComptes2);
        em.persist(agence);
        em.persist(agence1);
        em.persist(agence2);
        transac.commit();
        // attribution de l'agence aux comptes
        transac.begin();
        compte.setAgence(agence);
        compte1.setAgence(agence);
        compte2.setAgence(agence1);
        compte3.setAgence(agence2);
        em.persist(compte);
        em.persist(compte1);
        em.persist(compte2);
        em.persist(compte3);
        transac.commit();
        // Attribution clients aux comptes
        transac.begin();
        compte.setClients(listClients);
        compte1.setClients(listClients1);
        compte2.setClients(listClients2);
        compte3.setClients(listClients3);
        em.persist(compte);
        em.persist(compte1);
        em.persist(compte2);
        em.persist(compte3);
        transac.commit();
        // Attribution des comptes aux clients
        transac.begin();
        client.setComptes(listCompteClients);
        client1.setComptes(listCompteClients1);
        client2.setComptes(listCompteClients2);
        em.persist(client);
        em.persist(client1);
        em.persist(client2);
        transac.commit();

        System.out.println("-------- End init --------");


        System.out.println("-------- Init show --------");
        transac.begin();
        Query query = em.createNativeQuery("SELECT * from account",Compte.class);
        List<Compte> listComptess = query.getResultList();
        for(Object c: listComptess){
            Compte cc = (Compte) c;
            System.out.println(String.format("----\n ID: %s\n LIBEL: %25s \n IBAN: %25s \n Adresse agence: %25s\n",cc.getId(),cc.getLibel(),cc.getIBAN(),cc.getAgence().getAdresse()));
        }
        transac.commit();
        System.out.println("-------- End show --------");


        System.out.println("-------- Start add --------");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Add New Client ? (y/n): ");

        String newClient = scanner.nextLine();
        Client chosenClient;
        Collection<Compte> newListComptes = new ArrayList<>();
        Collection<Client> newListClients = new ArrayList<>();

        if (newClient.matches("y|yes|Y|YES|ye|YE")) {
            transac.begin();
            Compte acc = new Compte();
            Client cli = new Client();
            System.out.println("Entrez les informations suivantes: ");
            System.out.println("Nom >");
            String Nom = scanner.nextLine();
            System.out.println("Prenom >");
            String Prenom = scanner.nextLine();
            System.out.println("IBAN >");
            String IBAN = scanner.nextLine();
            System.out.println("Libel >");
            String Libel = scanner.nextLine();
            System.out.println("Solde >");
            String balance= scanner.nextLine();
            System.out.println("Date naissance >");
            String dateBirth = scanner.nextLine();
            System.out.println("Choisissez une agence:");
            List<Agence> Agences = em.createQuery("SELECT a FROM Agence a",Agence.class).getResultList();
            for(Agence a : Agences){
                System.out.println(String.format("%10s | %10s |",a.getId(),a.getAdresse()));
            }
            System.out.println("ID agence >");
            String id_agence = scanner.nextLine();
            Query query1 = em.createQuery("select a from Agence a where a.id="+id_agence);
            Agence agenceSelect = (Agence)query1.getSingleResult();
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
        } else {
            System.out.println("DONE");
        }

        System.out.println("-------- End add --------");


        System.out.println("-------- Init show Two--------");
        transac.begin();
        Query query2 = em.createNativeQuery("SELECT * from account",Compte.class);
        List<Compte> listComptess2 = query2.getResultList();
        for(Object c: listComptess2){
            Compte cc = (Compte) c;
            System.out.println(String.format("----\n ID: %s\n LIBEL: %25s \n IBAN: %25s \n Adresse agence: %25s\n",cc.getId(),cc.getLibel(),cc.getIBAN(),cc.getAgence().getAdresse()));
        }
        transac.commit();
        System.out.println("-------- End show --------");


        System.out.println("-------- Start modif account --------");
        System.out.println("Which one you want to modify ? (ID): ");
        String modClienIDstr = scanner.nextLine();
        int modClienID = Integer.parseInt(modClienIDstr);
        transac.begin();
        Compte accountToMod = em.find(Compte.class,modClienID);
        System.out.println("Entrez les nouvelles informations: ");
        System.out.println("IBAN >");
        String IBANN = scanner.nextLine();
        System.out.println("Libel >");
        String Libell = scanner.nextLine();
        System.out.println("Solde >");
        String balancee= scanner.nextLine();
        System.out.println("Choisissez une agence:");
        List<Agence> Agencess = em.createQuery("SELECT a FROM Agence a",Agence.class).getResultList();
        for(Agence a : Agencess){
            System.out.println(String.format("%10s | %10s |",a.getId(),a.getAdresse()));
        }
        System.out.println("ID agence >");
        String id_agencee = scanner.nextLine();
        Query query3 = em.createQuery("select a from Agence a where a.id="+id_agencee);
        Agence agenceSelectt = (Agence)query3.getSingleResult();
        accountToMod.setIBAN(IBANN);
        accountToMod.setLibel(Libell);
        accountToMod.setSolde(Double.parseDouble(balancee));
        accountToMod.setAgence(agenceSelectt);
        em.flush();
        transac.commit();

        System.out.println("-------- End Modif --------");


        System.out.println("-------- Init show Three--------");
        transac.begin();
        Query query4 = em.createNativeQuery("SELECT * from account",Compte.class);
        List<Compte> listComptess3 = query4.getResultList();
        for(Object c: listComptess3){
            Compte cc = (Compte) c;
            System.out.println(String.format("----\n ID: %s\n LIBEL: %25s \n IBAN: %25s \n Adresse agence: %25s\n",cc.getId(),cc.getLibel(),cc.getIBAN(),cc.getAgence().getAdresse()));
        }
        transac.commit();
        System.out.println("-------- End show --------");


        em.close();
        emf.close();
    }

}
