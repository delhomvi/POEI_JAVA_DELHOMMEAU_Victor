package fr.delhomvi.Magasin;

// Importations des biblio utiles
import java.util.*;

public class Rayons {
    // Variables Privées
    private static ArrayList<String> articlesInStore;
    private static ArrayList<Double> priceOfArticles;

    // Main
    public static void main(String[] args) {
    }

    // Getter setter et adder
    public static ArrayList<String> getArticlesInStore(){
        return articlesInStore;
    }

    public static ArrayList<Double> getPriceOfArticles(){
        return priceOfArticles;
    }

    public static void addArticlesInStore(String article){
        articlesInStore.add(article);
    }

    public static void addPriceOfArticles(Double priceOfArticle){
        priceOfArticles.add(priceOfArticle);
    }

    // Autres fonctions
    public static void addToAlley(String article, Double price){
        addArticlesInStore(article);
        addPriceOfArticles(price);
    }

}
