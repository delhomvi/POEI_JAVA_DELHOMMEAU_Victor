package scripts_java.S3_java_advanced.magasinOnline;

class class_articles_auto extends class_articles{
    String km;
    public class_articles_auto(String nom,String prix,String details,String km){
        super(nom, prix, details);
        this.km=km;
    }
    @Override
    public String toString() {
        return "class_articles_auto [km=" + km + "]";
    }    
}
