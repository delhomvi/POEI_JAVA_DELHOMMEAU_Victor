package com.example.demojee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/Personnes")
public class BeanController {
    @GetMapping("/")
    public String getList(){return "Liste de personnes";}

    @GetMapping("/getSinglePerson/{id}")
    public String getSingle(@PathVariable Integer id){return "retour d'une personnes"+id;}

    @PostMapping("/postPerson")
    public String pagePost(){return "page avec du Post";}


}
