import java.util.*;
import delhomvi.Initiation.Surface;
import java.io.*;




/*
 * 
 *  Support de cours de DELHOMMEAU Victor
 *  L'objectif de ce support est de me donner un fichier "générique" retraçant tout ce qu'on a pu avoir l'occasion de voir/tester
 *  Test dans github
 */



public class SupportCours{
// Programme encapsulée dans une classe
// Une classe commence toujours par une majuscule

    public static Integer varPublicAccessibleEnDehors = 0; // on pourra acceder à cette variable en dehors de la classe via [ou est situé la classe].nomClasse.nomVar


    public static void main(String[] args){ // Un programme commence forcément par un main, c'est le point d'entrée dans le programme
        // ------------------------------------------------------------------------------------------------------------------------- Les variables
        // Types de variables: entier/String/double ... La majuscule indique que la variable est considerée comme un objet
        Integer entier      =   5                   ;
        Float floater       =   10.05f              ;
        String chaineCarac  =   "Titi, toto, tata"  ;
        String[] listeDeString = {"1","2","3"}      ; // Les liste ne sont pas dynamique, elles ont un nombre d'éléments fixe
        //Double[] listeDeDouble = {1.0,2.0,3.0}      ;
        //ArrayList<String> ArrayDyna = new ArrayList<>()  ; // A la différence des listes les arrays sont dynamique, leur taille peut varier
        HashMap<String, String> sportDict = new HashMap<String, String>() {
            {
                put("toto", "badmindton");
                put("tata", "piscine");
                put("samir", "foot");
            }
        }; // Les hashmap

        // ------------------------------------------------------------------------------------------------------------------------- Intéragir avec le terminal
        // Afficher des données dans un terminal
        System.out.println(chaineCarac+" avec "+entier+" puis "+floater);

        // Demander des choses à l'utilisateur
        Scanner scan= new Scanner(System.in);  
        System.out.print("Entre ton nom:");  
        String userInput= scan.nextLine();  
        System.out.println("Bonjour "+userInput+", comment vas-tu ?");
        scan.close();



        // ------------------------------------------------------------------------------------------------------------------------- Les boucles
        // Pour les boucles if la convention est if( start, valeur max; pas d'ajouts)
        for(int i=0 ; i<10 ; i++){
            System.out.println("Indice "+i);
        }

        // Les boucles sur des éléments de liste
        for(String elem : listeDeString){
            System.out.println(elem);
        }

        // ------------------------------------------------------------------------------------------------------------------------- Les conditions
        // "||"" dans une conditions est le "or" et "&&"" est les "and", si plusieurs conditions sont nécéssaires ajouter
        // "^^" est le xor, cest a dire ou exclusif, donc soir a soit b pas les deux
        // "else if..."
        if(entier>5 | entier<5){
            System.out.println("L'entier n'est ni supérieur, ni inférieur strictement à 5");
        }else{
            System.out.println("L'entier est donc égal à 5");
        }

        // Les cases
        String nom = "toto";
        String sport ="";
        switch(nom){
            default : sport = "rien"; break;
            case "toto" : sport = "badmindton"; break;
            case "tata" : sport = "piscine"; break;
            case "samir" : sport = "foot"; break;
        }

        // ------------------------------------------------------------------------------------------------------------------------- Intéragir avec des fonctions
        // On les définis en dehors de la fonction main d'une certaine façon
        fonctionExterne();

        // Appeler des fonctions issues d'autres classes
        int larg = 5;
        int longu= 6;
        System.out.println("Surface du rectangle de "+Surface.surfaceRect(larg, longu)+" cm2"); // on appele en general une fonction via nomDuFichier.nomDeLaFonctionPublic

        // ------------------------------------------------------------------------------------------------------------------------- Intéraction avec des variables
        // Intéragir avec des chaines de caractères
        List<String> myList = new ArrayList<String>(Arrays.asList(chaineCarac.split(","))); // Split dans une liste au niveau des "," la chaine de caractères
        System.out.println(myList);

        // Mettre en majuscule une chaine de caractères
        String chaineMaj = chaineCarac.toUpperCase();
        System.out.println(chaineMaj);

        // Intéragir avec des listes
        for(String elemListe : listeDeString){
            System.out.println(elemListe);
        }
        listeDeString[0]="elem 1";
        listeDeString[1]="elem 2";
        listeDeString[2]="elem 3";
        System.out.println(listeDeString);
        System.out.println(listeDeString.length);// Taille de la liste

        // Intéragir avec des éléments d'arrays
        List<Object> pdt = new ArrayList<Object>(); // Prend des objets comme éléments ( tout ce qui commence par une maj dans les variables en gros )
        List<String> pdtStr = new ArrayList<>();
        int pdtInt=5;
        pdtStr.add("Pomme");
        pdtStr.add("de");
        pdtStr.add("terre");
        pdt.add(pdtStr);
        pdt.add(pdtInt);
        int indexPomme = pdt.indexOf("Pomme de Terre");
        pdt.remove(0); // supprime un élément à l'index donné ou l'element
        System.out.println(pdt);
        System.out.println(pdt.get(0)); // Va chercher un élément de l'array
        System.out.println(pdtStr.size()); // Taille d'un array/objet


        // Division des strings
        String newStrVar = chaineCarac.substring(0,5); // Fonction qui va diviser entre un start et un end une chaine de caractère
        System.out.println(newStrVar);
        
        // Formatage des strings (voir des tableaux recap en ligne pour les types de format)
        String stringFormat=String.format("Valeur de %1.4f avec les articles %s",32.33434, "pomme de terre");
        System.out.println(stringFormat);

        // Forcer la conversion d'une variable en une autre
        // Code ascii
        for(int j=0; j<chaineCarac.length(); j++){
            char elemChar = chaineCarac.charAt(j); 
            int codeAscii = (int)elemChar;
            System.out.println("Le code ascii de "+elemChar+" est :"+codeAscii);

        }

        // Str vers in
        String v1s = "10";
        String v2s = "3";
        Integer v1i = Integer.parseInt(v1s); // convertit str en int
        Integer v2i = Integer.parseInt(v2s);
        System.out.println(v1s+v2s);
        System.out.println(v1i+v2i);

        // Str vers double
        System.out.println(Double.parseDouble(v2s));
        
        // Aller chercher des éléments dans les maps
        String Sport = sportDict.get("toto");
        //String keySport = sportDict.keySet("foot");
        // .containsKey/value (...)


        // ------------------------------------------------------------------------------------------------------------------------- Sorties de codes
        // Ecrire dans les fichiers, exemple du ticket de caisse
        String[] articles = {"Pomme","Poire","Mandarinnes"};
        double[] prix = {1.50,1.20,18.2};
        double[] qtes = {0.52,0.88,0.60};
        String toWrite = "";
        
        String stringFormatTwoo=String.format("| %15s | %5.10s | %5.10s | %5.10s |\n","article","prix","quantite","total");
        toWrite+=stringFormatTwoo;
        int totalCost=0;
        for(int index = 0 ; index<articles.length; index++){
            String stringFormatTwo=String.format("| %15s | %5.2f | %8.2f | %5.2f |\n",articles[index],prix[index],qtes[index],prix[index]*qtes[index]);
            totalCost+=prix[index]*qtes[index];
            toWrite+=stringFormatTwo;
        }
        toWrite+="Total a payer: "+totalCost+"euro(s)";
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(toWrite);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

        
        // Les opérateurs mathématiques
        /*
         *  +
         *  - 
         *  /
         *  *
         *  % modulo, reste de la division
         *  ! not
         *  
         *  & and
         *  | or
         *  ^ xor (condition a ou b exclusivement)
         * 
         *  >> décallage des bits vers la droite
         *  << vers la gauche
         *  >>> decallage des bits vers la droite sans impacter le signe
        */


    }


    // Fonction externe
    // on met private car la fonction ne sera pas accessibles dans une autre classe
    private static void fonctionExterne() {
        System.out.println("Fonction externe au main");
    }
}
