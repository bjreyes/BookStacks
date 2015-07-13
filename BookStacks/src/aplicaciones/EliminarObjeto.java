package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class EliminarObjeto extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarObjeto frame = new EliminarObjeto();
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
	public EliminarObjeto() {
		setClosable(true);
		setTitle("Eliminar Objeto");
		setBounds(100, 100, 477, 300);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDeObjeto = new JLabel("Tipo de Objeto");
		lblTipoDeObjeto.setBounds(12, 13, 105, 16);
		getContentPane().add(lblTipoDeObjeto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(133, 10, 116, 22);
		getContentPane().add(comboBox);
		
		JLabel lblCodigoDeObjeto = new JLabel("Codigo de Objeto:");
		lblCodigoDeObjeto.setBounds(12, 48, 105, 16);
		getContentPane().add(lblCodigoDeObjeto);
		
		textField = new JTextField();
		textField.setBounds(133, 45, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreDeObjeto = new JLabel("Nombre de Objeto:");
		lblNombreDeObjeto.setBounds(12, 80, 126, 16);
		getContentPane().add(lblNombreDeObjeto);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 77, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 117, 427, 134);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(261, 59, 178, 37);
		getContentPane().add(btnEliminar);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.setBounds(261, 9, 83, 37);
		getContentPane().add(btnProcesar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(356, 9, 83, 37);
		getContentPane().add(btnLimpiar);

	}

}
