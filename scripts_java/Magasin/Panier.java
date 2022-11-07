package scripts_java.Magasin;

// Importations des biblio utiles
import java.util.*;

public class Panier {
    // Initiation des variables
    public static List<String> articlesInCart = new ArrayList<>();
    public static List<Double> priceArticles = new ArrayList<>();
    public static List<Double> qtesArticles = new ArrayList<>();


    // Main
    public static void main(String[] args){
        // Initialisation du panier
        String[] articles = { "Pomme", "Poire", "Mandarinnes", "Orange", "Tomates", "Kebab","Frites"};
        double[] prix = { 1.50, 1.20, 18.2, 2.5, 4.0, 12, 1 };
        double[] qtes = { 0.52, 0.88, 0.60, 0.5, 0.8, 1, 1 };

        // Ajoute au panier
        for (int i = 0; i < articles.length; i++) {
            addToCart(articles[i], prix[i], qtes[i]);
        }
        removeFromCart("Kebab");
        removeFromCart("Frites");
        Ticket.makeTicket("Ticket");
    }

    // Getters et setters/adders
    public static List<String> getArticlesInCart() {
        return articlesInCart;
    }

    public static List<Double> getPrices() {
        return priceArticles;
    }

    public static List<Double> getQtesOfArticles() {
        return qtesArticles;
    }

    public static void addArticles(String elemArt) {
        articlesInCart.add(elemArt);
    }

    public static void addPrices(Double elemPrice) {
        priceArticles.add(elemPrice);
    }

    public static void addQtes(Double elemQtes) {
        qtesArticles.add(elemQtes);
    }

    // Autres fonctions
    public static void addToCart(String elemArt, Double elemPrice, Double elemQtes) {
        addArticles(elemArt);
        addPrices(elemPrice);
        addQtes(elemQtes);
    }

    public static void removeFromCart(String elemArt) {
        int indexArticle = articlesInCart.indexOf(elemArt);
        articlesInCart.remove(articlesInCart.get(indexArticle));
        priceArticles.remove(priceArticles.get(indexArticle));
        qtesArticles.remove(qtesArticles.get(indexArticle));
    }
}
    