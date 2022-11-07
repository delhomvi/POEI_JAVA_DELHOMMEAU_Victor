/*
 * 
 *  Exo par Victor DELHOMMEAU
 *  POEI JAVA Sogeti
 * 
 */

import java.util.HashMap;


public class ConditionVictor {
    
    static HashMap<String, String> sportDict = new HashMap<String, String>() {
        {
            put("toto", "badmindton");
            put("tata", "piscine");
            put("samir", "foot");
        }
    };
    
    
    public static void main(String[] args) {
        String[] noms = {"toto","tata","samir","samuel"};
        for(String nom : noms){
            System.out.println(String.format("%s fais le sport suivant (via les cases) : %s", nom, quelSportFaitCase(nom)));
            System.out.println(String.format("%s fais le sport suivant (via les if) : %s", nom, quelSportFaitSimple(nom)));
            System.out.println(String.format("%s fais le sport suivant (via le dico) : %s", nom, quelSportFaitMap(nom)));
        }
    }

    static String quelSportFaitCase(String nom){
        switch(nom){
            default : return "rien";
            case "toto" : return "badmindton";
            case "tata" : return "piscine";
            case "samir" : return "foot";
        }
    }

    static String quelSportFaitSimple(String nom){
        String Sport ="";
        if(nom=="toto"){Sport="badmindton";}
        else if(nom=="tata"){Sport="piscine";}
        else if(nom=="samir"){Sport="foot";}
        else{Sport="rien";}
        return Sport;
    }

    static String quelSportFaitMap(String nom){
        return sportDict.get(nom);
    }
 
    

}
