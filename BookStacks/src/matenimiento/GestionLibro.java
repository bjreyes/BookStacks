package matenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.MySQLConexion;
import beans.Libros;
import beans.Personas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GestionLibro {
	
	public int añadirLibro(String tituloLibro, int numPaginas, String idioma, int autor,
			int genero, double precioPorDia) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " INSERT INTO libro  VALUES (?,?,?,?,?,?)";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, tituloLibro);
			pst.setInt(2, numPaginas);
			pst.setString(3, idioma);
			pst.setInt(4, autor);
			pst.setInt(5, genero);
			pst.setDouble(6, precioPorDia);
			
			
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
	
	public ArrayList<Libros> filtraLibroXTitulo(String titulo) {
		ArrayList<Libros> lista = new ArrayList<Libros>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select * from persona where usuarioPersona = ? and contrasenaPersona = ?";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, titulo);
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				Libros x = new Libros(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDouble(8));
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
	
	public ArrayList<Libros> filtraLibroXAutor(String autor) {
		ArrayList<Libros> lista = new ArrayList<Libros>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select * from persona where usuarioPersona = ? and contrasenaPersona = ?";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, autor);
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				Libros x = new Libros(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDouble(8));
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
	
	public ArrayList<Libros> filtraLibroXCodigo(String codigo) {
		ArrayList<Libros> lista = new ArrayList<Libros>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select * from persona where usuarioPersona = ? and contrasenaPersona = ?";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, codigo);
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				Libros x = new Libros(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDouble(8));
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
	
	public ArrayList<Libros> filtraLibroXSalida(String fechaEntrada, String fechaSalida) {
		ArrayList<Libros> lista = new ArrayList<Libros>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select * from persona where usuarioPersona = ? and contrasenaPersona = ?";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, fechaEntrada);
			pst.setString(2, fechaSalida);		
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				Libros x = new Libros(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDouble(8));
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
	
	public ArrayList<Libros> filtraLibroXGenero(String genero) {
		ArrayList<Libros> lista = new ArrayList<Libros>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select * from persona where usuarioPersona = ? and contrasenaPersona = ?";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, genero);
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				Libros x = new Libros(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDouble(8));
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

}
