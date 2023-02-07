package base_de_datos.reporte_musical;

import java.sql.*;  //Importar librería para utilizar clases y métodos para conectar a base de datos
public class Conexion {
    static String url = "";  //Se hace estatica para poder usarla dentro del método que sera estatico también
    public Conexion(){
        url = "jdbc:mysql://localhost/bd_music";
    }

    public static Connection conectar(){  //Para evitar instanciarlo, se crea un método de tipo static, el cual retorna una conexión
        try {
            Connection cn = DriverManager.getConnection(url,"root","");
            return cn;
        }catch (SQLException exception){
            System.out.println("Error de conexión "+ exception);
        }
        return null;
    }
}
