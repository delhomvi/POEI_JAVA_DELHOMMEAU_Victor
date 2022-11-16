package scripts_java;


import java.sql.*;  

/* 
javac ConnectSQLOne.java 

puur pouvoir être éxécuté le fichier mysql-connector-java-8.0.30.jar doit etre présent
le lancement se fait :
java -cp mysql-connector-java-8.0.30.jar ConnectSQLOne.java
*/

class  ConnectSQLOne {

    public static void main(String[] args) 
    {
        try
        {  
            Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/zoo","root","Salami72550!");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from animal");  
            while(rs.next())  
                System.out.println(String.format("%3s | %20s | %3s",rs.getInt(1),rs.getString(2),rs.getInt(3)));  
            stmt.executeUpdate("select * from espece");
            while(rs.next())  
                System.out.println(String.format("%3s | %20s | %3s",rs.getInt(1),rs.getString(2),rs.getInt(3)));  

            con.close();  
        }
        catch(Exception e)
        { 
            System.out .println(e);
        }  
    }

}