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
            System.out.println("2. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer el número

            switch (opcion) {
                case 1:
                    mostrarMapas();
                    break;
                case 2:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            System.out.println();
        } while (opcion != 2);
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

    public static void main(String[] args) {
        menuMapaUsu menu = new menuMapaUsu();
        menu.mostrarMenu();
    }
}
