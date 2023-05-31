package mW2Wiki.CLASES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Faccion {

    private int idFaccion;
    private String nombre;
    private String descripcion;

    public Faccion(int idFaccion, String nombre, String descripcion) {
        this.idFaccion = idFaccion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public static List<Faccion> obtenerFacciones() {
        List<Faccion> facciones = new ArrayList<>();

        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";
        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Faccion")) {

            while (resultSet.next()) {
                int idFaccion = resultSet.getInt("id_Faccion");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                Faccion faccion = new Faccion(idFaccion, nombre, descripcion);
                facciones.add(faccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return facciones;
    }

    public int getIdFaccion() {
        return idFaccion;
    }

    public void setIdFaccion(int idFaccion) {
        this.idFaccion = idFaccion;
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
        return "Faccion{" +
                "idFaccion=" + idFaccion +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
