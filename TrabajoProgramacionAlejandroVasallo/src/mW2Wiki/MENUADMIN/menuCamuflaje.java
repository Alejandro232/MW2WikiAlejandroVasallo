package mW2Wiki.MENUADMIN;

import java.util.List;
import java.util.Scanner;

import mW2Wiki.CLASES.Camuflaje;
import mW2Wiki.CLASESBBDD.CamuflajeBBDD;

public class menuCamuflaje {

    private static Scanner scanner = new Scanner(System.in);
    private static CamuflajeBBDD camuflajeBBDD = new CamuflajeBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki");

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    insertarCamuflaje();
                    break;
                case 2:
                    eliminarCamuflaje();
                    break;
                case 3:
                    actualizarCamuflaje();
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

    private static void insertarCamuflaje() {
        System.out.println("----- Insertar Camuflaje -----");
        System.out.print("Ingrese el ID del camuflaje: ");
        int idCamuflaje = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea pendiente
        System.out.print("Ingrese el nombre del camuflaje: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el requisito de desbloqueo del camuflaje: ");
        String requisitoDesbloqueo = scanner.nextLine();

        System.out.print("Ingrese el ID del arma asociado al camuflaje: ");
        int idArma = scanner.nextInt();

        Camuflaje camuflaje = new Camuflaje(idCamuflaje, nombre, requisitoDesbloqueo, idArma);
        camuflajeBBDD.insertarCamuflaje(camuflaje);

        System.out.println("El camuflaje se ha insertado correctamente.");
        System.out.println();
    }

    private static void eliminarCamuflaje() {
        System.out.println("----- Eliminar Camuflaje -----");
        System.out.print("Ingrese el ID del camuflaje a eliminar: ");
        int idCamuflaje = scanner.nextInt();

        camuflajeBBDD.eliminarCamuflaje(idCamuflaje);

        System.out.println("El camuflaje se ha eliminado correctamente.");
        System.out.println();
    }

    private static void actualizarCamuflaje() {
        System.out.println("----- Actualizar Camuflaje -----");
        System.out.print("Ingrese el ID del camuflaje a actualizar: ");
        int idCamuflaje = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea pendiente
        System.out.print("Ingrese el nuevo nombre del camuflaje: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo requisito de desbloqueo del camuflaje: ");
        String requisitoDesbloqueo = scanner.nextLine();

        System.out.print("Ingrese el nuevo ID del arma asociado al camuflaje: ");
        int idArma = scanner.nextInt();

        Camuflaje camuflaje = new Camuflaje(idCamuflaje, nombre, requisitoDesbloqueo, idArma);
        camuflajeBBDD.actualizarCamuflaje(camuflaje);

        System.out.println("El camuflaje se ha actualizado correctamente.");
        System.out.println();
    }

    private static void mostrarCamuflajes() {
        System.out.println("----- Mostrar Camuflajes -----");

        List<Camuflaje> camuflajes = camuflajeBBDD.obtenerCamuflajes();
        if (camuflajes.isEmpty()) {
            System.out.println("No se encontraron camuflajes.");
        } else {
            System.out.println("ID\tNombre\t\t\tRequisito de Desbloqueo\tID Arma");
            System.out.println("---------------------------------------------------------");
            for (Camuflaje camuflaje : camuflajes) {
                System.out.printf("%d\t%-20s\t%s\t\t\t%d\n", camuflaje.getIdCamuflaje(), camuflaje.getNombre(), camuflaje.getRequisitoDesbloqueo(), camuflaje.getId_Arma());
            }
        }

        System.out.println();
    }
}
