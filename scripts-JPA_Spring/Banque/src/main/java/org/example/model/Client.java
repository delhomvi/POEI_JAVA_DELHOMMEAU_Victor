package org.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="client")
public class Client {
    @Id
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;

    @ManyToMany(mappedBy = "listeClient")
    private Collection<Compte> listeCompte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Collection<Compte> getListeCompte() {
        return listeCompte;
    }

    public void setListeCompte(Collection<Compte> listeCompte) {
        this.listeCompte = listeCompte;
    }
}
