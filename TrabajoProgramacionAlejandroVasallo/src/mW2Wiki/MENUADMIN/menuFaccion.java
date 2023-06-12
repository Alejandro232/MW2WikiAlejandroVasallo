package mW2Wiki.MENUADMIN;

import mW2Wiki.CLASES.Faccion;
import mW2Wiki.CLASESBBDD.FaccionBBDD;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class menuFaccion {
    private FaccionBBDD faccionBBDD = new FaccionBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki");
    private Scanner scanner;

    public menuFaccion(FaccionBBDD faccionBBDD) {
        this.faccionBBDD = faccionBBDD;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("===== MENU FACCIÓN =====");
            System.out.println("1. Mostrar facciones");
            System.out.println("2. Agregar facción");
            System.out.println("3. Actualizar facción");
            System.out.println("4. Eliminar facción");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer el número

            switch (opcion) {
                case 1:
                    mostrarFacciones();
                    break;
                case 2:
                    agregarFaccion();
                    break;
                case 3:
                    actualizarFaccion();
                    break;
                case 4:
                    eliminarFaccion();
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


    private void agregarFaccion() {
        System.out.println("===== AGREGAR FACCIÓN =====");
        int idFaccion = leerEntero("Ingrese el ID de la facción: ");
        String nombre = leerCadenaNoNumerica("Ingrese el nombre de la facción: ");
        String descripcion = leerCadenaNoNumerica("Ingrese la descripción de la facción: ");

        Faccion nuevaFaccion = new Faccion(idFaccion, nombre, descripcion);
        faccionBBDD.insertarFaccion(nuevaFaccion);
        System.out.println("La facción se agregó correctamente.");
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: entrada inválida. Por favor, ingrese un número entero.");
                scanner.nextLine(); // Consumir la entrada inválida
            }
        }
    }

    private String leerCadenaNoNumerica(String mensaje) {
        String entrada;
        while (true) {
            System.out.print(mensaje);
            entrada = scanner.next();
            if (!entrada.matches(".*\\d.*")) {
                break;
            } else {
                System.out.println("Error: la entrada no puede contener números. Por favor, ingrese una cadena de texto.");
            }
        }
        return entrada;
    }


    private void actualizarFaccion() {
        System.out.println("===== ACTUALIZAR FACCIÓN =====");
        System.out.print("Ingrese el ID de la facción a actualizar: ");
        int idFaccion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer el número

        Faccion faccionExistente = buscarFaccionPorId(idFaccion);
        if (faccionExistente == null) {
            System.out.println("No se encontró una facción con ese ID.");
        } else {
            System.out.print("Ingrese el nuevo nombre de la facción (dejar en blanco para mantener el valor actual): ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese la nueva descripción de la facción (dejar en blanco para mantener el valor actual): ");
            String nuevaDescripcion = scanner.nextLine();

            // Actualizar los valores solo si se proporciona un valor no vacío
            if (!nuevoNombre.isEmpty()) {
                faccionExistente.setNombre(nuevoNombre);
            }
            if (!nuevaDescripcion.isEmpty()) {
                faccionExistente.setDescripcion(nuevaDescripcion);
            }

            faccionBBDD.actualizarFaccion(faccionExistente);
            System.out.println("La facción se actualizó correctamente.");
        }
    }

    private void eliminarFaccion() {
        System.out.println("===== ELIMINAR FACCIÓN =====");
        System.out.print("Ingrese el ID de la facción a eliminar: ");
        int idFaccion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer el número

        Faccion faccionExistente = buscarFaccionPorId(idFaccion);
        if (faccionExistente == null) {
            System.out.println("No se encontró una facción con ese ID.");
        } else {
            faccionBBDD.eliminarFaccion(idFaccion);
            System.out.println("La facción se eliminó correctamente.");
        }
    }

    private Faccion buscarFaccionPorId(int idFaccion) {
        List<Faccion> facciones = faccionBBDD.obtenerFacciones();
        for (Faccion faccion : facciones) {
            if (faccion.getIdFaccion() == idFaccion) {
                return faccion;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";

        FaccionBBDD faccionBBDD = new FaccionBBDD(usu, pas, puerto, maquina, baseDatos);
        menuFaccion menu = new menuFaccion(faccionBBDD);
        menu.mostrarMenu();
    }

}
