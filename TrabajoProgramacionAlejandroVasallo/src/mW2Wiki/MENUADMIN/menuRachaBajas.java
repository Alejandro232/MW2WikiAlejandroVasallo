package mW2Wiki.MENUADMIN;

import mW2Wiki.CLASES.Racha_Bajas;
import mW2Wiki.CLASESBBDD.Racha_BajasBBDD;

import java.util.List;
import java.util.Scanner;

public class menuRachaBajas {
    private Scanner scanner;
    private Racha_BajasBBDD rachaBajasBBDD;

    public menuRachaBajas() {
        scanner = new Scanner(System.in);
        // Aquí debes proporcionar los valores adecuados para los parámetros de conexión a tu base de datos
        rachaBajasBBDD = new Racha_BajasBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki");
    }

    public void mostrarMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("----- Menú Racha Bajas -----");
            System.out.println("1. Mostrar todas las rachas bajas");
            System.out.println("2. Insertar una nueva racha baja");
            System.out.println("3. Actualizar una racha baja");
            System.out.println("4. Eliminar una racha baja");
            System.out.println("5. Salir");
            System.out.print("Ingrese el número de opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    mostrarTodasLasRachasBajas();
                    break;
                case 2:
                    insertarRachaBaja();
                    break;
                case 3:
                    actualizarRachaBaja();
                    break;
                case 4:
                    eliminarRachaBaja();
                    break;
                case 5:
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


    private void insertarRachaBaja() {
        System.out.println("----- Insertar Nueva Racha Baja -----");

        // Ingresar el nombre de la racha baja (solo se permiten letras y espacios)
        String nombre;
        boolean nombreValido = false;
        do {
            System.out.print("Ingrese el nombre de la racha baja: ");
            nombre = scanner.next();
            if (nombre.matches("[a-zA-Z\\s]+")) {
                nombreValido = true;
            } else {
                System.out.println("Error: El nombre solo puede contener letras y espacios.");
            }
        } while (!nombreValido);

        // Ingresar la descripción de la racha baja (solo se permiten letras y espacios)
        String descripcion;
        boolean descripcionValida = false;
        do {
            System.out.print("Ingrese la descripción de la racha baja: ");
            descripcion = scanner.next();
            if (descripcion.matches("[a-zA-Z\\s]+")) {
                descripcionValida = true;
            } else {
                System.out.println("Error: La descripción solo puede contener letras y espacios.");
            }
        } while (!descripcionValida);

        // Ingresar los puntos necesarios de la racha baja (solo se permiten números)
        int puntosNecesarios = 0; // Inicializar con un valor predeterminado
        boolean puntosValidos = false;
        do {
            System.out.print("Ingrese los puntos necesarios de la racha baja: ");
            if (scanner.hasNextInt()) {
                puntosNecesarios = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del Scanner
                puntosValidos = true;
            } else {
                System.out.println("Error: Los puntos necesarios deben ser un número válido.");
                scanner.nextLine(); // Limpiar el buffer del Scanner
            }
        } while (!puntosValidos);

        Racha_Bajas rachaBajas = new Racha_Bajas(nombre, descripcion, puntosNecesarios);
        rachaBajasBBDD.insertarRachaBajas(rachaBajas);
        System.out.println("Racha baja insertada correctamente.");
    }



    private void actualizarRachaBaja() {
        System.out.println("----- Actualizar Racha Baja -----");
        System.out.print("Ingrese el ID de la racha baja que desea actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del Scanner

        // Verificar si la racha baja existe
        Racha_Bajas rachaBajasExistente = obtenerRachaBajaPorID(id);
        if (rachaBajasExistente == null) {
            System.out.println("No se encontró la racha baja con el ID especificado.");
            return;
        }

        System.out.print("Ingrese el nuevo nombre de la racha baja (deje vacío para mantener el actual): ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la nueva descripción de la racha baja (deje vacío para mantener la actual): ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese los nuevos puntos necesarios de la racha baja (0 para mantener los actuales): ");
        int puntosNecesarios = scanner.nextInt();

        // Actualizar los campos solo si se proporcionan valores no vacíos
        if (!nombre.isEmpty()) {
            rachaBajasExistente.setNombre(nombre);
        }
        if (!descripcion.isEmpty()) {
            rachaBajasExistente.setDescripcion(descripcion);
        }
        if (puntosNecesarios != 0) {
            rachaBajasExistente.setPuntosNecesarios(puntosNecesarios);
        }

        rachaBajasBBDD.actualizarRachaBajas(rachaBajasExistente);
        System.out.println("Racha baja actualizada correctamente.");
    }

    private void eliminarRachaBaja() {
        System.out.println("----- Eliminar Racha Baja -----");
        System.out.print("Ingrese el ID de la racha baja que desea eliminar: ");
        int id = scanner.nextInt();

        // Verificar si la racha baja existe
        Racha_Bajas rachaBajasExistente = obtenerRachaBajaPorID(id);
        if (rachaBajasExistente == null) {
            System.out.println("No se encontró la racha baja con el ID especificado.");
            return;
        }

        rachaBajasBBDD.eliminarRachaBajas(id);
        System.out.println("Racha baja eliminada correctamente.");
    }

    private Racha_Bajas obtenerRachaBajaPorID(int id) {
        List<Racha_Bajas> rachasBajas = rachaBajasBBDD.obtenerRachasBajas();
        for (Racha_Bajas rachaBajas : rachasBajas) {
            if (rachaBajas.getIdRachaBajas() == id) {
                return rachaBajas;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        menuRachaBajas menu = new menuRachaBajas();
        menu.mostrarMenu();
    }
}
