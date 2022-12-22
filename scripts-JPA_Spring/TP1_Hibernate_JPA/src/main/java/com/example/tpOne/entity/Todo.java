package com.example.tpOne.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.Date;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String descr;
    @Temporal(TemporalType.DATE)
    private Date date;
    private boolean state;

}
