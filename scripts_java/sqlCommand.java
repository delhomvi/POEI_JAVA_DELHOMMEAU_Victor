package scripts_java;
import java.sql.*;  

public class sqlCommand {
    public sqlCommand(){
        try
        {  
            // Se connecte à mon sevreur, initialisation des variables
            Connection con=connectToMyServer();  
            readFromSQLservThreeColls(con,"SELECT * FROM animal");
            modSQLTable(con,"INSERT INTO animal(nom,id_espece) VALUES ('titi',1)");
            readFromSQLservTwoColls(con,"SELECT * FROM animal");

        }
        catch(Exception e)
        { 
            System.out .println(e);
        }  
    } 

    public Connection connectToMyServer() throws SQLException{ 
        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/zoo","root","Salami72550!");  
        return con;
    }

    public static void readFromSQLservTwoColls(Connection con,String query) throws SQLException{
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery(query);
        while(rs.next())  
                System.out.println(String.format("%3s | %20s",rs.getInt(1),rs.getString(2))); 
    }

    public static void readFromSQLservThreeColls(Connection con,String query) throws SQLException{
        Statement stmt=con.createStatement(); 
        ResultSet rs=stmt.executeQuery(query);
        while(rs.next())  
                System.out.println(String.format("%3s | %20s | %20s",rs.getInt(1),rs.getString(2),rs.getInt(3))); 
    }


    public static void modSQLTable(Connection con,String query) throws SQLException{
        Statement stmt=con.createStatement(); 
        stmt.executeUpdate(query); 
    }
    

    
}
