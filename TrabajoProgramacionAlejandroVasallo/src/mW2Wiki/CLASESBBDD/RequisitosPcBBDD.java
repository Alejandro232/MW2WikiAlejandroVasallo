package mW2Wiki.CLASESBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mW2Wiki.CLASES.RequisitosPc;

public class RequisitosPcBBDD {
    private String usu;
    private String pas;
    private String puerto;
    private String maquina;
    private String baseDatos;
    private String url;

    public RequisitosPcBBDD() {

    }

    public RequisitosPcBBDD(String usu, String pas, String puerto, String maquina, String baseDatos) {
        this.usu = usu;
        this.pas = pas;
        this.puerto = puerto;
        this.maquina = maquina;
        this.baseDatos = baseDatos;
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;
    }

    public void insertarRequisitoPc(RequisitosPc requisitoPc) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO RequisitosPc (id_Requisito, sistema_Operativo, memoria_Ram, procesador, tarjeta_Grafica, memoria_Grafica, almacenamiento) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            statement.setInt(1, requisitoPc.getIdRequisito());
            statement.setString(2, requisitoPc.getSistemaOperativo());
            statement.setString(3, requisitoPc.getMemoriaRam());
            statement.setString(4, requisitoPc.getProcesador());
            statement.setString(5, requisitoPc.getTarjetaGrafica());
            statement.setString(6, requisitoPc.getMemoriaGrafica());
            statement.setString(7, requisitoPc.getAlmacenamiento());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void eliminarRequisitoPc(int idRequisitoPc) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM RequisitosPc WHERE id_Requisito = ?")) {

            statement.setInt(1, idRequisitoPc);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void actualizarRequisitoPc(RequisitosPc requisitoPc) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("UPDATE RequisitosPc SET sistema_Operativo = ?, memoria_Ram = ?, procesador = ?, tarjeta_Grafica = ?, memoria_Grafica = ?, almacenamiento = ? WHERE id_Requisito = ?")) {

            statement.setString(1, requisitoPc.getSistemaOperativo());
            statement.setString(2, requisitoPc.getMemoriaRam());
            statement.setString(3, requisitoPc.getProcesador());
            statement.setString(4, requisitoPc.getTarjetaGrafica());
            statement.setString(5, requisitoPc.getMemoriaGrafica());
            statement.setString(6, requisitoPc.getAlmacenamiento());
            statement.setInt(7, requisitoPc.getIdRequisito());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public List<RequisitosPc> obtenerRequisitosPc() {
        List<RequisitosPc> requisitosPc = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM RequisitosPc")) {

            while (resultSet.next()) {
                int idRequisito = resultSet.getInt("id_Requisito");
                String sistemaOperativo = resultSet.getString("sistema_Operativo");
                String memoriaRam = resultSet.getString("memoria_Ram");
                String procesador = resultSet.getString("procesador");
                String tarjetaGrafica = resultSet.getString("tarjeta_Grafica");
                String memoriaGrafica = resultSet.getString("memoria_Grafica");
                String almacenamiento = resultSet.getString("almacenamiento");

                RequisitosPc requisitoPc = new RequisitosPc(idRequisito, sistemaOperativo, memoriaRam, procesador,
                        tarjetaGrafica, memoriaGrafica, almacenamiento);
                requisitosPc.add(requisitoPc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }

        return requisitosPc;
    }
}
