package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.SwingConstants;

import beans.Autor;
import beans.Disco;
import beans.Generos;
import beans.Libro;
import beans.Revista;
import matenimiento.GestionAutor;
import matenimiento.GestionDisco;
import matenimiento.GestionGenero;
import matenimiento.GestionLibro;
import matenimiento.GestionRevista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AgregarObjeto extends JInternalFrame {
	private JTextField txtCodObj;
	private JTextField txtNomObj;
	private JTextField txtImporte;
	private JComboBox<String> cboGenero;
	private JTextField txtNumPag;
	private JComboBox cboIdioma;
	private JComboBox cboObj;
	private JComboBox<String> cboAutor;
	private JTextField txtEdicion;
	private JLabel lblAutor;
	private JLabel lblIdioma;
	private JLabel lblNumeroDePaginas;
	private JTable tbLibros;
	private JButton btnEliminar;
	private JTable tbRevistas;
	private JTable tbDiscos;
	private JButton btnAgregar;
	
	int filasL;
	int filasR;
	int filasC;
	
	ArrayList<Libro> aLibros = new ArrayList<Libro>();
	ArrayList<Revista> aRevista = new ArrayList<Revista>();
	ArrayList<Disco> aDisco = new ArrayList<Disco>();
	private JScrollPane spTBRevistas;
	private JScrollPane spTBLibros;
	private JScrollPane spTBDiscos;

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
		setBounds(100, 100, 872, 420);
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
		
		JLabel lblNombreDelObjeto = new JLabel("Titulo del Objeto:");
		lblNombreDelObjeto.setBounds(12, 123, 116, 16);
		getContentPane().add(lblNombreDelObjeto);
		
		txtNomObj = new JTextField();
		txtNomObj.setBounds(141, 123, 126, 22);
		getContentPane().add(txtNomObj);
		txtNomObj.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(12, 189, 56, 16);
		getContentPane().add(lblGenero);
		
		lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(12, 228, 56, 16);
		getContentPane().add(lblIdioma);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (cboObj.getSelectedIndex()) {
				case 0:
					pintarLibro();
					break;
				case 1:
					pintarRevista();
					break;
				default:
					pintarDisco();
					break;
				}
			}

		});
		btnAgregar.setBounds(12, 309, 255, 58);
		getContentPane().add(btnAgregar);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setBounds(12, 259, 56, 16);
		getContentPane().add(lblImporte);
		
		txtImporte = new JTextField();
		txtImporte.setText("  ");
		txtImporte.setBounds(141, 256, 126, 22);
		getContentPane().add(txtImporte);
		txtImporte.setColumns(10);
		
		cboObj = new JComboBox();
		cboObj.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch (cboObj.getSelectedIndex()) {
				case 0:
					modoLibro();
					break;
				case 1:
					modoRevista();
					break;
				default:
					modoDisco();
					break;
				}
			}
		});
		cboObj.setModel(new DefaultComboBoxModel(new String[] {"Libros", "Revistas", "Discos"}));
		cboObj.setBounds(140, 10, 127, 27);
		getContentPane().add(cboObj);
		
		cboIdioma = new JComboBox();
		cboIdioma.setModel(new DefaultComboBoxModel(new String[] {"Ingrese Idioma", "Ingles", "Espa\u00F1ol", "Frances", "Portugues", "Italiano", "Latin"}));
		cboIdioma.setBounds(141, 224, 126, 22);
		getContentPane().add(cboIdioma);
		
		cboGenero = new JComboBox();
		cboGenero.setModel(new DefaultComboBoxModel(new String[] {"Ingrese Genero"}));
		cboGenero.setBounds(141, 186, 126, 22);
		getContentPane().add(cboGenero);
		
		lblNumeroDePaginas = new JLabel("Numero de Paginas :");
		lblNumeroDePaginas.setBounds(12, 153, 130, 23);
		getContentPane().add(lblNumeroDePaginas);
		
		txtNumPag = new JTextField();
		txtNumPag.setBounds(141, 155, 126, 24);
		getContentPane().add(txtNumPag);
		txtNumPag.setColumns(10);
		
		lblAutor = new JLabel("Autor : ");
		lblAutor.setBounds(12, 88, 126, 22);
		getContentPane().add(lblAutor);
		
		cboAutor = new JComboBox();
		cboAutor.setModel(new DefaultComboBoxModel(new String[] {"Ingrese Autor"}));
		cboAutor.setBounds(141, 87, 126, 22);
		getContentPane().add(cboAutor);
		
		txtEdicion = new JTextField();
		txtEdicion.setBounds(141, 223, 126, 27);
		getContentPane().add(txtEdicion);
		txtEdicion.setColumns(10);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
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
		btnGrabar.setBounds(596, 317, 155, 42);
		getContentPane().add(btnGrabar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (cboObj.getSelectedIndex()) {
				case 0:
					DefaultTableModel modeloLib = (DefaultTableModel) tbLibros.getModel();
			        int filaLib = tbLibros.getSelectedRow();

			        modeloLib.removeRow(filaLib);
			        Libro tmpL = new Libro(txtCodObj.getText(), txtNomObj.getText(), leerPaginas(), cboIdioma.getSelectedItem().toString(), cboAutor.getSelectedIndex(), cboGenero.getSelectedIndex(),Double.parseDouble(txtImporte.getText()));
			        aLibros.remove(tmpL);
			        limpiarDatos();
					break;
				case 1:
					DefaultTableModel modeloRev = (DefaultTableModel) tbRevistas.getModel();
			        int filaRev = tbRevistas.getSelectedRow();

			        modeloRev.removeRow(filaRev);
			        Revista tmpR = new Revista(txtCodObj.getText(), txtNomObj.getText(), txtEdicion.getText(),Integer.parseInt(txtNumPag.getText()),cboGenero.getSelectedIndex(), Double.parseDouble(txtImporte.getText()));
			        aRevista.remove(tmpR);
			        limpiarDatos();
					break;
				default :
					DefaultTableModel modeloDisc = (DefaultTableModel) tbDiscos.getModel();
			        int filaDisc = tbDiscos.getSelectedRow();

			        modeloDisc.removeRow(filaDisc);
			        Disco tmpD = new Disco(txtCodObj.getText(),  txtNomObj.getText(), txtNumPag.getText(), cboGenero.getSelectedIndex(), Double.parseDouble(txtImporte.getText()));
			        aDisco.remove(tmpD);
			        limpiarDatos();
					break;
				}
				
			}
		});
		btnEliminar.setBounds(379, 317, 155, 42);
		getContentPane().add(btnEliminar);
		
		spTBLibros = new JScrollPane();
		spTBLibros.setBounds(291, 13, 544, 284);
		getContentPane().add(spTBLibros);
		
		tbLibros = new JTable();
		spTBLibros.setViewportView(tbLibros);
		tbLibros.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Titulo", "Num de Paginas", "Idioma", "Autor", "Genero", "Importe"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, String.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				capturaLibrosTbl();
			}
		});
		//tbLibros.getColumnModel().getColumn(1).setPreferredWidth(132);
		//tbLibros.getColumnModel().getColumn(2).setPreferredWidth(110);
		
		spTBRevistas = new JScrollPane();
		spTBRevistas.setBounds(291, 13, 544, 284);
		getContentPane().add(spTBRevistas);
		
		tbRevistas = new JTable();
		tbRevistas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Edicion", "Num de Paginas", "Genero", "Importe"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbRevistas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				capturaRevistasTbl();
			}
		});
		spTBRevistas.setViewportView(tbRevistas);
		tbRevistas.setVisible(false);
		
		spTBDiscos = new JScrollPane();
		spTBDiscos.setBounds(291, 13, 544, 284);
		getContentPane().add(spTBDiscos);
		
		tbDiscos = new JTable();
		tbDiscos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Tama\u00F1o", "Genero", "Importe"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbDiscos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				capturaDiscosTbl();
			}
		});
		spTBDiscos.setViewportView(tbDiscos);
		tbDiscos.setVisible(false);
		spTBRevistas.setVisible(true);
		spTBDiscos.setVisible(false);
		llenarCombo();
		llenarAutores();
		txtEdicion.setVisible(false);
		bloqueEliminar(false);
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
		gl.añadirLibro(txtNomObj.getText(), Integer.parseInt(txtNumPag.getText()), cboIdioma.getSelectedItem().toString(), cboAutor.getSelectedIndex(), cboGenero.getSelectedIndex(), Double.parseDouble(txtImporte.getText()));
		JOptionPane.showMessageDialog(null, "Registro de Libro existoso");
	}
	
	private void ingresarRevista() {
		GestionRevista gr = new GestionRevista();
		gr.añadirRevista(txtCodObj.getText(), txtNomObj.getText(), txtEdicion.getText(),Integer.parseInt(txtNumPag.getText()),cboGenero.getSelectedIndex(), Double.parseDouble(txtImporte.getText()));
		JOptionPane.showMessageDialog(null, "Registro de Revista existoso");
	}
	
	private void ingresarDisco() {;
		GestionDisco gd = new GestionDisco();
		gd.añadirDisco(txtCodObj.getText(),  txtNomObj.getText(), txtNumPag.getText(), cboGenero.getSelectedIndex(), Double.parseDouble(txtImporte.getText()));
		JOptionPane.showMessageDialog(null, "Registro de Disco existoso");
	}
	
	void modoRevista() {
		lblAutor.setVisible(false);
		cboAutor.setVisible(false);
		cboIdioma.setVisible(false);
		lblIdioma.setText("Edicion :");
		lblNumeroDePaginas.setText("Numero de Paginas :");
		txtEdicion.setVisible(true);
		lblIdioma.setVisible(true);
		spTBDiscos.setVisible(false);
		spTBRevistas.setVisible(true);
		spTBLibros.setVisible(false);
	}
	void modoLibro() {
		lblAutor.setVisible(true);
		cboAutor.setVisible(true);
		cboIdioma.setVisible(true);
		lblIdioma.setVisible(true);
		lblIdioma.setText("Idioma :");
		lblNumeroDePaginas.setText("Numero de Paginas :");
		txtEdicion.setVisible(false);
		spTBDiscos.setVisible(false);
		spTBRevistas.setVisible(false);
		spTBLibros.setVisible(true);
	}
	
	void modoDisco() {
		lblAutor.setVisible(false);
		cboAutor.setVisible(false);
		cboIdioma.setVisible(false);
		txtEdicion.setVisible(false);
		lblIdioma.setVisible(false);
		lblNumeroDePaginas.setText("Tamaño :");
		spTBDiscos.setVisible(true);
		spTBRevistas.setVisible(false);
		spTBLibros.setVisible(false);
	}
	
	void llenarAutores() {
		GestionAutor ga = new GestionAutor();
		ArrayList<Autor> lista = ga.listadoAutores();
		for (Autor at : lista) {
			String autor = at.getNomAutor() + " " + at.getApePatAutor() + " " + at.getApeMatAutor();
			cboAutor.addItem(autor);
		}
	}
	
	private void pintarLibro() {
	
		if (!txtCodObj.getText().isEmpty()  && !txtNomObj.getText().isEmpty() && cboAutor.getSelectedIndex() > 0 && cboGenero.getSelectedIndex() > 0 && cboIdioma.getSelectedIndex() > 0) {
			
            DefaultTableModel modelo = (DefaultTableModel) tbLibros.getModel();
            String opcion = btnAgregar.getText();
            
            Object[] datos = {txtCodObj.getText(), txtNomObj.getText(),leerPaginas(), cboIdioma.getSelectedItem().toString(), cboAutor.getSelectedItem(), cboGenero.getSelectedItem(), leerPrecio()};
            Libro tmp = new Libro(txtCodObj.getText(), txtNomObj.getText(), leerPaginas(), cboIdioma.getSelectedItem().toString(), cboAutor.getSelectedIndex(), cboGenero.getSelectedIndex(),Double.parseDouble(txtImporte.getText()));
            if (opcion.equals("Actualizar")) {
                for (int i = 0; i < datos.length; i++) {
                    modelo.setValueAt(datos[i], filasL, i);
                }
                aLibros.remove(filasL);
                aLibros.add(filasL, tmp);

            } else {
                modelo.addRow(datos);
                aLibros.add(tmp);
            }
            limpiarDatos();

        } else {
            JOptionPane.showMessageDialog(null, "Complete los datos!!!");
        }
		
	}
	
	private void pintarRevista() {
		if (!txtCodObj.getText().isEmpty()  && !txtNomObj.getText().isEmpty() && cboGenero.getSelectedIndex() > 0) {
            DefaultTableModel modelo = (DefaultTableModel) tbRevistas.getModel();
            String opcion = btnAgregar.getText();
            
            Object[] datos = {txtCodObj.getText(), txtNomObj.getText(), txtEdicion.getText(),Integer.parseInt(txtNumPag.getText()),cboGenero.getSelectedItem().toString(), Double.parseDouble(txtImporte.getText())};
            Revista tmp = new Revista(txtCodObj.getText(), txtNomObj.getText(), txtEdicion.getText(),Integer.parseInt(txtNumPag.getText()),cboGenero.getSelectedIndex(), Double.parseDouble(txtImporte.getText()));
            if (opcion.equals("Actualizar")) {
                for (int i = 0; i < datos.length; i++) {
                    modelo.setValueAt(datos[i], filasR, i);
                }
                aRevista.remove(filasR);
                aRevista.add(filasR, tmp);

            } else {
                modelo.addRow(datos);
                aRevista.add(tmp);
            }
            limpiarDatos();

        } else {
            JOptionPane.showMessageDialog(null, "Complete los datos!!!");
        }
		
	}
	private void pintarDisco() {
		
		if (!txtCodObj.getText().isEmpty()  && !txtNomObj.getText().isEmpty() && cboGenero.getSelectedIndex() > 0) {

            DefaultTableModel modelo = (DefaultTableModel) tbDiscos.getModel();
            String opcion = btnAgregar.getText();
            
            Object[] datos = {txtCodObj.getText(),  txtNomObj.getText(), txtNumPag.getText(), cboGenero.getSelectedItem().toString(), Double.parseDouble(txtImporte.getText())};
            Disco tmp = new Disco(txtCodObj.getText(),  txtNomObj.getText(), txtNumPag.getText(), cboGenero.getSelectedIndex(), Double.parseDouble(txtImporte.getText()));
            if (opcion.equals("Actualizar")) {
                for (int i = 0; i < datos.length; i++) {
                    modelo.setValueAt(datos[i], filasC, i);
                }
                aDisco.remove(filasC);
                aDisco.add(filasC, tmp);

            } else {
                modelo.addRow(datos);
                aDisco.add(tmp);
            }

            limpiarDatos();

        } else {
            JOptionPane.showMessageDialog(null, "Complete los datos!!!");
        }
		
	}

	private void limpiarDatos() {
		txtCodObj.setText("");
		txtEdicion.setText("");
		txtImporte.setText("");
		txtNomObj.setText("");
		txtNumPag.setText("");
		cboAutor.setSelectedIndex(0);
		cboGenero.setSelectedIndex(0);
		cboIdioma.setSelectedIndex(0);
	}

	private Object leerPrecio() {
		try {
			return Double.parseDouble(txtImporte.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingresar correctamente Importe");
		}
		return null;
	}

	private int leerPaginas() {
		try {
			return Integer.parseInt(txtNumPag.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingresar correctamente numero de paginas");
		}
		return (Integer) null;
	}
	private void capturaLibrosTbl() {
		int filselect = tbLibros.getSelectedRow();
        txtCodObj.setText(tbLibros.getValueAt(filselect, 0).toString());
        txtNomObj.setText(tbLibros.getValueAt(filselect, 1).toString());
        txtNumPag.setText((tbLibros.getValueAt(filselect, 2).toString()));
        cboIdioma.setSelectedItem((tbLibros.getValueAt(filselect, 3).toString()));
        cboAutor.setSelectedItem((tbLibros.getValueAt(filselect, 4).toString()));
        cboGenero.setSelectedItem((tbLibros.getValueAt(filselect, 5).toString()));
        txtImporte.setText((tbLibros.getValueAt(filselect, 6).toString()));

        filasL = filselect;
        bloqueEliminar(true);
	}

	private void capturaRevistasTbl() {
		int filselect = tbRevistas.getSelectedRow();
        txtCodObj.setText(tbRevistas.getValueAt(filselect, 0).toString());
        txtNomObj.setText(tbRevistas.getValueAt(filselect, 1).toString());
        txtEdicion.setText((tbRevistas.getValueAt(filselect, 2).toString()));
        txtNumPag.setText((tbRevistas.getValueAt(filselect, 3).toString()));
        cboGenero.setSelectedItem((tbRevistas.getValueAt(filselect, 4).toString()));
        txtImporte.setText((tbRevistas.getValueAt(filselect, 6).toString()));

        filasR = filselect;
        bloqueEliminar(true);
	}
	private void capturaDiscosTbl() {
		int filselect = tbRevistas.getSelectedRow();
        txtCodObj.setText(tbRevistas.getValueAt(filselect, 0).toString());
        txtNomObj.setText(tbRevistas.getValueAt(filselect, 1).toString());
        txtNumPag.setText((tbRevistas.getValueAt(filselect, 2).toString()));
        cboGenero.setSelectedItem((tbRevistas.getValueAt(filselect, 4).toString()));
        txtImporte.setText((tbRevistas.getValueAt(filselect, 6).toString()));

        filasC = filselect;
        bloqueEliminar(true);
	}
	private void bloqueEliminar(boolean b) {
		btnEliminar.setEnabled(b);
	}
}
