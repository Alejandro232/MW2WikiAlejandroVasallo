package mW2Wiki.CLASESBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mW2Wiki.CLASES.Operador;

public class OperadorBBDD {
    private String usu;
    private String pas;
    private String puerto;
    private String maquina;
    private String baseDatos;
    private String url;

    public OperadorBBDD() {

    }

    public OperadorBBDD(String usu, String pas, String puerto, String maquina, String baseDatos) {
        this.usu = usu;
        this.pas = pas;
        this.puerto = puerto;
        this.maquina = maquina;
        this.baseDatos = baseDatos;
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;
    }

    public void insertarOperador(Operador operador) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Operador (id_Operador, nombre, genero, altura) VALUES (?, ?, ?, ?)")) {

            statement.setInt(1, operador.getIdOperador());
            statement.setString(2, operador.getNombre());
            statement.setString(3, operador.getGenero());
            statement.setFloat(4, operador.getAltura());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void eliminarOperador(int idOperador) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Operador WHERE id_Operador = ?")) {

            statement.setInt(1, idOperador);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void actualizarOperador(Operador operador) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("UPDATE Operador SET nombre = ?, genero = ?, altura = ? WHERE id_Operador = ?")) {

            statement.setString(1, operador.getNombre());
            statement.setString(2, operador.getGenero());
            statement.setFloat(3, operador.getAltura());
            statement.setInt(4, operador.getIdOperador());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public List<Operador> obtenerOperadores() {
        List<Operador> operadores = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Operador")) {

            while (resultSet.next()) {
                int idOperador = resultSet.getInt("id_Operador");
                String nombre = resultSet.getString("nombre");
                String genero = resultSet.getString("genero");
                float altura = resultSet.getFloat("altura");

                Operador operador = new Operador(idOperador, nombre, genero, altura);
                operadores.add(operador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return operadores;
    }
}
