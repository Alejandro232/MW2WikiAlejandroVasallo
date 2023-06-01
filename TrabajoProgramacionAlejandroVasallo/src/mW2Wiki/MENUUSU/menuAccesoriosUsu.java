package mW2Wiki.MENUUSU;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import mW2Wiki.CLASES.Accesorio;

public class menuAccesoriosUsu {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Menú de Gestión de Accesorios ===");
            System.out.println("1. Mostrar accesorios");
            System.out.println("2. Agregar un accesorio");
            System.out.println("3. Eliminar un accesorio");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    mostrarAccesorios();
                    break;
                case 2:
                   
                    break;
                case 3:
                    
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

    private static void mostrarAccesorios() {
        List<Accesorio> accesorios = Accesorio.obtenerAccesorios();

        if (accesorios.isEmpty()) {
            System.out.println("No hay accesorios disponibles.");
        } else {
            System.out.println("=== Accesorios ===");
            System.out.printf("%-5s %-20s %-50s\n", "ID", "Nombre", "Descripción");
            System.out.println("-------------------------------------------------------------");
            for (Accesorio accesorio : accesorios) {
                System.out.printf("%-5d %-20s %-50s\n",
                        accesorio.getId_Accesorio(), accesorio.getNombre(), accesorio.getDescripcion());
            }
        }
    }





    
}