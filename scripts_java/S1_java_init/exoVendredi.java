package scripts_java.S1_java_init;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * 
 *  Exo par Victor DELHOMMEAU
 *  POEI JAVA Sogeti
 * 
 */


public class exoVendredi {

    static ArrayList<String> paysList =  new ArrayList<String>(Arrays.asList("espagne"));
    public static void main(String[] args) {
        // listesReprise();
        // conditionsReprise();
        //conditionsExoOne("toto",5); // Va test les erreurs
        //conditionsExoOne("toto",1); // Va test la non presence
        //conditionsExoOne("titi",0); // Va test le succès
        //distribBonbon(25);

        // Initialisation du scan
        Scanner scan= new Scanner(System.in);
        jeuChiffre(scan, 5,1,10);
        scan.close();
    }

    
    // Opérateurs mathématique
    static void distribBonbon(int totalBonbon){
        String[] nomsBonbon = {"titi","tata","toto","tutu"};
        int resteBonbon=totalBonbon;
        for(int i=0 ; i<totalBonbon;i++){
            resteBonbon-=i%nomsBonbon.length;
            System.out.println(String.format("Je donne un bonbon a %s, il en reste au total %d", nomsBonbon[i%nomsBonbon.length],resteBonbon));
            if(resteBonbon<=0){break;}
        }
    }   
    
    // Reprise des conditions
    // ----------------------
    static void conditionsReprise(){
        String nom= "toto".toLowerCase();
        int age = 12;
        String messageToDisplay =nom;
        if(age>=18){messageToDisplay+=" est majeur";}
        else{
            messageToDisplay+=" est mineur";
            if(age>12 && nom!="toto"){messageToDisplay+=" et va à la grande école";} 
            if(age<=12 && nom!="toto"){messageToDisplay+=" et va à la petite école";}
            else{messageToDisplay+=" et va dans les champs";}
        }
        System.out.println(messageToDisplay);
    
    }

    static void conditionsExoOne(String nameToFind,int positionToVerif){
        String[] nameList = {"titi","tata","toto"};
        try {
            if(positionToVerif<nameList.length && nameList[positionToVerif]==nameToFind){System.out.println(String.format("Le nom %s est à la position %d dans la liste",nameList[positionToVerif], positionToVerif));}
            else{System.out.println(String.format("Le nom %s n'est pas à la position %d dans la liste",nameList[positionToVerif], positionToVerif));} 
        }catch (Exception e) {
            System.out.println("Erreur dans l'appel de la fonction.");
        }
    }

    // Reprise des listes
    // ------------------
    static void listesReprise(){
        paysList.add("italie");
        paysList.add("monaco");
        paysList.add("andore");
        paysList.add("vatican");
        paysList.add("lecheinstein");
        paysList.add("san marin");
        int nbrElem = paysList.size();
        for(int i=0 ; i<nbrElem ; i++){
            System.out.println(paysList.get(i));
        }
        System.out.println("------------------");
        for(String pays : paysList){
            System.out.println(pays);
        }
        System.out.println("------------------");
        int position = paysList.indexOf("andore");
        paysList.remove(position);
        paysList.remove("italie");
        System.out.println(paysList);
    }

    // Jeu chiffre
    // -----------

    static HashMap<String,Integer> resultatsMap = new HashMap<String,Integer>();

    static void jeuChiffre(Scanner scan, int tentatives,int startArr,int enArr){
        

        // Initialisation de l'interface
        System.out.println("\n--------------------------------\nJeu des chiffres\n--------------------------------\n");
        
        // Définition du nombre random
        int randomNumber = ThreadLocalRandom.current().nextInt(startArr,enArr+1);
        
        // Initialisation des variables utiles
        Boolean continuePlaying = true ;
        while(continuePlaying==true && tentatives>=0){  
            int userInput= intUserInput(scan,"Entre ton guess:\n>");  
            if(userInput==randomNumber){
                System.out.println("Tu as gagné en "+tentatives+" tentatives, le nombre gagnant était: "+randomNumber);
                continuePlaying=false;
            }else{ 
                if(userInput>randomNumber){System.out.println("Nombre trop grand, tentatives restantes: "+tentatives);}
                else{System.out.println("Nombre trop petit, tentatives restantes: "+tentatives);}
                tentatives-=1;
                if(tentatives==0){
                    System.out.println("Perdu");
                }
            }
        
        }  
        String userInputName= strUserInput(scan,"\n\nEntre ton nom:\n>");  
        addToLeaderBoard(userInputName,tentatives);
        showLeaderBoard();        
    }


    static int intUserInput(Scanner scan, String message){
        System.out.println(message);
        int intInput = 0;
        try {
            intInput += scan.nextInt();
        } catch (Exception e) {
            System.out.println("Erreur sur l'input");
            intUserInput(scan,message);
        }
        if(intInput<=0){System.out.println("Nombre négatif, erreur");intUserInput(scan,message);}
        return intInput;
    }

    static String strUserInput(Scanner scan, String message){
        System.out.println(message);
        String strInput ="";
        try {
            strInput += scan.nextLine();
        } catch (Exception e) {
            System.out.println("Erreur sur l'input");
            strUserInput(scan,message);
        }
        return strInput;
    }
    
    static void addToLeaderBoard(String nom, int tentatives){
        resultatsMap.put(nom,tentatives);
    }
    
    static void showLeaderBoard(){
        System.out.println("\n\n--------------------------------");
        System.out.println("Leader Board du jeu des chiffres");
        System.out.println("--------------------------------\n\n");
        System.out.println(String.format("joueurs | tentatives" ));
        for (Map.Entry<String, Integer> set : resultatsMap.entrySet()) {
            System.out.println(String.format("%s | %d",set.getKey(),set.getValue()));
        }
    }
}
