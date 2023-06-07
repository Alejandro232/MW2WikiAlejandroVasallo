package mW2Wiki;

import java.sql.*;

public class MostrarPartidasPersonalizadas {

    private static final String URL = "jdbc:mysql://localhost:3307/mw2wiki";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "alejandro2002";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establecer conexión con la base de datos
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            // Obtener el contenido de las tablas referenciadas
            resultSet = statement.executeQuery("SELECT p.*, o.nombre AS nombre_operador, a.nombre AS nombre_arma, m.nombre AS nombre_modo, mp.nombre AS nombre_mapa, rb.nombre AS nombre_racha_baja " +
                    "FROM PartidaPersonalizada p " +
                    "INNER JOIN Operador o ON p.id_Operador = o.id_Operador " +
                    "INNER JOIN Arma a ON p.id_Arma = a.id_Arma " +
                    "INNER JOIN Modo_Juego m ON p.id_Modo = m.id_Modo " +
                    "INNER JOIN Mapa mp ON p.id_Mapa = mp.id_Mapa " +
                    "INNER JOIN Rachas_bajas rb ON p.id_Rachas_Bajas = rb.id_Rachas_Bajas");

            System.out.println("=== PartidaPersonalizada ===");
            while (resultSet.next()) {
                int idPartida = resultSet.getInt("id_Partida");
                String nombreOperador = resultSet.getString("nombre_operador");
                String nombreArma = resultSet.getString("nombre_arma");
                String nombreModo = resultSet.getString("nombre_modo");
                String nombreMapa = resultSet.getString("nombre_mapa");
                String nombreRachaBaja = resultSet.getString("nombre_racha_baja");

                System.out.println("ID Partida: " + idPartida);
                System.out.println("Operador: " + nombreOperador);
                System.out.println("Arma: " + nombreArma);
                System.out.println("Modo de Juego: " + nombreModo);
                System.out.println("Mapa: " + nombreMapa);
                System.out.println("Racha Baja: " + nombreRachaBaja);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        } finally {
            // Cerrar la conexión y liberar los recursos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
