package aplicaciones;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Alquiler extends JInternalFrame {
	private JTextField txtCodAlq;
	private JTextField txtNomCli;
	private JTextField txtCodObj;
	private JTextField txtMontoPagar;
	private JComboBox cboObjeto;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alquiler frame = new Alquiler();
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
	public Alquiler() {
		setClosable(true);
		setTitle("Alquiler");
		setBounds(100, 100, 509, 429);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(12, 27, 56, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Objeto: ");
		label_1.setBounds(12, 27, 56, 16);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Codigo de Alquiler:");
		label_2.setBounds(12, 216, 119, 16);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Fecha de Entrega:");
		label_3.setBounds(12, 97, 105, 16);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Nombre del Cliente:");
		label_4.setBounds(12, 139, 119, 16);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Codigo del Objeto:");
		label_5.setBounds(12, 59, 119, 16);
		getContentPane().add(label_5);
		
		cboObjeto = new JComboBox();
		cboObjeto.setModel(new DefaultComboBoxModel(new String[] {"Libro", "Revista", "Disco"}));
		cboObjeto.setBounds(127, 24, 116, 19);
		getContentPane().add(cboObjeto);
		
		txtCodAlq = new JTextField();
		txtCodAlq.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtCodAlq.setText(generarCodigo());
			}
		});
		txtCodAlq.setColumns(10);
		txtCodAlq.setBounds(127, 213, 116, 22);
		getContentPane().add(txtCodAlq);
		
		JDateChooser dtcFechaEntrega = new JDateChooser();
		dtcFechaEntrega.setBounds(126, 91, 117, 22);
		getContentPane().add(dtcFechaEntrega);
		
		txtNomCli = new JTextField();
		txtNomCli.setColumns(10);
		txtNomCli.setBounds(127, 136, 116, 22);
		getContentPane().add(txtNomCli);
		
		txtCodObj = new JTextField();
		txtCodObj.setColumns(10);
		txtCodObj.setBounds(127, 56, 116, 22);
		getContentPane().add(txtCodObj);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(268, 13, 214, 366);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JButton btnGenerar = new JButton("Generar Boleta");
		btnGenerar.setBounds(137, 332, 119, 47);
		getContentPane().add(btnGenerar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(12, 331, 119, 48);
		getContentPane().add(btnLimpiar);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnProcesar.setBounds(12, 274, 243, 45);
		getContentPane().add(btnProcesar);
		
		JLabel label_6 = new JLabel("Monto a Pagar:");
		label_6.setBounds(12, 181, 119, 16);
		getContentPane().add(label_6);
		
		txtMontoPagar = new JTextField();
		txtMontoPagar.setColumns(10);
		txtMontoPagar.setBounds(127, 178, 116, 22);
		getContentPane().add(txtMontoPagar);
		txtCodAlq.setEditable(false);

	}

	private String generarCodigo() {
		String nom = new String(txtNomCli.getText());
		switch (cboObjeto.getSelectedIndex()) {
		case 0:
			return "L"+ nom.substring(0,1).toUpperCase() + obtenerFechaCod() ;
		case 1:
			return "R"+ nom.substring(0,1).toUpperCase() + obtenerFechaCod() ;
		default:
			return "C"+ nom.substring(0,1).toUpperCase() + obtenerFechaCod() ;
		}
	}

	private String obtenerFechaCod() {
		java.util.Date fecha = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMM");
		Calendar cal = Calendar.getInstance();
		return sdf.format(fecha);
	}
	
	private String obtenerFecha() {
		java.util.Date fecha = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		return sdf.format(fecha);
	}
	
}
