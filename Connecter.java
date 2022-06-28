package DB_Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Connector {

    public static Connection Connect() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=test_Database;user=Camelia;password=test; encrypt=true; trustServerCertificate=true");
    }

    public static String Login(){
        String usertype = JOptionPane.showInputDialog("Please enter your usertype: ");
        String username = JOptionPane.showInputDialog("Enter Username");
        String password = JOptionPane.showInputDialog("Enter Password");

        if(usertype.equals("admin")){
            if(username.equals("admin") && password.equals("admin")){
            return "admin";
                
            }
        }
        else if(usertype.equals("user")){
            if(username.equals("user") && password.equals("user")){
                return "user";
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Login Failed");
        }
        return "";
    }

  
}
