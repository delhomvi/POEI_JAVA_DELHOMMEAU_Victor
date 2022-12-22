package com.example.demojee.tools;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceHibernate {
    private Session _session;
    private ServiceHibernate(){
        try{
            _session=HibernateUtil.getSessionFactory().openSession();
        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
    }

    public Session getSession(){return HibernateUtil.getSessionFactory().openSession();}

}
