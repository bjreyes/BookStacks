package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Entrega extends JInternalFrame {
	private JTextField txtCodAlq;
	private JTextField txtNombreObj;
	private JTextField txtImporte;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrega frame = new Entrega();
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
	public Entrega() {
		setClosable(true);
		setTitle("Entrega");
		setBounds(100, 100, 450, 428);
		getContentPane().setLayout(null);
		
		JLabel lblCodigoDeAlquiler = new JLabel("Codigo de Alquiler:");
		lblCodigoDeAlquiler.setBounds(12, 13, 118, 16);
		getContentPane().add(lblCodigoDeAlquiler);
		
		txtCodAlq = new JTextField();
		txtCodAlq.setBounds(142, 10, 116, 22);
		getContentPane().add(txtCodAlq);
		txtCodAlq.setColumns(10);
		
		JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega:");
		lblFechaDeEntrega.setBounds(12, 47, 118, 16);
		getContentPane().add(lblFechaDeEntrega);
		
		JDateChooser dcFechEntrega = new JDateChooser();
		dcFechEntrega.setBounds(142, 47, 116, 22);
		getContentPane().add(dcFechEntrega);
		
		JLabel lblNombreDel = new JLabel("Nombre del Objeto:");
		lblNombreDel.setBounds(12, 92, 118, 16);
		getContentPane().add(lblNombreDel);
		
		txtNombreObj = new JTextField();
		txtNombreObj.setBounds(142, 89, 116, 22);
		getContentPane().add(txtNombreObj);
		txtNombreObj.setColumns(10);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setBounds(12, 189, 56, 16);
		getContentPane().add(lblImporte);
		
		txtImporte = new JTextField();
		txtImporte.setBounds(142, 186, 116, 22);
		getContentPane().add(txtImporte);
		txtImporte.setColumns(10);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.setBounds(270, 13, 152, 50);
		getContentPane().add(btnProcesar);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(270, 83, 152, 50);
		getContentPane().add(btnGenerar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(270, 158, 152, 50);
		getContentPane().add(btnLimpiar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 228, 410, 151);
		getContentPane().add(scrollPane);
		
		JTextArea txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JLabel lblNombreDelCliente = new JLabel("Nombre del Cliente:");
		lblNombreDelCliente.setBounds(12, 143, 118, 16);
		getContentPane().add(lblNombreDelCliente);
		
		textField = new JTextField();
		textField.setBounds(142, 140, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);

	}
}
