package Main;

import BD.OperacionesBD;
import Personas.Enfermero;
import Personas.Paciente;
import Personas.Persona;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arkaitz
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
	private static Logger main = LogManager.getLogger(Main.class);
	
    public static void main(String[] args) throws SQLException {
        ArrayList<Persona> listaCiudad = new ArrayList<>();
        ArrayList<Enfermero> listaVacunables = new ArrayList<>();
        ArrayList<Paciente> listaInfectable = new ArrayList<>();
        ArrayList<Paciente> soloInfectados = new ArrayList<>();
    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String url = "C:\\Users\\Formacion\\Desktop\\Arkaitz\\Maven\\PruebaJaviSerbatic\\src\\resources\\log4j.properties";
		PropertyConfigurator.configure(url);
        int idCiudad = 0;
        Scanner teclado = new Scanner(System.in);
        try {
        	do{        	
	            System.out.print("Introduce id de ciudad (0-10): ");
	            idCiudad = teclado.nextInt();
        	}while(idCiudad < 1 || idCiudad >10);
        }catch(java.util.InputMismatchException e) {
        		main.error("No se ha introducido numero");
        }
        if(idCiudad>0) {
        	
	        listaCiudad = OperacionesBD.consultar(idCiudad);
	        for(int i = 0; i < listaCiudad.size(); i++){            
	            if(listaCiudad.get(i).getTipo().equals("E")){
	                Enfermero enfermero = new Enfermero(listaCiudad.get(i).getId(), listaCiudad.get(i).getNombre(), listaCiudad.get(i).getTipo(), listaCiudad.get(i).getInfectado());
	                listaVacunables.add(enfermero);
	                main.info("Se ha añadido enfermero "+enfermero.getNombre());
	            }else if(listaCiudad.get(i).getTipo().equals("P")){
	                Paciente paciente = new Paciente(listaCiudad.get(i).getId(), listaCiudad.get(i).getNombre(), listaCiudad.get(i).getTipo(), listaCiudad.get(i).getInfectado());
	                listaInfectable.add(paciente);
	                main.info("Se ha añadido paciente "+ paciente.getNombre());
	            }
	        }
	        for(int i = 0; i < listaInfectable.size(); i++){
	            if(listaInfectable.get(i).simularDia()){
	                listaInfectable.get(i).setInfectado(1);
	            }
	        }
	        for(int i = 0; i < listaInfectable.size(); i++){
	            if(listaInfectable.get(i).getInfectado()==1){
	                soloInfectados.add(listaInfectable.get(i));
	            }
	        }
	        System.out.println("Lista infectados: ");
	        for(int i = 0; i < soloInfectados.size(); i++){
	            System.out.println("- "+soloInfectados.get(i)+"\n");
	        }
	        
	        for(int i = 0; i < 2; i++){
	            Enfermero e = new Enfermero();
	            int aleatorio = (int) Math.floor(Math.random()*soloInfectados.size()+1);
	            e.vacunar(soloInfectados.get(aleatorio));
	            soloInfectados.remove(aleatorio);
	        }
	        for(int i = 0; i < 1; i++){
	            Enfermero e = new Enfermero();
	            int aleatorio = (int) Math.floor(Math.random()*soloInfectados.size()+1);
	            e.vacunar(soloInfectados.get(aleatorio));
	            soloInfectados.remove(aleatorio);
	        }
	        System.out.println("Nueva lista infectados");
	        for(int i = 0; i < soloInfectados.size(); i++){
	            System.out.println("- "+soloInfectados.get(i)+"\n");
	        }
	        for(int i = 0; i < soloInfectados.size(); i++){
	            OperacionesBD.insertar(soloInfectados.get(i), idCiudad);
	        }
        }else {
        	main.error("No se puede ejecutar ninguna operacion, porque la ciudad ha sido mal introducida");
        }
    }
}
