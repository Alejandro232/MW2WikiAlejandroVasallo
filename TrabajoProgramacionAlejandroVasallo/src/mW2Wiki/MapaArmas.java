package mW2Wiki;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapaArmas {

	
	MapaArmas(){
		
	}
	
	public void mapaArmas() {
		
		List<ClaseArma> clasesArma = ClaseArma.obtenerClasesArma();
        List<Arma> armas = Arma.obtenerArmas();
        Map<ClaseArma, List<Arma>> mapaArmasPorClase = new HashMap<>();

        System.out.println("Cantidad de clases de arma: " + clasesArma.size());
        System.out.println("Cantidad de armas: " + armas.size());

        for (ClaseArma claseArma : clasesArma) {
            List<Arma> armasPorClase = new ArrayList<>();

            for (Arma arma : armas) {
                if (arma.getId_Arma() == claseArma.getId_Clase_Arma()) {
                    armasPorClase.add(arma);
                }
            }

            mapaArmasPorClase.put(claseArma, armasPorClase);
        }

        // Buscar la clase de arma "Rifle de Francotirador" y las armas con IDs 19, 20 y 21
        ClaseArma claseRifleFrancotirador = null;
        List<Arma> armasSeleccionadas = new ArrayList<>();

        for (ClaseArma claseArma : clasesArma) {
            if (claseArma.getNombre().equals("Rifle de Francotirador")) {
                claseRifleFrancotirador = claseArma;
            }
        }

        for (Arma arma : armas) {
            int armaId = arma.getId_Arma();
            if (armaId == 19 || armaId == 20 || armaId == 21) {
                armasSeleccionadas.add(arma);
            }
        }

        // Verificar si se encontró la clase de arma "Rifle de Francotirador"
        if (claseRifleFrancotirador != null) {
            mapaArmasPorClase.put(claseRifleFrancotirador, armasSeleccionadas);
        } else {
            System.out.println("No se encontró la clase de arma \"Rifle de Francotirador\".");
        }
     // Buscar la clase de arma "Rifle de Asalto" y las armas con IDs 13, 14 y 15
        ClaseArma claseRifleAsalto = null;
        List<Arma> armasSeleccionadasRifleAsalto = new ArrayList<>();

        for (ClaseArma claseArma : clasesArma) {
            if (claseArma.getNombre().equals("Rifle de Asalto")) {
                claseRifleAsalto = claseArma;
            }
        }

        for (Arma arma : armas) {
            int armaId = arma.getId_Arma();
            if (armaId == 13 || armaId == 14 || armaId == 15) {
                armasSeleccionadasRifleAsalto.add(arma);
            }
        }

        // Verificar si se encontró la clase de arma "Rifle de Asalto"
        if (claseRifleAsalto != null) {
            mapaArmasPorClase.put(claseRifleAsalto, armasSeleccionadasRifleAsalto);
        } else {
            System.out.println("No se encontró la clase de arma \"Rifle de Asalto\".");
        }

   

     // Buscar la clase de arma "Subfusil" y las armas con IDs 16, 17 y 18
        ClaseArma claseSubfusil = null;
        List<Arma> armasSeleccionadasSubfusil = new ArrayList<>();

        for (ClaseArma claseArma : clasesArma) {
            if (claseArma.getNombre().equals("Subfusil")) {
                claseSubfusil = claseArma;
            }
        }

        for (Arma arma : armas) {
            int armaId = arma.getId_Arma();
            if (armaId == 16 || armaId == 17 || armaId == 18) {
                armasSeleccionadasSubfusil.add(arma);
            }
        }

        // Verificar si se encontró la clase de arma "Subfusil"
        if (claseSubfusil != null) {
            mapaArmasPorClase.put(claseSubfusil, armasSeleccionadasSubfusil);
        } else {
            System.out.println("No se encontró la clase de arma \"Subfusil\".");
        }
        
     // Crear una lista para almacenar las armas seleccionadas
        List<Arma> armasSeleccionadasPistola = new ArrayList<>();

        // Obtener las armas con IDs 28, 29 y 30 y agregarlas a la lista
        for (Arma arma : armas) {
            int armaId = arma.getId_Arma();
            if (armaId == 28 || armaId == 29 || armaId == 30) {
                armasSeleccionadasPistola.add(arma);
            }
        }

        // Verificar si se encontraron armas para la clave "Pistola"
        if (!armasSeleccionadasPistola.isEmpty()) {
            // Buscar la clase de arma correspondiente a la clave "Pistola"
            ClaseArma clasePistola = null;
            for (ClaseArma claseArma : clasesArma) {
                if (claseArma.getNombre().equals("Pistola")) {
                    clasePistola = claseArma;
                    break;
                }
            }

            // Verificar si se encontró la clase de arma "Pistola"
            if (clasePistola != null) {
                // Agregar las armas seleccionadas al mapa utilizando la clase de arma como clave
                mapaArmasPorClase.put(clasePistola, armasSeleccionadasPistola);
            } else {
                System.out.println("No se encontró la clase de arma \"Pistola\".");
            }
        } else {
            System.out.println("No se encontraron armas con las IDs especificadas para la clave \"Pistola\".");
        }
        
     // Crear una lista para almacenar las armas seleccionadas
        List<Arma> armasSeleccionadasAmetralladoraPesada = new ArrayList<>();

        // Obtener las armas con IDs 34, 35 y 36 y agregarlas a la lista
        for (Arma arma : armas) {
            int armaId = arma.getId_Arma();
            if (armaId == 34 || armaId == 35 || armaId == 36) {
                armasSeleccionadasAmetralladoraPesada.add(arma);
            }
        }

        // Verificar si se encontraron armas para la clave "Ametralladora Pesada"
        if (!armasSeleccionadasAmetralladoraPesada.isEmpty()) {
            // Buscar la clase de arma correspondiente a la clave "Ametralladora Pesada"
            ClaseArma claseAmetralladoraPesada = null;
            for (ClaseArma claseArma : clasesArma) {
                if (claseArma.getNombre().equals("Ametralladora Pesada")) {
                    claseAmetralladoraPesada = claseArma;
                    break;
                }
            }

            // Verificar si se encontró la clase de arma "Ametralladora Pesada"
            if (claseAmetralladoraPesada != null) {
                // Agregar las armas seleccionadas al mapa utilizando la clase de arma como clave
                mapaArmasPorClase.put(claseAmetralladoraPesada, armasSeleccionadasAmetralladoraPesada);
            } else {
                System.out.println("No se encontró la clase de arma \"Ametralladora Pesada\".");
            }
        } else {
            System.out.println("No se encontraron armas con las IDs especificadas para la clave \"Ametralladora Pesada\".");
        }
        
     // Crear una lista para almacenar las armas seleccionadas
        List<Arma> armasSeleccionadasEscopetaFrancotirador = new ArrayList<>();

        // Obtener las armas con IDs 37, 38 y 39 y agregarlas a la lista
        for (Arma arma : armas) {
            int armaId = arma.getId_Arma();
            if (armaId == 37 || armaId == 38 || armaId == 39) {
                armasSeleccionadasEscopetaFrancotirador.add(arma);
            }
        }

        // Verificar si se encontraron armas para la clave "Escopeta de Francotirador"
        if (!armasSeleccionadasEscopetaFrancotirador.isEmpty()) {
            // Buscar la clase de arma correspondiente a la clave "Escopeta de Francotirador"
            ClaseArma claseEscopetaFrancotirador = null;
            for (ClaseArma claseArma : clasesArma) {
                if (claseArma.getNombre().equals("Escopeta de Francotirador")) {
                    claseEscopetaFrancotirador = claseArma;
                    break;
                }
            }

            // Verificar si se encontró la clase de arma "Escopeta de Francotirador"
            if (claseEscopetaFrancotirador != null) {
                // Agregar las armas seleccionadas al mapa utilizando la clase de arma como clave
                mapaArmasPorClase.put(claseEscopetaFrancotirador, armasSeleccionadasEscopetaFrancotirador);
            } else {
                System.out.println("No se encontró la clase de arma \"Escopeta de Francotirador\".");
            }
        } else {
            System.out.println("No se encontraron armas con las IDs especificadas para la clave \"Escopeta de Francotirador\".");
        }
        
     // Crear una lista para almacenar las armas seleccionadas
        List<Arma> armasSeleccionadasLanzagranadas = new ArrayList<>();

        // Obtener las armas con IDs 31, 32 y 33 y agregarlas a la lista
        for (Arma arma : armas) {
            int armaId = arma.getId_Arma();
            if (armaId == 31 || armaId == 32 || armaId == 33) {
                armasSeleccionadasLanzagranadas.add(arma);
            }
        }

        // Verificar si se encontraron armas para la clave "Lanzagranadas"
        if (!armasSeleccionadasLanzagranadas.isEmpty()) {
            // Buscar la clase de arma correspondiente a la clave "Lanzagranadas"
            ClaseArma claseLanzagranadas = null;
            for (ClaseArma claseArma : clasesArma) {
                if (claseArma.getNombre().equals("Lanzagranadas")) {
                    claseLanzagranadas = claseArma;
                    break;
                }
            }

            // Verificar si se encontró la clase de arma "Lanzagranadas"
            if (claseLanzagranadas != null) {
                // Agregar las armas seleccionadas al mapa utilizando la clase de arma como clave
                mapaArmasPorClase.put(claseLanzagranadas, armasSeleccionadasLanzagranadas);
            } else {
                System.out.println("No se encontró la clase de arma \"Lanzagranadas\".");
            }
        } else {
            System.out.println("No se encontraron armas con las IDs especificadas para la clave \"Lanzagranadas\".");
        }
        
     // Crear una lista para almacenar las armas seleccionadas
        List<Arma> armasSeleccionadasArmaSecundaria = new ArrayList<>();

        // Obtener las armas con IDs 40, 41 y 42 y agregarlas a la lista
        for (Arma arma : armas) {
            int armaId = arma.getId_Arma();
            if (armaId == 40 || armaId == 41 || armaId == 42) {
                armasSeleccionadasArmaSecundaria.add(arma);
            }
        }

        // Verificar si se encontraron armas para la clave "Arma Secundaria"
        if (!armasSeleccionadasArmaSecundaria.isEmpty()) {
            // Buscar la clase de arma correspondiente a la clave "Arma Secundaria"
            ClaseArma claseArmaSecundaria = null;
            for (ClaseArma claseArma : clasesArma) {
                if (claseArma.getNombre().equals("Arma Secundaria")) {
                    claseArmaSecundaria = claseArma;
                    break;
                }
            }

            // Verificar si se encontró la clase de arma "Arma Secundaria"
            if (claseArmaSecundaria != null) {
                // Agregar las armas seleccionadas al mapa utilizando la clase de arma como clave
                mapaArmasPorClase.put(claseArmaSecundaria, armasSeleccionadasArmaSecundaria);
            } else {
                System.out.println("No se encontró la clase de arma \"Arma Secundaria\".");
            }
        } else {
            System.out.println("No se encontraron armas con las IDs especificadas para la clave \"Arma Secundaria\".");
        }
        
     // Crear una lista para almacenar las armas seleccionadas
        List<Arma> armasSeleccionadasEscopeta = new ArrayList<>();

        // Obtener las armas con IDs 22, 23 y 24 y agregarlas a la lista
        for (Arma arma : armas) {
            int armaId = arma.getId_Arma();
            if (armaId == 22 || armaId == 23 || armaId == 24) {
                armasSeleccionadasEscopeta.add(arma);
            }
        }

        // Verificar si se encontraron armas para la clave "Escopeta"
        if (!armasSeleccionadasEscopeta.isEmpty()) {
            // Buscar la clase de arma correspondiente a la clave "Escopeta"
            ClaseArma claseEscopeta = null;
            for (ClaseArma claseArma : clasesArma) {
                if (claseArma.getNombre().equals("Escopeta")) {
                    claseEscopeta = claseArma;
                    break;
                }
            }

            // Verificar si se encontró la clase de arma "Escopeta"
            if (claseEscopeta != null) {
                // Agregar las armas seleccionadas al mapa utilizando la clase de arma como clave
                mapaArmasPorClase.put(claseEscopeta, armasSeleccionadasEscopeta);
            } else {
                System.out.println("No se encontró la clase de arma \"Escopeta\".");
            }
        } else {
            System.out.println("No se encontraron armas con las IDs especificadas para la clave \"Escopeta\".");
        }
        
        // Imprimir el mapa actualizado
        for (Map.Entry<ClaseArma, List<Arma>> entry : mapaArmasPorClase.entrySet()) {
            ClaseArma claseArma = entry.getKey();
            List<Arma> armasPorClase = entry.getValue();

            System.out.println("Clase de arma: " + claseArma.getNombre());
            System.out.println("Cantidad de armas por clase: " + armasPorClase.size());
            System.out.println("Armas:");
            for (Arma arma : armasPorClase) {
                System.out.println("- " + arma.getNombre());
            }
            System.out.println();
        }
		
	}
	
	
	
}
