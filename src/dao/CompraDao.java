package dao;

import java.sql.*;

import pojos.*;

public class CompraDao extends Operacion {
	
	public CompraDao(){
		super();
	}
		
	public boolean InsertaCompra(String id, String des,String cant,String val, String sub, String im, String tot,String fe, String hor){
		try {
			String query = "INSERT INTO COMPRA (IdCompra,Descripcion,Cantidad,valorUnitario,subtotal,impuestos,total,Fecha,Hora)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = getConexion().prepareStatement(query);
			System.out.println("orz");
			ps.setString(1, id);
			ps.setString(2, des);
			ps.setString(3, cant);
			ps.setString(4, val);
			ps.setString(5, sub);
			ps.setString(6, im);
			ps.setString(7, tot);
			ps.setString(8, fe);
			ps.setString(9, hor);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public Compra obtieneCompra(String id){
		try{
			String query ="select * from compra where idcompra = '" + id + "'";
			Compra compra = new Compra();
			Statement st = getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			compra.setIdentificacion(rs.getString("idcompra"));
			compra.setDescripcion(rs.getString("descripcion"));
			compra.setCantidad(rs.getString("cantidad"));
			compra.setUnidad(rs.getString("unidad"));
			compra.setValorUnitario(rs.getString("valorunitario"));
			compra.setSubtotal(rs.getString("subtotal"));
			compra.setImpuestos(rs.getString("impuestos"));
			compra.setTotal(rs.getString("total"));
			compra.setFecha(rs.getString("fecha"));
			compra.setHora(rs.getString("hora"));
			return compra;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
