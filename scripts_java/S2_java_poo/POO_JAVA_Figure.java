package scripts_java.S2_java_poo;


class Point{
    Integer x , y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void showFig(){
        System.out.println(String.format("Point en (%d , %d)",this.x,this.y));
    }

}

class Cercle extends Point{
    Integer r;
    public Cercle(int x,int y,int r){
        super(x, y);
        this.r=r;
    }

    public void showFig(){
        System.out.println(String.format("Cercle en (%d , %d) de rayon %d",this.x,this.y,this.r));
    }

}

class Rectangle extends Point{
    Integer longg,larg;
    public Rectangle(int x,int y,int longg,int larg){
        super(x, y);
        this.longg=longg;
        this.larg=larg;
    }

    public void showFig(){
        System.out.println(String.format("Rectangle en (%d , %d) de cotes %d*%d",this.x,this.y,this.longg,this.larg));
    }

}

class Carre extends Rectangle{
    Integer cote;
    public Carre(int x,int y,int cot){
        super(x, y,cot,cot);
        this.cote=cot;
    }

    public void showFig(){
        System.out.println(String.format("Carre en (%d , %d) de cote %d",this.x,this.y,this.cote));
    }

}



public class POO_JAVA_Figure {
    
    public static void main(String[] args) {
        Point p1 = new Point(5,6);
        p1.showFig();

        Cercle c1 = new Cercle(5,6,7);
        c1.showFig();

        Carre car1 = new Carre(5,6,7);
        car1.showFig();

        Rectangle r1 = new Rectangle(5,6,7,8);
        r1.showFig();


    }
}
