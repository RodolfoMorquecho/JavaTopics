package base_de_datos.reporte_musical;

//Importar librería para utilizar clases y métodos para conectar a base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static String url = "jdbc:mysql://localhost/bd_music";  //Se hace estatica para poder usarla dentro del método que sera estatico también
    static String user = "root";
    static String password = "";

    public static Connection conectar(){  //Para evitar instanciarlo, se crea un método de tipo static, el cual retorna una conexión
        try {
            Connection cn = DriverManager.getConnection(url, user, password);
            return cn;
        }catch (SQLException exception){
            System.out.println("Error de conexión "+ exception);
        }
        return null;
    }
}
