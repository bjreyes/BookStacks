package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import matenimiento.GestionGenero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AñadirGenero extends JInternalFrame {
	private JTextField txtGenero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirGenero frame = new AñadirGenero();
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
	public AñadirGenero() {
		setTitle("Agregar Genero");
		setClosable(true);
		setBounds(100, 100, 440, 192);
		getContentPane().setLayout(null);
		
		JLabel lblGenero = new JLabel("Genero :");
		lblGenero.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblGenero.setBounds(37, 38, 103, 35);
		getContentPane().add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(155, 40, 200, 35);
		getContentPane().add(txtGenero);
		txtGenero.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestionGenero gg = new GestionGenero();
				if(txtGenero.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Ingresar Genero");
				}else{
				gg.añadirGenero(txtGenero.getText());
				txtGenero.setText("");
				}
			}
		});
		btnAgregar.setBounds(12, 102, 393, 41);
		getContentPane().add(btnAgregar);
	}

}
