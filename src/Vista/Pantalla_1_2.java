package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador_1_2;
import Modelo.ConexionBBDD;
import Modelo.Productos;
import Modelo.TMProductos;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Pantalla_1_2 extends JDialog{

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtNombreCategoria;
	private JTable table;
	
	private ConexionBBDD conexion;
	private TMProductos TablaDatos;
	private ArrayList<String> ListaCat;
	private Controlador_1_2 controlador_12;
	private JComboBox comboBox;


	public Pantalla_1_2(ArrayList<String> lista, Pantalla_Inicial pantalla_ini) {
		super();
		ListaCat = new ArrayList<String>();
		ListaCat = lista;
		
		addWindowListener(new WindowAdapter() {                //Hay que echarle un ojo a esta mierda
			
			public void windowClosed(WindowEvent e) {
				pantalla_ini.setVisible(true);
				}
			
			   public void windowClosing(WindowEvent e) {
			     pantalla_ini.setVisible(true);
			   }
			 });
		setPantalla_12();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	public void setPantalla_12() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 196, 222));
		frame.setBounds(100, 100, 984, 538);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton btnOk = new JButton("");
		btnOk.setToolTipText("A\u00F1adir");
		btnOk.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\Jhota\\Clases\\Proyectito\\Imagenes\\ok\\mipmap-xhdpi\\ic_launcher.png"));
		btnOk.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnOk.setBounds(35, 374, 73, 73);
		frame.getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(!txtNombre.getText().equals("Producto") && !txtPrecio.getText().equals("Precio") && txtNombreCategoria.getText().equals("Categoria")) {
				
				}
			
			}
		});
		
		
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 24));
		txtNombre.setText("Producto");
		txtNombre.setBounds(24, 148, 299, 38);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		
		
		
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Verdana", Font.PLAIN, 24));
		txtPrecio.setText("Precio");
		txtPrecio.setBounds(24, 224, 299, 38);
		frame.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		
		
		txtNombreCategoria = new JTextField();
		txtNombreCategoria.setFont(new Font("Verdana", Font.PLAIN, 24));
		txtNombreCategoria.setText("Categoria");
		txtNombreCategoria.setBounds(24, 57, 257, 49);
		frame.getContentPane().add(txtNombreCategoria);
		txtNombreCategoria.setColumns(10);
		txtNombreCategoria.setVisible(false); 
		
		
		
		

		JButton btnCancelar = new JButton("");
		btnCancelar.setToolTipText("Eliminar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\Jhota\\Clases\\Proyectito\\Imagenes\\eliminar\\mipmap-xhdpi\\ic_launcher.png"));
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnCancelar.setBounds(172, 374, 73, 73);
		frame.getContentPane().add(btnCancelar);
		
		
		
		
		JButton btnAtrassssssssssss = new JButton("");
		btnAtrassssssssssss.setToolTipText("Retroceder");
		btnAtrassssssssssss.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\Jhota\\Clases\\Proyectito\\Imagenes\\atras\\atras\\mipmap-xhdpi\\ic_launcher.png"));
		btnAtrassssssssssss.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnAtrassssssssssss.setBounds(308, 374, 73, 73);
		frame.getContentPane().add(btnAtrassssssssssss);
		
		
		
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Categoria"}));
		comboBox.setBounds(24, 62, 299, 38);
		frame.getContentPane().add(comboBox);
		for(int i = 0; i < ListaCat.size(); i ++) {
			comboBox.addItem(ListaCat.get(i));
		}
		comboBox.addItem("Añadir...");
		comboBox.addActionListener(new Escuchador());
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new CompoundBorder());
		scrollPane.setBounds(454, 11, 484, 458);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = table.rowAtPoint(e.getPoint());
				Productos p = new Productos(0, null, 0, 0);
				
				p = TablaDatos.getRow(seleccion);  					
				controlador_12.AbrirPantallaEdicion(p);
			}
		});
		table.setFont(new Font("Verdana", Font.PLAIN, 20));
		table.setForeground(SystemColor.windowText);
		table.setToolTipText("");
		
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"COD_CATEGORIA", "NOMBRE_PRODUCTO", "PRECIO"
			}
		));
		scrollPane.setViewportView(table);

		
		
		
		frame.setVisible(true);
	}
	
	private class Escuchador implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==comboBox) {
				if(!comboBox.getSelectedItem().toString().equals("Añadir...")) {
					TablaDatos = new TMProductos(controlador_12.ActualizarTablaProductos((String)comboBox.getSelectedItem()));
					table.setModel(TablaDatos);	
				}else if(comboBox.getSelectedItem().toString().equals("Añadir...")) {
					comboBox.setVisible(false);
					txtNombreCategoria.setVisible(true);
				}
			}
			
		}
		
	}
	
	public void setControlador(Controlador_1_2 controlador) {
		this.controlador_12 = controlador;
	}
	
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
	
	
	
}

//INSERT INTO CATEGORIA (Cod_Categoria, Nombre_Categoria) VALUES ((SELECT MAX(Cod_Categoria)+1 FROM Categoria), 'Snacks');
