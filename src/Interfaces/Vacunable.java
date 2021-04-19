package Interfaces;

import Personas.Paciente;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arkaitz
 */
public interface Vacunable {
    public boolean vacunar(Paciente p);
    public boolean vacunar(Collection<Paciente> coleccion);
}
