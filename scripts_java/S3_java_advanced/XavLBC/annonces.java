package scripts_java.S3_java_advanced.XavLBC;

class annonces {
    String titre;
    String detail;
    String prix;
    String typeAnnonce;
    
    public annonces(String titre,String detail,String prix){
        this.titre=titre;
        this.detail=detail;
        this.prix=prix;
    }    

    public void showAnnonce(){
        System.out.println(String.format("%s \n\n Prix: %s\n\nDetail annonce:\n%s",titre,prix,detail));
    }

}
