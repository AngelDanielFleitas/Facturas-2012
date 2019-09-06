package dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class Conexion {
	private Connection conexion;
	
	public Conexion(){
		conexion = null;
	}
	
	public Connection getConexion(){
		conexion = (Connection) null;
		Context initContext;
		try{
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/ConexionMySQL");
			conexion = ds.getConnection();
			System.out.println("CORRECTO!!!");
		}catch(NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conexion;
	}
}