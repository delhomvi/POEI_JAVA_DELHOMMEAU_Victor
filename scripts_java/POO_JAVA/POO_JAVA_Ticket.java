package scripts_java.POO_JAVA;

import java.util.ArrayList;
import java.util.List;

class Ligne
{
    String libel    ="" ;
    Double prix_unit=0.0;
    Double qte      =0.0;
    static Double totalPrice = 0.0;
    
    public Ligne(String nom, Double pu, Double qte){
        this.libel=nom;
        this.prix_unit=pu;
        this.qte=qte;
        totalPrice+=qte*pu;
    } 

    public void showLine(){
        System.out.println(String.format("%25s %8.2f %8.2f %8.2f",this.libel,this.prix_unit,this.qte,this.prix_unit*this.qte));
    }
}

public class POO_JAVA_Ticket {
    static List<Ligne> lignes = new ArrayList<>();
    
    public static void main(String[] args) {
        lignes.add(new Ligne("Romarin",1.0,1.5));
        lignes.add(new Ligne("Salami",1.0,1.5));
        lignes.add(new Ligne("Cordons Bleus",1.0,1.5));
        lignes.add(new Ligne("Saucisse de poulet",1.0,1.5));
        lignes.add(new Ligne("Boeuf",1.0,1.5));
        lignes.add(new Ligne("Porc",1.0,1.5));
        lignes.add(new Ligne("Salade",1.0,1.5));

        for(Ligne l:lignes){
            l.showLine();
        }
        System.out.println(String.format("total %8.2f",Ligne.totalPrice));


    }
}
