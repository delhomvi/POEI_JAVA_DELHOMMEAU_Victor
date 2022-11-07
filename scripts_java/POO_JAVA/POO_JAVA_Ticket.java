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

class Ticket{
    String client = "";
    List<Ligne> lignesTicket = new ArrayList<>();
    public Ticket(String nom){
        this.client=nom;
    }

    public void addAchat (Ligne l){
        lignesTicket.add(l);
    }

    public void showTicket (){
        System.out.println("===============================");
        System.out.println(String.format("client %8.25s",this.client));
        for(Ligne l: lignesTicket){
            l.showLine();
        }
        System.out.println(String.format("total %8.2f",Ligne.totalPrice));
        System.out.println("===============================");
    }

    
}


public class POO_JAVA_Ticket {
    static List<Ligne> lignes = new ArrayList<>();
    
    public static void main(String[] args) {
        Ticket t1 = new Ticket("toto dutrou");

        t1.addAchat(new Ligne("Romarin",1.0,1.5));
        t1.addAchat(new Ligne("Salami",1.0,1.5));
        t1.addAchat(new Ligne("Cordons Bleus",1.0,1.5));
        t1.addAchat(new Ligne("Saucisse de poulet",1.0,1.5));
        t1.addAchat(new Ligne("Boeuf",1.0,1.5));
        t1.addAchat(new Ligne("Porc",1.0,1.5));
        t1.addAchat(new Ligne("Salade",1.0,1.5));

        t1.showTicket();

        Ticket t2 = new Ticket("tata dutrou");

        t2.addAchat(new Ligne("Romarin",1.0,1.5));
        t2.addAchat(new Ligne("Salami",1.0,1.5));
        t2.showTicket();
    }
}
