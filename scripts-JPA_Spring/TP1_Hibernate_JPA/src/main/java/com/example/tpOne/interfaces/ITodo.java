package com.example.tpOne.interfaces;

import com.example.tpOne.entity.Todo;

import java.util.List;

public interface ITodo {
    boolean create(Todo o);

    boolean update(Todo o);

    boolean delete(Todo o);

    Todo findById(int id);

    List<Todo> findAll();
}
