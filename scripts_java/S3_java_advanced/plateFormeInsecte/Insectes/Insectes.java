package scripts_java.S3_java_advanced.plateFormeInsecte.Insectes;
import scripts_java.S3_java_advanced.plateFormeInsecte.Locus.Locus;

public class Insectes {
    String especeIsecte;
    String nomInsecte;
    public Insectes(String especeInsecte,String nomInsecte){
        this.especeIsecte=especeInsecte;
        this.nomInsecte=nomInsecte;
    }

    public void showSpec(){
        System.out.println(String.format("Insecte: %s\nNom Insecte:%s\n\n", especeIsecte, nomInsecte));
    }

}
