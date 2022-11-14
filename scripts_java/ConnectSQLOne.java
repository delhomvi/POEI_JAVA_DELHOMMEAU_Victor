package scripts_java;
import java.util.*;
import java.util.ArrayList.*;
import java.sql.*;  

/* 
javac ConnectSQLOne.java 

puur pouvoir être éxécuté le fichier mysql-connector-java-8.0.30.jar doit etre présent
le lancement se fait :
java -cp mysql-connector-java-8.0.30.jar ConnectSQLOne 
*/

class  ConnectSQLOne {

    public static void main(String[] args) 
    {
        try
        {  
            Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/","root","root");  
            Statement stmt=con.createStatement();  
            // ResultSet rs=stmt.executeQuery("select * from auteur");  
            while(rs.next())  
                System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
            con.close();  
        }
        catch(Exception e)
        { 
            System.out .println(e);
        }  
    }

}