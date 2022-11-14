// Import des packages
package scripts_java.S3_java_advanced.XavLBC;


// Main
public class lbc {
    public static void main(String[] args){
        siteInternet LBC = new siteInternet("Le Bon Coin","Vends pas mal de chose");
        immobilier a1 = new immobilier("Appt à vendre", "neuf", "150000", "appt", "50m2");
        a1.showAnnonce();
        System.out.println("-------------------------");
        auto a2 = new auto("vends voiture neuve", "voiture absoluement pas volée", "15000", "coupée", "1500000");
        a2.showAnnonce();
        
    }
}
