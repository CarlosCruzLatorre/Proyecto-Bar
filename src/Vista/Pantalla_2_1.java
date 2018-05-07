package Vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador_1_2;
import Controlador.Controlador_2_1;
import Modelo.Contiene;
import Modelo.TMContiene;
import Modelo.TMProductos;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class Pantalla_2_1 {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private ArrayList<Contiene> ListaCont;
	private Controlador_2_1 controlador_21;
	private JComboBox comboBox;
	private TMContiene TablaDatos;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Pantalla_2_1(ArrayList<Contiene> lista) {
		ListaCont = new ArrayList<Contiene>();
		ListaCont = lista;
		setPantalla_21();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setPantalla_21() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 196, 222));
		frame.setBounds(100, 100, 727, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 34, 208, 45);
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Numero Mesa", "1", "2", "3", "4"}));
		comboBox.addItem("Todas");
		comboBox.addActionListener(new Escuchador());
		frame.getContentPane().add(comboBox);
		
		JButton btnAadir = new JButton("");
		btnAadir.setBounds(69, 111, 73, 73);
		btnAadir.setToolTipText("A\u00F1adir Comanda");
		btnAadir.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\Jhota\\Clases\\Proyectito\\Imagenes\\a\u00F1adir\\mipmap-xhdpi\\ic_launcher.png"));
		frame.getContentPane().add(btnAadir);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setBounds(69, 279, 73, 73);
		btnCancelar.setToolTipText("Retroceder");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\Jhota\\Clases\\Proyectito\\Imagenes\\atras\\atras\\mipmap-xhdpi\\ic_launcher.png"));
		frame.getContentPane().add(btnCancelar);
		
		JButton btnFinalizar = new JButton("");
		btnFinalizar.setBounds(69, 195, 73, 73);
		btnFinalizar.setToolTipText("Hacer ticket");
		btnFinalizar.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\Jhota\\Clases\\Proyectito\\Imagenes\\ok\\mipmap-xhdpi\\ic_launcher.png"));
		frame.getContentPane().add(btnFinalizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 34, 456, 315);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Cantidad", "Total", "Producto", "Comanda"
			}
		));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(228, 354, 453, 41);
		frame.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Total", "Pagado", "A devolver"
			}
		));
		
		scrollPane_1.setViewportView(table_1);
		frame.setVisible(true);
	}

	public void setContolador(Controlador_2_1 controlador) {
		this.controlador_21 = controlador;
	}
	
	
	private class Escuchador implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==comboBox) {
				TablaDatos = new TMContiene(controlador_21.ActualizarTablaContiene(comboBox.getSelectedIndex()));
				table.setModel(TablaDatos);
			}
			
		}
		
	}
}
