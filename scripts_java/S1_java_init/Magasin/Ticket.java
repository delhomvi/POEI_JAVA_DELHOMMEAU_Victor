package scripts_java.Magasin;

// Importations des biblio utiles
import java.io.*;

// Classe Principale
public class Ticket {
    // Variables Privées
    private static Double totalCart = 0.0;
    private static String ticketStr = "";

    // Main
    public void main(String[] args) {
    }

    // Getters et Adders
    public static String getTicketStr() {
        return ticketStr;
    }
    public static Double getTotalCart() {
        return totalCart;
    }
    public static void addTicketStr(String elemStr) {
        ticketStr = ticketStr + elemStr;
    }
    public static void addTotalCart(Double valueToCart) {
        totalCart += valueToCart;
    }

    // Autres fonctions
    public static void makeTicket(String fileName) {
        // Réinitialise le total et le string lié au ticket
        ticketStr = "";
        totalCart = 0.0;
        // Initialise le ticket
        buildTicket();
        // Build le ticket
        try {
            FileWriter myWriter = new FileWriter(fileName + ".txt");
            myWriter.write(ticketStr);
            myWriter.close();
            System.out.println("Ecriture du ticket en cours.");
        } catch (IOException e) {
            System.out.println("Erreur dans l'écriture du ticket.");
            e.printStackTrace();
        }
        System.out.println("Ecriture du ticket Finalisée.");
    }

    public static void buildTicket() {
        // Initialisation de la structure du ticket
        String initString = "\n------------------\nMagasin storeArray (ou alors store_array)\nDans une certaine virtual machine\nAvec tel Version de build\n------------------\n\n";
        String initFormat = String.format("| %5.10s | %15s | %5.10s | %5.10s | %5.10s |\n", "index", "article", "prix",
                "quantite", "total");
        addTicketStr(initString + initFormat);
        // Boucle sur les articles du panier
        for (int index = 0; index < Panier.articlesInCart.size(); index++) {
            addTotalCart(Panier.getPrices().get(index) * Panier.getQtesOfArticles().get(index));
            String addFormatArticle = String.format("| %5.2s | %15s | %5.2f | %8.2f | %5.2f |\n", index,
                    Panier.getArticlesInCart().get(index), Panier.getPrices().get(index), Panier.getQtesOfArticles().get(index),
                    Panier.getPrices().get(index)*Panier.getQtesOfArticles().get(index)); // Formatage du ticket
            addTicketStr(addFormatArticle);
        }
        addTicketStr("\nTotal a payer: " + getTotalCart() + "euro(s)");
    }

}
