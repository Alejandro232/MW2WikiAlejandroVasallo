package mW2Wiki.MENUADMIN;

import java.util.List;
import java.util.Scanner;

import mW2Wiki.CLASES.ModoJuego;
import mW2Wiki.CLASESBBDD.ModoJuegoBBDD;

public class menuModoJuego {

    private ModoJuegoBBDD modoJuegoBBDD;
    private Scanner scanner;

    public menuModoJuego() {
        // Configurar los datos de conexión a la base de datos
        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";

        modoJuegoBBDD = new ModoJuegoBBDD(usu, pas, puerto, maquina, baseDatos);
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("---- MENÚ MODO DE JUEGO ----");
            System.out.println("1. Mostrar modos de juego");
            System.out.println("2. Agregar modo de juego");
            System.out.println("3. Actualizar modo de juego");
            System.out.println("4. Eliminar modo de juego");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer la opción

            switch (opcion) {
                case 1:
                    mostrarModosJuego();
                    break;
                case 2:
                    agregarModoJuego();
                    break;
                case 3:
                    actualizarModoJuego();
                    break;
                case 4:
                    eliminarModoJuego();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private void mostrarModosJuego() {
        List<ModoJuego> modosJuego = modoJuegoBBDD.obtenerModosJuego();

        if (modosJuego.isEmpty()) {
            System.out.println("No hay modos de juego registrados.");
        } else {
            System.out.println("---- MODOS DE JUEGO ----");
            System.out.printf("%-8s%-20s%-30s%n", "ID", "Nombre", "Descripción");
            System.out.println("--------------------------------------------");

            for (ModoJuego modoJuego : modosJuego) {
                System.out.printf("%-8d%-20s%-30s%n", modoJuego.getIdModo(), modoJuego.getNombre(), modoJuego.getDescripcion());
            }
        }
    }




    private void agregarModoJuego() {
        System.out.println("---- AGREGAR MODO DE JUEGO ----");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        ModoJuego nuevoModoJuego = new ModoJuego(nombre, descripcion);
        modoJuegoBBDD.insertarModoJuego(nuevoModoJuego);

        System.out.println("El modo de juego se ha agregado correctamente.");
    }

    private void actualizarModoJuego() {
        System.out.println("---- ACTUALIZAR MODO DE JUEGO ----");

        System.out.print("ID del modo de juego a actualizar: ");
        int idModoJuego = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer el ID

        ModoJuego modoJuego = modoJuegoBBDD.obtenerModoJuego(idModoJuego);

        if (modoJuego == null) {
            System.out.println("No se encontró un modo de juego con el ID especificado.");
            return;
        }

        System.out.println("Modo de juego actual:");
        System.out.println(modoJuego);

        System.out.print("Nuevo nombre (dejar en blanco para mantener el nombre actual): ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nueva descripción (dejar en blanco para mantener la descripción actual): ");
        String nuevaDescripcion = scanner.nextLine();

        if (!nuevoNombre.isEmpty()) {
            modoJuego.setNombre(nuevoNombre);
        }

        if (!nuevaDescripcion.isEmpty()) {
            modoJuego.setDescripcion(nuevaDescripcion);
        }

        modoJuegoBBDD.actualizarModoJuego(modoJuego);

        System.out.println("El modo de juego se ha actualizado correctamente.");
    }

    private void eliminarModoJuego() {
        System.out.println("---- ELIMINAR MODO DE JUEGO ----");

        System.out.print("ID del modo de juego a eliminar: ");
        int idModoJuego = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer el ID

        ModoJuego modoJuego = modoJuegoBBDD.obtenerModoJuego(idModoJuego);

        if (modoJuego == null) {
            System.out.println("No se encontró un modo de juego con el ID especificado.");
            return;
        }

        System.out.println("Modo de juego a eliminar:");
        System.out.println(modoJuego);

        System.out.print("¿Estás seguro de que deseas eliminar este modo de juego? (S/N): ");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            modoJuegoBBDD.eliminarModoJuego(idModoJuego);
            System.out.println("El modo de juego se ha eliminado correctamente.");
        } else {
            System.out.println("No se ha eliminado el modo de juego.");
        }
    }

    public static void main(String[] args) {
        menuModoJuego menu = new menuModoJuego();
        menu.mostrarMenu();
    }
}
