package mW2Wiki.MENUADMIN;

import java.util.List;
import java.util.Scanner;

import mW2Wiki.CLASES.ModoJuego;
import mW2Wiki.CLASESBBDD.ModoJuegoBBDD;

public class menuModoJuego {

    private ModoJuegoBBDD modoJuegoBBDD;

    public menuModoJuego() {
        // Configurar los datos de conexión a la base de datos
        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";

        modoJuegoBBDD = new ModoJuegoBBDD(usu, pas, puerto, maquina, baseDatos);
    }

    public void mostrarMenu(Scanner scanner) {
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
            scanner.nextLine(); // Consumir el salto de línea después de leer el entero

            switch (opcion) {
                case 1:
                    mostrarModosJuego();
                    break;
                case 2:
                    agregarModoJuego(scanner);
                    break;
                case 3:
                    actualizarModoJuego(scanner);
                    break;
                case 4:
                    eliminarModoJuego(scanner);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }

            System.out.println();
        }
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
                System.out.printf("%-8d%-20s%-30s%n", modoJuego.getIdModo(), modoJuego.getNombre(),
                        modoJuego.getDescripcion());
            }
        }
    }

    private void agregarModoJuego(Scanner scanner) {
        System.out.println("---- AGREGAR MODO DE JUEGO ----");

        System.out.print("Ingrese el nombre del modo de juego: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la descripción del modo de juego: ");
        String descripcion = scanner.nextLine();

        ModoJuego modoJuego = new ModoJuego(nombre, descripcion);
        modoJuegoBBDD.insertarModoJuego(modoJuego);

        System.out.println("Modo de juego agregado exitosamente.");
    }

    private void actualizarModoJuego(Scanner scanner) {
        System.out.println("---- ACTUALIZAR MODO DE JUEGO ----");

        System.out.print("Ingrese el ID del modo de juego que desea actualizar: ");
        int idModo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer el entero

        ModoJuego modoJuegoExistente = modoJuegoBBDD.obtenerModoJuego(idModo);

        if (modoJuegoExistente == null) {
            System.out.println("No se encontró un modo de juego con ese ID.");
            return;
        }

        System.out.print("Ingrese el nuevo nombre del modo de juego: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Ingrese la nueva descripción del modo de juego: ");
        String nuevaDescripcion = scanner.nextLine();

        ModoJuego modoJuegoActualizado = new ModoJuego(idModo, nuevoNombre, nuevaDescripcion);
        modoJuegoBBDD.actualizarModoJuego(modoJuegoActualizado);

        System.out.println("Modo de juego actualizado exitosamente.");
    }

    private void eliminarModoJuego(Scanner scanner) {
        System.out.println("---- ELIMINAR MODO DE JUEGO ----");

        System.out.print("Ingrese el ID del modo de juego que desea eliminar: ");
        int idModo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer el entero

        ModoJuego modoJuegoExistente = modoJuegoBBDD.obtenerModoJuego(idModo);

        if (modoJuegoExistente == null) {
            System.out.println("No se encontró un modo de juego con ese ID.");
            return;
        }

        modoJuegoBBDD.eliminarModoJuego(idModo);

        System.out.println("Modo de juego eliminado exitosamente.");
    }
   
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            menuModoJuego menu = new menuModoJuego();
            menu.mostrarMenu(scanner);
            scanner.close();
        }

	
}
