/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import Controller.Coneccionbs;
import Modelo.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class MateriaDao extends Coneccionbs  {
    private Connection connection;

    public MateriaDao() {
        connection=Coneccionbs.Conectar();
        
        
    }
    
    public void agregarMateria(Materia materia)
    {    if (connection!=null)
    {
        try {
           //String sql = "INSERT INTO materia(nombre, anio, estado) VALUES (?, ?, ?)";
            String sql="INSERT INTO `materia`(`nombre`, `anio`, `estado`) VALUE (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,materia.getNombre());
            statement.setInt(2,materia.getAnio());
            statement.setBoolean(3,materia.isEstado());
            System.out.println(materia.getNombre());
            int result=statement.executeUpdate();
             Coneccionbs.CerrarConexion();
            if (result>0){
                JOptionPane.showMessageDialog(null, "Materia Guardada");
            
            }
            else
            { JOptionPane.showMessageDialog(null, "Materia Finalizada");}
            
        }  catch (SQLIntegrityConstraintViolationException ex) {
    
                   JOptionPane.showMessageDialog(null, "Materia Ya esta Cargada");
            } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error sentencia sql");}
        }
     else
    {
        JOptionPane.showMessageDialog(null, "No conectado a la base de dato");
    }
    
    
    }
     public ArrayList<Materia>  mostrarMaterias()
            {
                
                ArrayList<Materia> materias= new ArrayList();
               
                
                try {
                
                
                        String sql = "SELECT * FROM materia WHERE estado = 1";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
                
                  while(rs.next())
                  {   
                       Materia mate=new Materia();
                     
                      mate.setNombre(rs.getString("nombre"));
                      mate.setAnio(rs.getInt("anio"));
                      mate.setEstado(rs.getBoolean("estado"));
                
                      materias.add(mate);
                  }
                      int i=ps.executeUpdate();
                      
                     if(i>0)
                     {JOptionPane.showMessageDialog(null, "Materias Listo Para Mostraer");}
                     else
                     {JOptionPane.showMessageDialog(null, "Materia No estan Cargado");}
                      connection.close();
                  
                  
                 
                  
                
                
                
                
               
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
          
        }
          
    return materias;
    
            }
   

}
    
        
    
    
    
    
    
    
    

