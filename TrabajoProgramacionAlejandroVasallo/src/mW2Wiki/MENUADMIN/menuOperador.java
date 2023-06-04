package mW2Wiki.MENUADMIN;

import mW2Wiki.CLASES.Faccion;
import mW2Wiki.CLASES.Operador;
import mW2Wiki.CLASESBBDD.FaccionBBDD;
import mW2Wiki.CLASESBBDD.OperadorBBDD;

import java.util.List;
import java.util.Scanner;

public class menuOperador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OperadorBBDD operadorBBDD = new OperadorBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki");

        boolean continuar = true;
        while (continuar) {
            System.out.println("=== Menú Operador ===");
            System.out.println("1. Crear Operador");
            System.out.println("2. Mostrar Operadores");
            System.out.println("3. Actualizar Operador");
            System.out.println("4. Eliminar Operador");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    crearOperador(scanner, operadorBBDD);
                    break;
                case 2:
                	FaccionBBDD faccionBBDD = new FaccionBBDD("root", "alejandro2002", "3307", "localhost", "mw2wiki"); // Crear una instancia de FaccionBBDD si no la tienes

                    mostrarOperadores(operadorBBDD,faccionBBDD);
                    break;
                case 3:
                    actualizarOperador(scanner, operadorBBDD);
                    break;
                case 4:
                    eliminarOperador(scanner, operadorBBDD);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }

    private static void crearOperador(Scanner scanner, OperadorBBDD operadorBBDD) {
        System.out.println("=== Crear Operador ===");
        System.out.print("Ingrese el ID del Operador: ");
        int idOperador = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        System.out.print("Ingrese el ID de la Facción: ");
        int idFaccion = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        System.out.print("Ingrese el género: ");
        String genero = scanner.nextLine();

        System.out.print("Ingrese la altura: ");
        float altura = scanner.nextFloat();
        scanner.nextLine(); // Consumir nueva línea

        Operador operador = new Operador(idOperador, idFaccion, genero, altura);
        operadorBBDD.insertarOperador(operador);

        System.out.println("Operador creado exitosamente");
        System.out.println();
    }

    private static void mostrarOperadores(OperadorBBDD operadorBBDD, FaccionBBDD faccionBBDD) {
        System.out.println("=== Mostrar Operadores ===");
        List<Operador> operadores = operadorBBDD.obtenerOperadores();

        if (operadores.isEmpty()) {
            System.out.println("No se encontraron operadores.");
        } else {
            System.out.printf("%-15s %-15s %-15s %-15s%n", "ID Operador", "Facción", "Género", "Altura");
            System.out.println("---------------------------------------------");

            for (Operador operador : operadores) {
                Faccion faccion = obtenerFaccionPorId(faccionBBDD, operador.getIdFaccion());
                String nombreFaccion = faccion != null ? faccion.getNombre() : "Desconocida";

                System.out.printf("%-15d %-15s %-15s %-15.2f%n", operador.getIdOperador(), nombreFaccion,
                        operador.getGenero(), operador.getAltura());
            }
        }

        System.out.println();
    }

    private static Faccion obtenerFaccionPorId(FaccionBBDD faccionBBDD, int idFaccion) {
        List<Faccion> facciones = faccionBBDD.obtenerFacciones();

        for (Faccion faccion : facciones) {
            if (faccion.getIdFaccion() == idFaccion) {
                return faccion;
            }
        }

        return null;
    }



    private static void actualizarOperador(Scanner scanner, OperadorBBDD operadorBBDD) {
        System.out.println("=== Actualizar Operador ===");
        System.out.print("Ingrese el ID del Operador a actualizar: ");
        int idOperador = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        // Verificar si el Operador existe
        List<Operador> operadores = operadorBBDD.obtenerOperadores();
        boolean encontrado = false;
        for (Operador operador : operadores) {
            if (operador.getIdOperador() == idOperador) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.print("Ingrese el nuevo ID de la Facción: ");
            int idFaccion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            System.out.print("Ingrese el nuevo género: ");
            String genero = scanner.nextLine();

            System.out.print("Ingrese la nueva altura: ");
            float altura = scanner.nextFloat();
            scanner.nextLine(); // Consumir nueva línea

            Operador operador = new Operador(idOperador, idFaccion, genero, altura);
            operadorBBDD.actualizarOperador(operador);

            System.out.println("Operador actualizado exitosamente");
        } else {
            System.out.println("El ID del Operador no existe");
        }

        System.out.println();
    }

    private static void eliminarOperador(Scanner scanner, OperadorBBDD operadorBBDD) {
        System.out.println("=== Eliminar Operador ===");
        System.out.print("Ingrese el ID del Operador a eliminar: ");
        int idOperador = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        // Verificar si el Operador existe
        List<Operador> operadores = operadorBBDD.obtenerOperadores();
        boolean encontrado = false;
        for (Operador operador : operadores) {
            if (operador.getIdOperador() == idOperador) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            operadorBBDD.eliminarOperador(idOperador);
            System.out.println("Operador eliminado exitosamente");
        } else {
            System.out.println("El ID del Operador no existe");
        }

        System.out.println();
    }
}

