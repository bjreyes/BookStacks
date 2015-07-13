package matenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.MySQLConexion;
import beans.Recomendaciones;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GestionRecomendacion {
	public ArrayList<Recomendaciones> listadoRecomendaciones() {
		ArrayList<Recomendaciones> lista = new ArrayList<Recomendaciones>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select * from recomendacion ";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				Recomendaciones x = new Recomendaciones(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				lista.add(x);
			}
		}catch (Exception e) {
			System.out.println(e);
			System.out.println("Error en la Sentencia");
		}finally {
			try {
				if(pst != null) pst.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				System.out.println(e);
				System.out.println("Error al Cerrar");
			}
		}
		return lista;
	}
	
	public int añadirRecomendacion(String tipObjRecomendacion,
			String nomObjRecomendacion, String autorObjRecomendacion,
			int idpersona) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " insert into recomendacion (tipoObjRecomendacion,nomObjRecomendacion,autorObjRecomendacion,persona_idpersona) values (?,?,?,?) ";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, tipObjRecomendacion);
			pst.setString(2, nomObjRecomendacion);
			pst.setString(3, autorObjRecomendacion);
			pst.setInt(4, idpersona);			
			
			
			rs =  pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Registro de Recomendacion Exitoso");
		
		}catch (Exception e) {
			System.out.println(e);
			System.out.println("Error en la Sentencia");
		}finally {
			try {
				if(pst != null) pst.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				System.out.println(e);
				System.out.println("Error al Cerrar");
			}
		}
		return rs;
	}

}
