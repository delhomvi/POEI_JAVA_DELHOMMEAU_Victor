package scripts_java.S3_java_advanced.testsUnitaires;

class toTest{
    public static Integer calc1(Integer i){return 5*i;}
    public static String firstLetterMaj(String i){return i.substring(0, 1).toUpperCase() + i.substring(1);}
    public static Boolean isBisextile(Integer i){
        if(i%4==0 && i%100!=0 || i%400==0){
            System.out.println(String.format("%s est une année bissextile", i));
            return true;
        }else{System.out.println(String.format("%s n'est pas une année bissextile", i));return false;}
    }
    
}

public class TestsOne {
    public static void main(String[] args){
        if(toTest.calc1(5)==25){System.out.println("OK");}
        if(toTest.calc1(4)==20){System.out.println("OK");}
        if(toTest.calc1(3)==15){System.out.println("OK");}
        if(toTest.calc1(2)==10){System.out.println("OK");}

        System.out.println("---------------");
        if(toTest.firstLetterMaj("toto").equals("Toto")){System.out.println("OK");}
        else{System.out.println("KO");}

        if(toTest.firstLetterMaj("tata").equals("Tata")){System.out.println("OK");}
        else{System.out.println("KO");}

        System.out.println("-------------------");
        if(toTest.isBisextile(1900)==false){System.out.println("OK");}
        else{System.out.println("KO");}

        if(toTest.isBisextile(1900)==true){System.out.println("OK");}
        else{System.out.println("KO");}

        if(toTest.isBisextile(1904)==true){System.out.println("OK");}
        else{System.out.println("KO");}

    }
}
