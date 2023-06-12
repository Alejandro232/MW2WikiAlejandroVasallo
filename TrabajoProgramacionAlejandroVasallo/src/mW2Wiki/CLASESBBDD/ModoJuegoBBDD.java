package mW2Wiki.CLASESBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mW2Wiki.CLASES.ModoJuego;

public class ModoJuegoBBDD {
    private String usu;
    private String pas;
    private String puerto;
    private String maquina;
    private String baseDatos;
    private String url;

    public ModoJuegoBBDD() {

    }

    public ModoJuegoBBDD(String usu, String pas, String puerto, String maquina, String baseDatos) {
        this.usu = usu;
        this.pas = pas;
        this.puerto = puerto;
        this.maquina = maquina;
        this.baseDatos = baseDatos;
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;
    }

    public void insertarModoJuego(ModoJuego modoJuego) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Modo_Juego (nombre, descripcion) VALUES (?, ?)")) {

            statement.setString(1, modoJuego.getNombre());
            statement.setString(2, modoJuego.getDescripcion());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void eliminarModoJuego(int idModoJuego) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Modo_Juego WHERE id_Modo_Juego = ?")) {

            statement.setInt(1, idModoJuego);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void actualizarModoJuego(ModoJuego modoJuego) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("UPDATE Modo_Juego SET nombre = ?, descripcion = ? WHERE id_Modo_Juego = ?")) {

            statement.setString(1, modoJuego.getNombre());
            statement.setString(2, modoJuego.getDescripcion());
            statement.setInt(3, modoJuego.getIdModo());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public List<ModoJuego> obtenerModosJuego() {
        List<ModoJuego> modosJuego = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Modo_Juego")) {

            while (resultSet.next()) {
                int idModo = resultSet.getInt("id_Modo_Juego");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                ModoJuego modoJuego = new ModoJuego(idModo, nombre, descripcion);
                modosJuego.add(modoJuego);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return modosJuego;
    }

	public ModoJuego obtenerModoJuego(int idModoJuego) {
    ModoJuego modoJuego = null;

    try (Connection connection = DriverManager.getConnection(url, usu, pas);
         PreparedStatement statement = connection.prepareStatement("SELECT * FROM Modo_Juego WHERE id_Modo_Juego = ?")) {

        statement.setInt(1, idModoJuego);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int idModo = resultSet.getInt("id_Modo_Juego");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                modoJuego = new ModoJuego(idModo, nombre, descripcion);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Manejo de excepciones en caso de error de conexión o consulta
    }

    return modoJuego;
}

}
