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
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                
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
            for (Faccion faccion : facciones) {
                System.out.println(faccion);
            }
        }
    }

    private void agregarFaccion() {
        System.out.println("===== AGREGAR FACCIÓN =====");
        System.out.print("Ingrese el ID de la facción: ");
        int idFaccion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer el número
        System.out.print("Ingrese el nombre de la facción: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción de la facción: ");
        String descripcion = scanner.nextLine();

        Faccion nuevaFaccion = new Faccion(idFaccion, nombre, descripcion);
        faccionBBDD.insertarFaccion(nuevaFaccion);
        System.out.println("La facción se agregó correctamente.");
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
        FaccionBBDD faccionBBDD = new FaccionBBDD(); // Reemplaza esta línea con tu propia lógica de inicialización de la base de datos
        menuFaccionUsu menu = new menuFaccionUsu(faccionBBDD);
        menu.mostrarMenu();
    }
}
