package mW2Wiki.MAPAS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import mW2Wiki.CLASES.Arma;
import mW2Wiki.CLASES.Camuflaje;

public class MapaCamuflajeArmas {

    public static void mostrarAspectoArmaMap() {
       
    	
    	 List<Camuflaje> camuflajes = Camuflaje.obtenerCamuflajes();
         List<Arma> armas = Arma.obtenerArmas();

         Map<Camuflaje, List<Arma>> mapaCamuflajeArma = new HashMap<>();
         Random random = new Random();

         for (Camuflaje camuflaje : camuflajes) {
             List<Arma> armasAsignadas = new ArrayList<>();
             int cantidadArmas = random.nextInt(armas.size()) + 1; 

             for (int i = 0; i < cantidadArmas; i++) {
                 int indiceArmaAleatoria = random.nextInt(armas.size());
                 Arma armaAleatoria = armas.get(indiceArmaAleatoria);
                 armasAsignadas.add(armaAleatoria);
             }

             mapaCamuflajeArma.put(camuflaje, armasAsignadas);
         }

         // Mostrar el mapa
         for (Map.Entry<Camuflaje, List<Arma>> entry : mapaCamuflajeArma.entrySet()) {
             Camuflaje camuflaje = entry.getKey();
             List<Arma> armasAsignadas = entry.getValue();

             System.out.println("Camuflaje: " + camuflaje.getNombre());
             System.out.println("Armas:");

             for (Arma arma : armasAsignadas) {
                 System.out.println("- " + arma.getNombre());
             }

             System.out.println();
         }
    }
    	
    	
    	
    }

