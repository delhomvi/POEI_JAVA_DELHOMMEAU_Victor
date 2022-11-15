package scripts_java.S3_java_advanced.plateFormeInsecte.Mamiferes;

public class Mamifere {
    String especeMamif;
    String nomMamif;
    public Mamifere(String espece,String nom){
        this.especeMamif=espece;
        this.nomMamif=nom;
    }

    public void showSpec(){
        System.out.println(String.format("Mamifere: %s\nNom Mamifere:%s\n\n", especeMamif, nomMamif));
    }
}
