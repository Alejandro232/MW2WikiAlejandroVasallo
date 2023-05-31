package mW2Wiki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Operador {

    private int idOperador;
    private String nombre;
    private String genero;
    private float altura;

    public Operador(int idOperador, String nombre, String genero, float altura) {
        this.idOperador = idOperador;
        this.nombre = nombre;
        this.genero = genero;
        this.altura = altura;
    }

    public static List<Operador> obtenerOperadores() {
        List<Operador> operadores = new ArrayList<>();

        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";
        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

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

    public int getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(int idOperador) {
        this.idOperador = idOperador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Operador{" +
                "idOperador=" + idOperador +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", altura=" + altura +
                '}';
    }
}
