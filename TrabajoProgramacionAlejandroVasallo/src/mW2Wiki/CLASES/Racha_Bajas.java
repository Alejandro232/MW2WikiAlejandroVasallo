package mW2Wiki.CLASES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Racha_Bajas {

	private int idRachaBajas;
    private String nombre;
    private String descripcion;
    private int puntosNecesarios;

    public Racha_Bajas(int idRachaBajas, String nombre, String descripcion, int puntosNecesarios) {
        this.idRachaBajas = idRachaBajas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntosNecesarios = puntosNecesarios;
    }
    
    public static List<Racha_Bajas> obtenerRachasBajas() {
        List<Racha_Bajas> rachasBajas = new ArrayList<>();

        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";
        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Rachas_Bajas")) {

            while (resultSet.next()) {
                int idRachaBaja = resultSet.getInt("id_Racha_Baja");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                int puntosNecesarios = resultSet.getInt("puntos_Necesarios");

                Racha_Bajas rachaBaja = new Racha_Bajas(idRachaBaja, nombre, descripcion, puntosNecesarios);
                rachasBajas.add(rachaBaja);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return rachasBajas;
    }

    public Racha_Bajas(int idRachaBajas) {
        this.idRachaBajas = idRachaBajas;
    }

    public int getIdRachaBajas() {
        return idRachaBajas;
    }

    public void setIdRachaBajas(int idRachaBajas) {
        this.idRachaBajas = idRachaBajas;
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

    public int getPuntosNecesarios() {
        return puntosNecesarios;
    }

    public void setPuntosNecesarios(int puntosNecesarios) {
        this.puntosNecesarios = puntosNecesarios;
    }

    @Override
    public String toString() {
        return "RachaBajas{" +
                "idRachaBajas=" + idRachaBajas +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", puntosNecesarios=" + puntosNecesarios +
                '}';
    }
	
}
