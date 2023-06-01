package mW2Wiki.CLASESBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mW2Wiki.CLASES.Arma;

public class ArmaBBDD {
    private String usu;
    private String pas;
    private String puerto;
    private String maquina;
    private String baseDatos;
    private String url;

    public ArmaBBDD() {

    }

    public ArmaBBDD(String usu, String pas, String puerto, String maquina, String baseDatos) {
        this.usu = usu;
        this.pas = pas;
        this.puerto = puerto;
        this.maquina = maquina;
        this.baseDatos = baseDatos;
        this.url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;
    }

    public void insertarArma(Arma arma) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO Arma (id_Clase_Arma, nombre, descripcion, requisito_Desbloqueo, daño, `precision`, retroceso, manejo, movilidad, cadencia, alcance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            statement.setInt(1, arma.getId_Clase_Arma());
            statement.setString(2, arma.getNombre());
            statement.setString(3, arma.getDescripcion());
            statement.setString(4, arma.getRequisito_Desbloqueo());
            statement.setInt(5, arma.getDaño());
            statement.setInt(6, arma.getPrecision());
            statement.setInt(7, arma.getRetroceso());
            statement.setInt(8, arma.getManejo());
            statement.setInt(9, arma.getMovilidad());
            statement.setInt(10, arma.getCadencia());
            statement.setInt(11, arma.getAlcance());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void eliminarArma(int idArma) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Arma WHERE id_Arma = ?")) {

            statement.setInt(1, idArma);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }

    public void actualizarArma(Arma arma) {
        try (Connection connection = DriverManager.getConnection(url, usu, pas);
             PreparedStatement statement = connection.prepareStatement("UPDATE Arma SET nombre = ?, descripcion = ?, requisito_Desbloqueo = ?, daño = ?, precision = ?, retroceso = ?, manejo = ?, movilidad = ?, cadencia = ?, alcance = ? WHERE id_Arma = ?")) {

            statement.setString(1, arma.getNombre());
            statement.setString(2, arma.getDescripcion());
            statement.setString(3, arma.getRequisito_Desbloqueo());
            statement.setInt(4, arma.getDaño());
            statement.setInt(5, arma.getPrecision());
            statement.setInt(6, arma.getRetroceso());
            statement.setInt(7, arma.getManejo());
            statement.setInt(8, arma.getMovilidad());
            statement.setInt(9, arma.getCadencia());
            statement.setInt(10, arma.getAlcance());
            statement.setInt(11, arma.getId_Arma());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones en caso de error de conexión o consulta
        }
    }
}
