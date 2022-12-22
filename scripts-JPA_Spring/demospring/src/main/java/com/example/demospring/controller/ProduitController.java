package com.example.demospring.controller;


import com.example.demospring.entity.Produit;
import com.example.demospring.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produit")
@ResponseBody
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @PostMapping("/post")
    public Produit postProduit(@RequestBody Produit produit){
        if(produitService.create(produit)) {
            return produit;
        }
        return null;
    }

    @GetMapping("/find/{id}")
    public Produit findByID(@PathVariable Integer id){
        return produitService.findById(id);
    }

    @GetMapping("/find")
    public List<Produit> findProduct(){
        return produitService.findAll();
    }

    @PostMapping("/update/{id}")
    public Produit updateProduct(@PathVariable Integer id,@RequestBody Produit produit){
        Produit exisProduit = produitService.findById(id);
        if(exisProduit!=null){
            exisProduit.setMarque(produit.getMarque());
            exisProduit.setReference(produit.getReference());
            exisProduit.setPrix(produit.getPrix());
            exisProduit.setStock(produit.getStock());
            exisProduit.setDateAchat(produit.getDateAchat());
            if(produitService.update(exisProduit)){
                return exisProduit;
            }
        }
        return exisProduit;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        Produit exisProduit = produitService.findById(id);
        if(exisProduit!=null){
            if(produitService.delete(exisProduit)){
                return "produit supprimé";
            }
        }
        return "produit n'existe pas";
    }
}
