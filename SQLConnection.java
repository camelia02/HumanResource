package DB_Testing;
import java.sql.*;
import java.util.*;

public class SQLConnection{
    static final String url = "jdbc:sqlserver://localhost:1433; database=test_Database";
    static final String user = "Camelia";
    static final String password = "test";
    static final String encryption = "true";
    static final String trustServer= "true";
    public static String connectionUrl = url + ";user = " + user +";password = " + password + ";encrypt = " + encryption + ";trustServerCertificate = " + trustServer;

  public static void main(String[] args) {
    
    try{
        try(Connection conn = DriverManager.getConnection(connectionUrl)){
        System.out.println("Database created succesfully. Fetching data...");

        Statement stmt=conn.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from [dbo].[Employee.Information]");  
        while(rs.next())  
        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)
                            + rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)
                            + rs.getString(7)+"  "+rs.getInt(8));  
        conn.close();  
        
        }
    }catch(SQLException e){
        System.out.println("Error creating database");
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
 }
}


