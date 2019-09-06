package dao;

import java.sql.*;

import pojos.*;

public class EmisorDao extends Operacion{

	public EmisorDao(){
		super();
	}
	
	public Emisor obtieneEmisor(){
		try{
			String query ="select * from emisor";
			Emisor emisor = new Emisor();
			Statement st = getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			emisor.setRfc(rs.getString("rfc"));
			emisor.setRazonSocial(rs.getString("razonsocial"));
			emisor.setCalle(rs.getString("calle"));
			emisor.setNumeroExt(rs.getString("numeroext"));
			emisor.setNumeroInt(rs.getString("numeroint"));
			emisor.setColonia(rs.getString("colonia"));
			emisor.setCp(rs.getString("cp"));
			emisor.setMunicipio(rs.getString("municipio"));
			emisor.setEstado(rs.getString("estado"));
			emisor.setRegimen(rs.getString("regimenfiscal"));
			return emisor;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}	
}
