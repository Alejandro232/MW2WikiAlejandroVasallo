package mW2Wiki.CLASES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ClaseArma {
    private int id_Clase_Arma;
    private String nombre;
    private String descripcion;

    // Constructor principal
    public ClaseArma(int id_Clase_Arma, String nombre, String descripcion) {
        this.id_Clase_Arma = id_Clase_Arma;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public static List<ClaseArma> obtenerClasesArma() {
        List<ClaseArma> clasesArma = new ArrayList<>();

        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";
        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

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

    // Getters y setters
    public int getId_Clase_Arma() {
        return id_Clase_Arma;
    }

    public void setId_Clase_Arma(int id_Clase_Arma) {
        this.id_Clase_Arma = id_Clase_Arma;
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
        return "ClaseArma{" +
                "id_Clase_Arma=" + id_Clase_Arma +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

