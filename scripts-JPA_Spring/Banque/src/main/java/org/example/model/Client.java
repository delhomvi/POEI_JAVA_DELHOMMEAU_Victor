package org.example.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nom;

    private String prenom;

    @ManyToMany(mappedBy = "clients")
    private Collection<Compte> comptes;

    private Date dateNaissance;

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateDeNaissance) {
        this.dateNaissance = dateDeNaissance;
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

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
