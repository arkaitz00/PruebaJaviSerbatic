/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;



import Personas.Paciente;
import Personas.Persona;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Arkaitz
 */
public class OperacionesBD {
    private static Connection conexion = Conexion.getConexion();
    private static Statement st;
    private static Logger operacionesBDLogger = LogManager.getLogger(OperacionesBD.class);
    
    public static ArrayList consultar(int idCiudad) throws SQLException {
        ArrayList listado = new ArrayList<>();
        
        if(conexion != null){
            System.out.println("Consultar registros:");
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM personas where id_ciudad = ?");
            ps.setInt(1, idCiudad);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int idP = rs.getInt(1);
                String nombre = rs.getString(3);
                String tipo = rs.getString(4);
                int infectado = rs.getInt(5);
                
                Persona persona = new Persona(idP,nombre,tipo,infectado);
                listado.add(persona);
            }
            rs.close();
        }else {
        	operacionesBDLogger.debug("Sin conexion");
        }
        return listado;
    }
    public static void insertar(Paciente p, int idCiudad) throws SQLException{
        int infectado = p.getInfectado();
        String nombre = p.getNombre();
        String tipo = p.getTipo();
        if(conexion != null){
            PreparedStatement ps = conexion.prepareStatement("Insert into personas_informe (id_ciudad, Nombre, Tipo, Infectado) values (?, ?, ?, ?)");
            ps.setInt(1, idCiudad);
            ps.setString(2, nombre);
            ps.setString(3, tipo);
            ps.setInt(4, infectado);
            int resultado = ps.executeUpdate();

            if (resultado == 0) {
                System.out.println("NO se ha podido insertar");
            }else{
                System.out.println("Se ha insertado con exito");
            }
        } else {
        	operacionesBDLogger.debug("Sin conexion");
        }    
    }
}
