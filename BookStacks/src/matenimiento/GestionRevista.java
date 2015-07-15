package matenimiento;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import utils.MySQLConexion;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GestionRevista {
	public int añadirRevista( String codRevista, String tituloRevista,
			String edicionRevista, int numPaginas, int genero,
			double precioPorDia) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try{
			con = MySQLConexion.getConexion();
			
			String sql = "INSERT INTO revista(codRevista,tituloRevista,edicionRevista,numPagRevista,genero_idgenero,precioPorDiaRevista)VALUES(?,?,?,?,?,?)";
			
			pst = (PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, codRevista);
			pst.setString(2, tituloRevista);
			pst.setString(3, edicionRevista);
			pst.setInt(4, numPaginas);
			pst.setInt(5, genero);
			pst.setDouble(6, precioPorDia);
			
			
			rs =  pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro de Revista Exitoso");
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
