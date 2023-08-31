/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;


/**
 *
 * @author vishu
 */
public class MyConnect {
    private static final String username="root";
    private static final String password="Kumar@1234";
    private static final String dataCon="jdbc:mysql://localhost:3306/st_managmnt";
    private static Connection con = null;
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(dataCon,username,password);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
    }   
     return con;   
    }
  
    
  
    
}
