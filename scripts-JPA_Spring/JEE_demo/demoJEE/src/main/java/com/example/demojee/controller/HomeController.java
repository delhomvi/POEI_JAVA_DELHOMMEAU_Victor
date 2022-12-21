package com.example.demojee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {

    @RequestMapping("/")
    public String getHome(){return "Hello world";}

    @RequestMapping("/toto")
    public String getToto(){return "Hello Toto !";}

    @GetMapping("/get")
    public String pageGet(){return "page avec du get";}

    @PostMapping("/post")
    public String pagePost(){return "page avec du Post";}


}
