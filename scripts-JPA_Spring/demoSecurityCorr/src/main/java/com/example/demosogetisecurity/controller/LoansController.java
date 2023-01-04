package com.example.demosogetisecurity.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/myLoans")
    public String getAccountDetails(){
        return "Voici le detail de mes emprunts";
    }


}
