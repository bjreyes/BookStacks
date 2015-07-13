package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.SwingConstants;

import beans.Generos;
import matenimiento.GestionGenero;
import matenimiento.GestionLibro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarObjeto extends JInternalFrame {
	private JTextField txtCodObj;
	private JTextField txtNomObj;
	private JTextField txtImporte;
	private JComboBox<String> cboGenero;
	private JTextField txtNumPag;
	private JComboBox cboIdioma;
	private JComboBox cboObj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarObjeto frame = new AgregarObjeto();
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
	public AgregarObjeto() {
		setClosable(true);
		setTitle("Agregar Objeto");
		setBounds(100, 100, 450, 327);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDeObjeto = new JLabel("Tipo de Objeto:");
		lblTipoDeObjeto.setBounds(12, 13, 105, 16);
		getContentPane().add(lblTipoDeObjeto);
		
		JLabel lblCodigoDelObjeto = new JLabel("Codigo del Objeto:");
		lblCodigoDelObjeto.setBounds(12, 53, 116, 16);
		getContentPane().add(lblCodigoDelObjeto);
		
		txtCodObj = new JTextField();
		txtCodObj.setBounds(141, 50, 126, 22);
		getContentPane().add(txtCodObj);
		txtCodObj.setColumns(10);
		
		JLabel lblNombreDelObjeto = new JLabel("Nombre del Objeto:");
		lblNombreDelObjeto.setBounds(12, 123, 116, 16);
		getContentPane().add(lblNombreDelObjeto);
		
		txtNomObj = new JTextField();
		txtNomObj.setBounds(141, 123, 126, 22);
		getContentPane().add(txtNomObj);
		txtNomObj.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(12, 189, 56, 16);
		getContentPane().add(lblGenero);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(12, 228, 56, 16);
		getContentPane().add(lblIdioma);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (cboGenero.getSelectedIndex()) {
				case 0:
					ingresarLibro();
					break;
				case 1:
					ingresarRevista();
					break;
				default:
					ingresarDisco();
					break;
				}
			}

		});
		btnAgregar.setBounds(287, 57, 135, 82);
		getContentPane().add(btnAgregar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(287, 182, 135, 74);
		getContentPane().add(btnLimpiar);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setBounds(12, 259, 56, 16);
		getContentPane().add(lblImporte);
		
		txtImporte = new JTextField();
		txtImporte.setText("  ");
		txtImporte.setBounds(141, 256, 126, 22);
		getContentPane().add(txtImporte);
		txtImporte.setColumns(10);
		
		cboObj = new JComboBox();
		cboObj.setModel(new DefaultComboBoxModel(new String[] {"Libros", "Revistas", "Discos"}));
		cboObj.setBounds(140, 10, 127, 27);
		getContentPane().add(cboObj);
		
		cboIdioma = new JComboBox();
		cboIdioma.setModel(new DefaultComboBoxModel(new String[] {"Ingles", "Espa\u00F1ol", "Frances", "Portugues", "Italiano", "Latin"}));
		cboIdioma.setBounds(141, 224, 126, 22);
		getContentPane().add(cboIdioma);
		
		cboGenero = new JComboBox();
		cboGenero.setBounds(141, 186, 126, 22);
		getContentPane().add(cboGenero);
		
		JLabel lblNumeroDePaginas = new JLabel("Numero de Paginas :");
		lblNumeroDePaginas.setBounds(12, 153, 130, 23);
		getContentPane().add(lblNumeroDePaginas);
		
		txtNumPag = new JTextField();
		txtNumPag.setBounds(141, 155, 126, 24);
		getContentPane().add(txtNumPag);
		txtNumPag.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor : ");
		lblAutor.setBounds(12, 88, 126, 22);
		getContentPane().add(lblAutor);
		
		JComboBox cboAutor = new JComboBox();
		cboAutor.setBounds(141, 87, 126, 22);
		getContentPane().add(cboAutor);
		llenarCombo();
	}
	void llenarCombo() {
		GestionGenero gg = new GestionGenero();
		ArrayList<Generos> lista = gg.listarGenero(); 
		for (Generos x: lista) {
			cboGenero.addItem(x.getGenero());
		}
	}
	private void ingresarLibro() {
		GestionLibro gl = new GestionLibro();
		gl.añadirLibro(txtNomObj.getText(), Integer.parseInt(txtNumPag.getText()), cboIdioma.getSelectedItem(), , genero, precioPorDia)
		
	}
}
