package matenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import utils.MySQLConexion;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import beans.Personas;

public class GestionPersonas {

	public ArrayList<Personas> listadoPersonas() {
		ArrayList<Personas> lista = new ArrayList<Personas>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select * from persona ";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				Personas x = new Personas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				lista.add(x);
			}
		}catch (Exception e) {
			System.out.println("Error en la Sentencia");
		}finally {
			try {
				if(pst != null) pst.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				System.out.println("Error al Cerrar");
			}
		}
		return lista;
	}
	
	public ArrayList<Personas>   validarPersona(String usuarioPersona,
			String contraseñaPersona) {
		ArrayList<Personas> lista = new ArrayList<Personas>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select * from persona where usuarioPersona = ? and contrasenaPersona = ?";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, usuarioPersona);
			pst.setString(2, contraseñaPersona);
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				Personas x = new Personas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
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
				System.out.println("Error al Cerrar");
			}
		}
		return lista;
	}
	
	public int añadirPersona(String usuarioPersona,
			String contraseñaPersona, String nombrePersona,
			String apePatPersona, String apeMatPersona) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " insert into persona(usuarioPersona,contrasenaPersona,nombrePersona,apellidoMatPersona,apellidoPatPersona) values (?,?,?,?,?) ";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, usuarioPersona);
			pst.setString(2, contraseñaPersona);
			pst.setString(3, nombrePersona);
			pst.setString(4, apePatPersona);
			pst.setString(5, apeMatPersona);
			
			
			rs =  pst.executeUpdate();
			
			System.out.println("Registro Dictado");
		
		}catch (Exception e) {
			System.out.println(e);
			System.out.println("Error en la Sentencia");
		}finally {
			try {
				if(pst != null) pst.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				System.out.println("Error al Cerrar");
			}
		}
		return rs;
	}
}
