package scripts_java.S3_java_advanced.XavLBC;

class auto extends annonces{
    String typeAuto;
    String km;
    public auto(String titre,String detail,String prix,String typeAuto,String km){
        super(titre, detail, prix);
        this.typeAuto=typeAuto;
        this.km=km;
        this.typeAnnonce="auto";
    }    

    public void showAnnonce(){
        System.out.println(String.format("%s \n\n Prix: %s\n\nType de voiture: %s\n\nKilométrage: %s\n\n Detail annonce:\n%s",titre,prix,typeAuto,km,detail));
    }
}
