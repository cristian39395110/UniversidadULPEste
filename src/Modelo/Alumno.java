/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Ruben
 */
public class Alumno {
 
    private int dni;
    private  String apellido;
    private String nombre;
    private LocalDate fecha;
    private boolean disponible;

    public Alumno() {
        
        fecha=LocalDate.now();
        
    }

    
     public Alumno( int dni, String apellido, String nombre,  boolean disponible) {
      
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
         this.fecha = LocalDate.now();
        this.disponible = disponible;
    }
       public Alumno( int dni, String apellido, String nombre,LocalDate fecha,  boolean disponible) {
        
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
         this.fecha = fecha;
        this.disponible = disponible;
    }

   

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Alumno{" + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", fecha=" + fecha + ", disponible=" + disponible + '}';
    }

    public void getFecha(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
}
