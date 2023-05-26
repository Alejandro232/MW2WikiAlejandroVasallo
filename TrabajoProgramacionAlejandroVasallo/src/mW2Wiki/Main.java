package mW2Wiki;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 

	      //Modos de juego
	        List<ModoJuego> modosJuego = ModoJuego.obtenerModosJuego();
	       
	        System.out.println(modosJuego);
	        
	        
	        //Mapas
	        List<Mapa> mapas = Mapa.obtenerMapas();
		       
	        System.out.println(mapas);
	        
	        
	        //Armas
	        List<Arma> armas = Arma.obtenerArmas();
		       
	        System.out.println(armas);
	        
	        
	    }
		
		
		
	}


