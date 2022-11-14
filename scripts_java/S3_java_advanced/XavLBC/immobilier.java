package scripts_java.S3_java_advanced.XavLBC;

class immobilier extends annonces{
    String typeBien;
    String surface;
    public immobilier(String titre,String detail,String prix,String typeBien,String surface){
        super(titre, detail, prix);
        this.typeBien=typeBien;
        this.surface=surface;
        this.typeAnnonce="immo";
    }    

    public void showAnnonce(){
        System.out.println(String.format("%s \n\n Prix: %s\n\nType de bien: %s\n\nSurface: %s\n\n Detail annonce:\n%s",titre,prix,typeBien,surface,detail));
    }
}
