package aplicaciones;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AgregarAutor extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);

	}

}
