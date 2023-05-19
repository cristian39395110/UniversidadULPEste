/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Ruben
 */
public class Inscripcion {
    private int idinscripto;
    private int idalumno;
    private int idmateria;

    public Inscripcion() {
    }

    public int getIdinscripto() {
        return idinscripto;
    }

    public void setIdinscripto(int idinscripto) {
        this.idinscripto = idinscripto;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idinscripto=" + idinscripto + ", idalumno=" + idalumno + ", idmateria=" + idmateria + '}';
    }
    
    
}
