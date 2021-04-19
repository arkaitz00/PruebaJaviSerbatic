/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import Interfaces.Vacunable;
import java.util.Collection;

/**
 *
 * @author Arkaitz
 */
public class Enfermero extends Persona implements Vacunable{

    public Enfermero() {
    }

    public Enfermero(int id, String nombre, String tipo, int infectado) {
        super(id, nombre, tipo, infectado);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfectado() {
        return infectado;
    }

    public void setInfectado(int infectado) {
        this.infectado = infectado;
    }
    
    @Override
    public boolean vacunar(Paciente p) {
        if(p.getInfectado() != 0){
            p.setInfectado(0);
            return true;
        }else{
            System.out.println("El paciente no esta infectado");
            return false;
        }
    }

    @Override
    public boolean vacunar(Collection<Paciente> coleccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
