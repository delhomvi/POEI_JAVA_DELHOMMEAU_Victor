package com.delhomvi.demoSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/loans")
    public String getAccDetails(){
        return "detail du compte";
    }
}
