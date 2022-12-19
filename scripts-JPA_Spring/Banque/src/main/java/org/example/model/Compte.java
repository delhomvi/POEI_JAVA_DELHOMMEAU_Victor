package org.example.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="account")
public class Compte {
    @Id
    private int id;
    private String libel;
    private String IBAN;
    private Double Solde;

    @OneToOne
    @JoinColumn(name="AGE_ID")
    private Agence agenceID;

    @ManyToMany
    @JoinTable(name="CLI_ACC",
    joinColumns = @JoinColumn(name = "CLI_ID",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "ACC_ID",referencedColumnName = "id"))
    private Collection<Client> listeClient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibel() {
        return libel;
    }

    public void setLibel(String libel) {
        this.libel = libel;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Double getSolde() {
        return Solde;
    }

    public void setSolde(Double solde) {
        Solde = solde;
    }

    public Agence getAgenceID() {
        return agenceID;
    }

    public void setAgence(Agence agenceID) {
        this.agenceID = agenceID;
    }

    public Collection<Client> getListeClient() {
        return listeClient;
    }

    public void setListeClient(Collection<Client> listeClient) {
        this.listeClient = listeClient;
    }
}
