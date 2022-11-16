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

class Ferme{
    String nom,whatInside;
    public Ferme(String nom,String whatInside){
        this.nom=nom;
        this.whatInside=whatInside;
    }

    public void composedOf(){
        System.out.println(String.format("Le/La %s est composée de %s",this.nom,this.whatInside));
    }
}

class Poulailler extends Ferme{
    Poule p1,p2,p3;
    public Poulailler(){
        super("poulailler", "poule");
        this.p1 = new Poule("Cocote","courir dans la grange");
        this.p2 = new Poule("Margotte","dormir");
        this.p3 = new Poule("Cracotte","pondre");
    }
    public void whosInside(){
        composedOf();
        p1.speak();
        p2.speak();
        p3.speak();
    }
}

class Champs extends Ferme{
    Vache v1,v2;
    public Champs(){
        super("Champs", "vache");
        this.v1 = new Vache("Marguerite","regarder le train");
        this.v2 = new Vache("Brigitte","s'allonger sur l'herbe");
    }

    public void whosInside(){
        composedOf();
        v1.speak();
        v2.speak();
    }
}

class Porcherie extends Ferme{
    Cochon c1,c2;
    public Porcherie(){
        super("Porcherie", "cochon");
        this.c1 = new Cochon("Porcinet","Manger");
        this.c2 = new Cochon("Vianet","Se rouler dans la boue");
    }

    public void whosInside(){
        composedOf();
        c1.speak();
        c2.speak();
    }
}

class runFerme{
    public runFerme(){
        Poulailler p1 = new Poulailler();
        Champs c1 = new Champs();
        Porcherie pp1 = new Porcherie();
        System.out.println("--------------");
        p1.whosInside();
        System.out.println("--------------");
        c1.whosInside();
        System.out.println("--------------");
        pp1.whosInside();
    }
}
public class POO_JAVA_Ferme {
    public static void main(String[] args) {
        //runFerme rf =new runFerme();
    }

}
