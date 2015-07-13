package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;

public class Libros extends JInternalFrame {
	private JTextField txtBuscar;
	private JTable tblLibros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Libros frame = new Libros();
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
	public Libros() {
		setClosable(true);
		setTitle("Libros");
		setBounds(100, 100, 499, 565);
		getContentPane().setLayout(null);
		
		JComboBox cboTipBusqueda = new JComboBox();
		cboTipBusqueda.setModel(new DefaultComboBoxModel(new String[] {"Titulo", "Autor", "Codigo", "Genero"}));
		cboTipBusqueda.setBounds(12, 14, 97, 36);
		getContentPane().add(cboTipBusqueda);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(374, 13, 97, 37);
		getContentPane().add(btnBuscar);
		
		tblLibros = new JTable();
		tblLibros.setBounds(12, 63, 459, 453);
		getContentPane().add(tblLibros);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(115, 14, 247, 36);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JComboBox cboGenero = new JComboBox();
		cboGenero.setEnabled(false);
		cboGenero.setBounds(149, 14, 178, 36);
		getContentPane().add(cboGenero);

	}
}
