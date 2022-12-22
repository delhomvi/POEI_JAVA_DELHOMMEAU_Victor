package com.example.tpOne.service;

import com.example.tpOne.entity.Todo;
import com.example.tpOne.interfaces.ITodo;
import com.example.tpOne.tools.ServiceHibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodo {

    private ServiceHibernate serviceHibernate;
    private Session session;

    public TodoService(ServiceHibernate serviceHibernate){
        this.serviceHibernate = serviceHibernate;
        session = this.serviceHibernate.getSession();
    }

    @Override
    public boolean create(Todo o) {
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Todo o) {
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(Todo o) {
        session.beginTransaction();
        session.remove(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Todo findById(int id) {
        Todo res = null;
        res = (Todo) session.get(Todo.class,id);
        return res;
    }

    @Override
    public List<Todo> findAll() {
        return session.createQuery("SELECT t FROM Todo t", Todo.class).list();
    }
}
