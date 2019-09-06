package dao;
import pojos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CombustileDao extends Operacion{

	public CombustileDao(){
		super();
	}
	
	public Combustible obtieneCombustible(String nombre){
		try{
			String query ="select * from combustible where nombre = '" + nombre + "'";
			Combustible com = new Combustible();
			Statement st = getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			com.setNombre(rs.getString("nombre"));
			com.setPrecioUni(rs.getString("preciounitario"));
			return com;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String fecha(){
		try{
			String query ="select CURDATE()";
			Statement st = getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String fecha = ""+rs.getDate(1);
			return fecha;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String hora(){
		try{
			String query ="select CURTIME()";
			Statement st = getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String hora = ""+rs.getTime(1);
			return hora;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
