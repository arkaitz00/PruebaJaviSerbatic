/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import Main.Main;

/**
 *
 * @author Arkaitz
 */
public class Conexion {
    static String url = "jdbc:mysql://localhost:3306/prueba_serbatic";
    static Connection conexion;
    private static Logger conexionLogger = LogManager.getLogger(Conexion.class);   
        
	
    public static Connection getConexion() {
	    if (crearConexion()) {
                System.out.println("Conexion creada");
                conexionLogger.debug("Conexion creada");
	    }else{
                System.out.println("No se ha podido crear la conexion");
                conexionLogger.debug("Conexion fallida");
            }
	    return conexion;
    }
   
    public static boolean crearConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url,"root","");
            conexion.setAutoCommit(false);

        } catch (SQLException | ClassNotFoundException e) {
            return false;
        }
        return true;
    }

    public static void desconectar(){
    	try {
            conexion.close();
            conexion = null;
            System.out.println("La conexion a la  base de datos ha terminado");    	
    	} catch (SQLException e) {
    		System.out.println("Error al cerrar la conexion");
    		conexionLogger.error("Error al cerrar la conexion");
        }
    }
}
