package scripts_java.S1_java_init.Initiation;
//
// Par DELHOMMEAU Victor
//

import java.io.*;
public class Tickets {

    public static String buildTicket(String[] articles, double[] prix, double[] qtes) {
        String toWritee = "\n------------------\nMagasin Bidule\nDans une certaine ville\navec tel contacts\n------------------\n\n";
        String ticketString=String.format("| %15s | %5.10s | %5.10s | %5.10s |\n","article","prix","quantite","total");
        toWritee+=ticketString;
        double totalCost=0;
        for(int index = 0 ; index<articles.length; index++){
            String stringFormat=String.format("| %15s | %5.2f | %8.2f | %5.2f |\n",articles[index],prix[index],qtes[index],prix[index]*qtes[index]);
            totalCost+=prix[index]*qtes[index];
            toWritee+=stringFormat;
        }
        toWritee+="\nTotal a payer: "+totalCost+"euro(s)";
        return toWritee;
    }

    public static void writeInTxt(String toWritee, String name){
        try {
            FileWriter myWriter = new FileWriter(name+".txt");
            myWriter.write(toWritee);
            myWriter.close();
            System.out.println("Ecriture du ticket.");
        } catch (IOException e) {
            System.out.println("Erreur dans l'écriture du ticket.");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) 
    {
       // Ecrire des choses dans un fichier
        String[] articles = {"Pomme","Poire","Mandarinnes","Orange","Tomates","Kebab"};
        double[] prix = {1.50,1.20,18.2,2.5,4.0,12};
        double[] qtes = {0.52,0.88,0.60,0.5,0.8,1};
        
        // Ecrit le ticket
        String toWrite = buildTicket(articles,prix,qtes);

        // ToWrite in txt
        writeInTxt(toWrite,"ticket");
    }
    
}
