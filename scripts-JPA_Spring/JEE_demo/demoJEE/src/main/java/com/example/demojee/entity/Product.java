package com.example.demojee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String nom;
    private Double price;
    private String ref;
    private int qty;
    private Date date;
}
