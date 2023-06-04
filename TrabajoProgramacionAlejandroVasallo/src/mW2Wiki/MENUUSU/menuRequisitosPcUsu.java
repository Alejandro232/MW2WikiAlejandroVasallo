package mW2Wiki.MENUUSU;

import mW2Wiki.CLASES.RequisitosPc;
import mW2Wiki.CLASESBBDD.RequisitosPcBBDD;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class menuRequisitosPcUsu {

    private static final String MENU_OPTIONS =
            "----- Menú de Requisitos de PC -----\n" +
                    "1. Mostrar requisitos de PC\n" +
                    "5. Salir\n" +
                    "-----------------------------------\n" +
                    "Ingrese el número de opción: ";

    private RequisitosPcBBDD requisitosPcBBDD = new RequisitosPcBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki");
    private Scanner scanner;

    public menuRequisitosPcUsu() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.print(MENU_OPTIONS);
            try {
                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir nueva línea pendiente

                switch (option) {
                    case 1:
                        mostrarRequisitosPc();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // Consumir entrada inválida
            }

            System.out.println();
        }

        System.out.println("¡Hasta luego!");
    }

    private void mostrarRequisitosPc() {
        System.out.println("----- Mostrar Requisitos de PC -----");

        List<RequisitosPc> requisitosPc = requisitosPcBBDD.obtenerRequisitosPc();
        if (requisitosPc.isEmpty()) {
            System.out.println("No se encontraron requisitos de PC.");
        } else {
            System.out.println("ID\tSistema Operativo\tMemoria RAM\tProcesador\tTarjeta Gráfica\tMemoria Gráfica\tAlmacenamiento");
            System.out.println("---------------------------------------------------------------------------------------------------");
            for (RequisitosPc requisitoPc : requisitosPc) {
                System.out.printf("%d\t%-20s\t%-10s\t%-10s\t%-16s\t%-16s\t%s\n",
                        requisitoPc.getIdRequisito(), requisitoPc.getSistemaOperativo(), requisitoPc.getMemoriaRam(),
                        requisitoPc.getProcesador(), requisitoPc.getTarjetaGrafica(), requisitoPc.getMemoriaGrafica(),
                        requisitoPc.getAlmacenamiento());
            }
        }

        System.out.println();
    }



 

    public static void main(String[] args) {
        menuRequisitosPcUsu menu = new menuRequisitosPcUsu();
        menu.mostrarMenu();
    }
}
