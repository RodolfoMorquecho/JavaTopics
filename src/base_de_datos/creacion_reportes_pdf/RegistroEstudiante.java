package base_de_datos.creacion_reportes_pdf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.*;
import javax.swing.*;

//Import que daran acceso a las clases que nos proporciona "ITEXT", se agregaran manualmente ya que no pertenecen al JDK e Intellij no las agregara
import com.itextpdf.text.Document;  //La primer clase importada sera "Document"
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;  //De esta forma se obtiene la clase PdfPTable
import com.itextpdf.text.pdf.PdfWriter;

public class RegistroEstudiante extends JFrame{
    private JTextField txt_nombre;
    private JTextField txt_grupo;
    private JButton btnRegistrar;
    private JButton btnReportes;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JTextField txt_buscar;
    private JButton btnBuscar;
    private JPanel mainPanel;
    private JLabel label_status;

    //Constructor
    public RegistroEstudiante(){
        this.setContentPane(mainPanel);
        setTitle("Generador de reportes estudiantil");  //Titulo de interfaz
        setBounds(0,0,600,450);  //Medidas de interfaz
        setLocationRelativeTo(null);  //Centrar interfaz

        //Registrar - Create
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_est","root","");
                    PreparedStatement pst = cn.prepareStatement("insert into estudiantes values(?,?,?)");

                    pst.setString(1,"0");
                    pst.setString(2,txt_nombre.getText().trim());
                    pst.setString(3,txt_grupo.getText().trim());

                    pst.executeUpdate();  //Ejecutar instrucciones hacia base de datos

                    //Limpiar campos
                    txt_nombre.setText("");
                    txt_grupo.setText("");

                    //Indicación de registro
                    label_status.setText("Registro exitoso.");

                }catch (Exception exception){

                }
            }
        });

        //Buscar - Read
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_est","root","");
                    PreparedStatement pst = cn.prepareStatement("select * from estudiantes where ID = ?");

                    pst.setString(1,txt_buscar.getText().trim());

                    ResultSet rs = pst.executeQuery();  //Verificar si el resultado se encontro en la base de datos al ejecutarse la instruccion

                    if(rs.next()){  //Si se encuentra el registro:
                        txt_nombre.setText(rs.getString("NombreEstudiante"));
                        txt_grupo.setText(rs.getString("Grupo"));
                    }else {
                        JOptionPane.showMessageDialog(null,"Estudiante no registrado.");
                    }
                }catch (Exception exception){

                }
            }
        });

        //Modificar - Update
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID = txt_buscar.getText().trim();  //Se captura el ID de registro buscado por el usuario

                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_est","root","");
                    PreparedStatement pst = cn.prepareStatement("update estudiantes set NombreEstudiante=?, Grupo=? where ID ="+ ID);

                    pst.setString(1,txt_nombre.getText().trim());
                    pst.setString(2,txt_grupo.getText().trim());

                    pst.executeUpdate();

                    //Limpiar campos
                    txt_nombre.setText("");
                    txt_grupo.setText("");

                    //Indicación de modificación
                    label_status.setText("Modificación exitosa.");
                }catch (Exception exception){

                }
            }
        });

        //Eliminar - Delete
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_est","root","");
                    PreparedStatement pst = cn.prepareStatement("delete from estudiantes where ID = ?");

                    pst.setString(1,txt_buscar.getText().trim());

                    //Limpiar campos
                    txt_nombre.setText("");
                    txt_grupo.setText("");

                    //Indicación de eliminación de registro
                    label_status.setText("Registro eliminado.");
                }catch (Exception exception){

                }
            }
        });

        //Boton para generar reportes en PDF
        btnReportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se creara un objeto de la clase "Document"
                Document documento = new Document();

                //Al igual que cuando se crea código que conecta con base de datos, cuando se escribe código para crear archivo
                //en PDF, es necesario colocarlo dentro de una estructura try - catch
                try {
                    //Lo primero es declarar una variable de tipo String llamada ruta

                    //Lo que se guardara en la variable sera la ruta que nos da acceso a la carpeta de usuario de la computadora
                    //donde se este ejecutando el programa, es decír, la ruta que aparece al abrir el simbolo de sistema de la PC
                    //Con esta ruta podemos indicar en que parte(Escritorio, Documentos, etc.) queremos guardar los archivos PDF
                    String ruta = System.getProperty("uset.home");

                    //Crear línea de código para indicar al programa donde va a guardar el archivo y cual sera el nombre:

                    //Mediante la clase "PdfWriter" accederemos al método "getInstance", el cual pide 2 parametros:
                    //Primero: Es un objeto de la clase "Document", usaremos el que creamos al inicio de este boton "documento"
                    //Segundo: Se hara uso de la clase "FileOutputStream" por lo que crearemos un nuevo objeto anonimo de esta y dentro
                    //de los parentesis se colocara la variable "ruta"(donde se guardo el acceso a la carpeta de usuario) y se
                    //va a concatenar la boblioteca donde se guardara, y el nombre del archivo junto con su extension ".pdf"

                    //Se creara el archivo en el escritorio y tendra el nombre de "Reporte_Estudiantes.pdf"
                    PdfWriter.getInstance(documento,new FileOutputStream(ruta + "/Desktop/Reporte_Estudiantes.pdf"));
                }catch (Exception exception){

                }
            }
        });
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroEstudiante().setVisible(true);  //mediante un objeto anonimo, accedemos al metodo setVisible y lo activamos
            }
        });
    }
}
