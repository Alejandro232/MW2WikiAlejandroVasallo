package mW2Wiki.MENUUSU;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import mW2Wiki.CLASES.Arma;
import mW2Wiki.CLASESBBDD.ArmaBBDD;

public class menuArmaUsu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String usu = "root";
    private static final String pas = "alejandro2002";
    private static final String puerto = "3307";
    private static final String maquina = "localhost";
    private static final String baseDatos = "mw2wiki";
    private static final ArmaBBDD armaBBDD = new ArmaBBDD(usu, pas, puerto, maquina, baseDatos);

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Menú de Gestión de Armas ===");
            System.out.println("1. Mostrar armas");
            System.out.println("2. Comparar armas por atributo");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    mostrarArmas();
                    break;
                case 2:
                    compararArmasPorAtributo();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

    private static void mostrarArmas() {
        List<Arma> armas = Arma.obtenerArmas();
        for (Arma arma : armas) {
            System.out.printf("ID: %d%n", arma.getId_Arma());
            System.out.printf("Nombre: %s%n", arma.getNombre());
            System.out.printf("Descripción: %s%n", arma.getDescripcion());
            System.out.printf("Requisito de Desbloqueo: %s%n", arma.getRequisito_Desbloqueo());
            System.out.printf("Daño: %d%n", arma.getDaño());
            System.out.printf("Precisión: %d%n", arma.getPrecision());
            System.out.printf("Retroceso: %d%n", arma.getRetroceso());
            System.out.printf("Manejo: %d%n", arma.getManejo());
            System.out.printf("Movilidad: %d%n", arma.getMovilidad());
            System.out.printf("Cadencia: %d%n", arma.getCadencia());
            System.out.printf("Alcance: %d%n", arma.getAlcance());
            System.out.println("------------------------------");
        }
    }
    
    private static void compararArmasPorAtributo() {
        List<Arma> armas = Arma.obtenerArmas();
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Comparar armas por atributo ===");
            System.out.println("1. Comparar por daño");
            System.out.println("2. Comparar por precisión");
            System.out.println("3. Comparar por retroceso");
            System.out.println("4. Comparar por manejo");
            System.out.println("5. Comparar por movilidad");
            System.out.println("6. Comparar por cadencia");
            System.out.println("7. Comparar por alcance");
            System.out.println("8. Volver al menú principal");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    Collections.sort(armas, Comparator.comparingInt(Arma::getDaño));
                    break;
                case 2:
                    Collections.sort(armas, Comparator.comparingInt(Arma::getPrecision));
                    break;
                case 3:
                    Collections.sort(armas, Comparator.comparingInt(Arma::getRetroceso));
                    break;
                case 4:
                    Collections.sort(armas, Comparator.comparingInt(Arma::getManejo));
                    break;
                case 5:
                    Collections.sort(armas, Comparator.comparingInt(Arma::getMovilidad));
                    break;
                case 6:
                    Collections.sort(armas, Comparator.comparingInt(Arma::getCadencia));
                    break;
                case 7:
                    Collections.sort(armas, Comparator.comparingInt(Arma::getAlcance));
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            if (!salir) {
                // Mostrar las armas ordenadas por el atributo seleccionado
                for (Arma arma : armas) {
                    System.out.printf("ID: %d%n", arma.getId_Arma());
                    System.out.printf("Nombre: %s%n", arma.getNombre());
                    System.out.printf("Descripción: %s%n", arma.getDescripcion());
                    System.out.printf("Requisito de Desbloqueo: %s%n", arma.getRequisito_Desbloqueo());
                    System.out.printf("Daño: %d%n", arma.getDaño());
                    System.out.printf("Precisión: %d%n", arma.getPrecision());
                    System.out.printf("Retroceso: %d%n", arma.getRetroceso());
                    System.out.printf("Manejo: %d%n", arma.getManejo());
                    System.out.printf("Movilidad: %d%n", arma.getMovilidad());
                    System.out.printf("Cadencia: %d%n", arma.getCadencia());
                    System.out.printf("Alcance: %d%n", arma.getAlcance());
                    System.out.println("------------------------------");
                }
            }
        }
    }
}
