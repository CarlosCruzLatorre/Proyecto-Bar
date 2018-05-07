package Controlador;

import Modelo.ConexionBBDD;
import Vista.Pantalla_1_2;
import Vista.Pantalla_2_1;
import Vista.Pantalla_Inicial;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConexionBBDD conexion = new ConexionBBDD();
		Pantalla_Inicial pantalla_ini = new Pantalla_Inicial();
		Controlador_Inicial controlador_ini = new Controlador_Inicial(conexion, pantalla_ini);
		
		pantalla_ini.setControlador(controlador_ini);
		

	}

}
