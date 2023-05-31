package mW2Wiki.CLASESBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mW2Wiki.CLASES.Accesorio;

public class AccesorioBBDD {
    private String usu;
    private String pas;
    private String puerto;
    private String maquina;
    private String baseDatos;
    private String url;
    
    public AccesorioBBDD() {
    	
    }

    public AccesorioBBDD(String usu, String pas, String puerto, String maquina, String baseDatos) {
        this.usu = usu;
        this.pas = pas;
        this.puerto = puerto;
        this.maquina = maquina;
        this.baseDatos = baseDatos;
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;
    }

    public void insertarAccesorio(Accesorio accesorio) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Accesorio (id_Accesorio, nombre, descripcion) VALUES (?, ?, ?)")) {

            statement.setInt(1, accesorio.getId_Accesorio());
            statement.setString(2, accesorio.getNombre());
            statement.setString(3, accesorio.getDescripcion());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void eliminarAccesorio(int idAccesorio) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Accesorio WHERE id_Accesorio = ?")) {

            statement.setInt(1, idAccesorio);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void actualizarAccesorio(Accesorio accesorio) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("UPDATE Accesorio SET nombre = ?, descripcion = ? WHERE id_Accesorio = ?")) {

            statement.setString(1, accesorio.getNombre());
            statement.setString(2, accesorio.getDescripcion());
            statement.setInt(3, accesorio.getId_Accesorio());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public List<Accesorio> obtenerAccesorios() {
        List<Accesorio> accesorios = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Accesorio")) {

            while (resultSet.next()) {
                int idAccesorio = resultSet.getInt("id_Accesorio");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                Accesorio accesorio = new Accesorio(idAccesorio, nombre, descripcion);
                accesorios.add(accesorio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return accesorios;
    }
}
