package matenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.MySQLConexion;
import beans.Generos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GestionGenero {
	public ArrayList<Generos> listarGenero () {
		ArrayList<Generos> lista = new ArrayList<Generos>();
		
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " select * from genero ";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			ResultSet rs =  pst.executeQuery();
			
			while(rs.next()){
				Generos x = new Generos(rs.getInt(1), rs.getString(2));
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

	public int añadirGenero(String genero) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = " INSERT INTO genero (nomGenero) VALUES(?);";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, genero);
			
			rs =  pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
		
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
