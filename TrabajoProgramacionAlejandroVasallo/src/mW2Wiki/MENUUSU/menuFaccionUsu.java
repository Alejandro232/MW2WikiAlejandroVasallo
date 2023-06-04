package mW2Wiki.MENUUSU;

import mW2Wiki.CLASES.Faccion;
import mW2Wiki.CLASESBBDD.FaccionBBDD;
import java.util.List;
import java.util.Scanner;

public class menuFaccionUsu {
    private FaccionBBDD faccionBBDD;
    private Scanner scanner;

    public menuFaccionUsu(FaccionBBDD faccionBBDD) {
        this.faccionBBDD = faccionBBDD;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("===== MENU FACCIÓN =====");
            System.out.println("1. Mostrar facciones");
            System.out.println("2. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer el número

            switch (opcion) {
                case 1:
                    mostrarFacciones();
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

    private void mostrarFacciones() {
        System.out.println("===== LISTA DE FACCIONES =====");
        List<Faccion> facciones = faccionBBDD.obtenerFacciones();

        if (facciones.isEmpty()) {
            System.out.println("No hay facciones registradas.");
        } else {
            System.out.println("| ID   | Nombre                | Descripción            |");
            System.out.println("+------+-----------------------+-----------------------+");

            for (Faccion faccion : facciones) {
                System.out.printf("| %-4d | %-21s | %-21s |%n", faccion.getIdFaccion(), faccion.getNombre(), faccion.getDescripcion());
            }

            System.out.println("+------+-----------------------+-----------------------+");
        }
    }

    public static void main(String[] args) {
        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";

        FaccionBBDD faccionBBDD = new FaccionBBDD(usu, pas, puerto, maquina, baseDatos);
        menuFaccionUsu menu = new menuFaccionUsu(faccionBBDD);
        menu.mostrarMenu();
    }
}
