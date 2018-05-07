package Controlador;

import java.util.ArrayList;

import Modelo.ConexionBBDD;
import Modelo.Contiene;
import Modelo.Productos;
import Vista.Pantalla_2_1;

public class Controlador_2_1 {
	private ConexionBBDD conexion;
	private Pantalla_2_1 pantalla_21;
	
	public Controlador_2_1(ConexionBBDD conexion, Pantalla_2_1 p) {
		this.conexion = conexion;
		this.pantalla_21 = p;
	}
	
	public ArrayList<Contiene> ActualizarTablaContiene(int mesa){
		return conexion.ConsultaTablaCont(mesa);
	}
	

}