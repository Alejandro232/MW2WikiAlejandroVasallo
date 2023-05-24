package mW2Wiki;

public class Arma {

	private int id_Arma;
	private String nombre;
	private String descripcion;
	private String requisito_Desbloqueo;
	private int daño;
	private int precision;
	private int retroceso;
	private int manejo;
	private int movilidad;
	private int cadencia;
	private int alcance;
	private Accesorio [] accesorios;
	private Camuflaje [] camuflajes;
	
	
	// Constructor principal
    public Arma(int id_Arma, String nombre, String descripcion, String requisito_Desbloqueo,
                int daño, int precision, int retroceso, int manejo, int movilidad,
                int cadencia, int alcance, Accesorio[] accesorios, Camuflaje[] camuflajes) {
        this.id_Arma = id_Arma;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.requisito_Desbloqueo = requisito_Desbloqueo;
        this.daño = daño;
        this.precision = precision;
        this.retroceso = retroceso;
        this.manejo = manejo;
        this.movilidad = movilidad;
        this.cadencia = cadencia;
        this.alcance = alcance;
        this.accesorios = accesorios;
        this.camuflajes = camuflajes;
    }


    // Getters y setters
    public int getId_Arma() {
        return id_Arma;
    }

    public void setId_Arma(int id_Arma) {
        this.id_Arma = id_Arma;
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

    public String getRequisito_Desbloqueo() {
        return requisito_Desbloqueo;
    }

    public void setRequisito_Desbloqueo(String requisito_Desbloqueo) {
        this.requisito_Desbloqueo = requisito_Desbloqueo;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getRetroceso() {
        return retroceso;
    }

    public void setRetroceso(int retroceso) {
        this.retroceso = retroceso;
    }

    public int getManejo() {
        return manejo;
    }

    public void setManejo(int manejo) {
        this.manejo = manejo;
    }

    public int getMovilidad() {
        return movilidad;
    }

    public void setMovilidad(int movilidad) {
        this.movilidad = movilidad;
    }

    public int getCadencia() {
        return cadencia;
    }

    public void setCadencia(int cadencia) {
        this.cadencia = cadencia;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public Accesorio[] getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(Accesorio[] accesorios) {
        this.accesorios = accesorios;
    }

    public Camuflaje[] getCamuflajes() {
        return camuflajes;
    }

    public void setCamuflajes(Camuflaje[] camuflajes) {
        this.camuflajes = camuflajes;
    }
	
	
}
