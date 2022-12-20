package org.example.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="agency")
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String adresse;

    @OneToMany(mappedBy = "agence")
    private Collection<Compte> comptes;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
