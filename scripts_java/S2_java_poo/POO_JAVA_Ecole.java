package scripts_java.S2_java_poo;
import java.util.ArrayList;

/*
 * 
 * Scripts qui ressence les personnes d'une école
 * elèves comme enseignant le but est de comprendre
 * la programatiuon orientée objet
 * 
*/


// Usagers -------------------------------------------------
class Usagers{
    String nom="indefini";
    String prenom="indefini";
    Integer age=0;
    String adresse="indefini";
    String contact="indefinis";
    String fonction = "indefinis";
    String Horraires = "indefinis";

    // Getters et setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public String getFonction() {
        return fonction;
    }
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getHorraires() {
        return Horraires;
    }
    public void setHorraires(String horraires) {
        Horraires = horraires;
    }

    // Constructeur
    public Usagers(String n,String pn,String adr,String c,Integer a, String Hor){
        this.nom=n;
        this.prenom=pn;
        this.age=a;
        this.adresse=adr;
        this.contact=c;
        this.Horraires=Hor;
    }
    

}

// Eleves -------------------------------------------------
class Eleves extends Usagers{
    Double moyenne=0.0;

    // getters et setters
    public Double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }

    // Constructeurs
    public Eleves(String n,String pn,String adr,String c,Integer a, String Hor){
        super(n, pn, adr, c, a,Hor);
        this.fonction="Eleves";

    }

    
}

// Salariés -------------------------------------------------
class Salaries extends Usagers{
    String whatDoing = "indefinis";
    Double Salaire =0.0;
    String statut ="indefinis";
    
    // Getter et setter
    public String getWhatDoing() {
        return whatDoing;
    }
    public void setWhatDoing(String whatDoing) {
        this.whatDoing = whatDoing;
    }
    public Double getSalaire() {
        return Salaire;
    }
    public void setSalaire(Double salaire) {
        Salaire = salaire;
    }
    
    // Constructeur
    public Salaries(String n,String pn,String adr,String c,Integer a, String Hor){
        super(n, pn, adr, c, a, Hor);
    }
    
    // Autres fonctions
    public void whatDo(){
        System.out.println(String.format("La fonction %s est chargée de la tache suivante: %s",this.fonction,this.whatDoing));
    }
}

class Administratif extends Salaries{
    public Administratif(String n,String pn,String adr,String c,Integer a, String Hor){
        super(n, pn, adr, c, a, Hor);
        this.statut="Administratif";
    }
}

class Contractuel extends Salaries{
    public Contractuel(String n,String pn,String adr,String c,Integer a, String Hor){
        super(n, pn, adr, c, a, Hor);
        this.statut="Contractuel";
}
}

class Enseignant_stat extends Salaries{
    public Enseignant_stat(String n,String pn,String adr,String c,Integer a, String Hor){
        super(n, pn, adr, c, a, Hor);
        this.statut="Contractuel";
}
}

class Enseignants extends Enseignant_stat{
    // Constructeur
    public Enseignants(String n,String pn,String adr,String c,Integer a,String Hor ){
        super(n, pn, adr, c, a,Hor);
        this.fonction="Enseignant";
        this.whatDoing="Enseigner les bases aux eleves";
        this.Salaire=2000.0;
    }

    
}

class Surveillants extends Contractuel{
    // Constructeur
    public Surveillants(String n,String pn,String adr,String c,Integer a,String Hor){
        super(n, pn, adr, c, a,Hor);
        this.fonction="Surveillants";
        this.whatDoing="Surveiller les eleves";
        this.Salaire=1400.0;
    }
}

class Secretaires extends Administratif{
    // Constructeur
    public Secretaires(String n,String pn,String adr,String c,Integer a, String Hor){
        super(n, pn, adr, c, a,Hor);
        this.fonction="Secretaires";
        this.whatDoing="Effectuer des taches administratives";
        this.Salaire=1400.0;
    }
}

class Bibliothequaire extends Enseignant_stat{
    // Constructeur
    public Bibliothequaire(String n,String pn,String adr,String c,Integer a, String Hor){
        super(n, pn, adr, c, a,Hor);
        this.fonction="Bibliothequaire";
        this.whatDoing="Gerer la bibliothèque";
        this.Salaire=1400.0;
    }
}

