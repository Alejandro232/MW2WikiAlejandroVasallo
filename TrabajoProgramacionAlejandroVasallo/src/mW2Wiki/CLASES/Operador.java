package mW2Wiki.CLASES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Operador {

    private int idOperador;
    private int idFaccion; 
    private String genero;
    private float altura;

    public Operador(int idOperador, int idFaccion, String genero, float altura) {
        this.idOperador = idOperador;
        this.idFaccion = idFaccion;
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
                int idFaccion = resultSet.getInt("id_Faccion");
                String genero = resultSet.getString("genero");
                float altura = resultSet.getFloat("altura");

                Operador operador = new Operador(idOperador, idFaccion, genero, altura);
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

    public int getIdFaccion() {
        return idFaccion;
    }

    public void setIdFaccion(int idFaccion) {
        this.idFaccion = idFaccion;
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
                ", idFaccion=" + idFaccion +
                ", genero='" + genero + '\'' +
                ", altura=" + altura +
                '}';
    }
}
