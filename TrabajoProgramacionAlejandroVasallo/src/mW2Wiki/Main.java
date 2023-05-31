package mW2Wiki;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mW2Wiki.CLASES.Accesorio;
import mW2Wiki.CLASES.Faccion;
import mW2Wiki.CLASES.Mapa;
import mW2Wiki.CLASES.ModoJuego;
import mW2Wiki.CLASES.Operador;
import mW2Wiki.CLASES.Racha_Bajas;
import mW2Wiki.CLASES.RequisitosPc;
import mW2Wiki.CLASESBBDD.AccesorioBBDD;
import mW2Wiki.CLASESBBDD.ArmaBBDD;
import mW2Wiki.CLASESBBDD.AspectoBBDD;
import mW2Wiki.CLASESBBDD.CamuflajeBBDD;
import mW2Wiki.CLASESBBDD.ClaseArmaBBDD;
import mW2Wiki.CLASESBBDD.FaccionBBDD;
import mW2Wiki.CLASESBBDD.MapaBBDD;
import mW2Wiki.CLASESBBDD.ModoJuegoBBDD;
import mW2Wiki.CLASESBBDD.OperadorBBDD;
import mW2Wiki.CLASESBBDD.Racha_BajasBBDD;
import mW2Wiki.CLASESBBDD.RequisitosPcBBDD;
import mW2Wiki.MAPAS.MapaCamuflajeArmas;
import mW2Wiki.MAPAS.MapaOperadoresFacciones;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 

//	      //Modos de juego
//	        List<ModoJuego> modosJuego = ModoJuego.obtenerModosJuego();
//	       
//	        System.out.println(modosJuego); 
//	        
//	        //Mapas
//	        List<Mapa> mapas = Mapa.obtenerMapas();
//		       
//	        System.out.println(mapas);
//	        
//	        //RequisitosPC
//	        List<RequisitosPc> requisitos = RequisitosPc.obtenerRequisitosPc();
//		       
//	        System.out.println(requisitos);
//	        
//	      //RachasBajas
//	        List<Racha_Bajas> rachasBajas = Racha_Bajas.obtenerRachasBajas();
//		       
//	        System.out.println(rachasBajas);
//	        
//	        //Faccion
//	        List<Faccion> facciones = Faccion.obtenerFacciones();
//		       
//	        System.out.println(facciones);
//	        
//	      //Operadores
//	        List<Operador> operadores = Operador.obtenerOperadores();
//		       
//	        System.out.println(operadores);
//	        
//	        
//	        //Mapa CamuflajeArmas
//	        MapaCamuflajeArmas mapaCamuflajeArmas= new MapaCamuflajeArmas();
//	        MapaCamuflajeArmas.mostrarAspectoArmaMap();
//	        
//	        
//	        
//	        //Mapa operadores-Facciones
//	        MapaOperadoresFacciones mapaOperadoresFacciones= new MapaOperadoresFacciones();
//	        mapaOperadoresFacciones.mapaOperadoresFacciones();
//	        
//	        
//	        
//	        //Mapa de Armas
//	        MapaArmas mapaArmas= new MapaArmas();
//	        mapaArmas.mapaArmas();

		String usu = "root";
		String pas = "alejandro2002";
		String puerto = "3307";
		String maquina = "localhost";
		String baseDatos = "mw2wiki";
		String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

		AccesorioBBDD accesorioBBDD = new AccesorioBBDD(usu, pas, puerto, maquina, baseDatos);
		System.out.println(accesorioBBDD.obtenerAccesorios());

		ArmaBBDD armaBBDD = new ArmaBBDD(usu, pas, puerto, maquina, baseDatos);
		System.out.println(armaBBDD.obtenerArmas());
	    
		AspectoBBDD aspectoBBDD = new AspectoBBDD(usu, pas, puerto, maquina, baseDatos);
		System.out.println(aspectoBBDD.obtenerAspectos());

		CamuflajeBBDD camuflajeBBDD = new CamuflajeBBDD(usu, pas, puerto, maquina, baseDatos);
		ClaseArmaBBDD claseArmaBBDD= new ClaseArmaBBDD(usu, pas, puerto, maquina, baseDatos);
		FaccionBBDD faccionBBDD= new FaccionBBDD(usu, pas, puerto, maquina, baseDatos);
		MapaBBDD mapaBBDD = new MapaBBDD(usu, pas, puerto, maquina, baseDatos);
		ModoJuegoBBDD modoJuegoBBDD= new ModoJuegoBBDD(usu, pas, puerto, maquina, baseDatos);
		OperadorBBDD operadorBBDD= new OperadorBBDD(usu, pas, puerto, maquina, baseDatos);
		Racha_BajasBBDD rachaBajas= new Racha_BajasBBDD(usu, pas, puerto, maquina, baseDatos);
		RequisitosPcBBDD requisitosPcBBDD= new RequisitosPcBBDD(usu, pas, puerto, maquina, baseDatos);




	        
	  







	        
	    }

		
}
		
	


