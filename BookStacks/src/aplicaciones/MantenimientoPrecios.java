package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MantenimientoPrecios extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoPrecios frame = new MantenimientoPrecios();
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
	public MantenimientoPrecios() {
		setTitle("Mantenimiento Precios");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDeObjeto = new JLabel("Tipo de Objeto");
		lblTipoDeObjeto.setBounds(12, 24, 122, 16);
		getContentPane().add(lblTipoDeObjeto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(146, 21, 116, 22);
		getContentPane().add(comboBox);
		
		JLabel lblCodigoDeObjeto = new JLabel("Codigo de Objeto:");
		lblCodigoDeObjeto.setBounds(12, 66, 122, 16);
		getContentPane().add(lblCodigoDeObjeto);
		
		textField = new JTextField();
		textField.setBounds(146, 63, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPrecioActual = new JLabel("Precio Actual:");
		lblPrecioActual.setBounds(12, 165, 122, 16);
		getContentPane().add(lblPrecioActual);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 162, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombreDelObjeto = new JLabel("Nombre del Objeto:");
		lblNombreDelObjeto.setBounds(12, 114, 122, 16);
		getContentPane().add(lblNombreDelObjeto);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 111, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPrecioNuevo = new JLabel("Precio Nuevo:");
		lblPrecioNuevo.setBounds(12, 218, 122, 16);
		getContentPane().add(lblPrecioNuevo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 215, 116, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.setBounds(274, 13, 148, 85);
		getContentPane().add(btnProcesar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(274, 115, 148, 85);
		getContentPane().add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(274, 214, 148, 37);
		getContentPane().add(btnLimpiar);

	}

}
