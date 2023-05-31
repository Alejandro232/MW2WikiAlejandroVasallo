package mW2Wiki.MENUADMIN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import mW2Wiki.CLASES.Accesorio;

public class menuAccesorios {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Menú de Gestión de Accesorios ===");
            System.out.println("1. Mostrar accesorios");
            System.out.println("2. Agregar un accesorio");
            System.out.println("3. Eliminar un accesorio");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    mostrarAccesorios();
                    break;
                case 2:
                    agregarAccesorio();
                    break;
                case 3:
                    eliminarAccesorio();
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

    private static void mostrarAccesorios() {
        List<Accesorio> accesorios = Accesorio.obtenerAccesorios();
        
        if (accesorios.isEmpty()) {
            System.out.println("No hay accesorios disponibles.");
        } else {
            System.out.println("=== Accesorios ===");
            for (Accesorio accesorio : accesorios) {
                System.out.println(accesorio);
            }
        }
    }

    private static void agregarAccesorio() {
        System.out.println("Ingrese los datos del nuevo accesorio:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        // Crear el nuevo objeto Accesorio
        Accesorio nuevoAccesorio = new Accesorio(0, nombre, descripcion);

        // Guardar el accesorio en la base de datos
        List<Accesorio> accesorios = Accesorio.obtenerAccesorios();
        int nuevoId = accesorios.size() + 1;
        nuevoAccesorio.setId_Accesorio(nuevoId);
        accesorios.add(nuevoAccesorio);

        // Actualizar la base de datos
        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";
        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement()) {

            // Generar la consulta SQL para insertar el nuevo accesorio
            String sql = "INSERT INTO Accesorio (id_Accesorio, nombre, descripcion) VALUES (" + nuevoId + ", '" + nombre + "', '" + descripcion + "')";

            // Ejecutar la consulta SQL
            statement.executeUpdate(sql);

            System.out.println("El accesorio se agregó correctamente a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el accesorio en la base de datos.");
        }
    }
    private static void eliminarAccesorio() {
        System.out.println("Ingrese el ID del accesorio a eliminar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        // Buscar el accesorio en la lista de accesorios
        List<Accesorio> accesorios = Accesorio.obtenerAccesorios();
        Accesorio accesorioAEliminar = null;
        for (Accesorio accesorio : accesorios) {
            if (accesorio.getId_Accesorio() == id) {
                accesorioAEliminar = accesorio;
                break;
            }
        }

        if (accesorioAEliminar != null) {
            // Eliminar el accesorio de la lista
            accesorios.remove(accesorioAEliminar);

            // Actualizar la base de datos
            String usu = "root";
            String pas = "alejandro2002";
            String puerto = "3307";
            String maquina = "localhost";
            String baseDatos = "mw2wiki";
            String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

            try (Connection connection = DriverManager.getConnection(url, usu, pas);
                 Statement statement = connection.createStatement()) {

                // Generar la consulta SQL para eliminar el accesorio
                String sql = "DELETE FROM Accesorio WHERE id_Accesorio = " + id;

                // Ejecutar la consulta SQL
                statement.executeUpdate(sql);

                System.out.println("El accesorio se eliminó correctamente de la base de datos.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al eliminar el accesorio de la base de datos.");
            }
        } else {
            System.out.println("No se encontró ningún accesorio con el ID especificado.");
        }
    }
}