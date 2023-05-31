package mW2Wiki.CLASES;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ModoJuego {

	private int idModo;
    private String nombre;
    private String descripcion;

    public ModoJuego(int idModo, String nombre, String descripcion) {
        this.idModo = idModo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public static List<ModoJuego> obtenerModosJuego() {
        List<ModoJuego> modosJuego = new ArrayList<>();

        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";
        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Modo_Juego")) {

            while (resultSet.next()) {
                int idModo = resultSet.getInt("id_Modo");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");

                ModoJuego modoJuego = new ModoJuego(idModo, nombre, descripcion);
                modosJuego.add(modoJuego);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return modosJuego;
    }
    
    
    
    

    public ModoJuego(int idModo) {
        this.idModo = idModo;
    }

    public int getIdModo() {
        return idModo;
    }

    public void setIdModo(int idModo) {
        this.idModo = idModo;
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
        return "Modo{" +
                "idModo=" + idModo +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
	
	
	
	
}
