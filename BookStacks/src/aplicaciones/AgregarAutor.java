package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import matenimiento.GestionAutor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarAutor extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField txtApePat;
	private JTextField txtApeMat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarAutor frame = new AgregarAutor();
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
	public AgregarAutor() {
		setTitle("A\u00F1adir Autor");
		setClosable(true);
		setBounds(100, 100, 355, 261);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 22, 94, 27);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno :");
		lblApellidoPaterno.setBounds(10, 61, 131, 27);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno :");
		lblApellidoMaterno.setBounds(10, 103, 131, 27);
		getContentPane().add(lblApellidoMaterno);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 22, 180, 27);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApePat = new JTextField();
		txtApePat.setColumns(10);
		txtApePat.setBounds(133, 61, 180, 27);
		getContentPane().add(txtApePat);
		
		txtApeMat = new JTextField();
		txtApeMat.setColumns(10);
		txtApeMat.setBounds(133, 103, 180, 27);
		getContentPane().add(txtApeMat);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionAutor ga = new GestionAutor();
				ga.añadirAutor(txtNombre.getText(), txtApePat.getText(), txtApeMat.getText());
				limpiar();
			}
		});
		btnAgregar.setBounds(10, 159, 154, 43);
		getContentPane().add(btnAgregar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(182, 159, 131, 43);
		getContentPane().add(btnLimpiar);

	}
	void limpiar(){
		txtNombre.setText("");
		txtApePat.setText("");
		txtApeMat.setText("");
	}
}