class Cuisinier extends Contractuel{
    // Constructeur
    public Cuisinier(String n,String pn,String adr,String c,Integer a,String Hor){
        super(n, pn, adr, c, a,Hor);
        this.fonction="Cuisinier";
        this.whatDoing="Preparer les repas";
        this.Salaire=1400.0;
    }
}


// Benevoles -------------------------------------------------
class Benevoles extends Salaries{
    Benevoles(String n,String pn,String adr,String c,Integer a,String wd,String Hor){
        super(n, pn, adr, c, a,Hor);
        this.fonction="Benevole";
        this.whatDoing=wd;
    }
}


// Ecole -------------------------------------------------
class Ecole{
    // Initialisation de l'école
    ArrayList<Usagers> Personnels = new ArrayList<>()  ;
    ArrayList<Classes> ClassesList = new ArrayList<>()  ;
    String nom;
    String adresse;
    String Contact;
    
    // Constructeur
    public Ecole(String n,String a,String c){
        this.nom=n;
        this.adresse=a;
        this.Contact=c;
    }

    // Getetrs et setters
    public ArrayList<Usagers> getPersonnels() {
        return Personnels;
    }
    public void setPersonnels(ArrayList<Usagers> personnels) {
        Personnels = personnels;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getContact() {
        return Contact;
    }
    public void setContact(String contact) {
        Contact = contact;
    }
    
    // Autres fonctions
    public void addSecretaire(String n,String pn,String adr,String c,Integer a, String Hor){
        Personnels.add(new Secretaires(n,pn,adr,c,a ,Hor));
    }
    public void addCuisinier(String n,String pn,String adr,String c,Integer a, String Hor){
        Personnels.add(new Cuisinier(n,pn,adr,c,a,Hor));
    }
    public void addEnseignants(String n,String pn,String adr,String c,Integer a , String Hor){
        Personnels.add(new Enseignants(n,pn,adr,c,a,Hor));
    }
    public void addSurveillants(String n,String pn,String adr,String c,Integer a, String Hor){
        Personnels.add(new Surveillants(n,pn,adr,c,a ,Hor));
    }
    public void addBibliothequaire(String n,String pn,String adr,String c,Integer a, String Hor){
        Personnels.add(new Bibliothequaire(n,pn,adr,c,a ,Hor));
    }
    public void addBenevoles(String n,String pn,String adr,String c,Integer a, String wd, String Hor){
        Personnels.add(new Benevoles(n,pn,adr,c,a,wd,Hor));
    }
    public void addEleves(String n,String pn,String adr,String c,Integer a , String Hor){
        Personnels.add(new Eleves(n,pn,adr,c,a,Hor));
    }
    public void addClasse(String n,String lvl){
        ClassesList.add(new Classes(n,lvl));
    }

    // Faire l'appel du personnel
    public void appelDeLecole(){
        System.out.println("-----------------\nAppel du personnel de l'école:\n\n");
        for(Usagers e:Personnels){
            System.out.println(String.format("%s %s, Présent? Oui présent!", e.getPrenom(),e.getNom()));
        }
        System.out.println("-----------------\n\n");
    }
    public void appelByName(String nom,String prenom){
        System.out.println(String.format("-----------------\nAppel de %s %s:\n", nom,prenom));
        for(Usagers usa : Personnels){
            if (usa.getNom() == nom && usa.getPrenom()==prenom) {
                System.out.println(String.format("%s %s est present",nom,prenom));
                break;
            }
        }
        System.out.println("-----------------\n");
    }
    public Classes findClasse(String nom){
        Classes resClasse = new Classes("indefinis", "indefinis");
        for(Classes c:ClassesList){
            if(c.getNom()==nom){
                resClasse=c;
            }
        }
        return resClasse;
    }
}

// Classe
class Classes{
    // Initialisation de l'école
    ArrayList<Usagers> ElevesInClasse = new ArrayList<>()  ;
    String nom ;
    String niveau;
    // Constructeur
    public Classes(String nom, String niveau){
        this.nom=nom;
        this.niveau=niveau;
    }
    // Getters Setters
    public ArrayList<Usagers> getElevesInClasse() {
        return ElevesInClasse;
    }
    public void setElevesInClasse(ArrayList<Usagers> elevesInClasse) {
        ElevesInClasse = elevesInClasse;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNiveau() {
        return niveau;
    }
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    // Autres fonctions
    public void appelByName(String nom,String prenom){
        System.out.println(String.format("-----------------\nAppel de %s %s:\n", nom,prenom));
        for(Usagers usa : ElevesInClasse){
            if (usa.getNom() == nom && usa.getPrenom()==prenom) {
                System.out.println(String.format("%s %s est present",nom,prenom));
                break;
            }
        }
        System.out.println("-----------------\n");
        
    }
    public void addElevesToClasse(ArrayList<Usagers> Personnels,String nom,String prenom){
        for(Usagers usa : Personnels){
            if (usa.getNom() == nom && usa.getPrenom()==prenom) {
                ElevesInClasse.add(usa);
                break;
            }
        }
    }
    public void appelEleves(){
        System.out.println("-----------------\nAppel des eleves de la classe:\n\n");
        for(Usagers e:ElevesInClasse){
            System.out.println(String.format("%s %s, Présent? Oui présent!", e.getPrenom(),e.getNom()));
        }
        System.out.println("-----------------\n\n");
    }

}

// Main -------------------------------------------------
public class POO_JAVA_Ecole {
    public static void main(String[] args){
        
        // Initialise école
        Ecole jaures = new Ecole("Jaures","Genre pas loin de la gare","mél: ecole.scolaire@trou.fr");
        
        // Remplissage du Personnel et ded élèves
        jaures.addEnseignants("Rondeau", "Stephane", "Un peu loins de l'école", "Telephone de sa maison", 55,"8h-17h");
        jaures.addEnseignants("Rondu", "Irma", "Un peu loins de l'école", "Telephone de sa maison", 57,"8h-17h");
        jaures.addSurveillants("Sadhi", "Salim", "Un peu loins de l'école", "Telephone de sa maison", 58,"8h-17h");
        jaures.addSecretaire("Secrets", "Victoria", "Un peu loins de l'école", "Telephone de sa maison", 59,"8h-17h");
        jaures.addBibliothequaire("Biblots", "Eleonore", "Un peu loins de l'école", "Telephone de sa maison", 54,"8h-17h");
        jaures.addCuisinier("Cuiseur", "Eric", "Un peu loins de l'école", "Telephone de sa maison", 40,"8h-17h");
        jaures.addBenevoles("Bassi", "Benassi", "Proche de l'école", "Telephone de sa maison", 25,"Il s'occupe de l'entretiens informatique","8h-17h");
        jaures.addEleves("Durand", "Toto", "Pas loins de l'école", "Tel de ses parents", 10,"8h-17h");
        jaures.addEleves("Dutrou", "Tata", "Pas loins de l'école", "Tel de ses parents", 10,"8h-17h");
        jaures.addEleves("Dutranoix", "Tete", "Pas loins de l'école", "Tel de ses parents", 10,"8h-17h");
        jaures.addEleves("Dutronc", "Titi", "Pas loins de l'école", "Tel de ses parents", 10,"8h-17h");
        jaures.addEleves("Durondal", "Tutu", "Pas loins de l'école", "Tel de ses parents", 10,"8h-17h");

        // Appel du personnel !
        jaures.appelDeLecole();
        jaures.appelByName("Durand", "Toto");
        jaures.appelByName("Durond", "Cercle");

        // Ajouts des eleves à la classe
        System.out.println("---------------");
        jaures.addClasse("512", "5eme");
        jaures.findClasse("512").addElevesToClasse(jaures.Personnels, "Durand", "Toto");
        jaures.findClasse("512").addElevesToClasse(jaures.Personnels, "Dutrou", "Tata");
        jaures.findClasse("512").addElevesToClasse(jaures.Personnels, "Dutranoix", "Tete");
        jaures.findClasse("512").addElevesToClasse(jaures.Personnels, "Dutronc", "Titi");
        jaures.findClasse("512").addElevesToClasse(jaures.Personnels, "Durondal", "Tutu");
        jaures.findClasse("512").appelEleves();
        
    }


}
