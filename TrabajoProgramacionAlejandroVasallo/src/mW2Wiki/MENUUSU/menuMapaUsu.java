package mW2Wiki.MENUUSU;

import mW2Wiki.CLASES.Mapa;
import mW2Wiki.CLASESBBDD.MapaBBDD;

import java.util.List;
import java.util.Scanner;

public class menuMapaUsu {
    private MapaBBDD mapaBBDD;
    private Scanner scanner;

    public menuMapaUsu() {
        this.mapaBBDD = new MapaBBDD();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("===== MENU MAPAS =====");
            System.out.println("1. Mostrar mapas");
            System.out.println("2. Agregar mapa");
            System.out.println("3. Actualizar mapa");
            System.out.println("4. Eliminar mapa");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer el número

            switch (opcion) {
                case 1:
                    mostrarMapas();
                    break;
                case 2:
                    agregarMapa();
                    break;
                case 3:
                    actualizarMapa();
                    break;
                case 4:
                    eliminarMapa();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            System.out.println();
        } while (opcion != 5);
    }

    private void mostrarMapas() {
        System.out.println("===== LISTA DE MAPAS =====");
        List<Mapa> mapas = mapaBBDD.obtenerMapas();
        if (mapas.isEmpty()) {
            System.out.println("No hay mapas registrados.");
        } else {
            for (Mapa mapa : mapas) {
                System.out.println("ID: " + mapa.getIdMapa());
                System.out.println("Nombre: " + mapa.getNombre());
                System.out.println("Descripción: " + mapa.getDescripcion());
                System.out.println("------------------------------");
            }
        }
    }


    private void agregarMapa() {
        System.out.println("===== AGREGAR MAPA =====");
        System.out.print("Ingrese el nombre del mapa: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del mapa: ");
        String descripcion = scanner.nextLine();

        Mapa nuevoMapa = new Mapa(nombre, descripcion);
        mapaBBDD.insertarMapa(nuevoMapa);
        System.out.println("El mapa se agregó correctamente.");
    }

    private void actualizarMapa() {
        System.out.println("===== ACTUALIZAR MAPA =====");
        System.out.print("Ingrese el ID del mapa a actualizar: ");
        int idMapa = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer el número

        Mapa mapaExistente = mapaBBDD.buscarMapaPorId(idMapa);
        if (mapaExistente == null) {
            System.out.println("No se encontró un mapa con ese ID.");
        } else {
            System.out.print("Ingrese el nuevo nombre del mapa: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese la nueva descripción del mapa: ");
            String nuevaDescripcion = scanner.nextLine();

            mapaExistente.setNombre(nuevoNombre);
            mapaExistente.setDescripcion(nuevaDescripcion);

            mapaBBDD.actualizarMapa(mapaExistente);
            System.out.println("El mapa se actualizó correctamente.");
        }
    }

    private void eliminarMapa() {
        System.out.println("===== ELIMINAR MAPA =====");
        System.out.print("Ingrese el ID del mapa a eliminar: ");
        int idMapa = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer el número

        Mapa mapaExistente = mapaBBDD.buscarMapaPorId(idMapa);
        if (mapaExistente == null) {
            System.out.println("No se encontró un mapa con ese ID.");
        } else {
            mapaBBDD.eliminarMapa(idMapa);
            System.out.println("El mapa se eliminó correctamente.");
        }
    }

    public static void main(String[] args) {
        menuMapaUsu menu = new menuMapaUsu();
        menu.mostrarMenu();
    }
}
