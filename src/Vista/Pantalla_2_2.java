package Vista;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;

public class Pantalla_2_2 {

	private JFrame frame;
	private JTextField txtCantidad;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_2_2 window = new Pantalla_2_2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla_2_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 196, 222));
		frame.setBounds(100, 100, 555, 305);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Categor\u00EDa"}));
		comboBox.setBounds(21, 27, 147, 41);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Verdana", Font.PLAIN, 24));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Producto"}));
		comboBox_1.setBounds(195, 27, 147, 41);
		frame.getContentPane().add(comboBox_1);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Verdana", Font.PLAIN, 24));
		txtCantidad.setText("Cantidad");
		txtCantidad.setBounds(365, 27, 156, 41);
		frame.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);

		JButton btnAadir = new JButton("");
		btnAadir.setToolTipText("A\u00F1adir");
		btnAadir.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\Jhota\\Clases\\Proyectito\\Imagenes\\a\u00F1adir\\mipmap-xhdpi\\ic_launcher.png"));
		btnAadir.setBounds(67, 197, 59, 59);
		frame.getContentPane().add(btnAadir);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setToolTipText("Retroceder");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\Jhota\\Clases\\Proyectito\\Imagenes\\atras\\atras\\mipmap-xhdpi\\ic_launcher.png"));
		btnCancelar.setBounds(383, 197, 59, 59);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("");
		btnAceptar.setToolTipText("Aceptar");
		btnAceptar.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\Jhota\\Clases\\Proyectito\\Imagenes\\ok\\mipmap-xhdpi\\ic_launcher.png"));
		btnAceptar.setBounds(304, 197, 59, 59);
		frame.getContentPane().add(btnAceptar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setToolTipText("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\Jhota\\Clases\\Proyectito\\Imagenes\\eliminar\\mipmap-xhdpi\\ic_launcher.png"));
		btnEliminar.setBounds(148, 197, 59, 59);
		frame.getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 79, 490, 113);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setToolTipText("");
		table_1.setFont(new Font("Verdana", Font.PLAIN, 17));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", ""},
				{null, null, null, null},
			},
			new String[] {
				"Categor\u00EDa", "Producto", "Precio", "Cantidad"
			}
		));
		scrollPane.setViewportView(table_1);
	}
}
