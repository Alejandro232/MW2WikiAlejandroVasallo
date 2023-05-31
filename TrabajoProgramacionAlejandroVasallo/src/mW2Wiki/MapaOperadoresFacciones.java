package mW2Wiki;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class MapaOperadoresFacciones {

	MapaOperadoresFacciones(){
		
	}
	
	public void mapaOperadoresFacciones() {
		List<Faccion> facciones = Faccion.obtenerFacciones();
        List<Operador> operadores = Operador.obtenerOperadores();

        Map<String, List<Operador>> mapaFaccionOperador = new HashMap<>();

        // Asociar los operadores con ID 1, 3 y 5 a la llave "specgru" en el mapa
        List<Operador> operadoresSpecgru = new ArrayList<>();
        for (Operador operador : operadores) {
            if (operador.getIdOperador() == 1 || operador.getIdOperador() == 3 || operador.getIdOperador() == 5) {
                operadoresSpecgru.add(operador);
            }
        }
        mapaFaccionOperador.put("specgru", operadoresSpecgru);

        // Asociar los operadores con ID 2, 4 y 6 a la llave "kortak" en el mapa
        List<Operador> operadoresKortak = new ArrayList<>();
        for (Operador operador : operadores) {
            if (operador.getIdOperador() == 2 || operador.getIdOperador() == 4 || operador.getIdOperador() == 6) {
                operadoresKortak.add(operador);
            }
        }
        mapaFaccionOperador.put("kortak", operadoresKortak);

        // Imprimir el mapa
        for (Map.Entry<String, List<Operador>> entry : mapaFaccionOperador.entrySet()) {
            String faccion = entry.getKey();
            List<Operador> operadoresEnFaccion = entry.getValue();
            System.out.println("Facción: " + faccion);
            for (Operador operador : operadoresEnFaccion) {
                System.out.println("Operador: " + operador.getNombre());
            }
        }
	}
}

	
	

