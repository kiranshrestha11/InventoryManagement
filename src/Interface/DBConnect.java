package Interface;

import java.sql.*; 
import javax.swing.JOptionPane;

public class DBConnect {
    public static Connection connect()
    {
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory?","root","");
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Failed to connect with database");
        }
        return conn;
    }
}
