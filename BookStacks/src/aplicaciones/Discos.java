package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class Discos extends JInternalFrame {
	private JTable tbDiscos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Discos frame = new Discos();
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
	public Discos() {
		setClosable(true);
		setTitle("Discos");
		setBounds(100, 100, 473, 300);
		getContentPane().setLayout(null);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(12, 13, 56, 16);
		getContentPane().add(lblGenero);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(64, 10, 81, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Idioma:");
		lblNewLabel.setBounds(157, 13, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(210, 10, 88, 19);
		getContentPane().add(comboBox_1);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(312, 13, 56, 16);
		getContentPane().add(lblEstado);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(380, 10, 65, 19);
		getContentPane().add(comboBox_2);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(12, 46, 212, 22);
		getContentPane().add(btnBuscar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(241, 45, 204, 23);
		getContentPane().add(btnLimpiar);
		
		tbDiscos = new JTable();
		tbDiscos.setBounds(12, 81, 433, 170);
		getContentPane().add(tbDiscos);

	}

}
