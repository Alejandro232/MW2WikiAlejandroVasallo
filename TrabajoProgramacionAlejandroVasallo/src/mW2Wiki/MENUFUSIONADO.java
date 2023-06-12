package mW2Wiki;

import java.util.Scanner;
import mW2Wiki.MENUADMIN.MENUADMINCOMPLETO;
import mW2Wiki.MENUUSU.MENUUSUCOMPLETO;
import mW2Wiki.PARTIDAPERSONALIZADA.MenuPartidaPersonalizada;

public class MENUFUSIONADO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();
            System.out.print("Ingrese una opción: ");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        MENUADMINCOMPLETO.main(args);
                        break;
                    case 2:
                        MENUUSUCOMPLETO.main(args);
                        break;
                    case 3:
                        MenuPartidaPersonalizada.main(args);
                        break;
                    case 4:
                        salir = true;
                        System.out.println("Salió del Programa MW2Wiki");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                        break;
                }
            } else {
                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                scanner.nextLine(); // Consumir el salto de línea
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Menú Administrador");
        System.out.println("2. Menú Usuario");
        System.out.println("3.Crear Partida Personalizada");
        System.out.println("4. Salir");
    }
}
