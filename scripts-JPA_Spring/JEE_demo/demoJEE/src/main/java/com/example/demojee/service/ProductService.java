package com.example.demojee.service;

import com.example.demojee.entity.Product;
import com.example.demojee.inderfaces.IProductService;
import com.example.demojee.tools.ServiceHibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private ServiceHibernate serviceHibernate;
    private Session session;

    public  ProductService(ServiceHibernate serviceHibernate){
        this.serviceHibernate=serviceHibernate;
        session = this.serviceHibernate.getSession();
    }

    @Override
    public List<Product> getProducts() {
        return Arrays.asList(new Product(1,"Salade",1.00,"EEEEE",5,new Date(01/01/2000)),new Product(2,"Tomate",1.00,"EEEEE",5,new Date(01/01/2000)),new Product(3,"Oignons",1.00,"EEEEE",5,new Date(01/01/2000)));
    }

    @Override
    public List<Product> getProductsFromDB() {
        return null;
    }

    @Override
    public void begin() {

    }

    @Override
    public boolean create(Product o) {
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Product o) {
        return false;
    }

    @Override
    public boolean delete(Product o) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void envoie() {

    }

    @Override
    public void close() {

    }


    /*
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exercicejpa");

    private EntityManager em=emf.createEntityManager();


    @Override
    public List<Product> getProducts() {
        return Arrays.asList(new Product(1,"Salade",1.00,"EEEEE",5,new Date(01/01/2000)),new Product(2,"Tomate",1.00,"EEEEE",5,new Date(01/01/2000)),new Product(3,"Oignons",1.00,"EEEEE",5,new Date(01/01/2000)));
    }

    @Override
    public List<Product> getProductsFromDB() {
        Query query = em.createNativeQuery("SELECT * FROM produit;");
        List<Product> list = query.getResultList();
        return list;
    }

    @Override
    public void begin() {
        em.getTransaction().begin();
        System.out.println("Demarrrage de la persistance");
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
        Query query = em.createNativeQuery("SELECT * FROM produit WHERE id="+id);
        Product res = (Product) query.getSingleResult();
        return res;
    }

    @Override
    public void envoie() {
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        em.close();
        emf.close();
    }
    */


}
