package conexionSQL;

import java.sql.Connection;// Objeto de conexión
import java.sql.DriverManager;// Objeto del controlador o driver JDBC
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {

	 public static void main(String[] args) {
	        
		 	String usu = "root";
	        String pas = "alejandro2002";
	        String puerto = "3307";
	        String maquina = "localhost";
	        String baseDatos="mw2wiki";
	        String url= "jdbc:mysql://"+maquina+":"+puerto+"/"+baseDatos;
	        Connection con = null;
	        
	       // ArrayList<Libro> libros = new ArrayList<>();
	        
	        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");// Driver depende de la BD
	            //establece la conexión
	            con = (Connection) DriverManager.getConnection(url, usu, pas);
	            System.out.println("Conexión establecida");
	            
	            String consulta = "SELECT * FROM Arma";
	            ResultSet rs=null;
	            System.out.println(consulta);
	             Statement st=con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            
	             rs=st.executeQuery(consulta);
	            
	             
	            while(rs.next())
	            {
	 
	            	
	                int libro_id = rs.getInt("id_Arma");
	                String titulo = rs.getString("nombre");
	                String isbn = rs.getString("descripcion");
	               
	                //System.out.println(libro_id+"\t"+titulo+"\t"+isbn+"\t"+categoria);
	                
	                //Libro libro = new Libro(libro_id,titulo, categoria, isbn);
	                //System.out.println(libro);
	                
	                //libros.add(libro);
	                System.out.println(libro_id);
	                System.out.println(titulo);
	                System.out.println();
	            }
	            
	            
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	        
	        
	        //System.out.println(libros);
	        
	        
	        
	    }
}