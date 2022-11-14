package scripts_java.S3_java_advanced.magasinOnline;

class class_articles {
    String nom;
    String prix;
    String details;
    public class_articles(String nom,String prix,String details){
        this.nom=nom;
        this.prix=prix;
        this.details=details;
    }
    @Override
    public String toString() {
        return "class_articles [nom=" + nom + ", prix=" + prix + ", details=" + details + "]";
    }

    
}
