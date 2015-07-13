package aplicaciones;

import java.awt.BorderLayout;




import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import beans.Personas;
import matenimiento.GestionPersonas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class CrearCuenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsu;
	private JPasswordField txtPass;
	private JTextField txtNombre;
	private JTextField txtApellidoMat;
	private JTextField txtApellidoPat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearCuenta dialog = new CrearCuenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearCuenta() {
		setTitle("Crear Cuenta");
		setBounds(100, 100, 288, 352);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(12, 147, 56, 16);
			contentPanel.add(lblUsuario);
		}
		{
			txtUsu = new JTextField();
			txtUsu.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					txtUsu.setText(generarUsuario());
				}
			});
			txtUsu.setBounds(140, 144, 116, 22);
			contentPanel.add(txtUsu);
			txtUsu.setColumns(10);
		}
		{
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setBounds(12, 192, 70, 16);
			contentPanel.add(lblContrasea);
		}
		
		txtPass = new JPasswordField();
		txtPass.setBounds(140, 190, 116, 19);
		contentPanel.add(txtPass);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirPersona();
			}
		});
		btnCrear.setBounds(12, 236, 135, 54);
		contentPanel.add(btnCrear);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(159, 236, 97, 54);
		contentPanel.add(btnLimpiar);
		
		JLabel lblNombre = new JLabel(" Nombre :");
		lblNombre.setBounds(12, 30, 70, 16);
		contentPanel.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellido Paterno :");
		lblApellidos.setBounds(12, 75, 116, 16);
		contentPanel.add(lblApellidos);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(140, 27, 116, 22);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidoMat = new JTextField();
		txtApellidoMat.setColumns(10);
		txtApellidoMat.setBounds(140, 107, 116, 22);
		contentPanel.add(txtApellidoMat);
		
		txtApellidoPat = new JTextField();
		txtApellidoPat.setColumns(10);
		txtApellidoPat.setBounds(140, 72, 116, 22);
		contentPanel.add(txtApellidoPat);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno :");
		lblApellidoMaterno.setBounds(12, 110, 116, 16);
		contentPanel.add(lblApellidoMaterno);
		
	}

	protected void limpiar() {
		txtNombre.setText(null);
		txtApellidoPat.setText(null);
		txtApellidoMat.setText(null);
		txtUsu.setText(null);
		txtPass.setText(null);
	}

	protected void añadirPersona() {
		GestionPersonas gp = new GestionPersonas();
		ArrayList<Personas> lista =  gp.listadoPersonas();
		for (Personas p : lista) {
			if(p.getUsuarioPersona().equals(generarUsuario())){
				JOptionPane.showMessageDialog(null, "Usuario Repetido");
			}else{
				gp.añadirPersona(txtUsu.getText(), String.valueOf(txtPass.getPassword()), txtNombre.getText(), txtApellidoPat.getText(), txtApellidoMat.getText());
				
				JOptionPane.showMessageDialog(null, "CUENTA CREADA \n" + "Nombre : " + txtNombre.getText() + "\n" +
																		 "Apellidos: " + txtApellidoPat.getText() + " " + txtApellidoMat.getText() + "\n" + 
																		 "Usuario: " + txtUsu.getText() + "\n");
				cerrarVentana();
			}
		}
	}

	private String generarUsuario() {
		String str = new String(txtNombre.getText());
		String usu = str.substring(0, 1).toLowerCase() + txtApellidoPat.getText().toLowerCase();  
		return usu;
	}
	
	void cerrarVentana(){
		this.dispose();
	}
}
