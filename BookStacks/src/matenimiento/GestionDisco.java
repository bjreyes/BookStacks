package matenimiento;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import utils.MySQLConexion;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GestionDisco {
		
		public int añadirDisco(String codDisco, String nomDisco,
				String tamañoDisco, int genero, double precioPorDia) {
			
			Connection con = null;
			PreparedStatement pst = null;
			int rs = 0;
			try{
				con = MySQLConexion.getConexion();
				
				String sql = " INSERT INTO disco (codDiscol,nomDisco,tamanoDisco,genero_idgenero,precioPorDiaDisco)VALUES(?,?,?,?,?);";
				
				pst = (PreparedStatement) con.prepareStatement(sql);
				
				pst.setString(1, codDisco);
				pst.setString(2, nomDisco);
				pst.setString(3, tamañoDisco);
				pst.setInt(4, genero);
				pst.setDouble(5, precioPorDia);
				
				
				rs =  pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Registro de Disco"
						+ " Exitoso");
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
