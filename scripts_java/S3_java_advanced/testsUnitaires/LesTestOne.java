import javax.naming.ldap.ExtendedRequest;

// Bourget

class Atester 
{
    static public Integer calcul1( int var )
    {
        return 5 * var;
    }

    static public String presentation( String n )
    {
        if ( n == null )
            return null;
            
        if ( n.length() == 0 )
            return n;
            
        return n.substring(0, 1 ).toUpperCase() +  n.substring( 1 ).toLowerCase();

    }

    static public void testString( String a,  String b )
    {
        if ( a != null && b != null  )
            System.out.println( String.format( "%s : %s == %s   ", a.equals(b) ? "OK" : "KO",  a, b   ));
        else if ( a == null && b != null  )
            System.out.println( String.format( "KO : null == %s   ", b   ));
        else if ( b == null && a != null  )
            System.out.println( String.format( "KO : %s == null   ", a   ));
        else
            System.out.println( "OK : null == null");
    }

    static public void testBisextile( int an, Boolean r  )
    {
        System.out.print( an );
        Atester.testBoolean( isBisextile(an )  , r);
 
    }

    static public void testBoolean( Boolean a,  Boolean b )
    {
        if ( a!= null && b != null )
            System.out.println( String.format( "%s : %b == %b   ", a == b ? "OK" : "KO",  a, b   ));
        else if ( a == null && b != null  )
            System.out.println( String.format( "KO : null == %b   ", b   ));
        else if ( b == null && a != null  )
            System.out.println( String.format( "KO : %b == null   ", a   ));
        else
            System.out.println( "OK : null == null");
    }

    static public void testDoubleEq( Double a,  Double b )
    {
        if ( a!= null && b != null )
            System.out.println( String.format( "%s : %f == %f   ", a == b ? "OK" : "KO",  a, b   ));
        else if ( a == null && b != null  )
            System.out.println( String.format( "KO : null == %f   ", b   ));
        else if ( b == null && a != null  )
            System.out.println( String.format( "KO : %f == null   ", a   ));
        else
            System.out.println( "OK : null == null");
    }

    static public boolean isBisextileAI(int annee) {
        if (annee % 400 == 0) {
            return true;
        } else if (annee % 100 == 0) {
            return false;
        } else if (annee % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static public Double tarif(int age) {
        return 0.0;
    }

    static public boolean isBisextile(int annee) {
        return ((annee % 4 == 0) && (annee % 100 != 0)) || (annee % 400 == 0);
    }

} 


public class LesTestOne {
    public static void main( String[] args )
    {
        if ( Atester.calcul1( 3 ) == 15 )
            System.out.println( "OK" );

        if ( Atester.calcul1( 0 ) == 0 )
            System.out.println( "OK" );


        /* ******************************* */

        String n = null;
        Atester.testString( Atester.presentation( "toto" )  , "Toto" );
        Atester.testString( Atester.presentation( "TOTO" )  , "Toto" );
        Atester.testString( Atester.presentation( "t" )     , "T" );
        Atester.testString( Atester.presentation( n )    , null );
        Atester.testString( Atester.presentation( "" )  , "" );

        Atester.testBisextile( 1900   , false );
        Atester.testBisextile( 2068   , true );
        Atester.testBisextile( 2488   , true );
        Atester.testBisextile( 2600   , false );
        Atester.testBisextile( 1983   , false );
        Atester.testBisextile( 1982   , false );
        Atester.testBisextile( 1981   , false );
        Atester.testBisextile( 2020   , true );


        /*
         * inf      à 12 a -> 4€
         * inf      à 60 a -> 5.5€
         * sup ega  à 60 a -> 4.5€
         */

        Atester.testDoubleEq( Atester.tarif( 41 ) ) , 5.5 );



   }    
}