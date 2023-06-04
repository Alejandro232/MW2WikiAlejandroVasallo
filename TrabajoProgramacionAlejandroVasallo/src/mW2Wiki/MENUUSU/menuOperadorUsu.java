package mW2Wiki.MENUUSU;

import mW2Wiki.CLASES.Faccion;
import mW2Wiki.CLASES.Operador;
import mW2Wiki.CLASESBBDD.FaccionBBDD;
import mW2Wiki.CLASESBBDD.OperadorBBDD;

import java.util.List;
import java.util.Scanner;

public class menuOperadorUsu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OperadorBBDD operadorBBDD = new OperadorBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki");

        boolean continuar = true;
        while (continuar) {
            System.out.println("=== Menú Operador ===");
            System.out.println("1. Mostrar Operadores");
            System.out.println("2. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    FaccionBBDD faccionBBDD = new FaccionBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki");
                    mostrarOperadores(operadorBBDD, faccionBBDD);
                    break;
                case 2:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }

    private static void mostrarOperadores(OperadorBBDD operadorBBDD, FaccionBBDD faccionBBDD) {
        System.out.println("=== Mostrar Operadores ===");
        List<Operador> operadores = operadorBBDD.obtenerOperadores();

        if (operadores.isEmpty()) {
            System.out.println("No se encontraron operadores.");
        } else {
            System.out.printf("%-15s %-15s %-15s %-15s%n", "ID Operador", "Facción", "Género", "Altura");
            System.out.println("---------------------------------------------");

            for (Operador operador : operadores) {
                Faccion faccion = obtenerFaccionPorId(faccionBBDD, operador.getIdFaccion());
                String nombreFaccion = faccion != null ? faccion.getNombre() : "Desconocida";

                System.out.printf("%-15d %-15s %-15s %-15.2f%n", operador.getIdOperador(), nombreFaccion,
                        operador.getGenero(), operador.getAltura());
            }
        }

        System.out.println();
    }

    private static Faccion obtenerFaccionPorId(FaccionBBDD faccionBBDD, int idFaccion) {
        List<Faccion> facciones = faccionBBDD.obtenerFacciones();

        for (Faccion faccion : facciones) {
            if (faccion.getIdFaccion() == idFaccion) {
                return faccion;
            }
        }

        return null;
    }
}
