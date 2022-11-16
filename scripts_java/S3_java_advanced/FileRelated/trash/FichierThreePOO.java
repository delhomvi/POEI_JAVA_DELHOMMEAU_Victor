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
    static Integer EOF = -1;
    static Integer LF = 10;
    static int CR = 13;
    int caractereLuEnTrop; 


    public MyFileReader(String fileName ) throws FileNotFoundException
    {
        super( fileName );
    }

    public Boolean hasNext() throws IOException
    {

        if ( EOF == ( this.caractereLuEnTrop=this.read()) )
            return false;
        return true;
    }

    public String readLine() throws IOException
    {
        int caracter;

        String res = new String();
        res += (char)this.caractereLuEnTrop;

        while ( EOF != (caracter = this.read()) )
        {
            if ( caracter == LF )
                return res;
            else
                res += (char)caracter; 
        }
        return "";
    } 
}




public class  FichierThreePOO {
    // Xavier

    public static void main(String[] args)
    {          
        String file = "Figures.java";
        try {
            MyFileReader filereader = new MyFileReader(file);
                
                int nbrLin = 1;
                String ligne;

                while ( filereader.hasNext() )
                {
                    ligne = filereader.readLine();
                    System.out.println( String.format("%4d : %s", nbrLin++, ligne ) );
                }
                filereader.close();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }    
}