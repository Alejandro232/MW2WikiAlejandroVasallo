package mW2Wiki.MENUADMIN;

import java.util.List;
import java.util.Scanner;

import mW2Wiki.CLASES.Arma;
import mW2Wiki.CLASESBBDD.ArmaBBDD;

public class menuArma {
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
            System.out.println("2. Agregar un arma");
            System.out.println("3. Eliminar un arma");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    mostrarArmas();
                    break;
                case 2:
                    agregarArma();
                    break;
                case 3:
                    eliminarArma();
                    break;
                case 4:
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




    private static void agregarArma() {
        System.out.println("Ingrese los datos del arma:");

        int idClaseArma;
        while (true) {
            try {
                System.out.print("ID Clase Arma: ");
                idClaseArma = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero para el ID Clase Arma.");
            }
        }

        String nombre;
        while (true) {
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();
            if (!nombre.isEmpty() && esTexto(nombre)) {
                break;
            } else {
                System.out.println("Error: el nombre no puede estar vacío y debe contener solo texto.");
            }
        }

        String descripcion;
        while (true) {
            System.out.print("Descripción: ");
            descripcion = scanner.nextLine();
            if (!descripcion.isEmpty() && esTexto(descripcion)) {
                break;
            } else {
                System.out.println("Error: la descripción no puede estar vacía y debe contener solo texto.");
            }
        }

        String requisitoDesbloqueo;
        while (true) {
            System.out.print("Requisito de desbloqueo: ");
            requisitoDesbloqueo = scanner.nextLine();
            if (!requisitoDesbloqueo.isEmpty() && esTexto(requisitoDesbloqueo)) {
                break;
            } else {
                System.out.println("Error: el requisito de desbloqueo no puede estar vacío y debe contener solo texto.");
            }
        }

        int daño;
        while (true) {
            try {
                System.out.print("Daño: ");
                daño = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero para el Daño.");
            }
        }

        int precision;
        while (true) {
            try {
                System.out.print("Precisión: ");
                precision = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero para la Precisión.");
            }
        }

        int retroceso;
        while (true) {
            try {
                System.out.print("Retroceso: ");
                retroceso = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero para el Retroceso.");
            }
        }

        int manejo;
        while (true) {
            try {
                System.out.print("Manejo: ");
                manejo = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero para el Manejo.");
            }
        }

        int movilidad;
        while (true) {
            try {
                System.out.print("Movilidad: ");
                movilidad = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero para la Movilidad.");
            }
        }

        int cadencia;
        while (true) {
            try {
                System.out.print("Cadencia: ");
                cadencia = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero para la Cadencia.");
            }
        }

        int alcance;
        while (true) {
            try {
                System.out.print("Alcance: ");
                alcance = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero para el Alcance.");
            }
        }

        Arma nuevaArma = new Arma(idClaseArma, nombre, descripcion, requisitoDesbloqueo, daño, precision,
                retroceso, manejo, movilidad, cadencia, alcance);

        armaBBDD.insertarArma(nuevaArma);
        System.out.println("El arma se ha agregado correctamente a la base de datos.");
    }

    private static boolean esTexto(String texto) {
        return texto.matches("[a-zA-Z]+");
    }




    private static void eliminarArma() {
        System.out.print("Ingrese el ID del arma que desea eliminar: ");
        int idArma = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        armaBBDD.eliminarArma(idArma);
        System.out.println("El arma se ha eliminado correctamente de la base de datos.");
    }
}
