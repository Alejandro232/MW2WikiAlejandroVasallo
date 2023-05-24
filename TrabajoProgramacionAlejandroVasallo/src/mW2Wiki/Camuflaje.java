package mW2Wiki;

public class Camuflaje {

	private int idCamuflaje;
    private String nombre;
    private String requisitoDesbloqueo;
    private Arma[] armas;

    public Camuflaje(int idCamuflaje, String nombre, String requisitoDesbloqueo, Arma[] armas) {
        this.idCamuflaje = idCamuflaje;
        this.nombre = nombre;
        this.requisitoDesbloqueo = requisitoDesbloqueo;
        this.armas = armas;
    }

    public Camuflaje(int idCamuflaje, String nombre, String requisitoDesbloqueo) {
        this.idCamuflaje = idCamuflaje;
        this.nombre = nombre;
        this.requisitoDesbloqueo = requisitoDesbloqueo;
    }

    public int getIdCamuflaje() {
        return idCamuflaje;
    }

    public void setIdCamuflaje(int idCamuflaje) {
        this.idCamuflaje = idCamuflaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRequisitoDesbloqueo() {
        return requisitoDesbloqueo;
    }

    public void setRequisitoDesbloqueo(String requisitoDesbloqueo) {
        this.requisitoDesbloqueo = requisitoDesbloqueo;
    }

    public Arma[] getArmas() {
        return armas;
    }

    public void setArmas(Arma[] armas) {
        this.armas = armas;
    }
	
	
}
