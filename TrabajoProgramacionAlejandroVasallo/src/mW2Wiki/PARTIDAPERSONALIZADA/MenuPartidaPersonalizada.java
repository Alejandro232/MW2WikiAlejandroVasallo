package mW2Wiki.PARTIDAPERSONALIZADA;
import java.sql.*;
import java.util.Scanner;

public class MenuPartidaPersonalizada {

    private static final String URL = "jdbc:mysql://localhost:3307/mw2wiki";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "alejandro2002";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Inserción de datos en PartidaPersonalizada ===");

        String insertStatement=null;
        
        try {
            // Establecer conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Obtener los IDs de los elementos seleccionados por el usuario
            int idOperador = seleccionarId(connection, "Operador");
            int idArma = seleccionarId(connection, "Arma");
            int idModo = seleccionarId(connection, "Modo_Juego");
            int idMapa = seleccionarId(connection, "Mapa");
            int idRachaBaja = seleccionarId(connection, "Rachas_Bajas");

            // Cerrar la conexión con la base de datos
            

            // Generar la sentencia INSERT
            insertStatement = "INSERT INTO PartidaPersonalizada (id_Operador, id_Arma, id_Modo, id_Mapa, id_Rachas_Bajas) VALUES (?, ?, ?, ?, ?)";

            
            // Establecer conexión nuevamente para ejecutar la sentencia INSERT
           // connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setInt(1, idOperador);
            preparedStatement.setInt(2, idArma);
            preparedStatement.setInt(3, idModo);
            preparedStatement.setInt(4, idMapa);
            preparedStatement.setInt(5, idRachaBaja);

            
            // Ejecutar la sentencia INSERT
            preparedStatement.executeUpdate();

            // Cerrar la conexión y el scanner
            preparedStatement.close();
            

            System.out.println("\nSu partida se ha ingresado exitosamente.");
        } catch (SQLException e) {
            System.out.println("query:" + insertStatement);

            System.out.println("Error al conectar22 con la base de datos: " + e.getMessage());
        }

    }

    private static int seleccionarId(Connection connection, String tabla) throws SQLException {
        String query = "SELECT id_" + tabla + ", nombre FROM " + tabla;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        System.out.println("\n=== " + tabla + " ===");
        while (resultSet.next()) {
            int id = resultSet.getInt("id_" + tabla);
            String nombre = resultSet.getString("nombre");

            System.out.println("ID: " + id);
            System.out.println("Nombre: " + nombre);
            System.out.println();
        }

        resultSet.close();
        statement.close();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Selecciona el ID de " + tabla + ": ");
        return scanner.nextInt();
    }
}
