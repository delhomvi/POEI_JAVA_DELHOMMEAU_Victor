package com.example.tpOne.controller;

import com.example.tpOne.entity.Todo;
import com.example.tpOne.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
@ResponseBody
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/create")
    public Todo createTodo(@RequestBody Todo todo){
        if(todoService.create(todo)){
            return todo;
        }
        return null;
    }

    @GetMapping("/read/{id}")
    public Todo findByID(@PathVariable Integer id){
        return todoService.findById(id);
    }

    @GetMapping("/read")
    public List<Todo> findProduct(){
        return todoService.findAll();
    }

    @PostMapping("/update/{id}")
    public Todo updateProduct(@PathVariable Integer id,@RequestBody Todo todo){
        Todo exisTodo = todoService.findById(id);
        if(exisTodo!=null){
            exisTodo.setTitle(todo.getTitle());
            exisTodo.setDesc(todo.getDesc());
            exisTodo.setDate(todo.getDate());
            exisTodo.setState(todo.isState());
            if(todoService.update(exisTodo)){
                return exisTodo;
            }
        }
        return exisTodo;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        Todo exisProduit = todoService.findById(id);
        if(exisProduit!=null){
            if(todoService.delete(exisProduit)){
                return "todo supprimé";
            }
        }
        return "id n'existe pas";
    }


}
