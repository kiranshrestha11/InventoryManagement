/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.*; 
//import javax.swing.JOptionPane;

/**
 *
 * @author hjp
 */
public class DBConnect {
    public static Connection connect()
    {
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory?","root","");
            //JOptionPane.showMessageDialog(null,"connection success");
            //System.out.println("connected successfully");
        }
        catch(Exception e){
            System.out.println("Failed to connect with database");
        }
        return conn;
    }
}
