package mW2Wiki;

public class ModoJuego {

	private int idModo;
    private String nombre;
    private String descripcion;

    public ModoJuego(int idModo, String nombre, String descripcion) {
        this.idModo = idModo;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
