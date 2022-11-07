package scripts_java.S1_java_init;
import java.io.*;

public class WriteTicket {
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
}
