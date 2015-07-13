package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import matenimiento.GestionRecomendacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

public class Recomendaciones extends JInternalFrame {
	private JTextField txtNombreObj;
	private JTextField txtAutor;
	private JComboBox cboTipObj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recomendaciones frame = new Recomendaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Recomendaciones() {
		setClosable(true);
		setTitle("Recomendaciones");
		setBounds(100, 100, 281, 218);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDeObjeto = new JLabel("Tipo de Objeto:");
		lblTipoDeObjeto.setBounds(12, 24, 91, 16);
		getContentPane().add(lblTipoDeObjeto);
		
		JLabel lblNombreDelObjeto = new JLabel("Nombre del Objeto:");
		lblNombreDelObjeto.setBounds(12, 57, 118, 16);
		getContentPane().add(lblNombreDelObjeto);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(12, 86, 56, 16);
		getContentPane().add(lblAutor);
		
		cboTipObj = new JComboBox();
		cboTipObj.setModel(new DefaultComboBoxModel(new String[] {"Libro", "Revista", "Disco"}));
		cboTipObj.setBounds(133, 21, 116, 19);
		getContentPane().add(cboTipObj);
		
		txtNombreObj = new JTextField();
		txtNombreObj.setBounds(133, 54, 116, 22);
		getContentPane().add(txtNombreObj);
		txtNombreObj.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(133, 86, 116, 22);
		getContentPane().add(txtAutor);
		txtAutor.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				añadirRecomendacion();
			}
		});
		btnGuardar.setBounds(12, 128, 108, 41);
		getContentPane().add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limpiar();
				
			}
		});
		btnLimpiar.setBounds(141, 128, 108, 41);
		getContentPane().add(btnLimpiar);
	}

	void añadirRecomendacion() {
		
		int id = login.getIdUsuario();
		GestionRecomendacion gr = new GestionRecomendacion();
		try {
			gr.añadirRecomendacion(cboTipObj.getSelectedItem().toString(), txtNombreObj.getText(), txtAutor.getText(), id);
			JOptionPane.showMessageDialog(null, "Recomendacion registrada");
			limpiar();
			
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Error en Registro");
		}
	}
	void limpiar() {
		cboTipObj.setSelectedIndex(1);
		txtNombreObj.setText("");
		txtAutor.setText("");
		cboTipObj.setFocusable(true);
	}

}
