package com.example.demosogetisecurity.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/notices")
    public String getAccountDetails(){
        return "Voici le detail des notices";
    }


}
