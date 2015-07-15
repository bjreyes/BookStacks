package matenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.MySQLConexion;
import beans.Autor;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GestionAutor {
public int añadirAutor(String nomAutor, String apePatAutor,
		String apeMatAutor ) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = "INSERT INTO autor (`nomAutor`,`apePatAutor`,`apeMatAutor`) VALUES (?,?,?)";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, nomAutor);
			pst.setString(2, apePatAutor);
			pst.setString(3, apeMatAutor);
			
			rs =  pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
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

	public ArrayList<Autor> listadoAutores() {
	ArrayList<Autor> lista = new ArrayList<Autor>();
	
	Connection con = null;
	PreparedStatement pst = null;
	try{
		con = MySQLConexion.getConexion();
		
		String sql = " select * from autor ";
		
		pst = (PreparedStatement) con.prepareStatement(sql);
		
		ResultSet rs =  pst.executeQuery();
		
		while(rs.next()){
			Autor x = new Autor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
}
