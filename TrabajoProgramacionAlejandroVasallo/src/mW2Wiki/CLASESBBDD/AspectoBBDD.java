package mW2Wiki.CLASESBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mW2Wiki.CLASES.Aspecto;

public class AspectoBBDD {
    private String usu;
    private String pas;
    private String puerto;
    private String maquina;
    private String baseDatos;
    private String url;

    public AspectoBBDD() {

    }

    public AspectoBBDD(String usu, String pas, String puerto, String maquina, String baseDatos) {
        this.usu = usu;
        this.pas = pas;
        this.puerto = puerto;
        this.maquina = maquina;
        this.baseDatos = baseDatos;
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;
    }

    public void insertarAspecto(Aspecto aspecto) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Aspecto (id_Aspecto, nombre, requisito_Desbloqueo) VALUES (?, ?, ?)")) {

            statement.setInt(1, aspecto.getIdAspecto());
            statement.setString(2, aspecto.getNombre());
            statement.setString(3, aspecto.getRequisitoDesbloqueo());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void eliminarAspecto(int idAspecto) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Aspecto WHERE id_Aspecto = ?")) {

            statement.setInt(1, idAspecto);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void actualizarAspecto(Aspecto aspecto) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("UPDATE Aspecto SET nombre = ?, requisito_Desbloqueo = ? WHERE id_Aspecto = ?")) {

            statement.setString(1, aspecto.getNombre());
            statement.setString(2, aspecto.getRequisitoDesbloqueo());
            statement.setInt(3, aspecto.getIdAspecto());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public List<Aspecto> obtenerAspectos() {
        List<Aspecto> aspectos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Aspecto")) {

            while (resultSet.next()) {
                int idAspecto = resultSet.getInt("id_Aspecto");
                String nombre = resultSet.getString("nombre");
                String requisitoDesbloqueo = resultSet.getString("requisito_Desbloqueo");

                Aspecto aspecto = new Aspecto(idAspecto, nombre, requisitoDesbloqueo, null);
                aspectos.add(aspecto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return aspectos;
    }
}

