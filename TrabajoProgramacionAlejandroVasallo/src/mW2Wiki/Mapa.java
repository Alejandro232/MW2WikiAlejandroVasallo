package mW2Wiki;

public class Mapa {

	private int idMapa;
    private String nombre;
    private String descripcion;

    public Mapa(int idMapa, String nombre, String descripcion) {
        this.idMapa = idMapa;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
