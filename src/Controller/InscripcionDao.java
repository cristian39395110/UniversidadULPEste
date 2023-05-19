/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class InscripcionDao extends Coneccionbs{
    private Connection conection;

    public InscripcionDao() {
        conection=Coneccionbs.Conectar();
    }
    
    
    public void agregarInscripcion(int dni, String materia){
        
        {    
            
            if (conection!=null)
          {
      
            try {
                
                String sql1="INSERT INTO `inscripcion`(`id_alumno`,`id_materia`) VALUE (?,?)";
                String sql2 = "SELECT * FROM alumno WHERE dni = ? AND estado = 1";
                String sql3 = "SELECT * FROM materia WHERE nombre = ? AND estado=1";
                
                PreparedStatement ps1 = conection.prepareStatement(sql1);
                PreparedStatement ps2 = conection.prepareStatement(sql2);
                PreparedStatement ps3 = conection.prepareStatement(sql3);
                ps2.setInt(1, dni);
                ps3.setString(1, materia);
                
                 
                ResultSet rs1= ps2.executeQuery();
                ResultSet rs2= ps3.executeQuery();
                
                
                if (rs1.next()&&rs2.next())
                {
                    
                    
                    int idalumno=rs1.getInt("id_alumno");
                    int idmateria=rs2.getInt("id_materia");
                    
                    ps1.setInt(1,idalumno);
                    ps1.setInt(2, idmateria);
                   
                    int resulta=ps1.executeUpdate();
                   
                    rs2.close();
               rs1.close();
               ps1.close();
              ps2.close();
             ps3.close();
                    if (resulta>0){
                        JOptionPane.showMessageDialog(null, "Materia Guardada");
                        
                    }
                    else
                    { JOptionPane.showMessageDialog(null, "Materia Finalizada");}
                    
                    
                    
                    
                }
                else
                {JOptionPane.showMessageDialog(null, "NO se enconttro el alumno");}
            }   catch (SQLIntegrityConstraintViolationException ex) {
    
                   JOptionPane.showMessageDialog(null, "La inscripción ya existe en la base de datos");
            }
            
            catch (SQLException ex) {
                Logger.getLogger(InscripcionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
          
      
    Coneccionbs.CerrarConexion();
    }
            else
            { JOptionPane.showMessageDialog(null, "por aca no");}
        


}
    
    
}
    }

