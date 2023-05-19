/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class Coneccionbs{
private static Connection connection;
    public Coneccionbs() {
    }
   
    public static Connection Conectar()
    {  Connection con=null;
        String url="jdbc:mysql://localhost:3307/universida";
       String user="root";
       String pass="";
       
        try {
               
         Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
           JOptionPane.showMessageDialog(null, "se conecto a la base de dato");
            
        } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "Error la base de dato");
            
        }
      
    
    return con;
    
    
    }
     static void CerrarConexion() {
        
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                JOptionPane.showMessageDialog(null, "Se cerró la conexión a la base de datos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión a la base de datos");
        }
    }
    
}