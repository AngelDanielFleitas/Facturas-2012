package dao;

import pojos.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao extends Operacion{
	
	public AdminDao(){
		super();
	}

	public boolean verificaAdmin(String id){
		String query = "select * from admin where idadmin = '" + id + "'";
		try {
			Statement st = getConexion().createStatement();
			ResultSet r = st.executeQuery(query);
			if(r.next() == true){
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} 
			
		return false;
	}
	
	public Admin obtieneAdmin(String id){
		try{
			String query = "select * from admin where idadmin = '" + id + "'";
			Admin admin = new Admin();
			Statement st = getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			admin.setIdAdmin(rs.getString("idadmin"));
			admin.setPass(rs.getString("pass"));
			admin.setMensaje(rs.getString("mensaje"));
			admin.setAsunto(rs.getString("asunto"));
			return admin;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
