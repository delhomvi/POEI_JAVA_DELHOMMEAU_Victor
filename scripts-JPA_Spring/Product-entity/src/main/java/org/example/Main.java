package org.example;

import org.example.model.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialisation
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductJPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        // Création des 5 produits
        Product productC;
        List<String> dates = new ArrayList<String>();
        dates.add("01/01/2022");dates.add("02/01/2022");dates.add("03/01/2022");dates.add("04/01/2022");dates.add("05/01/2022");dates.add("06/01/2022");
        transac.begin();
        for(int i=0;i<=5;i++){
            productC= new Product();
            productC.setBrand("brand "+(i+1));
            productC.setReference("ref "+(i+1));
            productC.setPurchaseDate(new Date(dates.get(i)));
            productC.setPrice(98.0+i);
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

        // Afficher tout les produits
        System.out.println("Resultat Exo 5: ");
        List<Product> results4 = em.createNativeQuery("SELECT * FROM product",Product.class).getResultList();
        for(Product p : results4){
            System.out.println(String.format("%10s | %10s | %10s | %10s | %10s",p.getId(),p.getBrand(),p.getPrice(),p.getNumberInStock(),p.getPurchaseDate()));
        }

        //Afficher liste des produits dont le prix est supérieur à 100 euros
        System.out.println("Resultat Exo 6: ");
        List<Product> results5 = em.createNativeQuery("SELECT * FROM product where price>=100",Product.class).getResultList();
        for(Product p : results5){
            System.out.println(String.format("%10s | %10s | %10s | %10s | %10s",p.getId(),p.getBrand(),p.getPrice(),p.getNumberInStock(),p.getPurchaseDate()));
        }

        //Afficher liste des produits dont le prix est supérieur à 100 euros
        System.out.println("Resultat Exo 7: ");
        Query query2 = em.createQuery("select p from Product p where p.purchaseDate<'2022-03-01' and p.purchaseDate>'2022-01-01'");
        List products = query2.getResultList();
        for(Object product: products){
            Product p = (Product) product;
            System.out.println(String.format("%10s | %10s | %10s | %10s | %10s",p.getId(),p.getBrand(),p.getPrice(),p.getNumberInStock(),p.getPurchaseDate()));
        }
    }
}