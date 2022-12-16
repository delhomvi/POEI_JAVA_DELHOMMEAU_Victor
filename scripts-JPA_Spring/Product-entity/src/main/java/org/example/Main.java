package org.example;

import org.example.model.Product;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialisation
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductJPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        // Création des 5 produits
        Product productC;
        transac.begin();
        for(int i=0;i<=5;i++){
            productC= new Product();
            productC.setBrand("brand "+(i+1));
            productC.setReference("ref "+(i+1));
            productC.setPurchaseDate(null);
            productC.setPrice(1.00);
            productC.setNumberInStock(i);
            em.persist(productC);
            transac.commit();
            transac.begin();
            productC=null;
        }
        transac.commit();

        System.out.println("Resultat Exo 1: ");
        List<Product> results = em.createNativeQuery("SELECT * FROM product",Product.class).getResultList();
        for(Product p : results){
            System.out.println(String.format("%10s | %10s | %10s | %10s | %10s",p.getId(),p.getBrand(),p.getPrice(),p.getNumberInStock(),p.getPurchaseDate()));
        }

        // Afficher le produit id2
        Query query = em.createQuery("select p from Product p where p.id=2");
        Product product2 = (Product)query.getSingleResult();
        System.out.println("Resultat Exo 2: ");
        System.out.println(String.format("%10s | %10s | %10s | %10s | %10s",product2.getId(),product2.getBrand(),product2.getPrice(),product2.getNumberInStock(),product2.getPurchaseDate()));

        // Supprimer le produit id3
        transac.begin();
        Product product3 = em.find(Product.class,3);
        em.remove(product3);
        transac.commit();
        System.out.println("Resultat Exo 3: ");
        List<Product> results2 = em.createNativeQuery("SELECT * FROM product",Product.class).getResultList();
        for(Product p : results2){
            System.out.println(String.format("%10s | %10s | %10s | %10s | %10s",p.getId(),p.getBrand(),p.getPrice(),p.getNumberInStock(),p.getPurchaseDate()));
        }

        // Modifier produit id1
        transac.begin();
        Product product4 = em.find(Product.class,1);
        product4.setBrand("MarqueModif");
        product4.setReference("Reference Modif");
        product4.setPrice(10000.0);
        product4.setNumberInStock(0);
        em.flush();
        transac.commit();

        System.out.println("Resultat Exo 4: ");
        List<Product> results3 = em.createNativeQuery("SELECT * FROM product",Product.class).getResultList();
        for(Product p : results3){
            System.out.println(String.format("%10s | %10s | %10s | %10s | %10s",p.getId(),p.getBrand(),p.getPrice(),p.getNumberInStock(),p.getPurchaseDate()));
        }

    }
}