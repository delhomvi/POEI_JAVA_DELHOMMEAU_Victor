package com.example.tpOne.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

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

    public Todo(String title, String descr, Date date, boolean state) {
        this.title = title;
        this.descr = descr;
        this.date = date;
        this.state = state;
    }
}
