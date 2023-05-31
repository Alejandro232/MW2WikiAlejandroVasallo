package mW2Wiki.CLASESBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mW2Wiki.CLASES.ClaseArma;

public class ClaseArmaBBDD {
    private String usu;
    private String pas;
    private String puerto;
    private String maquina;
    private String baseDatos;
    private String url;

    public ClaseArmaBBDD() {

    }

    public ClaseArmaBBDD(String usu, String pas, String puerto, String maquina, String baseDatos) {
        this.usu = usu;
        this.pas = pas;
        this.puerto = puerto;
        this.maquina = maquina;
        this.baseDatos = baseDatos;
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;
    }

    public void insertarClaseArma(ClaseArma claseArma) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Clase_Arma (id_Clase_Arma, nombre, descripcion) VALUES (?, ?, ?)")) {

            statement.setInt(1, claseArma.getId_Clase_Arma());
            statement.setString(2, claseArma.getNombre());
            statement.setString(3, claseArma.getDescripcion());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void eliminarClaseArma(int idClaseArma) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Clase_Arma WHERE id_Clase_Arma = ?")) {

            statement.setInt(1, idClaseArma);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void actualizarClaseArma(ClaseArma claseArma) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("UPDATE Clase_Arma SET nombre = ?, descripcion = ? WHERE id_Clase_Arma = ?")) {

            statement.setString(1, claseArma.getNombre());
            statement.setString(2, claseArma.getDescripcion());
            statement.setInt(3, claseArma.getId_Clase_Arma());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public List<ClaseArma> obtenerClasesArma() {
        List<ClaseArma> clasesArma = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Clase_Arma")) {

            while (resultSet.next()) {
                int idClaseArma = resultSet.getInt("id_Clase_Arma");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                ClaseArma claseArma = new ClaseArma(idClaseArma, nombre, descripcion);
                clasesArma.add(claseArma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return clasesArma;
    }
}
