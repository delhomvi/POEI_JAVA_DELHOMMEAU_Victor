package com.example.demojee.service;

import com.example.demojee.entity.Personne;
import com.example.demojee.inderfaces.IPersonneService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Personne2Service implements IPersonneService {
    @Override
    public List<Personne> getPersonnes() {
        return Arrays.asList(new Personne(3,"Papa","Noel"),new Personne(4,"Maman","Noel"));
    }
}
