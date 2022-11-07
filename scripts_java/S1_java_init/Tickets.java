package scripts_java.S1_java_init;

import java.util.*;

public class Tickets {
    public static List<String> articlesArr = new ArrayList<>();
    public static List<Double> prixArr = new ArrayList<>();
    public static List<Double> qtesArr = new ArrayList<>();

    public static void main(String[] args) 
    {   
        // Ecrire des choses dans un fichier
        AddArticle.addArticle();
        
        // Ecrit le ticket
        String toWrite = BuildTicket.buildTicket(articlesArr,prixArr,qtesArr);

        // ToWrite in txt
        WriteTicket.writeInTxt(toWrite,"ticket");
    }
}
