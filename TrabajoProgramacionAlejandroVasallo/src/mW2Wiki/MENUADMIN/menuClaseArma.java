package mW2Wiki.MENUADMIN;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import mW2Wiki.CLASES.ClaseArma;
import mW2Wiki.CLASESBBDD.ClaseArmaBBDD;

public class menuClaseArma {

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
                        agregarClaseArma();
                        break;
                    case 3:
                        actualizarClaseArma();
                        break;
                    case 4:
                        eliminarClaseArma();
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


    private static void agregarClaseArma() {
        System.out.println("=== Agregar Clase de Arma ===");
        int idClaseArma = leerEntero("Ingrese el ID de la Clase de Arma: ");
        String nombre = leerCadena("Ingrese el nombre de la Clase de Arma: ");
        String descripcion = leerCadena("Ingrese la descripción de la Clase de Arma: ");

        ClaseArma nuevaClaseArma = new ClaseArma(idClaseArma, nombre, descripcion);
        claseArmaBBDD.insertarClaseArma(nuevaClaseArma);

        System.out.println("La Clase de Arma ha sido agregada correctamente.");
    }

    private static void actualizarClaseArma() {
        System.out.println("=== Actualizar Clase de Arma ===");
        int idClaseArma = leerEntero("Ingrese el ID de la Clase de Arma que desea actualizar: ");

        // Verificar si la Clase de Arma existe
        List<ClaseArma> clasesArma = claseArmaBBDD.obtenerClasesArma();
        boolean existeClaseArma = false;
        for (ClaseArma claseArma : clasesArma) {
            if (claseArma.getId_Clase_Arma() == idClaseArma) {
                existeClaseArma = true;
                break;
            }
        }

        if (!existeClaseArma) {
            System.out.println("La Clase de Arma con ID " + idClaseArma + " no existe.");
            return;
        }

        String nombre = leerCadena("Ingrese el nuevo nombre de la Clase de Arma: ");
        String descripcion = leerCadena("Ingrese la nueva descripción de la Clase de Arma: ");

        ClaseArma claseArmaActualizada = new ClaseArma(idClaseArma, nombre, descripcion);
        claseArmaBBDD.actualizarClaseArma(claseArmaActualizada);

        System.out.println("La Clase de Arma ha sido actualizada correctamente.");
    }

    private static void eliminarClaseArma() {
        System.out.println("=== Eliminar Clase de Arma ===");
        int idClaseArma = leerEntero("Ingrese el ID de la Clase de Arma que desea eliminar: ");

        // Verificar si la Clase de Arma existe
        List<ClaseArma> clasesArma = claseArmaBBDD.obtenerClasesArma();
        boolean existeClaseArma = false;
        for (ClaseArma claseArma : clasesArma) {
            if (claseArma.getId_Clase_Arma() == idClaseArma) {
                existeClaseArma = true;
                break;
            }
        }

        if (!existeClaseArma) {
            System.out.println("La Clase de Arma con ID " + idClaseArma + " no existe.");
            return;
        }

        claseArmaBBDD.eliminarClaseArma(idClaseArma);

        System.out.println("La Clase de Arma ha sido eliminada correctamente.");
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

