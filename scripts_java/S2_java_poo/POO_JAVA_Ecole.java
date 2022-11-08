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

    // Constructeur
    public Usagers(String n,String pn,String adr,String c,Integer a ){
        this.nom=n;
        this.prenom=pn;
        this.age=a;
        this.adresse=adr;
        this.contact=c;
    }
    

}

// Eleves -------------------------------------------------
class Eleves extends Usagers{
    String classe="indefinis";
    Double moyenne=0.0;

    // getters et setters
    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }

    // Constructeurs
    public Eleves(String n,String pn,String adr,String c,Integer a ,String classe){
        super(n, pn, adr, c, a);
        this.classe=classe;
        this.fonction="Eleves";

    }

    
}


// Salariés -------------------------------------------------
class Salaries extends Usagers{
    String whatDoing = "indefinis";
    
    // Getter et setter
    public String getFonction() {
        return fonction;
    }
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    
    // Constructeur
    public Salaries(String n,String pn,String adr,String c,Integer a){
        super(n, pn, adr, c, a);
    }
    
    // Autres fonctions
    public void whatDo(){
        System.out.println(String.format("La fonction %s est chargée de la tache suivante: %s",this.fonction,this.whatDoing));
    }
}

class Enseignants extends Salaries{
    // Constructeur
    public Enseignants(String n,String pn,String adr,String c,Integer a ){
        super(n, pn, adr, c, a);
        this.fonction="Enseignant";
        this.whatDoing="Enseigner les bases aux eleves";
    }

    
}

class Surveillants extends Salaries{
    // Constructeur
    public Surveillants(String n,String pn,String adr,String c,Integer a ){
        super(n, pn, adr, c, a);
        this.fonction="Surveillants";
        this.whatDoing="Surveiller les eleves";
    }
}

class Secretaires extends Salaries{
    // Constructeur
    public Secretaires(String n,String pn,String adr,String c,Integer a ){
        super(n, pn, adr, c, a);
        this.fonction="Secretaires";
        this.whatDoing="Effectuer des taches administratives";
    }
}

class Bibliothequaire extends Salaries{
    // Constructeur
    public Bibliothequaire(String n,String pn,String adr,String c,Integer a ){
        super(n, pn, adr, c, a);
        this.fonction="Bibliothequaire";
        this.whatDoing="Gerer la bibliothèque";
    }
}

class Cuisinier extends Salaries{
    // Constructeur
    public Cuisinier(String n,String pn,String adr,String c,Integer a ){
        super(n, pn, adr, c, a);
        this.fonction="Cuisinier";
        this.whatDoing="Preparer les repas";
    }
}

// Main -------------------------------------------------
public class POO_JAVA_Ecole {
    static ArrayList<Usagers> Personnels = new ArrayList<>()  ;
    public static void main(String[] args){
        // Remplissage de Personnels
        Personnels.add(new Eleves("Durand", "Toto", "Pas loins de l'école", "Tel de ses parents", 10, "CP"));
        Personnels.add(new Eleves("Dutrou", "Tata", "Pas loins de l'école", "Tel de ses parents", 10, "CP"));
        Personnels.add(new Eleves("Dutranoix", "Tete", "Pas loins de l'école", "Tel de ses parents", 10, "CP"));
        Personnels.add(new Eleves("Dutronc", "Titi", "Pas loins de l'école", "Tel de ses parents", 10, "CP"));
        Personnels.add(new Eleves("Durondal", "Tutu", "Pas loins de l'école", "Tel de ses parents", 10, "CP"));
        Personnels.add(new Enseignants("Rondeau", "Stephane", "Un peu loins de l'école", "Telephone de sa maison", 55));
        Personnels.add(new Enseignants("Rondu", "Irma", "Un peu loins de l'école", "Telephone de sa maison", 57));
        Personnels.add(new Surveillants("Sadhi", "Salim", "Un peu loins de l'école", "Telephone de sa maison", 58));
        Personnels.add(new Secretaires("Secrets", "Victoria", "Un peu loins de l'école", "Telephone de sa maison", 59));
        Personnels.add(new Bibliothequaire("Biblots", "Eleonore", "Un peu loins de l'école", "Telephone de sa maison", 54));
        Personnels.add(new Cuisinier("Cuiseur", "Eric", "Un peu loins de l'école", "Telephone de sa maison", 40));
        
        // Affichage des resultats
        System.out.println("------------------");
        for(Usagers e:Personnels){
            System.out.println(String.format("%s %s a pour fonction %s",e.nom,e.prenom,e.fonction));
        }


    }


}
