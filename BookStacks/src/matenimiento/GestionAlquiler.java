package matenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.MySQLConexion;
import aplicaciones.Alquiler;
import beans.AlquilerDisco;
import beans.AlquilerLibros;
import beans.AlquilerRevistas;
import beans.Personas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GestionAlquiler {

	public ArrayList<AlquilerLibros> listadoAlqLibros() {
		ArrayList<AlquilerLibros> lista = new ArrayList<AlquilerLibros>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select alq.idalquiler, alq.fechaEntrega, alq.fechasalida, per.usuarioPersona , lib.tituloLibro , lib.precioPorDiaLibro, aut.nomAutor , aut.apePatAutor , gen.nomGenero" +
						"from alquiler as alq join persona as per on alq.persona_idpersona = per.idpersona join alquilerlibros as alqLib on alq.idalquiler = alqLib.alquiler_idalquiler "
						+ "join libro as lib on alqLib.libro_idlibro = lib.idlibro join autor as aut on lib.autor_idautor = aut.idautor join genero as gen on lib.genero_idgenero = gen.idgenero ";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				AlquilerLibros x = new AlquilerLibros(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8));
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
	
	public int añadirAlqLibro(int idLibro , String codAlq, String fechaEntrega, String fechaSalida, double montoPagar, int idUsuario, String estadoAlq ) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " insert into persona(usuarioPersona,contrasenaPersona,nombrePersona,apellidoMatPersona,apellidoPatPersona) values (?,?,?,?,?) ";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setInt(1, idLibro);
			pst.setString(2, codAlq);
			pst.setString(3, fechaEntrega);
			pst.setString(4, fechaSalida);
			pst.setDouble(5, montoPagar);
			pst.setInt(6, idUsuario);
			pst.setString(4, estadoAlq);
			
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
	
	public ArrayList<AlquilerRevistas> listadoAlqRevistas() {
		ArrayList<AlquilerRevistas> lista = new ArrayList<AlquilerRevistas>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select alq.idalquiler, alq.fechaEntrega, alq.fechasalida, per.usuarioPersona , lib.tituloLibro , lib.precioPorDiaLibro, aut.nomAutor , aut.apePatAutor , gen.nomGenero" +
						"from alquiler as alq join persona as per on alq.persona_idpersona = per.idpersona join alquilerlibros as alqLib on alq.idalquiler = alqLib.alquiler_idalquiler "
						+ "join libro as lib on alqLib.libro_idlibro = lib.idlibro join autor as aut on lib.autor_idautor = aut.idautor join genero as gen on lib.genero_idgenero = gen.idgenero ";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				AlquilerRevistas x = new AlquilerRevistas(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8));
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
	
	public int añadirAlqRevista(int idRevista , String codAlq, String fechaEntrega, String fechaSalida, double montoPagar, int idUsuario, String estadoAlq ) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " insert into persona(usuarioPersona,contrasenaPersona,nombrePersona,apellidoMatPersona,apellidoPatPersona) values (?,?,?,?,?) ";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setInt(1, idRevista);
			pst.setString(2, codAlq);
			pst.setString(3, fechaEntrega);
			pst.setString(4, fechaSalida);
			pst.setDouble(5, montoPagar);
			pst.setInt(6, idUsuario);
			pst.setString(4, estadoAlq);
			
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
	
	public ArrayList<AlquilerDisco> listadoAlqDiscos() {
		ArrayList<AlquilerDisco> lista = new ArrayList<AlquilerDisco>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select alq.idalquiler, alq.fechaEntrega, alq.fechasalida, per.usuarioPersona , lib.tituloLibro , lib.precioPorDiaLibro, aut.nomAutor , aut.apePatAutor , gen.nomGenero" +
						"from alquiler as alq join persona as per on alq.persona_idpersona = per.idpersona join alquilerlibros as alqLib on alq.idalquiler = alqLib.alquiler_idalquiler "
						+ "join libro as lib on alqLib.libro_idlibro = lib.idlibro join autor as aut on lib.autor_idautor = aut.idautor join genero as gen on lib.genero_idgenero = gen.idgenero ";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				AlquilerDisco x = new AlquilerDisco (rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8));
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
	
public int añadirAlqDisco(int idDisco, String codAlq, String fechaEntrega, String fechaSalida, double montoPagar, int idUsuario, String estadoAlq ) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " insert into persona(usuarioPersona,contrasenaPersona,nombrePersona,apellidoMatPersona,apellidoPatPersona) values (?,?,?,?,?) ";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setInt(1, idDisco);
			pst.setString(2, codAlq);
			pst.setString(3, fechaEntrega);
			pst.setString(4, fechaSalida);
			pst.setDouble(5, montoPagar);
			pst.setInt(6, idUsuario);
			pst.setString(4, estadoAlq);
			
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
