package com.example.demospring.service;

import com.example.demospring.entity.Produit;
import com.example.demospring.interfaces.IDAO;
import com.example.demospring.tools.ServiceHibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements IDAO<Produit> {

   // @Autowired
    private ServiceHibernate serviceHibernate;

    private Session session;

    public ProduitService(ServiceHibernate serviceHibernate){
        this.serviceHibernate = serviceHibernate;
        session = this.serviceHibernate.getSession();
    }

    @Override
    public boolean create(Produit o) {
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Produit o) {
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(Produit o) {
        session.beginTransaction();
        session.remove(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Produit findById(int id) {
        Produit res = null;
        res = (Produit) session.get(Produit.class,id);
        return res;
    }

    @Override
    public List<Produit> findAll() {
        return session.createQuery("SELECT p FROM Produit p", Produit.class).list();
    }
}
