package mW2Wiki.MENUADMIN;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import mW2Wiki.CLASES.Aspecto;
import mW2Wiki.CLASESBBDD.AspectoBBDD;

public class menuAspecto {
    private AspectoBBDD aspectoBBDD;
    private Scanner scanner;

    public menuAspecto(String usu, String pas, String puerto, String maquina, String baseDatos) {
        aspectoBBDD = new AspectoBBDD(usu, pas, puerto, maquina, baseDatos);
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("----- Menú de Aspectos -----");
            System.out.println("1. Insertar aspecto");
            System.out.println("2. Eliminar aspecto");
            System.out.println("3. Actualizar aspecto");
            System.out.println("4. Mostrar aspectos");
            System.out.println("0. Salir");
            System.out.println("-----------------------------");
            System.out.print("Seleccione una opción: ");

            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Limpiar el buffer de entrada
                System.out.println("Opción inválida. Intente nuevamente.");
                continue;
            }

            switch (opcion) {
                case 1:
                    insertarAspecto();
                    break;
                case 2:
                    eliminarAspecto();
                    break;
                case 3:
                    actualizarAspecto();
                    break;
                case 4:
                    mostrarAspectos();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
        System.out.println("¡Hasta luego!");
    }

    private void insertarAspecto() {
        System.out.println("----- Insertar Aspecto -----");

        System.out.print("ID del aspecto: ");
        int idAspecto = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Nombre del aspecto: ");
        String nombre = scanner.nextLine();

        System.out.print("Requisito de desbloqueo: ");
        String requisitoDesbloqueo = scanner.nextLine();

        Aspecto aspecto = new Aspecto(idAspecto, nombre, requisitoDesbloqueo, null);
        aspectoBBDD.insertarAspecto(aspecto);

        System.out.println("Aspecto insertado correctamente.");
        System.out.println();
    }

    private void eliminarAspecto() {
        System.out.println("----- Eliminar Aspecto -----");

        System.out.print("ID del aspecto a eliminar: ");
        int idAspecto = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        aspectoBBDD.eliminarAspecto(idAspecto);

        System.out.println("Aspecto eliminado correctamente.");
        System.out.println();
    }

    private void actualizarAspecto() {
        System.out.println("----- Actualizar Aspecto -----");

        System.out.print("ID del aspecto a actualizar: ");
        int idAspecto = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Nuevo nombre del aspecto: ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo requisito de desbloqueo: ");
        String requisitoDesbloqueo = scanner.nextLine();

        Aspecto aspecto = new Aspecto(idAspecto, nombre, requisitoDesbloqueo, null);
        aspectoBBDD.actualizarAspecto(aspecto);

        System.out.println("Aspecto actualizado correctamente.");
        System.out.println();
    }

    private void mostrarAspectos() {
        System.out.println("----- Mostrar Aspectos -----");

        List<Aspecto> aspectos = aspectoBBDD.obtenerAspectos();
        if (aspectos.isEmpty()) {
            System.out.println("No se encontraron aspectos.");
        } else {
            System.out.println("ID\tNombre\t\t\tRequisito de Desbloqueo");
            System.out.println("-----------------------------------------");
            for (Aspecto aspecto : aspectos) {
                System.out.printf("%d\t%-20s\t%s\n", aspecto.getIdAspecto(), aspecto.getNombre(), aspecto.getRequisitoDesbloqueo());
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {
        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";

        menuAspecto aspectoMenu = new menuAspecto(usu, pas, puerto, maquina, baseDatos);
        aspectoMenu.mostrarMenu();
    }
}
