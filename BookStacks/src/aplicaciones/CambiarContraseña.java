package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CambiarContraseña extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiarContraseña frame = new CambiarContraseña();
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
	public CambiarContraseña() {
		setTitle("Cambiar Contrase\u00F1a");
		setClosable(true);
		setBounds(100, 100, 450, 183);
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(12, 23, 56, 16);
		getContentPane().add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(140, 20, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a Actual: ");
		lblContraseaActual.setBounds(12, 69, 116, 16);
		getContentPane().add(lblContraseaActual);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 66, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblContraseaNueva = new JLabel("Contrase\u00F1a Nueva:");
		lblContraseaNueva.setBounds(12, 118, 125, 16);
		getContentPane().add(lblContraseaNueva);
		
		textField_2 = new JTextField();
		textField_2.setBounds(140, 115, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.setBounds(262, 13, 160, 48);
		getContentPane().add(btnCambiar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(262, 86, 160, 48);
		getContentPane().add(btnLimpiar);

	}

}
