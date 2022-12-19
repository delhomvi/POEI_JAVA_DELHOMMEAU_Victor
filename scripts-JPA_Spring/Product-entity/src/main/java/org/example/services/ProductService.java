package org.example.services;

import org.example.interfaces.IDAO;
import org.example.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

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

    @Override
    public List<Product> findAll() {
        Query query = em.createQuery("select p from Product p");
        List<Product> list = query.getResultList();
        return list;
    }

    public List<Product> filterByPrice(double min){
        Query query = em.createQuery("select p from Product p where p.price >= :min");
        query.setParameter("min",min);
        List<Product> list = query.getResultList();
        return list;
    }

    public List<Product> filterByDate(Date min,Date max) throws Exception{
        if(min.before(max)){
            Query query = em.createQuery("select p from Product p where purchaseDate");
        }
    }
}
