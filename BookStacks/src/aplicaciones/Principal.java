package aplicaciones;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JInternalFrame;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JDesktopPane;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class Principal extends JFrame {
	private JDesktopPane escritorio;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("BookStacks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 553);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(153, 102, 102));
		setJMenuBar(menuBar);
		
		JMenu mnOperacion = new JMenu("Operacion");
		mnOperacion.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		menuBar.add(mnOperacion);
		
		JMenuItem mntmAlquiler = new JMenuItem("Alquiler");
		mntmAlquiler.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		mntmAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Alquiler alq = new Alquiler();
				alq.setVisible(true);
				escritorio.add(alq);
			}

		});
		mnOperacion.add(mntmAlquiler);
		
		JMenuItem mntmRecomendacion = new JMenuItem("Recomendacion");
		mntmRecomendacion.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		mntmRecomendacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recomendaciones recon = new Recomendaciones();
				recon.setVisible(true);
				escritorio.add(recon);
			}
		});
		mnOperacion.add(mntmRecomendacion);
		
		JMenuItem mntmEntrega = new JMenuItem("Entrega");
		mntmEntrega.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		mntmEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrega entre = new Entrega();
				entre.setVisible(true);
				escritorio.add(entre);   
			}
		});
		mnOperacion.add(mntmEntrega);
		
		JMenu mnSalir = new JMenu("Salir");
		mnSalir.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		mnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int  ok = JOptionPane.showConfirmDialog(mnSalir,"¿Estas seguro de salir?");
				if (ok == 0)
					System.exit(0);
			}
		});
		
		JMenu mnReportes = new JMenu("Reportes");
		mnReportes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		menuBar.add(mnReportes);
		
		JMenuItem mntmLibros = new JMenuItem("Libros");
		mntmLibros.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		mntmLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Libros lib = new Libros();
				lib.setVisible(true);
				escritorio.add(lib);
			}
		});
		mnReportes.add(mntmLibros);
		
		JMenuItem mntmRevistas = new JMenuItem("Revistas");
		mntmRevistas.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		mntmRevistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Revistas rev = new Revistas();
				rev.setVisible(true);
				escritorio.add(rev);
			}
		});
		mnReportes.add(mntmRevistas);
		
		JMenuItem mntmDiscos = new JMenuItem("Discos");
		mntmDiscos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		mntmDiscos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Discos disc = new Discos();
				disc.setVisible(true);
				escritorio.add(disc);
			}
		});
		mnReportes.add(mntmDiscos);
		
		JMenu mnConfig = new JMenu("Usuario");
		mnConfig.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		menuBar.add(mnConfig);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cambiar contrase\u00F1a");
		mntmNewMenuItem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarContraseña cc = new CambiarContraseña();
				cc.setVisible(true);
				escritorio.add(cc);
			}
		});
		mnConfig.add(mntmNewMenuItem);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int  ok = JOptionPane.showConfirmDialog(mnSalir,"¿Deseas Cerrar sesion?");
				if (ok == 0){
					cerrarPricipal();
					login l = new login();
					l.setVisible(true);
				}
			}
		});
		mntmCerrarSesion.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		mnConfig.add(mntmCerrarSesion);
		
		JMenu mnConfiguracion = new JMenu("Mantenimiento");
		mnConfiguracion.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		menuBar.add(mnConfiguracion);
		
		JMenuItem mntmNuevoObjeto = new JMenuItem("Agregar Objeto");
		mntmNuevoObjeto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		mntmNuevoObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarObjeto agObj = new AgregarObjeto();
				agObj.setVisible(true);
				escritorio.add(agObj);
			}
		});
		mnConfiguracion.add(mntmNuevoObjeto);
		
		JMenuItem mntmEliminarObjeto = new JMenuItem("Eliminar Objeto");
		mntmEliminarObjeto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		mntmEliminarObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarObjeto elmObj = new EliminarObjeto();
				elmObj.setVisible(true);
				escritorio.add(elmObj);
			}
		});
		
		JMenuItem mntmAgregarGenero = new JMenuItem("Agregar Genero");
		mntmAgregarGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AñadirGenero a = new AñadirGenero();
				a.setVisible(true);
				escritorio.add(a);
			}
		});
		mntmAgregarGenero.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		mnConfiguracion.add(mntmAgregarGenero);
		
		JMenuItem mntmAgregarAutor = new JMenuItem("Agregar Autor");
		mntmAgregarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarAutor au = new AgregarAutor();
				au.setVisible(true);
				escritorio.add(au);
			}
		});
		mntmAgregarAutor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		mnConfiguracion.add(mntmAgregarAutor);
		mnConfiguracion.add(mntmEliminarObjeto);
		menuBar.add(mnSalir);
		getContentPane().setLayout(null);
		
		escritorio = new JDesktopPane();
		escritorio.setBounds(0, 0, 658, 480);
		getContentPane().add(escritorio);
	}
	private void cerrarPricipal() {
		this.dispose();
	}
}
