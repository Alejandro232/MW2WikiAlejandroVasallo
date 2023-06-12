package mW2Wiki.MENUADMIN;

import mW2Wiki.CLASES.RequisitosPc;
import mW2Wiki.CLASESBBDD.RequisitosPcBBDD;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class menuRequisitosPc {

    private static final String MENU_OPTIONS =
            "----- Menú de Requisitos de PC -----\n" +
                    "1. Mostrar requisitos de PC\n" +
                    "2. Insertar requisito de PC\n" +
                    "3. Eliminar requisito de PC\n" +
                    "4. Actualizar requisito de PC\n" +
                    "5. Salir\n" +
                    "-----------------------------------\n" +
                    "Ingrese el número de opción: ";

    private RequisitosPcBBDD requisitosPcBBDD = new RequisitosPcBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki");
    private Scanner scanner;

    public menuRequisitosPc() {
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
                    case 2:
                        insertarRequisitoPc();
                        break;
                    case 3:
                        eliminarRequisitoPc();
                        break;
                    case 4:
                        actualizarRequisitoPc();
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
                System.out.printf("%d\t%-20s\t%-10s\t%-15s\t%-30s\t%-15s\t%s\n",
                        requisitoPc.getIdRequisito(), requisitoPc.getSistemaOperativo(), requisitoPc.getMemoriaRam(),
                        requisitoPc.getProcesador(), requisitoPc.getTarjetaGrafica(), requisitoPc.getMemoriaGrafica(),
                        requisitoPc.getAlmacenamiento());
            }
        }

        System.out.println();
    }


    private void insertarRequisitoPc() {
        System.out.println("----- Insertar Requisito de PC -----");

        System.out.print("Ingrese el ID del requisito: ");
        int idRequisito = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el sistema operativo: ");
        String sistemaOperativo = scanner.nextLine();

        System.out.print("Ingrese la memoria RAM: ");
        String memoriaRam = scanner.nextLine();

        System.out.print("Ingrese el procesador: ");
        String procesador = scanner.nextLine();

        System.out.print("Ingrese la tarjeta gráfica: ");
        String tarjetaGrafica = scanner.nextLine();

        System.out.print("Ingrese la memoria gráfica: ");
        String memoriaGrafica = scanner.nextLine();

        System.out.print("Ingrese el almacenamiento: ");
        String almacenamiento = scanner.nextLine();

        RequisitosPc requisitoPc = new RequisitosPc(idRequisito, sistemaOperativo, memoriaRam, procesador,
                tarjetaGrafica, memoriaGrafica, almacenamiento);
        requisitosPcBBDD.insertarRequisitoPc(requisitoPc);

        System.out.println("Requisito de PC insertado correctamente.");
        System.out.println();
    }

    private void eliminarRequisitoPc() {
        System.out.println("----- Eliminar Requisito de PC -----");

        System.out.print("Ingrese el ID del requisito a eliminar: ");
        int idRequisito = scanner.nextInt();
        scanner.nextLine();

        requisitosPcBBDD.eliminarRequisitoPc(idRequisito);

        System.out.println("Requisito de PC eliminado correctamente.");
        System.out.println();
    }

    private void actualizarRequisitoPc() {
        System.out.println("----- Actualizar Requisito de PC -----");

        System.out.print("Ingrese el ID del requisito a actualizar: ");
        int idRequisito = scanner.nextInt();
        scanner.nextLine();

        // Verificar si el requisito existe antes de proceder con la actualización
        List<RequisitosPc> requisitosPc = requisitosPcBBDD.obtenerRequisitosPc();
        boolean requisitoExiste = false;
        for (RequisitosPc requisitoPc : requisitosPc) {
            if (requisitoPc.getIdRequisito() == idRequisito) {
                requisitoExiste = true;
                break;
            }
        }

        if (requisitoExiste) {
            System.out.print("Ingrese el sistema operativo actualizado: ");
            String sistemaOperativo = scanner.nextLine();

            System.out.print("Ingrese la memoria RAM actualizada: ");
            String memoriaRam = scanner.nextLine();

            System.out.print("Ingrese el procesador actualizado: ");
            String procesador = scanner.nextLine();

            System.out.print("Ingrese la tarjeta gráfica actualizada: ");
            String tarjetaGrafica = scanner.nextLine();

            System.out.print("Ingrese la memoria gráfica actualizada: ");
            String memoriaGrafica = scanner.nextLine();

            System.out.print("Ingrese el almacenamiento actualizado: ");
            String almacenamiento = scanner.nextLine();

            RequisitosPc requisitoPc = new RequisitosPc(idRequisito, sistemaOperativo, memoriaRam, procesador,
                    tarjetaGrafica, memoriaGrafica, almacenamiento);
            requisitosPcBBDD.actualizarRequisitoPc(requisitoPc);

            System.out.println("Requisito de PC actualizado correctamente.");
        } else {
            System.out.println("El requisito con ID " + idRequisito + " no existe.");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        menuRequisitosPc menu = new menuRequisitosPc();
        menu.mostrarMenu();
    }
}
