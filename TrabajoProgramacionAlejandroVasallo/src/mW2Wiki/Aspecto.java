package mW2Wiki;

import java.util.Arrays;

public class Aspecto {

	private int idAspecto;
    private String nombre;
    private String requisitoDesbloqueo;
    private Operador[] operadores;

    public Aspecto(int idAspecto, String nombre, String requisitoDesbloqueo, Operador[] operadores) {
        this.idAspecto = idAspecto;
        this.nombre = nombre;
        this.requisitoDesbloqueo = requisitoDesbloqueo;
        this.operadores = operadores;
    }

    public Aspecto(int idAspecto) {
        this.idAspecto = idAspecto;
    }

    public int getIdAspecto() {
        return idAspecto;
    }

    public void setIdAspecto(int idAspecto) {
        this.idAspecto = idAspecto;
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

    public Operador[] getOperadores() {
        return operadores;
    }

    public void setOperadores(Operador[] operadores) {
        this.operadores = operadores;
    }

    @Override
    public String toString() {
        return "Aspecto{" +
                "idAspecto=" + idAspecto +
                ", nombre='" + nombre + '\'' +
                ", requisitoDesbloqueo='" + requisitoDesbloqueo + '\'' +
                ", operadores=" + Arrays.toString(operadores) +
                '}';
    }
	
}
