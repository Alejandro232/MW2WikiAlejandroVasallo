package mW2Wiki.MENUADMIN;

import java.util.Scanner;

public class MENUADMINCOMPLETO {

    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la contraseña: ");
        String password = scanner.nextLine();

        if (password.equals(PASSWORD)) {
            boolean salir = false;

            while (!salir) {
                mostrarMenu();
                System.out.print("Ingrese una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el búfer del scanner

                switch (opcion) {
                    case 1:
                        menuAccesorios.main(args);
                        break;
                    case 2:
                        menuArma.main(args);;
                        break;
                    case 3:
                        menuAspecto.main(args);;
                        break;
                    case 4:
                        menuCamuflaje.main(args);;
                        break;
                    case 5:
                        menuClaseArma.main(args);;
                        break;
                    case 6:
                        menuFaccion.main(args);;
                        break;
                    case 7:
                        menuMapa.main(args);
                        break;
                    case 8:
                        menuModoJuego.main(args);;
                        break;
                    case 9:
                        menuOperador.main(args);;
                        break;
                    case 10:
                       menuRachaBajas.main(args);
                        break;
                    case 11:
                        menuRequisitosPc.main(args);
                        break;
                    case 12:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                        break;
                }
                System.out.println();
            }
        } else {
            System.out.println("Contraseña incorrecta. No tiene acceso al programa gestos de la BBDD MW2WIKI.");
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("=== Menú ===");
        System.out.println("1. Accesorios");
        System.out.println("2. Armas");
        System.out.println("3. Aspectos");
        System.out.println("4. Camuflajes");
        System.out.println("5. Clases de Armas");
        System.out.println("6. Facciones");
        System.out.println("7. Mapas");
        System.out.println("8. Modos de Juego");
        System.out.println("9. Operadores");
        System.out.println("10. Rachas de Bajas");
        System.out.println("11. Requisitos para jugar en PC");
        System.out.println("12. Salir");
    }

   
}

