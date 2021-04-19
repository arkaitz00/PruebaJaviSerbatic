/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

/**
 *
 * @author Lenovo
 */
public class Persona {
    String nombre, tipo;
    int id, infectado;

    public Persona() {
    }

    public Persona( int id, String nombre, String tipo,int infectado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.infectado = infectado;
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
    public String toString() {
        return id+", " + nombre+", "+tipo+", "+infectado;
    }
}
