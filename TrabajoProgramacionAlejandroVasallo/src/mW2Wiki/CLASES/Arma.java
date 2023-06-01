package mW2Wiki.CLASES;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Arma {
    private int id_Arma;
    private int idClaseArma;
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
    private ArrayList<Accesorio> accesorios;
    private ArrayList<Camuflaje> camuflajes;

    // Constructor principal
    public Arma(int id_Arma, String nombre, String descripcion, String requisito_Desbloqueo,
                int daño, int precision, int retroceso, int manejo, int movilidad,
                int cadencia, int alcance, ArrayList<Accesorio> accesorios, ArrayList<Camuflaje> camuflajes) {
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

    public Arma(int idArma, int idClaseArma, String nombre, String descripcion, String requisitoDesbloqueo, int daño,
			int precision, int retroceso, int manejo, int movilidad, int cadencia, int alcance) {
    this.id_Arma = idArma;
    this.idClaseArma=idClaseArma;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.requisito_Desbloqueo = requisitoDesbloqueo;
    this.daño = daño;
    this.precision = precision;
    this.retroceso = retroceso;
    this.manejo = manejo;
    this.movilidad = movilidad;
    this.cadencia = cadencia;
    this.alcance = alcance;
}

	public static List<Arma> obtenerArmas() {
        List<Arma> armas = new ArrayList<>();

        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";
        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Arma")) {

            while (resultSet.next()) {
                int idArma = resultSet.getInt("id_Arma");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                String requisitoDesbloqueo = resultSet.getString("requisito_Desbloqueo");
                int daño = resultSet.getInt("daño");
                int precision = resultSet.getInt("precision");
                int retroceso = resultSet.getInt("retroceso");
                int manejo = resultSet.getInt("manejo");
                int movilidad = resultSet.getInt("movilidad");
                int cadencia = resultSet.getInt("cadencia");
                int alcance = resultSet.getInt("alcance");

                // Obtener accesorios y camuflajes de la base de datos
                ArrayList<Accesorio> accesorios = obtenerAccesorios(idArma);
                ArrayList<Camuflaje> camuflajes = obtenerCamuflajes(idArma);

                Arma arma = new Arma(idArma, nombre, descripcion, requisitoDesbloqueo, daño,
                        precision, retroceso, manejo, movilidad, cadencia, alcance, accesorios, camuflajes);
                armas.add(arma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return armas;
    }

    private static ArrayList<Accesorio> obtenerAccesorios(int idArma) {
        ArrayList<Accesorio> accesorios = new ArrayList<>();

        // Lógica para obtener los accesorios de la base de datos para el arma con el idArma proporcionado

        // Ejemplo:
        // Accesorio accesorio1 = obtenerAccesorio(idAccesorio1);
        // Accesorio accesorio2 = obtenerAccesorio(idAccesorio2);
        // accesorios.add(accesorio1);
        // accesorios.add(accesorio2);

        return accesorios;
    }

    private static ArrayList<Camuflaje> obtenerCamuflajes(int idArma) {
        ArrayList<Camuflaje> camuflajes = new ArrayList<>();

        // Lógica para obtener los camuflajes de la base de datos para el arma con el idArma proporcionado

        // Ejemplo:
        // Camuflaje camuflaje1 = obtenerCamuflaje(idCamuflaje1);
        // Camuflaje camuflaje2 = obtenerCamuflaje(idCamuflaje2);
        // camuflajes.add(camuflaje1);
        // camuflajes.add(camuflaje2);

        return camuflajes;
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

    public ArrayList<Accesorio> getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(ArrayList<Accesorio> accesorios) {
        this.accesorios = accesorios;
    }

    public ArrayList<Camuflaje> getCamuflajes() {
        return camuflajes;
    }

    public void setCamuflajes(ArrayList<Camuflaje> camuflajes) {
        this.camuflajes = camuflajes;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "id_Arma=" + id_Arma +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", requisito_Desbloqueo='" + requisito_Desbloqueo + '\'' +
                ", daño=" + daño +
                ", precision=" + precision +
                ", retroceso=" + retroceso +
                ", manejo=" + manejo +
                ", movilidad=" + movilidad +
                ", cadencia=" + cadencia +
                ", alcance=" + alcance +
                ", accesorios=" + accesorios +
                ", camuflajes=" + camuflajes +
                '}';
    }

	public int getId_Clase_Arma() {
		// TODO Auto-generated method stub
		return idClaseArma;
	}
}
