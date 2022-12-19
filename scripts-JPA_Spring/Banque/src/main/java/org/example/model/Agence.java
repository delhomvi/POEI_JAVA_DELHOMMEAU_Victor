package org.example.model;

import javax.persistence.*;

@Entity
@Table(name="agency")
public class Agence {
    @Id
    @OneToOne(mappedBy="agenceID")
    private int id;
    private String adresse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
