package mW2Wiki.MENUUSU;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import mW2Wiki.CLASES.ClaseArma;
import mW2Wiki.CLASESBBDD.ClaseArmaBBDD;

public class menuClaseArmaUsu {

    private static Scanner scanner = new Scanner(System.in);
    private static ClaseArmaBBDD claseArmaBBDD = new ClaseArmaBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki");

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Menú Clase de Arma ===");
            System.out.println("1. Mostrar Clases de Arma");
            System.out.println("2. Agregar Clase de Arma");
            System.out.println("3. Actualizar Clase de Arma");
            System.out.println("4. Eliminar Clase de Arma");
            System.out.println("5. Salir");

            try {
                int opcion = leerEntero("Ingrese una opción: ");
                System.out.println();

                switch (opcion) {
                    case 1:
                        mostrarClasesArma();
                        break;
                    case 2:
                      
                        break;
                    case 3:
                       
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Se esperaba un valor numérico. Por favor, ingrese una opción válida.");
                scanner.nextLine(); // Limpiar el búfer del escáner
            }

            System.out.println();
        }
    }

    private static void mostrarClasesArma() {
        System.out.println("=== Mostrar Clases de Arma ===");
        List<ClaseArma> clasesArma = claseArmaBBDD.obtenerClasesArma();

        if (clasesArma.isEmpty()) {
            System.out.println("No se encontraron clases de arma.");
        } else {
            System.out.printf("%-15s %-15s %-15s%n", "ID Clase Arma", "Nombre", "Descripción");
            System.out.println("-----------------------------------------------");
            for (ClaseArma claseArma : clasesArma) {
                System.out.printf("%-15d %-15s %-15s%n", claseArma.getId_Clase_Arma(), claseArma.getNombre(),
                        claseArma.getDescripcion());
            }
        }

        System.out.println();
    }


    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }
}

