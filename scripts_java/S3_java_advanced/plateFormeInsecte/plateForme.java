package scripts_java.S3_java_advanced.plateFormeInsecte;
import scripts_java.S3_java_advanced.plateFormeInsecte.Insectes.*;
import scripts_java.S3_java_advanced.plateFormeInsecte.Locus.*;


public class plateForme {
    public static void main(String[] args){
        System.out.println("----Création des insectes----");
        class_Insectes_Cigales c1 = new class_Insectes_Cigales("Cigalus Maximus", "Cigalus Maximus Cubitus");    
        class_Insectes_Moustiques m1 = new class_Insectes_Moustiques("Moustiqus Casse Couillus", "Moustiqus Casse Couillus Maximus");    
        class_Insectes_Papillons p1 = new class_Insectes_Papillons("Papillonus Butifulus", "Papillonus Butifulus Maximus")    ;
        
        System.out.println("----Création des locus----");
        class_Locus_Alpin a1 = new class_Locus_Alpin("Montagnes isèroises");
        class_Locus_Marin ma1 = new class_Locus_Marin("Plages Bretones");
        class_Locus_Plaine pl1= new class_Locus_Plaine("Plaines Sarthoises");
        
        System.out.println("----Ajouts des insectes aux locus----");
        a1.locusHave((Insectes)p1);
        ma1.locusHave((Insectes)c1);
        pl1.locusHave((Insectes)m1);
        System.out.println("----Affichage des insectes----");
        a1.whatInsect();
        System.out.println("--");
        ma1.whatInsect();
        System.out.println("--");
        pl1.whatInsect();
        System.out.println("--");

    }
}
