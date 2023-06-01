package mW2Wiki.CLASESBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mW2Wiki.CLASES.Mapa;

public class MapaBBDD {
    private String usu;
    private String pas;
    private String puerto;
    private String maquina;
    private String baseDatos;
    private String url;

    public MapaBBDD() {
        this.usu = "root";
        this.pas = "alejandro2002";
        this.puerto = "3307";
        this.maquina = "localhost";
        this.baseDatos = "mw2wiki";
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;
    }

    public void insertarMapa(Mapa mapa) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Mapa (nombre, descripcion) VALUES (?, ?)")) {

            statement.setString(1, mapa.getNombre());
            statement.setString(2, mapa.getDescripcion());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void eliminarMapa(int idMapa) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Mapa WHERE id_Mapa = ?")) {

            statement.setInt(1, idMapa);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void actualizarMapa(Mapa mapa) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("UPDATE Mapa SET nombre = ?, descripcion = ? WHERE id_Mapa = ?")) {

            statement.setString(1, mapa.getNombre());
            statement.setString(2, mapa.getDescripcion());
            statement.setInt(3, mapa.getIdMapa());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public List<Mapa> obtenerMapas() {
        List<Mapa> mapas = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Mapa")) {

            while (resultSet.next()) {
                int idMapa = resultSet.getInt("id_Mapa");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                Mapa mapa = new Mapa(idMapa, nombre, descripcion);
                mapas.add(mapa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return mapas;
    }

	public Mapa buscarMapaPorId(int idMapa) {
    Mapa mapa = null;

    try (Connection connection = DriverManager.getConnection(url, usu, pas);
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM Mapa WHERE id_Mapa = ?")) {

        statement.setInt(1, idMapa);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                mapa = new Mapa(idMapa, nombre, descripcion);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Manejo de excepciones en caso de error de conexión o consulta
    }

    return mapa;
}

}
