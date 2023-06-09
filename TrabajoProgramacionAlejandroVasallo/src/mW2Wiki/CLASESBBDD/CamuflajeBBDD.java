package mW2Wiki.CLASESBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mW2Wiki.CLASES.Camuflaje;

public class CamuflajeBBDD {
    private String usu;
    private String pas;
    private String puerto;
    private String maquina;
    private String baseDatos;
    private String url;

    public CamuflajeBBDD() {

    }

    public CamuflajeBBDD(String usu, String pas, String puerto, String maquina, String baseDatos) {
        this.usu = usu;
        this.pas = pas;
        this.puerto = puerto;
        this.maquina = maquina;
        this.baseDatos = baseDatos;
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;
    }

    public void insertarCamuflaje(Camuflaje camuflaje) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Camuflaje (id_Camuflaje, nombre, requisito_Desbloqueo, id_Arma) VALUES (?, ?, ?, ?)")) {

            statement.setInt(1, camuflaje.getIdCamuflaje());
            statement.setString(2, camuflaje.getNombre());
            statement.setString(3, camuflaje.getRequisitoDesbloqueo());
            statement.setInt(4, camuflaje.getId_Arma());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void eliminarCamuflaje(int idCamuflaje) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Camuflaje WHERE id_Camuflaje = ?")) {

            statement.setInt(1, idCamuflaje);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void actualizarCamuflaje(Camuflaje camuflaje) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("UPDATE Camuflaje SET nombre = ?, requisito_Desbloqueo = ?, id_Arma = ? WHERE id_Camuflaje = ?")) {

            statement.setString(1, camuflaje.getNombre());
            statement.setString(2, camuflaje.getRequisitoDesbloqueo());
            statement.setInt(3, camuflaje.getId_Arma());
            statement.setInt(4, camuflaje.getIdCamuflaje());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public List<Camuflaje> obtenerCamuflajes() {
        List<Camuflaje> camuflajes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Camuflaje")) {

            while (resultSet.next()) {
                int idCamuflaje = resultSet.getInt("id_Camuflaje");
                String nombre = resultSet.getString("nombre");
                String requisitoDesbloqueo = resultSet.getString("requisito_Desbloqueo");
                int id_Arma = resultSet.getInt("id_Arma");

                Camuflaje camuflaje = new Camuflaje(idCamuflaje, nombre, requisitoDesbloqueo, id_Arma);
                camuflajes.add(camuflaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return camuflajes;
    }
    public String obtenerNombreArma(int idArma) {
        String nombreArma = "";
        try {
            Connection connection = DriverManager.getConnection(url, usu, pas);
            String query = "SELECT nombre FROM Arma WHERE id_Arma = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idArma);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                nombreArma = resultSet.getString("nombre");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreArma;
    }

}
