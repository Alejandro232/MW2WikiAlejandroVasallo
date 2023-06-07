package mW2Wiki.CLASESBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mW2Wiki.CLASES.Racha_Bajas;

public class Racha_BajasBBDD {
    private String usu;
    private String pas;
    private String puerto;
    private String maquina;
    private String baseDatos;
    private String url;

    public Racha_BajasBBDD() {

    }

    public Racha_BajasBBDD(String usu, String pas, String puerto, String maquina, String baseDatos) {
        this.usu = usu;
        this.pas = pas;
        this.puerto = puerto;
        this.maquina = maquina;
        this.baseDatos = baseDatos;
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;
    }

    public void insertarRachaBajas(Racha_Bajas rachaBajas) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Rachas_Bajas (id_Rachas_Bajas, nombre, descripcion, puntos_Necesarios) VALUES (?, ?, ?, ?)")) {

            statement.setInt(1, rachaBajas.getIdRachaBajas());
            statement.setString(2, rachaBajas.getNombre());
            statement.setString(3, rachaBajas.getDescripcion());
            statement.setInt(4, rachaBajas.getPuntosNecesarios());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void eliminarRachaBajas(int idRachaBajas) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Rachas_Bajas WHERE id_Rachas_Bajas = ?")) {

            statement.setInt(1, idRachaBajas);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void actualizarRachaBajas(Racha_Bajas rachaBajas) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("UPDATE Rachas_Bajas SET nombre = ?, descripcion = ?, puntos_Necesarios = ? WHERE id_Racha_Baja = ?")) {

            statement.setString(1, rachaBajas.getNombre());
            statement.setString(2, rachaBajas.getDescripcion());
            statement.setInt(3, rachaBajas.getPuntosNecesarios());
            statement.setInt(4, rachaBajas.getIdRachaBajas());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public List<Racha_Bajas> obtenerRachasBajas() {
        List<Racha_Bajas> rachasBajas = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Rachas_Bajas")) {

            while (resultSet.next()) {
                int idRachaBajas = resultSet.getInt("id_Rachas_Bajas");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                int puntosNecesarios = resultSet.getInt("puntos_Necesarios");

                Racha_Bajas rachaBajas = new Racha_Bajas(idRachaBajas, nombre, descripcion, puntosNecesarios);
                rachasBajas.add(rachaBajas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return rachasBajas;
    }
}

