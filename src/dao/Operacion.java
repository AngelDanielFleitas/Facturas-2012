package dao;

import java.sql.*;

public class Operacion {
	private Conexion conexion;
	
	public Operacion(){
		conexion = new Conexion();
	}
	
	public Connection getConexion(){
		return conexion.getConexion();
	}
	
}
