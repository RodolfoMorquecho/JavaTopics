package base_de_datos.BD_Alumnos.ventanas;

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
    private JButton btnBuscar;
    private JLabel label_status;

    public RegistroAlumnos(){
        this.setContentPane(panel1);
        setBounds(0,0,350,400);
        setLocationRelativeTo(null);
        //setResizable(false);
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

                    Como ya se realizo la conexión, basta con poner el nombre de la tabla y no la base de datos
                    "Insertar dentro de la tabla alumnos los datos/valores" dentro de los parentesis de values(), pero el problema
                    es que no se conocen los valores que el usuario va a ingresar, por lo que es necesario agregar 3 signos de
                    interrogación de cierre, que corresponden al id, nombre de alumno y grupo.
                    */
                    PreparedStatement pst = cn.prepareStatement("insert into alumnos values(?,?,?)");

                    /*
                    Es indispensable indicarle a java que debe mandar 3 valores, la base de datos los manejara segun su configuracion
                    El objeto "pst" ya esta configurado para insertar valores, por lo que se va a definir que tipo de dato ira a cual columna
                    Dentro del método String se piden 2 parametros, el primero hace referencia al campo/culumna de la tabla y en el
                    segundo parametro se manda un string
                     */
                    //Para este caso, el string debe de tener un numero entre comillar, de preferencia un 0. Si no, no hara la busqueda en la bd
                    pst.setString(1,"0");
                    //Recuperar el valor directamente del campo y con getText se obtiene el texto del campo
                    //"trim()" sirve para eliminar los espacios previos o posteriores a la cadena de caracteres(nombre)
                    pst.setString(2, txt_nombre.getText().trim());
                    pst.setString(3,txt_grupo.getText().trim());
                    /*
                    Hasta ahora no es suficiente para introducir los datos a la "base de datos", se tiene que indicar a
                    java y a la base de datos que se tienen que ejecutar
                     */
                    //El método "executeUpdate()" permite ejecutar las lineas o instrucciones que le estamos enviando a la base de datos
                    //De no hacerlo, nunca se va a ejecutar nada de la parted de la base de datos
                    pst.executeUpdate();

                    //Se limpiaran los campos despues de generar/registrar un alta a la base de datos
                    txt_nombre.setText("");
                    txt_grupo.setText("");
                    label_status.setText("Registro exitoso.");  //En la eitqueta se muestra que se ha hecho el regitro
                }catch (Exception exception){  //"e" ya se usa en el evento del boton, por lo que usamos exception
                    //No es necesario poner el mensaje, ya que si no muetra nada, el error es de conexión
                }
            }
        });

        //Boton btnBuscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Al igual que en el boton Registrar, las instrucciones deben de ir dentro de una estructura "try-catch", ya que
                //se esta trabajando con conexión a base de datos
                try {
                    //Debido a que nos conectaremos a la misma base de datos, se pueden copiar la 2 primeras lineas del btn anterior
                    //Solo se cambiara la instrucción a la bd, ya que ahora solo se consultara y no insertar.
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins", "root", "");

                    //Se le indicara a la base de datos que: seleccione tod0 de la tabla "alumnos" donde el "ID" sea igual a '?'
                    //Es importante poner en el query los nombres exactamente iguales a como los llamamos en la bs(ID,Grupo,etc.)
                    PreparedStatement pst = cn.prepareStatement("select * from alumnos where ID = ?");

                    //Ya que se ha establecido la conexión y se ha escrito la instruccion a la base de datos, ahora es
                    //necesario enviar a la bd el valor que el usuario que quiere buscar.

                    //Con el campo que se quiere comparar es con el de "ID" el cual corresponde al 1, ira como parametro del método setString
                    //En el segundo parametro se indicara de donde se obtiene el valor que se tiene que enviar
                    pst.setString(1,txt_buscar.getText().trim());

                    /*
                    Ahora es necesario crear un objeto que se comunique con la clase "ResultSet", la cual nos permite obtener
                    el resultado de la busqueda que ha hecho esta base de datos, es decír, esta clase nos permite saber si,
                    se encontraron los valores o si, no se encontraron.
                     */

                    //El objeto "rs" sera igual a la ejecución de lo que esta dentro de nuestro objeto "pst", oon la ayuda del
                    //método "executeQuery()"
                    ResultSet rs = pst.executeQuery();

                    /*
                    Con el objeto "rs" ya sabemos si los valores que se estan buscando, coincidieron o fueron encontrados,
                    ahora crearemos una estructura condicional para indicarle al programa que tiene que hacer en caso de que,
                    si haya encontrado los valores o que no los haya encontrado, en este caso, en que el "ID" no haya correspondido
                     */
                    //Si "rs" coincide, se utiliza el método "next()", es decír, si el dato/valor que se busco en la base de datos
                    if (rs.next()){  //Con next() va a brincar al sig. paso, es decir, validar la condición "rs"
                        //Dentro del campo va a colocar lo que encontro dentro de la base de datos, para ello, usara setText()
                        // y dentro debe utilizar "rs" que a final de cuentas ahí estan los valores que se encontraron.
                        //Dentro de getString(), se debe poner el campo de la base de datos de donde se va a obtener la información
                        txt_nombre.setText(rs.getString("NombreAlumno"));  //Se debe poner tal cual el nombre de la columna
                        txt_grupo.setText(rs.getString("Grupo"));
                    }else {  //En caso de que el ID que se ingree no corresponda con ningun ID en la base de datos
                        JOptionPane.showMessageDialog(null,"Alumno no registrado");
                    }
                }catch (Exception exception){
                    //No es necesario poner el mensaje, ya que si no muetra nada, el error es de conexión
                }

            }
        });
    }

    //Para que la conexión a la base de datos se haga es necesario ir al panel de control de XAMPP e iniciar los modulos de
    //"Apache" y "MySQL", una vez que se hayan arrancado exitosamente, dirigirse al navegador y escribir la siguiente ruta:
    // "localhost/phpmyadmin", ahora podremos visualizar nuestras bases de datos
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroAlumnos().setVisible(true);
            }
        });
    }
}
