package scripts_java.S2_java_poo;

class Animaux{
    String nom;
    String specie;
    String food;
    String whatDooing;
    
    public Animaux (String nom,String specie,String food,String whatDooing){
        this.nom=nom;
        this.specie=specie;
        this.food=food;
        this.whatDooing=whatDooing;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setSpecie(String specie) {
        this.specie = specie;
    }
    public void setFood(String food) {
        this.food = food;
    }
    public void setWhatDooing(String whatDooing) {
        this.whatDooing = whatDooing;
    }

    public String getNom() {
        return nom;
    }
    public String getSpecie() {
        return specie;
    }
    public String getFood() {
        return food;
    }
    public String getWhatDooing() {
        return whatDooing;
    }
}

class Poule extends Animaux{
    public Poule(String nom,String whatDooing){
        super(nom, "ovipare", "graines", whatDooing);
    }

    public void speak(){
        System.out.println(String.format("Cotcotcot, je suis la poule %s, je mange de/des %s, je suis de la famille des %s et j'aime bien faire de/des %s",this.nom,this.food,this.specie,this.whatDooing));
    }
}

class Vache extends Animaux{
    public Vache(String nom,String whatDooing){
        super(nom, "bovin", "herbe", whatDooing);
    }

    public void speak(){
        System.out.println(String.format("Meuh, je suis la vache %s, je mange de/des %s, je suis de la famille des %s et j'aime bien faire de/des %s",this.nom,this.food,this.specie,this.whatDooing));
    }

}

class Cochon extends Animaux{
    public Cochon(String nom,String whatDooing){
        super(nom, "porcin", "tout", whatDooing);
    }

    public void speak(){
        System.out.println(String.format("Gruick, je suis le cochon %s, je mange de/des %s, je suis de la famille des %s et j'aime bien faire de/des %s",this.nom,this.food,this.specie,this.whatDooing));
    }
}



public class POO_JAVA_Ferme {
    public static void main(String[] args) {
        Poule p1 = new Poule("Cocote","courir dans la grange");
        Poule p2 = new Poule("Margotte","dormir");
        Poule p3 = new Poule("Cracotte","pondre");
        
        Vache v1 = new Vache("Marguerite","regarder le train");
        Vache v2 = new Vache("Brigitte","s'allonger sur l'herbe");
        
        Cochon c1 = new Cochon("Porcinet","Manger");
        Cochon c2 = new Cochon("Vianet","Se rouler dans la boue");
        
        p1.speak();
        p2.speak();
        p3.speak();
        v1.speak();
        v2.speak();
        c1.speak();
        c2.speak();
        

    }
}
