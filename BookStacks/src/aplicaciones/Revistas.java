package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class Revistas extends JInternalFrame {
	private JTable tbRevistasb;
	private JTextField txtBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Revistas frame = new Revistas();
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
	public Revistas() {
		setClosable(true);
		setTitle("Revistas");
		setBounds(100, 100, 469, 517);
		getContentPane().setLayout(null);
		
		tbRevistasb = new JTable();
		tbRevistasb.setBounds(12, 77, 429, 395);
		getContentPane().add(tbRevistasb);
		
		JComboBox cboTipBusqueda = new JComboBox();
		cboTipBusqueda.setModel(new DefaultComboBoxModel(new String[] {"Titulo", "Codigo", "Genero"}));
		cboTipBusqueda.setBounds(12, 13, 121, 35);
		getContentPane().add(cboTipBusqueda);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(141, 13, 196, 35);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(344, 13, 97, 35);
		getContentPane().add(btnBuscar);
		
		JComboBox cboGenero = new JComboBox();
		cboGenero.setBounds(155, 13, 174, 35);
		getContentPane().add(cboGenero);

	}

}
