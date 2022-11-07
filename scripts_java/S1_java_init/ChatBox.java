package scripts_java.S1_java_init;
import java.util.*;
public class ChatBox {
    public static void main(String[] args) {
        // Interaction avec le joueur
        Scanner scan= new Scanner(System.in);    //System.in is a standard input stream  
        System.out.print("\n\nEntre ton nom:");  
        String userInput= scan.nextLine();  
        scan.close();

        // Chaine de caractères à afficher dans la chatbox
        String str = "Bonjour "+userInput+"!\ncomment vas-tu aujourd'hui?";
        // initie les arguments nécéssaires à l'affichage dans la chatbox
        int strLength=0;
        List<String> myList = new ArrayList<String>(Arrays.asList(str.split("\n")));
        //Map<List<String>, Integer> result = new HashMap<>();


        // Va check la taille max de la largeur de la box
        for(String charac : myList){
            int lengthCache = charac.length();
            if(lengthCache>=strLength){
                strLength=lengthCache;
            }
        }
        
        // Affiche la chatbox
        chatBox(myList, strLength);
    }


    public static void chatBox(List<String> msgList, int msgLength){  
        // initie les paramètres de la chatbox
        int larg=msgLength+4; // choix de +4 ici pour un espace de 2 de chaques côtes
        int mid=2; // Ligne à laquelle on commence à écrire l'argument
        int haut=4; // Total des marges hautes et basses 
        String linestring=""; // Lignes à afficher dans le terminal
        
        // Loop d'affichage de la box
        for(int y=0;y<haut;y++){   

            // Affichage des coins de la box
            for(int x=0;x<larg;x++){
            if(x==0 & y==0 | x==0 & y==haut-1| x==larg-1 & y==0| x==larg-1 & y==haut-1){
                linestring+="+";
            }
            
            // Affichage des côtés gauche et droite de la box
            else if(x==0 & y!=0 & y!=mid| x==larg-1 & y!=haut-1 & y!=mid){
                linestring+="|";
            }

            // Affichage des côtés haut et bas de la boite
            else if(x!=0 & y==0 | x!=larg-1 & y==haut-1){
                linestring+="-";
            }

            // Affichage du message
            else if(y==mid){
                for(String msg : msgList){
                    String msgCache=msg;
                    while(msgCache.length()<=msgLength){
                        msgCache+=" ";
                    }
                    linestring+="| "+msgCache+"|\n";
                }
                String spaceString="";
                for(int j=0;j<msgLength+2;j++){
                    spaceString+=" ";
                }    
                linestring+="|"+spaceString+"|";
                break;
            }

            // remplissage du vide
            else{
                linestring+=" ";
            }
            }

            // Saut de ligne à chaque itération
            linestring+="\n";
        }

        // Affiche les resultats
        System.out.println(linestring);
    }
}
