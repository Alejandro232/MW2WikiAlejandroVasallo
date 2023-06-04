package mW2Wiki.MENUUSU;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import mW2Wiki.CLASES.Aspecto;
import mW2Wiki.CLASESBBDD.AspectoBBDD;

public class menuAspectoUsu {
    private AspectoBBDD aspectoBBDD;
    private Scanner scanner;

    public menuAspectoUsu(String usu, String pas, String puerto, String maquina, String baseDatos) {
        aspectoBBDD = new AspectoBBDD(usu, pas, puerto, maquina, baseDatos);
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("----- Menú de Aspectos -----");
            System.out.println("1. Mostrar aspectos");
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

        System.out.println("¡Hasta luego!");
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

        menuAspectoUsu aspectoMenu = new menuAspectoUsu(usu, pas, puerto, maquina, baseDatos);
        aspectoMenu.mostrarMenu();
    }
}
