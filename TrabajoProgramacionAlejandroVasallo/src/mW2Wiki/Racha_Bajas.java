package mW2Wiki;

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
