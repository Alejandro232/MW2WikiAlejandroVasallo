package mW2Wiki.PARTIDAPERSONALIZADA;

import java.sql.*;

public class MostrarPartidasPersonalizadas {
    private static final String URL = "jdbc:mysql://localhost:3307/mw2wiki";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "alejandro2002";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Consulta para obtener los datos de la tabla PartidaPersonalizada y sus referencias
            String query = "SELECT PP.id_Partida, O.nombre AS operador, A.nombre AS arma, MJ.nombre AS modo, M.nombre AS mapa, RB.nombre AS racha_baja " +
                           "FROM PartidaPersonalizada PP " +
                           "JOIN Operador O ON PP.id_Operador = O.id_Operador " +
                           "JOIN Arma A ON PP.id_Arma = A.id_Arma " +
                           "JOIN Modo_Juego MJ ON PP.id_Modo = MJ.id_Modo_Juego " +
                           "JOIN Mapa M ON PP.id_Mapa = M.id_Mapa " +
                           "JOIN Rachas_Bajas RB ON PP.id_Rachas_Bajas = RB.id_Rachas_Bajas";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("=== Datos de PartidaPersonalizada ===");
            while (resultSet.next()) {
                int idPartida = resultSet.getInt("id_Partida");
                String operador = resultSet.getString("operador");
                String arma = resultSet.getString("arma");
                String modo = resultSet.getString("modo");
                String mapa = resultSet.getString("mapa");
                String rachaBaja = resultSet.getString("racha_baja");

                System.out.println("ID de Partida: " + idPartida);
                System.out.println("Operador: " + operador);
                System.out.println("Arma: " + arma);
                System.out.println("Modo de Juego: " + modo);
                System.out.println("Mapa: " + mapa);
                System.out.println("Racha Baja: " + rachaBaja);
                System.out.println();
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
