package scripts_java.S3_java_advanced.magasinOnline;
import java.util.ArrayList;


class magasin{
    String nom;
    String adresse;
    String SIRET;
    ArrayList<class_rayon> rayonsliste;
    public magasin(String nom,String SIRET,String adresse){
        this.nom=nom;
        this.SIRET=SIRET;
        this.adresse=adresse;
    }

    public void addRayons(class_rayon rayon){
        rayonsliste.add(rayon);
    }

}

public class magasinOnline {
    public static void main(String[] args){
        magasin LBC = new magasin("Le Bon Coin", "0002111524564564", "Internet");
        class_rayon r1 = new class_rayon("Auto");
        r1.toString();
        class_articles_auto twingo = new class_articles_auto("Vends twingo jaune, très peu utilisée","10.0€","Vends jolie twingo jaune, presque neuve, un peu ville mais fonctionne corectement ***anonce pas du tout frauduleuse***","1500000");
        twingo.toString();
    }
}
