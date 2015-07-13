package aplicaciones;
import hilos.HiloBarra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import beans.Personas;
import matenimiento.GestionPersonas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class login extends JFrame {
	private JTextField txtUsuario;
	private JPasswordField pswClave;
	public static JProgressBar barra;
	public static int idUsuario;

	public static int getIdUsuario() {
		return idUsuario;
	}

	public static void setIdUsuario(int idUsuario) {
		login.idUsuario = idUsuario;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			JOptionPane.showMessageDialog(null, "Libreria no soportada");
		} 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("BookStacks - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 350);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUsuario.setBounds(12, 40, 96, 16);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave :");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblClave.setBounds(12, 123, 96, 16);
		contentPane.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Verdana", Font.PLAIN, 17));
		txtUsuario.setBounds(12, 69, 248, 41);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valida();
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIngresar.setBounds(12, 207, 121, 56);
		contentPane.add(btnIngresar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalir.setBounds(145, 207, 89, 56);
		contentPane.add(btnSalir);
		
		pswClave = new JPasswordField();
		pswClave.setFont(new Font("Verdana", Font.PLAIN, 17));
		pswClave.setBounds(12, 152, 248, 42);
		contentPane.add(pswClave);
		
		barra = new JProgressBar();
		barra.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				abrirPrincipal();
			}

		});
		barra.setBounds(0, 0, 443, 16);
		contentPane.add(barra);
		
		JLabel label = new JLabel("");
		label.setBounds(273, 42, 147, 212);
		contentPane.add(label);
		
		JLabel lblCrearNuevaCuenta = new JLabel("Crear nueva cuenta");
		lblCrearNuevaCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CrearCuenta crear = new CrearCuenta();
				crear.setVisible(true);
			}
		});
		lblCrearNuevaCuenta.setBounds(12, 274, 128, 16);
		contentPane.add(lblCrearNuevaCuenta);
	}
	void valida() {
		String usuario = null;
		String clave = null;
		if(txtUsuario.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Ingresar Usuario");
			txtUsuario.setText("");
		}else{
			usuario = txtUsuario.getText();
		}
		if(String.valueOf(pswClave.getPassword()).isEmpty()){
			JOptionPane.showMessageDialog(null, "Ingresar Contraseña");
			pswClave.setText("");
		}else{
			clave = String.valueOf(pswClave.getPassword());
		}
		GestionPersonas gp = new GestionPersonas();
		ArrayList<Personas> lista = gp.validarPersona(usuario, clave);
		
		if(lista.size() == 0){
			JOptionPane.showMessageDialog(null, "Datos Incorreptos");
			limpiar();
		} else {
			setIdUsuario(lista.get(0).getIdpersona());
			JOptionPane.showMessageDialog(null, "BIENVENIDO \n" + lista.get(0).getNombrePersona() + " " + lista.get(0).getApePatPersona());
			ejecutaHiloBarra();
		}
	}

	private void limpiar() {
		txtUsuario.setText("");
		pswClave.setText("");
		
	}
	
	void ejecutaHiloBarra() {
		barra.setVisible(true);
		HiloBarra hilo = new HiloBarra();
		hilo.start();
	}
	
	private void abrirPrincipal() {
		if(barra.getValue()==100) {
			this.dispose();
			Principal p = new Principal();
			p.setVisible(true);
		}
		
	}
	
}
