package mW2Wiki.CLASES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Mapa {

	private int idMapa;
    private String nombre;
    private String descripcion;

    public Mapa(int idMapa, String nombre, String descripcion) {
        this.idMapa = idMapa;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public static List<Mapa> obtenerMapas() {
        List<Mapa> mapas = new ArrayList<>();

        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";
        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Mapa")) {

            while (resultSet.next()) {
                int idMapa = resultSet.getInt("id_Mapa");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                float tamaño = resultSet.getFloat("tamaño");

                Mapa mapa = new Mapa(idMapa, nombre, descripcion);
                mapas.add(mapa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return mapas;
    }

    public Mapa(int idMapa, String nombre) {
        this.idMapa = idMapa;
        this.nombre = nombre;
    }

    public int getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(int idMapa) {
        this.idMapa = idMapa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Mapa{" +
                "idMapa=" + idMapa +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
	
}
