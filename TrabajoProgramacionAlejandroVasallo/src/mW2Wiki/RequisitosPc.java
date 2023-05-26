package mW2Wiki;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class RequisitosPc {
    private int idRequisito;
    private String sistemaOperativo;
    private String memoriaRam;
    private String procesador;
    private String tarjetaGrafica;
    private String memoriaGrafica;
    private String almacenamiento;

    public RequisitosPc(int idRequisito, String sistemaOperativo, String memoriaRam, String procesador,
                       String tarjetaGrafica, String memoriaGrafica, String almacenamiento) {
        this.idRequisito = idRequisito;
        this.sistemaOperativo = sistemaOperativo;
        this.memoriaRam = memoriaRam;
        this.procesador = procesador;
        this.tarjetaGrafica = tarjetaGrafica;
        this.memoriaGrafica = memoriaGrafica;
        this.almacenamiento = almacenamiento;
    }

    public static List<RequisitosPc> obtenerRequisitosPc() {
        List<RequisitosPc> requisitosPc = new ArrayList<>();

        String usu = "root";
        String pas = "alejandro2002";
        String puerto = "3307";
        String maquina = "localhost";
        String baseDatos = "mw2wiki";
        String url = "jdbc:mysql://" + maquina + ":" + puerto + "/" + baseDatos;

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

    // Getters y setters
    // ...
}

