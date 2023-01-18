package base_de_datos.BD_Alumnos.ventanas.ventanas;

/*
Cuando se va a crear conexion a una base de datos es muy importante colocar el código dentro de una sentencia o
estructura "try-catch".
 */

import java.sql.*;  //Libreria importante para trabajar con la base de datos


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroAlumnos extends JFrame{
    private JPanel panel1;
    private JTextField txt_nombre;
    private JTextField txt_grupo;
    private JButton btnRegistrar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JTextField txt_buscar;
    private JButton buscarButton;
    private JLabel label_status;

    public RegistroAlumnos(){
        this.setContentPane(panel1);
        setBounds(0,0,350,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Programación de lo botones

        //Boton btnRegistrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //La primer línea de código que se debe crear es una cual permita establecer conexión con la base de datos
                try {
                    /*
                    Crear un objeto de la claes Connection y asignarle mediante el método getConnection de la clase "DriveManager"
                    la ruta, usuario y contraseña para obtener la conexión.
                    Parametros del método "getConnection":
                    Primer parametro: Contiene la ruta y el nombre de la base de datos a conectar
                    Segundo parametro: Nombre de usuario de la bd(en caso de que la tenga) y si no, usar la palabra "root"
                    Tercer parametro: Contraseña de la bd(en caso de que la tenga) y si no, dejar tal y como esta.
                     */
                    //Basicamente se indica que se esta trabajando con servidor local y el nombre de la bd, en el url.
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins", "root", "");
                    /*
                    La segunda linea de código va a servir para indicarle las instrucciones a la base de datos(no al programa de java).
                    Debemos crear un objeto de la clase "PreparedStatement" y asignarle el método "prepareStatement()"(sin 'd')
                    al cual accederemos desde el objeto que se creo previamente para la conexión. Dentro del parentesis del método
                    se agregara unas comillas y entre las mismas ira la instrucción que se le dara a la base de datos, también
                    conocido como "query" en base de datos.
                    INSTRUCCION A BASE DE DATOS: Indicarle que se quiere insertar dentro de la tabla "alumnos" que pertenece a la
                    base de datos "bd_ins" dos elementos, que son el "nombre del alumno" y el "grupo".
                     */
                    //Como ya se realizao la conexión, basta con poner el nombre de la base de datos y no el servidor
                    PreparedStatement pst = cn.prepareStatement("insert into alumnos values()");
                }catch (Exception exception){  //"e" ya se usa en el evento del boton, por lo que usamos exception

                }
            }
        });
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroAlumnos().setVisible(true);
            }
        });
    }
}
