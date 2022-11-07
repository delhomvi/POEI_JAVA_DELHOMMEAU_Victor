package delhomvi;
import java.util.*;

public class BuildTicket {
    public static String buildTicket(List<String> articles, List<Double> prix,  List<Double>  qtes) {
        String toWritee = "\n------------------\nMagasin Bidule\nDans une certaine ville\navec tel contacts\n------------------\n\n";
        String ticketString=String.format("| %15s | %5.10s | %5.10s | %5.10s |\n","article","prix","quantite","total");
        toWritee+=ticketString;
        double totalCost=0;
        for(int index = 0 ; index<articles.size(); index++){
            String stringFormat=String.format("| %15s | %5.2f | %8.2f | %5.2f |\n",articles.get(index),prix.get(index),qtes.get(index),prix.get(index)*qtes.get(index));
            totalCost+=prix.get(index)*qtes.get(index);
            toWritee+=stringFormat;
        }
        toWritee+="\nTotal a payer: "+totalCost+"euro(s)";
        return toWritee;
    }
}
