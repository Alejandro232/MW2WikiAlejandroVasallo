package mW2Wiki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Accesorio {
	    private int id_Accesorio;
	    private String nombre;
	    private String estadisticas;
	    private ArrayList<Arma> armasDisponibles;

	    public Accesorio(int id_Accesorio, String nombre, String estadisticas, ArrayList<Arma> armasDisponibles) {
	        this.id_Accesorio = id_Accesorio;
	        this.nombre = nombre;
	        this.estadisticas = estadisticas;
	        this.armasDisponibles = armasDisponibles;
	    }

	    // Constructor sobrecargado sin el parámetro "armasDisponibles"
	    public Accesorio(int id_Accesorio, String nombre, String estadisticas) {
	        this.id_Accesorio = id_Accesorio;
	        this.nombre = nombre;
	        this.estadisticas = estadisticas;
	        this.armasDisponibles = new ArrayList<>();
	    }
	    public static List<Accesorio> obtenerAccesorios() {
	        List<Accesorio> accesorios = new ArrayList<>();

	        String usu = "root";
	        String pas = "alejandro2002";
	        String puerto = "3307";
	        String maquina = "localhost";
	        String baseDatos = "mw2wiki";
	        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

	        try (Connection connection = DriverManager.getConnection(url, usu, pas);
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT * FROM Accesorio")) {

	            while (resultSet.next()) {
	                int idAccesorio = resultSet.getInt("id_Accesorio");
	                String nombre = resultSet.getString("nombre");
	                String descripcion = resultSet.getString("descripcion");

	                Accesorio accesorio = new Accesorio(idAccesorio, nombre, descripcion);
	                accesorios.add(accesorio);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Manejo de excepciones en caso de error de conexión o consulta
	        }

	        return accesorios;
	    }

	    public int getId_Accesorio() {
	        return id_Accesorio;
	    }

	    public void setId_Accesorio(int id_Accesorio) {
	        this.id_Accesorio = id_Accesorio;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getEstadisticas() {
	        return estadisticas;
	    }

	    public void setEstadisticas(String estadisticas) {
	        this.estadisticas = estadisticas;
	    }

	    public ArrayList<Arma> getArmasDisponibles() {
	        return armasDisponibles;
	    }

	    public void setArmasDisponibles(ArrayList<Arma> armasDisponibles) {
	        this.armasDisponibles = armasDisponibles;
	    }

	    @Override
	    public String toString() {
	        return "Accesorio{" +
	                "id_Accesorio=" + id_Accesorio +
	                ", nombre='" + nombre + '\'' +
	                ", estadisticas='" + estadisticas + '\'' +
	                ", armasDisponibles=" + armasDisponibles +
	                '}';
	    }
	}
	

