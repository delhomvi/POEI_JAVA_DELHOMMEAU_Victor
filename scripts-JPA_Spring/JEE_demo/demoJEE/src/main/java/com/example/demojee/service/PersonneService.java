package com.example.demojee.service;

import com.example.demojee.entity.Personne;
import com.example.demojee.inderfaces.IPersonneService;

import java.util.Arrays;
import java.util.List;

public class PersonneService implements IPersonneService {

    @Override
    public List<Personne> getPersonnes() {
        return Arrays.asList(new Personne(1,"toto","titi"),new Personne(2,"tata","titi"));
    }
}
