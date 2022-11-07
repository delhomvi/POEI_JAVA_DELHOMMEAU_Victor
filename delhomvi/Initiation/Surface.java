package delhomvi.Initiation;
public class Surface {

    public static double surfaceRect( double lar, double longueur )
    {
        return lar * longueur;
    }

    public static double surfaceCarre( double cot)
    {
        return cot*cot;
    }

    public static double surfaceCercle( double ray)
    {
        return Math.PI*ray*ray;
    }
   public static void main( String[] args )
    {
        //System.out.println( args[0]  );
        System.out.println("L'aire du rectangle est de " + surfaceRect( 5, 8 ) + "cm2");
        System.out.println("L'aire du carré est de " +  surfaceCarre( 7 ) + "cm2" );
        System.out.println("L'aire du cercle est de " +  surfaceCercle( 7.5 ) + "cm2" );
    }    
}
