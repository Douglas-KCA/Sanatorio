/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DylanIsaac
 */
public class Conexion {
    
    public Connection con = null;
    
     public Conexion() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                        
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","HOSPITAL","1234");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
		}
    }
	
	public Connection iniciarConexion(){
                //System.out.println("Conexion establecida con éxito.");
		return con;
	}
	
	public void cerrarConexion(){
		try {
			con.close();
		} catch (SQLException e) {
                }
	}
    
}
