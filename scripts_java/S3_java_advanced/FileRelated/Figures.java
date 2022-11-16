package scripts_java.S3_java_advanced.FileRelated;


class Figures {

    public static void main(String[] args) 
    {

        int hauteur =  5;

        for ( int ligne = 0 ; ligne < hauteur ; ligne++ )
        {
            int i; 
            for( i = 0 ; i  < ligne ; i++ )
                System.out.print( 'a'); 
            for(  ; i  < 4 ; i++ )
                System.out.print( 'z'); 
            System.out.print( '*'); 
            for( i=0 ; i  < 4-ligne ; i++ )
                System.out.print( 'e'); 
        
            System.out.println("");
        }

        for ( int ligne = 1 ; ligne < hauteur ; ligne++ )
        {
            int i; 
            for( i=0 ; i  < 4-ligne ; i++ )
                System.out.print( 'a'); 
            for(  ; i  < 4 ; i++ )
                System.out.print( 'z');
            System.out.print( '*'); 
            for( i = 0 ; i  < ligne ; i++ )
                System.out.print( 'g'); 
            
            System.out.println("");
        }

/*
        *********
         *******
          *****
           ***
            *
           ***
          *****
         *******
        *********  

        **********
         ********
          ******
           ****
            **
           ****
          ******
         ********
        **********  
 
 
 
 
 
           */







    }
}