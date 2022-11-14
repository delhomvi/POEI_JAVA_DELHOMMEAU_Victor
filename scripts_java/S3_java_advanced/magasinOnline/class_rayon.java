package scripts_java.S3_java_advanced.magasinOnline;
import java.util.ArrayList;
import java.util.Scanner;

class class_rayon {
    String Titre;
    ArrayList<class_articles> articles_list;
    String typearticle;
    
    public class_rayon(String nom){
        this.Titre=nom;
    }

    @Override
    public String toString() {
        return "class_rayon [Titre=" + Titre + ", articles_list=" + articles_list + ", typearticle=" + typearticle
                + "]";
    }

    public void addArticleDirect(class_articles article){
        articles_list.add(article);
    }

    

    public void addArticles(){
        Scanner scan= new Scanner(System.in);  
        
        System.out.print("Entre le type de l'annonce (immo/media/auto):\n");  
        String userInputType= scan.nextLine();
        
        System.out.print("titre anonce:\n>");  
        String userInputTitle= scan.nextLine();
        
        System.out.print("Details de l'anonce\n>");  
        String userInputDetails= scan.nextLine();
        
        System.out.print("Montant de l'anonce\n>");  
        String userInputPrice= scan.nextLine();
        
        if(userInputType.equals("immo")){
            articles_list.add(new class_articles_immo(userInputTitle,userInputPrice,userInputDetails));
        }
        else if(userInputType.equals("auto")){    
            System.out.print("kilométrage du véhicule\n>");  
            String userInputKm= scan.nextLine();
            articles_list.add(new class_articles_auto(userInputTitle,userInputPrice,userInputDetails,userInputKm));
        }
        else if(userInputType.equals("media")){
            System.out.print("Type de media\n>");  
            String userInputMediaType= scan.nextLine();
            articles_list.add(new class_articles_media(userInputTitle,userInputPrice,userInputDetails,userInputMediaType));
        }else{
            System.out.println("toto");
        }
    }
    
}
