package org.example.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="account")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    private int id;

    private String libel;

    private String IBAN;

    private Double solde;

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    @ManyToOne
    @JoinColumn(name="AGENCE_ID")
    private Agence agence;

    @ManyToMany
    @JoinTable(name= "compte_client",
            joinColumns = @JoinColumn(name= "COMPTE_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name= "CLIENT_ID", referencedColumnName = "id"))
    private Collection<Client> clients;


    public String getLibel() {
        return libel;
    }

    public void setLibel(String libelle) {
        this.libel = libelle;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }
}
