package Controlador;

import java.util.ArrayList;

import Modelo.ConexionBBDD;
import Modelo.Contiene;
import Vista.Pantalla_1_2;
import Vista.Pantalla_2_2;

public class Controlador_2_2 {
	
	private ConexionBBDD conexion;
	private Pantalla_2_2 pantalla22;
	private String mesa;
	
	public Controlador_2_2 (ConexionBBDD conexion, Pantalla_2_2 p, String mesa) {
		this.conexion = conexion;
		this.pantalla22 = p;
		this.mesa = mesa;
	}
	
	public ArrayList<Contiene> ActualizarTablaContiene(int mesa){
		return conexion.ConsultaTablaCont(mesa);
	}
	
	

}
