package scripts_java.S1_java_init.Initiation;
public class Sablier {
    public static void main( String[] args )
    {
        SablierBuild(5);
    }  

    public static void SablierBuild(int sizeSab){
        // Initiation des variables
        Integer numberOfX=sizeSab*2-1;
        Integer numberOfSpace=0;
        drawFig(sizeSab,0,numberOfSpace,numberOfX);
        
        // Inversion du sens
        numberOfX=1;
        numberOfSpace=2*sizeSab-1;        
        drawFig(sizeSab,1,numberOfSpace,numberOfX);
    }

    public static void drawFig(int sizeSab, int sensVal, int numberOfSpacee, int numberOfXX){
        String lineStr="";
        Integer numberOfX=numberOfXX;
        Integer numberOfSpace=numberOfSpacee;
        for(int y=1;y<=sizeSab;y++){
            for(int i=0;i<numberOfSpace/2;i++){
                lineStr+=" ";
            }
            for(int j=0;j<numberOfX;j++){
                lineStr+="X";
            }
            if(sensVal==0){
                numberOfX-=2;
                numberOfSpace+=2;
            }else{
                numberOfX+=2;
                numberOfSpace-=2;
            }
            lineStr+="\n";
        }
        System.out.print(lineStr);
    }

}
