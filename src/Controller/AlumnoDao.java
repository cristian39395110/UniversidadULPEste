/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ruben
 */
public class AlumnoDao {
    private Connection conection;

    public AlumnoDao() {
        
        conection=Coneccionbs.Conectar();
    }
    
    public void agregarAlumno(Alumno alumno)
    {
        if (conection!=null)
        {
            try {
                String sql="INSERT INTO alumno(dni,apellido,nombre,fecha_nacimiento,estado) VALUE (?,?,?,?,?)";
                PreparedStatement ps=conection.prepareStatement(sql);
                ps.setInt(1,alumno.getDni());
                ps.setString(2,alumno.getApellido());
                ps.setString(3,alumno.getNombre());
               LocalDate fechaNacimiento = alumno.getFecha(); // Suponiendo que getFecha() devuelve un objeto LocalDate
                ps.setDate(4, java.sql.Date.valueOf(fechaNacimiento));
                ps.setBoolean(5,alumno.isDisponible());
                
                int result=ps.executeUpdate();
                ps.close();
                 Coneccionbs.CerrarConexion();
                   if (result>0){
                JOptionPane.showMessageDialog(null, "Materia Guardada");
            
            }
            else
            { JOptionPane.showMessageDialog(null, "Materia Finalizada");}
                
            }  catch (SQLIntegrityConstraintViolationException ex) {
    
                   JOptionPane.showMessageDialog(null, "Alumno ya exite en La BD");
            }
            
            
            catch (SQLException ex) {
                Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
        }
        else
        {JOptionPane.showMessageDialog(null,"BD desconectada");}
    
    
    
    
    
    } 
    
    public Alumno  mostrarAlumno(int dni)
            {
                
                Alumno alumno= new Alumno();
                
                try {
                
                
                String sql = "SELECT * FROM alumno WHERE dni = ? AND estado=1";
                PreparedStatement ps=conection.prepareStatement(sql);
                ps.setInt(1, dni);
                  ResultSet rs= ps.executeQuery();
                
                  if (rs.next())
                  {    
                      alumno.setNombre(rs.getString("nombre"));
                      alumno.setApellido(rs.getString("apellido"));
                      alumno.setDni(dni);
                      alumno.getFecha(rs.getDate("fecha_nacimiento"));
                      alumno.setDisponible(rs.getBoolean("estado"));
                      int i=ps.executeUpdate();
                      
                     if(i>0)
                     {JOptionPane.showMessageDialog(null, "ALumno Listo Para Mostraer");}
                     else
                     {JOptionPane.showMessageDialog(null, "ALumno No esta Cargado");}
                      conection.close();
                  
                  }
                  else
                  {JOptionPane.showMessageDialog(null, "No se encontro el Alumno");}
                
                
                
                
               
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
          
        }
          
    return alumno;
    
            }
     public ArrayList<Alumno>  mostrarAlumnos()
            {
                
                ArrayList<Alumno> alumnos= new ArrayList ();
               
                
                try {
                
                
                String sql = "SELECT * FROM alumno WHERE estado=1";
                PreparedStatement ps=conection.prepareStatement(sql);
              
                  ResultSet rs= ps.executeQuery();
                
                  while(rs.next())
                  {   
                       Alumno alumno=new Alumno();
                     
                      alumno.setNombre(rs.getString("nombre"));
                      alumno.setApellido(rs.getString("apellido"));
                      alumno.setDni(rs.getInt("dni"));
                     // alumno.getFecha(rs.getDate("fecha_nacimiento"));
                      alumno.setDisponible(rs.getBoolean("estado"));
                      alumnos.add(alumno);
                  }
                      int i=ps.executeUpdate();
                      
                     if(i>0)
                     {JOptionPane.showMessageDialog(null, "ALumnos Listo Para Mostraer");}
                     else
                     {JOptionPane.showMessageDialog(null, "ALumnos No estan Cargado");}
                      conection.close();
                  
                  
                 
                  
                
                
                
                
               
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
          
        }
          
    return alumnos;
    
            }
          
            
    
}
