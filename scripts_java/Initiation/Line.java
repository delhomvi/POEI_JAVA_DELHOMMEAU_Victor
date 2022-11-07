package scripts_java.Initiation;
import java.util.*;
public class Line 
{
    public static void main(String[] args) 
    {
        //Rect(10, 6 );
        //chatBox("Message Juste Pour Tester");

        List<String> listeTest = new ArrayList<String>();
        listeTest.add("J'aime");
        listeTest.add("Les");
        listeTest.add("Pommes");
        listeTest.add("Frites");
        chatBoxBetter(listeTest, 7);

    }

    public static void Rect(int larg, int haut)
    {
        String linestring="";
        for(int y=0;y<haut;y++)
        {
            for(int x=0;x<larg;x++)
            {
            if(x==0 & y==0 | x==0 & y==haut-1| x==larg-1 & y==0| x==larg-1 & y==haut-1){linestring+="+";}
            else if(x==0 & y!=0 | x==larg-1 & y!=haut-1){linestring+="|";}
            else if(x!=0 & y==0 | x!=larg-1 & y==haut-1){linestring+="-";}
            else{linestring+=" ";}
            }
            linestring+="\n";
        }
        System.out.println(linestring);
    }


    public static void chatBox(String msg){   
        int msgLength=msg.length();
        int larg=msgLength+4;
        int mid=2;
        int haut=5;
        String linestring="";
        
        for(int y=0;y<haut;y++){   
            for(int x=0;x<larg;x++){
            if(x==0 & y==0 | x==0 & y==haut-1| x==larg-1 & y==0| x==larg-1 & y==haut-1){
                linestring+="+";
            } // rempli les arrêtes

            else if(x==0 & y!=0 & y!=mid| x==larg-1 & y!=haut-1 & y!=mid){
                linestring+="|";
            } // rempli les cotés autre que le centre de la chatbox

            else if(x!=0 & y==0 | x!=larg-1 & y==haut-1){
                linestring+="-";
            }// rempli les hauts et bas de la chatbox

            else if(y==mid){
                linestring+="| "+msg+" |";
                break;
            } // Ajoute au milieu de la chatbox le massage

            else{
                linestring+=" ";
            }
            }
            linestring+="\n"; // saut de ligne

        }
        System.out.println(linestring);
    }


    public static void chatBoxBetter(List<String> msgList, int msgLength){ // msgLength longeur du string le plus grand  
        int larg=msgLength+4;
        int mid=2;
        int haut=5;
        String linestring="";
        
        for(int y=0;y<haut;y++){   
            for(int x=0;x<larg;x++){
            if(x==0 & y==0 | x==0 & y==haut-1| x==larg-1 & y==0| x==larg-1 & y==haut-1){
                linestring+="+";
            } // rempli les arrêtes

            else if(x==0 & y!=0 & y!=mid| x==larg-1 & y!=haut-1 & y!=mid){
                linestring+="|";
            } // rempli les cotés autre que le centre de la chatbox

            else if(x!=0 & y==0 | x!=larg-1 & y==haut-1){
                linestring+="-";
            }// rempli les hauts et bas de la chatbox

            else if(y==mid){
                for(String msg : msgList){
                    String msgCache=msg;
                    while(msgCache.length()<=msgLength){
                        msgCache+=" ";
                    }
                    linestring+="| "+msgCache+"|\n";
                }
                String spaceString="";
                for(int j=0;j<msgLength+2;j++){
                    spaceString+=" ";
                }    
                linestring+="|"+spaceString+"|";
                break;
            } // Ajoute au milieu de la chatbox le massage

            else{
                linestring+=" ";
            }
            }
            linestring+="\n"; // saut de ligne
            
        }
        System.out.println(linestring);
    }

}



