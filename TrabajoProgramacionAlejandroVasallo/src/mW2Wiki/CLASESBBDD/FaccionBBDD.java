package mW2Wiki.CLASESBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mW2Wiki.CLASES.Faccion;

public class FaccionBBDD {
    private String usu;
    private String pas;
    private String puerto;
    private String maquina;
    private String baseDatos;
    private String url;

    public FaccionBBDD() {

    }

    public FaccionBBDD(String usu, String pas, String puerto, String maquina, String baseDatos) {
        this.usu = usu;
        this.pas = pas;
        this.puerto = puerto;
        this.maquina = maquina;
        this.baseDatos = baseDatos;
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;
    }

    public void insertarFaccion(Faccion faccion) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Faccion (id_Faccion, nombre, descripcion) VALUES (?, ?, ?)")) {

            statement.setInt(1, faccion.getIdFaccion());
            statement.setString(2, faccion.getNombre());
            statement.setString(3, faccion.getDescripcion());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void eliminarFaccion(int idFaccion) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Faccion WHERE id_Faccion = ?")) {

            statement.setInt(1, idFaccion);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void actualizarFaccion(Faccion faccion) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("UPDATE Faccion SET nombre = ?, descripcion = ? WHERE id_Faccion = ?")) {

            statement.setString(1, faccion.getNombre());
            statement.setString(2, faccion.getDescripcion());
            statement.setInt(3, faccion.getIdFaccion());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public List<Faccion> obtenerFacciones() {
        List<Faccion> facciones = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Faccion")) {

            while (resultSet.next()) {
                int idFaccion = resultSet.getInt("id_Faccion");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                Faccion faccion = new Faccion(idFaccion, nombre, descripcion);
                facciones.add(faccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return facciones;
    }
}
