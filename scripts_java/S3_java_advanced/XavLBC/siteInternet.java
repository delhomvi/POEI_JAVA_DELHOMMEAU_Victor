package scripts_java.S3_java_advanced.XavLBC;
import java.util.ArrayList;

class siteInternet {
    String nom;
    String detail;
    ArrayList<annonces> annoncesList;
    public siteInternet(String nom,String detail){
        this.nom=nom;
        this.detail=detail;
    }    

    public void addAnnonces(annonces a){
        annoncesList.add(a);
    }

    public void showAnnonces(){
        for(annonces a : annoncesList){
            a.showAnnonce();
            System.out.println("-----------------------");
        }
    }
}
