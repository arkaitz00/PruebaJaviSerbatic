/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import Interfaces.Moveable;
import Interfaces.Infectable;

/**
 *
 * @author Arkaitz
 */
public class Paciente extends Persona implements Infectable, Moveable{

    public Paciente() {
    }

    public Paciente(int id, String nombre, String tipo, int infectado) {
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
    public boolean infectar(boolean infectado) {
        infectado = false;
        if(visitarSuper() || visitarTrabajo() || cogerTransporte()){
            infectado = true;
        }
        return infectado;
    }

    @Override
    public boolean visitarSuper() {
        int aleatorio = (int) Math.floor(Math.random()*100+1);
        if(aleatorio>0 && aleatorio<11){
            return true;
        }
        return false;
    }

    @Override
    public boolean visitarTrabajo() {
        int aleatorio = (int) Math.floor(Math.random()*100+1);
        if(aleatorio>0 && aleatorio<12){
            return true;
        }
        return false;
    }

    @Override
    public boolean cogerTransporte() {
        int aleatorio = (int) Math.floor(Math.random()*100+1);
        if(aleatorio>0 && aleatorio<16  ){
            return true;
        }
        return false;
    }
    
    public boolean simularDia(){
        boolean infectado = false;
        int random = (int) Math.floor(Math.random()*6+1);
        
        switch(random){
            case 1:
                if(visitarSuper()){
                    infectado = true;
                }
            break;
            case 2:
                if(visitarSuper() || cogerTransporte()){
                    infectado = true;
                }
            break;
            case 3:
                if(visitarSuper() || cogerTransporte() || visitarTrabajo()){
                    infectado = true;
                }
            break;
            case 4:
                if(visitarTrabajo()){
                    infectado = true;
                }
            break;
            case 5:
                if(cogerTransporte()){
                    infectado = false;
                }
            break;
            case 6:
                if(cogerTransporte() || visitarTrabajo()){
                    infectado = true;
                }
            break;
        }
        return infectado;
    }    
}
