package mW2Wiki;

import java.util.ArrayList;

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
	

