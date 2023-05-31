package mW2Wiki.CLASES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Camuflaje {

    private int idCamuflaje;
    private String nombre;
    private String requisitoDesbloqueo;

    public Camuflaje(int idCamuflaje, String nombre, String requisitoDesbloqueo) {
        this.idCamuflaje = idCamuflaje;
        this.nombre = nombre;
        this.requisitoDesbloqueo = requisitoDesbloqueo;
    }
    
    public static List<Camuflaje> obtenerCamuflajes() {
        List<Camuflaje> camuflajes = new ArrayList<>();

        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";
        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Camuflaje")) {

            while (resultSet.next()) {
                int idCamuflaje = resultSet.getInt("id_Camuflaje");
                String nombre = resultSet.getString("nombre");
                String requisitoDesbloqueo = resultSet.getString("requisito_Desbloqueo");

                Camuflaje camuflaje = new Camuflaje(idCamuflaje, nombre, requisitoDesbloqueo);
                camuflajes.add(camuflaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return camuflajes;
    }

    public int getIdCamuflaje() {
        return idCamuflaje;
    }

    public void setIdCamuflaje(int idCamuflaje) {
        this.idCamuflaje = idCamuflaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRequisitoDesbloqueo() {
        return requisitoDesbloqueo;
    }

    public void setRequisitoDesbloqueo(String requisitoDesbloqueo) {
        this.requisitoDesbloqueo = requisitoDesbloqueo;
    }
}
