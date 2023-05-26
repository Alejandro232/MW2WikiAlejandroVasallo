package mW2Wiki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aspecto {

    private int idAspecto;
    private String nombre;
    private String requisitoDesbloqueo;
    private ArrayList<Operador> operadores;

    public Aspecto(int idAspecto, String nombre, String requisitoDesbloqueo, ArrayList<Operador> operadores) {
        this.idAspecto = idAspecto;
        this.nombre = nombre;
        this.requisitoDesbloqueo = requisitoDesbloqueo;
        this.operadores = operadores;
    }
    
    public static List<Aspecto> obtenerAspectos() {
        List<Aspecto> aspectos = new ArrayList<>();

        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";
        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Aspecto")) {

            while (resultSet.next()) {
                int idAspecto = resultSet.getInt("id_Aspecto");
                String nombre = resultSet.getString("nombre");
                String requisitoDesbloqueo = resultSet.getString("requisito_Desbloqueo");

                Aspecto aspecto = new Aspecto(idAspecto, nombre, requisitoDesbloqueo);
                aspectos.add(aspecto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return aspectos;
    }

    public Aspecto(int idAspecto) {
        this.idAspecto = idAspecto;
    }

    public int getIdAspecto() {
        return idAspecto;
    }

    public void setIdAspecto(int idAspecto) {
        this.idAspecto = idAspecto;
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

    public ArrayList<Operador> getOperadores() {
        return operadores;
    }

    public void setOperadores(ArrayList<Operador> operadores) {
        this.operadores = operadores;
    }

    @Override
    public String toString() {
        return "Aspecto{" +
                "idAspecto=" + idAspecto +
                ", nombre='" + nombre + '\'' +
                ", requisitoDesbloqueo='" + requisitoDesbloqueo + '\'' +
                ", operadores=" + operadores +
                '}';
    }
}
