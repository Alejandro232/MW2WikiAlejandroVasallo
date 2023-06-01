package mW2Wiki.MENUUSU;

import java.util.List;
import java.util.Scanner;

import mW2Wiki.CLASES.Camuflaje;
import mW2Wiki.CLASESBBDD.CamuflajeBBDD;

public class menuCamuflajeUsu {

    private static Scanner scanner = new Scanner(System.in);
    private static CamuflajeBBDD camuflajeBBDD = new CamuflajeBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki");

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                 
                    break;
                case 2:
                   
                    break;
                case 3:
                   
                    break;
                case 4:
                    mostrarCamuflajes();
                    break;
                case 5:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("----- Menú Camuflaje -----");
        System.out.println("1. Insertar camuflaje");
        System.out.println("2. Eliminar camuflaje");
        System.out.println("3. Actualizar camuflaje");
        System.out.println("4. Mostrar camuflajes");
        System.out.println("5. Salir");
    }

    private static int obtenerOpcion() {
        System.out.print("Ingresa el número de opción: ");
        return scanner.nextInt();
    }

    private static void mostrarCamuflajes() {
        System.out.println("----- Mostrar Camuflajes -----");

        List<Camuflaje> camuflajes = camuflajeBBDD.obtenerCamuflajes();
        if (camuflajes.isEmpty()) {
            System.out.println("No se encontraron camuflajes.");
        } else {
            System.out.println("ID\tNombre\t\t\tRequisito de Desbloqueo\tNombre del Arma");
            System.out.println("---------------------------------------------------------");
            for (Camuflaje camuflaje : camuflajes) {
                // Obtener el nombre del arma usando el ID del arma del camuflaje
                String nombreArma = camuflajeBBDD.obtenerNombreArma(camuflaje.getId_Arma());
                System.out.printf("%d\t%-20s\t%s\t\t\t%s\n", camuflaje.getIdCamuflaje(), camuflaje.getNombre(), camuflaje.getRequisitoDesbloqueo(), nombreArma);
            }
        }

        System.out.println();
    }

}
