package scripts_java.Initiation;
public class triangle {
    public static void main( String[] args )
    {
        triangleBuild(6);
    }  

    public static void triangleBuild(int cote){
        int count =0;
        for(int x=1;x<=cote;x++){
            for(int y=1;y<=x;y++){
                System.out.print("*");
                count++;
            }
            System.out.println("");
        }

        int countCalc = cote*(cote+1)/2;
        System.out.println("Il y a exactement "+count+" étoiles dans le triangle");
        System.out.println("Il y a exactement "+countCalc+" étoiles dans le triangle via calc");
        
    }
}
