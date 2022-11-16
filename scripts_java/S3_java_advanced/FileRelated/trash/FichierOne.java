package scripts_java.S3_java_advanced.FileRelated.trash;
import java.io.FileReader;

/* 
nécessite :
    commons-lang3-3.1.jar
    opencsv.jar
*/


public class  FichierOne {
    // Xavier

    public static void main(String[] args)
    {          
        int EOF = -1;
        int LF = 10;
        //int CR = 13;

        String file = "Figures.java";
        try {
                FileReader filereader = new FileReader(file);
                
                //int size = filereader.
                //for ( int i=0 ; i < 100 ; i++ )
                //    System.out.print( (char) filereader.read() ); 

                int caracter;
                int nbrCar = 0;
                int nbrLin = 1;

                System.out.print( String.format("%4d : ", nbrLin ) );
                while ( EOF != (caracter = filereader.read()) )
                {
                    if ( caracter == LF )
                    {
                        nbrLin++;
                        System.out.println( );
                        System.out.print( String.format("%4d : ", nbrLin ) );
                    }
                    else
                        System.out.print( (char)caracter ); 
                    
                    nbrCar++;
                }
                filereader.close();
                System.out.println();
                System.out.println( nbrCar );
                System.out.println( nbrLin );
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }    
}
