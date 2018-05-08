package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ConexionBBDD {

	private String bd;
	private String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private String usr = "SYSTEM";
	private String pwd = "Elr0botoni";
	private Connection conexion;
	

	public ConexionBBDD()  {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd);
			
			if(!conexion.isClosed()) {
				System.out.println("Conexión establecida");
			}
			else
				System.out.println("Fallo en Conexión");	
			

		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");	
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Productos> ConsultaTablaProductos(String nombreCat) { //Rellenar la tabla de productos con los productos existentes en el admin
		ArrayList<Productos> producto = new ArrayList<Productos>();
		String query = "SELECT * FROM JORGE.producto WHERE COD_CATEGORIA = (SELECT COD_CATEGORIA FROM JORGE.categoria WHERE NOMBRE_CATEGORIA LIKE '"+ nombreCat +"') ORDER BY COD_PRODUCTO";
		//SELECT COD_CATEGORIA, NOMBRE_PRODUCTO, PRECIO FROM PRODUCTO WHERE COD_CATEGORIA = (SELECT COD_CATEGORIA FROM CATEGORIA WHERE NOMBRE_CATEGORIA LIKE 'Cervezas');
		System.out.println(query);
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 int cod_Cat = rset.getInt("COD_CATEGORIA");
				 String nombre = rset.getString("NOMBRE_PRODUCTO");
				 double precio = rset.getDouble("PRECIO");
				 int cod_Pro = rset.getInt("COD_PRODUCTO");
				 Productos p = new Productos(cod_Pro, nombre, precio, cod_Cat);
				 producto.add(p);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return producto;
		
	}
	
	
	public int RellenarTablaProductos(Productos P) { //Rellenar la tabla de productos con productos nuevos en el admin
		String NombreProducto = P.getNombre();
		double Precio = P.getPrecio();
		int resultado = 0;

		String query = "INSERT INTO JORGE.categoria (Cod_Categoria, Nombre_Categoria) VALUES ((SELECT MAX(Cod_Categoria)+1 FROM Categoria), 'Snacks');";
		 //INSERT INTO CATEGORIA (Cod_Categoria, Nombre_Categoria) VALUES ((SELECT MAX(Cod_Categoria)+1 FROM Categoria), 'Snacks');
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return resultado;
		
	}
	
	public ArrayList<String> ConsultaTablaCat(){ //Consultar la tabla de categorias, se usa para hacer un filtro
		ArrayList<String> lista = new ArrayList<String>();
		String query = "SELECT * FROM JORGE.categoria";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 lista.add(rset.getString("NOMBRE_CATEGORIA"));   
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return lista;
	}
	
	public ArrayList<Contiene> ConsultaTablaCont(int mesa){
		ArrayList<Contiene> lista = new ArrayList<Contiene>();
		String query = "SELECT C.Cantidad_Producto, C.Total_Producto, C.Cod_Comanda, P.Nombre_Producto FROM JORGE.Contiene C, JORGE.Producto P, JORGE.Comandas Co WHERE Co.Num_Mesa = " +mesa+ " AND Co.Cod_Comanda=C.Cod_Comanda ORDER BY Cod_Comanda";
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				String nombre_Producto = rset.getString("NOMBRE_PRODUCTO");
				int cod_comanda = rset.getInt("COD_COMANDA");
				int precio = rset.getInt("TOTAL_PRODUCTO");
				int cantidad = rset.getInt("CANTIDAD_PRODUCTO");
				 
				Contiene c = new Contiene(nombre_Producto, cod_comanda, cantidad, precio);
				lista.add(c);  
				
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return lista;
	}
	
	public void ConsultaActualizaProducto(Productos p) {
		String nombre = p.getNombre();
		int cod = p.getCod_Producto();
		double precio = p.getPrecio();
		int resultado = 0;
		
		String query = "UPDATE JORGE.producto SET PRECIO="+precio+", NOMBRE_PRODUCTO='"+nombre+"' WHERE COD_PRODUCTO = "+cod;
		//UPDATE producto SET PRECIO=2, NOMBRE_PRODUCTO='Coca' WHERE COD_PRODUCTO=1
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		//return resultado;
		
	}
	
	
	public void AnadirProductos(String nombreCat, String nombrePro, Double pre) {
		
		String query ="INSERT INTO JORGE.producto (Cod_Producto, Nombre_Producto, Precio, Cod_Categoria) VALUES ((SELECT MAX(Cod_Producto) + 1 FROM JORGE.Producto), '"+nombrePro+"', "+pre+", (SELECT Cod_Categoria FROM JORGE.categoria WHERE NOMBRE_CATEGORIA LIKE '"+nombreCat+"'))";
		//INSERT INTO Producto (Cod_Producto, Nombre_Producto, Precio, Cod_Categoria) VALUES (5, 'Prueba', 12, (SELECT Cod_Categoria FROM categoria WHERE NOMBRE_CATEGORIA LIKE 'Cervezas'))
		//SELECT MAX(Cod_Producto) + 1 FROM Producto 
		int resultado = 0;
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
	}
	
	public void DeleteProductos(String nomb) {
		String query = "DELETE FROM JORGE.producto WHERE NOMBRE_PRODUCTO LIKE '"+nomb+"'";
		int resultado = 0;
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
	}
	

}