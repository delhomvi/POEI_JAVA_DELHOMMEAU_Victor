package org.example.services;

import org.example.interfaces.IDAO;
import org.example.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductService implements IDAO<Product> {
    private EntityManagerFactory emf;

    private EntityManager em;

    public ProductService(){
        emf = Persistence.createEntityManagerFactory("ProductJPA");
        em = emf.createEntityManager();
    }

    @Override
    public void begin() {
        em.getTransaction().begin();
        System.out.println("Start persistence");
    }

    @Override
    public boolean create(Product o) {
        em.persist(o);
        return true;
    }

    @Override
    public boolean update(Product o) {
        em.persist(o);
        return true;
    }

    @Override
    public boolean delete(Product o) {
        em.remove(o);
        return true;
    }

    @Override
    public Product findById(int id) {
        return em.find(Product.class,id);
    }

    @Override
    public void send() {
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        em.close();
        emf.close();
    }
}
