package mW2Wiki;

import java.util.Arrays;

public class Faccion {

	private int idFaccion;
    private String nombre;
    private String descripcion;
    private float tamaño;
    private String zona;
    private Operador[] operadores;

    public Faccion(int idFaccion, String nombre, String descripcion, float tamaño, String zona, Operador[] operadores) {
        this.idFaccion = idFaccion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamaño = tamaño;
        this.zona = zona;
        this.operadores = operadores;
    }

    public Faccion(int idFaccion) {
        this.idFaccion = idFaccion;
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

    public float getTamaño() {
        return tamaño;
    }

    public void setTamaño(float tamaño) {
        this.tamaño = tamaño;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Operador[] getOperadores() {
        return operadores;
    }

    public void setOperadores(Operador[] operadores) {
        this.operadores = operadores;
    }

    @Override
    public String toString() {
        return "Faccion{" +
                "idFaccion=" + idFaccion +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tamaño=" + tamaño +
                ", zona='" + zona + '\'' +
                ", operadores=" + Arrays.toString(operadores) +
                '}';
    }
	
	
}
