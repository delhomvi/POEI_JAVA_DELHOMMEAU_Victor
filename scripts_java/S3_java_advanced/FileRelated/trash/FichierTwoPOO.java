package scripts_java.S3_java_advanced.FileRelated.trash;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
nécessite :
    commons-lang3-3.1.jar
    opencsv.jar
*/

class MyFileReader  extends FileReader
{

    public MyFileReader(String fileName ) throws FileNotFoundException
    {
        super( fileName );
    }

    public String readLine() throws IOException
    {
        int EOF = -1;
        int LF = 10;
        //int CR = 13;
        int caracter;

        String res = "";

        while ( EOF != (caracter = this.read()) )
        {
            if ( caracter == LF )
                return res;
            else
                res += (char)caracter; 
        }
        return "x*X"; // mon EOF perso
    } 

    
}




public class  FichierTwoPOO {
    // Xavier

    public static void main(String[] args)
    {          
        String EOF = "x*X";
        //int LF = 10;
        //int CR = 13;

        String file = "Figures.java";
        try {
            MyFileReader filereader = new MyFileReader(file);
                
                int nbrLin = 1;
                String ligne;

                while ( EOF != (ligne = filereader.readLine()) )
                    System.out.println( String.format("%4d : %s", nbrLin++, ligne ) );

                filereader.close();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }    
}
