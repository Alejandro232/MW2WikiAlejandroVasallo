package mW2Wiki.MENUUSU;

import mW2Wiki.CLASES.Racha_Bajas;
import mW2Wiki.CLASESBBDD.Racha_BajasBBDD;

import java.util.List;
import java.util.Scanner;

public class menuRachaBajasUsu {
    private Scanner scanner;
    private Racha_BajasBBDD rachaBajasBBDD;

    public menuRachaBajasUsu() {
        scanner = new Scanner(System.in);
        // Aquí debes proporcionar los valores adecuados para los parámetros de conexión a tu base de datos
        rachaBajasBBDD = new Racha_BajasBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki");
    }

    public void mostrarMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("----- Menú Racha Bajas -----");
            System.out.println("1. Mostrar todas las rachas bajas");
            System.out.println("2. Salir");
            System.out.print("Ingrese el número de opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    mostrarTodasLasRachasBajas();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void mostrarTodasLasRachasBajas() {
        List<Racha_Bajas> rachasBajas = rachaBajasBBDD.obtenerRachasBajas();
        System.out.println("----- Todas las Rachas Bajas -----");
        for (Racha_Bajas rachaBajas : rachasBajas) {
            System.out.println("ID: " + rachaBajas.getIdRachaBajas());
            System.out.println("Nombre: " + rachaBajas.getNombre());
            System.out.println("Descripción: " + rachaBajas.getDescripcion());
            System.out.println("Puntos Necesarios: " + rachaBajas.getPuntosNecesarios());
            System.out.println("---------------------------------");
        }
    }

    public static void main(String[] args) {
        menuRachaBajasUsu menu = new menuRachaBajasUsu();
        menu.mostrarMenu();
    }
}
