package dao;

import java.sql.*;
import pojos.*;

public class ClienteDao extends Operacion{
	
	public ClienteDao(){
		super();
	}

	public boolean verificaCliente(String rfc){
		String query = "select * from cliente where rfc = '" + rfc + "'";
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
	
	public boolean insertaCliente(String rfc,String razon, String calle, String numext,String numint, String colonia, String cp,
			String municipio, String estado, String correo){		
		try {
			String query = "INSERT INTO CLIENTE (RFC, RazonSocial, Calle, Numeroext, Numeroint, Colonia, CP, Municipio, "
					+ "Estado, Correo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = getConexion().prepareStatement(query);
			System.out.println("orz");
			ps.setString(1, rfc);
			ps.setString(2, razon);
			ps.setString(3, calle);
			ps.setString(4, numext);
			ps.setString(5, numint);
			ps.setString(6, colonia);
			ps.setString(7, cp);
			ps.setString(8, municipio);
			ps.setString(9, estado);
			ps.setString(10, correo);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public Cliente obtieneCliente(String rfc){		
		try{
			String query ="select * from cliente where rfc = '" + rfc + "'";
			Cliente cliente = new Cliente();
			Statement st = getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			cliente.setRfc(rs.getString("rfc"));
			cliente.setRazonSocial(rs.getString("razonsocial"));
			cliente.setCalle(rs.getString("calle"));
			cliente.setNumeroext(rs.getString("numeroext"));
			cliente.setNumeroint(rs.getString("numeroint"));
			cliente.setColonia(rs.getString("colonia"));
			cliente.setCp(rs.getString("cp"));
			cliente.setMunicipio(rs.getString("municipio"));
			cliente.setEstado(rs.getString("estado"));
			cliente.setCorreo(rs.getString("correo"));
			return cliente;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean modifcaCliente(String rfc, String calle, String numeroext, String numeroint, String colonia, String cp, String municipio, String estado,String correo){
		try{
			String query="UPDATE CLIENTE SET calle=?, Numeroext=?, Numeroint=?, Colonia=?, CP=?, Municipio=?, Estado=?, Correo=? WHERE RFC=?";
			PreparedStatement ps = getConexion().prepareStatement(query);
			ps.setString(1, calle);
			ps.setString(2, numeroext);
			ps.setString(3, numeroint);
			ps.setString(4, colonia);
			ps.setString(5, cp);
			ps.setString(6, municipio);
			ps.setString(7, estado);
			ps.setString(8,correo);
			ps.setString(9, rfc);
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
}

