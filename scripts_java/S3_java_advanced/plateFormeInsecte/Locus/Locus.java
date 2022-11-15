package scripts_java.S3_java_advanced.plateFormeInsecte.Locus;
import java.util.ArrayList;

import scripts_java.S3_java_advanced.plateFormeInsecte.Insectes.Insectes;

public class Locus {
    String locus;
    String zone;
    ArrayList<Insectes> insectInLocus= new ArrayList<Insectes>();
    public Locus(String zone){
        this.zone=zone;
    }

    public void locusHave(Insectes i){
        insectInLocus.add(i);
    }

    public void whatInsect(){
        System.out.println(String.format("Dans la zone %s (Locus %s), il y a les insectes:\n",zone ,locus));
        for(Insectes i : insectInLocus){
            i.showInsect();
        }
    }
}
