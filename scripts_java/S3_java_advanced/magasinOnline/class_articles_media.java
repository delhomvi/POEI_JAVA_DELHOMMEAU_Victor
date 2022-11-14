package scripts_java.S3_java_advanced.magasinOnline;

class class_articles_media extends class_articles{
    String typeMedia;
    public class_articles_media(String nom,String prix,String details,String type){
        super(nom, prix, details);
        this.typeMedia=type;
    }
    @Override
    public String toString() {
        return "class_articles_media [typeMedia=" + typeMedia + "]";
    }    
}