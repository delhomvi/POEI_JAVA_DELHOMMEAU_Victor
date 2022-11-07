package scripts_java;
import java.util.ArrayList;

/*
 * 
 *  Exo par Victor DELHOMMEAU
 *  POEI JAVA Sogeti
 * 
 */


public class exoJeudi {
    public static void main(String[] args) {
        String prenom = "Gertrude";
        int age = 25;
        int numDeChance = numeroDeLaChance( prenom ); 
        ArrayList<String> preocupations=preoccupation( age );
        System.out.println( String.format( "Le numéro prédit par madame Irma pour %s est %d", prenom, numDeChance ));
        System.out.println(String.format( "Les préocupations prédites par madame Irma pour %s sont %s", prenom, preocupations ));
    }

    public static ArrayList<String> preoccupation( int age ){
        ArrayList<String> strPreeocupation = new ArrayList<>();
        if(age<12){strPreeocupation.add( "Ecole ");}
        if(age>=12 && age<20){strPreeocupation.add( "Trucs d'ado");}
        if(age>=20 && age<65){strPreeocupation.add("Travail");}
        if(age>=20 && age<30){strPreeocupation.add("Conjoint");}
        if(age>=20 && age<40){strPreeocupation.add("Enfants");}
        else{strPreeocupation.add("La retraite");}
        return strPreeocupation;
    }
    public static int numeroDeLaChance(  String  prenom ){
        prenom = prenom.toLowerCase();
        int resultat = 0;
        for( int i = 0 ; i < prenom.length() ; i++ ){
            int charactere  = prenom.charAt( i ) - (int)'a' + 1;  
            resultat += charactere;
        }
        return resultat % 50 ;
    } 

    static int convertStrToInt(String strVar){
        int resultat = 0;
        int multiplicateur = 1;
        for(int i = strVar.length()-1 ; i>=0;i--){
            char charVar = strVar.charAt(i);
            resultat  += ((int)charVar - (int)'0')*multiplicateur;
            multiplicateur*=10;
        }

        return resultat;
    }

    static String chaineToMaj(String chaineMin){
        String resultat = "";
        int offsetMAJ_MIN = (int)'a' - (int)'A';
        for(int i = 0; i<chaineMin.length();i++){
            char carac = chaineMin.charAt(i);
            int codeAscii = (int)carac;
            if((int)'a'<=codeAscii && codeAscii<=(int)'z'){
                int codeAsciiMAJ = codeAscii-offsetMAJ_MIN;
                resultat += (char)codeAsciiMAJ;
            }else{
                resultat+=carac;
            }
            
        }
        return resultat;
    }
}
