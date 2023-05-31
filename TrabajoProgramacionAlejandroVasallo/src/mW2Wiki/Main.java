package mW2Wiki;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 

	      //Modos de juego
	        List<ModoJuego> modosJuego = ModoJuego.obtenerModosJuego();
	       
	        System.out.println(modosJuego); 
	        
	        //Mapas
	        List<Mapa> mapas = Mapa.obtenerMapas();
		       
	        System.out.println(mapas);
	        
	        //RequisitosPC
	        List<RequisitosPc> requisitos = RequisitosPc.obtenerRequisitosPc();
		       
	        System.out.println(requisitos);
	        
	      //RachasBajas
	        List<Racha_Bajas> rachasBajas = Racha_Bajas.obtenerRachasBajas();
		       
	        System.out.println(rachasBajas);
	        
	        //Faccion
	        List<Faccion> facciones = Faccion.obtenerFacciones();
		       
	        System.out.println(facciones);
	        
	      //Operadores
	        List<Operador> operadores = Operador.obtenerOperadores();
		       
	        System.out.println(operadores);
	        
	        
	        
	        //Mapa operadores-Facciones
	        MapaOperadoresFacciones mapaOperadoresFacciones= new MapaOperadoresFacciones();
	        mapaOperadoresFacciones.mapaOperadoresFacciones();
	        
	        
	        
	        //Mapa de Armas
	        MapaArmas mapaArmas= new MapaArmas();
	        mapaArmas.mapaArmas();

	        
	        








	        
	   
	







	        
	    }
		
}
		
	


