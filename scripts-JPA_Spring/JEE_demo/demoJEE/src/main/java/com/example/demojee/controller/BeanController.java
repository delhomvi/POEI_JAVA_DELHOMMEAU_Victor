package com.example.demojee.controller;

import com.example.demojee.entity.Personne;
import com.example.demojee.inderfaces.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/Personnes")
public class BeanController {

    @Autowired
    @Qualifier("personne2Service")//Switch de service
    private IPersonneService personneService;

    @GetMapping("/")
    //public String getList(){return "Liste de personnes";}
    public List<Personne> getPersonne(){return personneService.getPersonnes();}

    @GetMapping("/getSinglePerson/{id}")
    public String getSingle(@PathVariable Integer id){return "retour d'une personnes"+id;}

    @PostMapping("/postPerson")
    public String pagePost(){return "page avec du Post";}

    @PostMapping("/postWithoutParam")
    public Personne postPersonne(@RequestBody Personne personne){
        return personne;
    }

    @PostMapping("/postWithParam")
    public Personne postPersonne(@RequestParam String nom,@RequestParam String prenom){
        return new Personne(1,nom,prenom);
    }





}
