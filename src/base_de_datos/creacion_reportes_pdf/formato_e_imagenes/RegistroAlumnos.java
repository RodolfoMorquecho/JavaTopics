package base_de_datos.creacion_reportes_pdf.formato_e_imagenes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;

//Import que daran acceso a las clases que nos proporciona "ITEXT", se agregaran manualmente ya que no pertenecen al JDK e Intellij no las agregara
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

//Import para integrar imagenes al formato PDF
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;  //Para dar un color al texto
import com.itextpdf.text.Font;

public class RegistroAlumnos extends JFrame{
    private JTextField txt_nombre;
    private JTextField txt_grupo;
    private JButton btnRegistrar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnReportes;
    private JTextField txt_buscar;
    private JButton btnBuscar;
    private JLabel label_status;
    private JPanel mainPanel;

    public RegistroAlumnos(){
        setContentPane(mainPanel);
        setBounds(0,0,600,450);
        setTitle("Generador de reportes");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_esc","root","");
                    PreparedStatement pst = cn.prepareStatement("insert into alumnos values(?,?,?)");

                    pst.setString(1,"0");
                    pst.setString(2,txt_nombre.getText().trim());
                    pst.setString(3,txt_grupo.getText().trim());

                    pst.executeUpdate();

                    txt_nombre.setText("");
                    txt_grupo.setText("");

                    label_status.setText("Registro exitoso.");
                }catch (Exception exception){

                }
            }
        });

        //Buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_esc","root","");
                    PreparedStatement pst = cn.prepareStatement("select * from alumnos where ID = ?");

                    pst.setString(1,txt_buscar.getText().trim());

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()){
                        txt_nombre.setText(rs.getString("NombreAlumno"));
                        txt_grupo.setText(rs.getString("Grupo"));
                    }else {
                        JOptionPane.showMessageDialog(null,"Estudiante no registrado.");
                    }
                }catch (Exception exception){

                }
            }
        });

        //Modificar
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID = txt_buscar.getText().trim();

                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_esc","root","");
                    PreparedStatement pst = cn.prepareStatement("update alumnos set NombreAlumno=?, Grupo=? where ID="+ID);

                    pst.setString(1,txt_nombre.getText().trim());
                    pst.setString(2,txt_grupo.getText().trim());

                    pst.executeUpdate();

                    txt_nombre.setText("");
                    txt_grupo.setText("");
                    label_status.setText("Modificación exitosa.");
                }catch (Exception exception){

                }
            }
        });

        //Eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_esc","root","");
                    PreparedStatement pst = cn.prepareStatement("delete * from alumnos where ID = ?");

                    pst.setString(1,txt_buscar.getText().trim());

                    pst.executeUpdate();

                    txt_nombre.setText("");
                    txt_grupo.setText("");
                    label_status.setText("Registro eliminado.");
                }catch (Exception exception){

                }
            }
        });

        //Generar reporte

        //1. Crear un objeto de tipo "Document"     ---- try - catch
        //2. Guardar en una variable de tipo string la ruta que que da acceso a la carpeta de usuario.
        //3. Crear el archivo en el escritorio usando la variable, concatenando la direccion final y el nombre del archivo.pdf
        //4. Abrir el objeto de tipo "Document"
        //5. Crear objeto de tipo "PdfPTable" al cual se le pasan como argumento el número de columnas
        //6. Mediante el objeto de tipo Table, agregar las celdas de titulo correspondiente a cada columna    [try - catch]
        //7. Conectar a base de datos
        //8. Instruccion a la base de datos: "Seleccionar tod0 de la tabla alumnos"
        //9. Crear objeto de tipo ResultSet para verificar si se encuentra el ID, asignandole la ejecución a base de datos
        //10. En caso de encontrar valores en la base de datos, crear algoritmo para llenar las celdas con la informaccion en orden
        //11. Agregar la tabla al archivo
        //12. Cerrar documento

        btnReportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document documento = new Document();  //Objeto de la clase Document
                try {
                    String ruta = System.getProperty("user.home");
                    PdfWriter.getInstance(documento,new FileOutputStream(ruta + "/Desktop/Reporte_Alumnos.pdf"));

                    //--------------------------------------------------------------------------------------------------
                    //FORMATO DE TEXTO E INSERCION DE IMAGENES

                    //Código que permite insertar la imágen dentro del documento    //Ruta donde se encuentra la imágen
                    Image header = Image.getInstance("src/base_de_datos/creacion_reportes_pdf/formato_e_imagenes/img/header.png");

                    //Agregar las dimensiones de la imágen
                    header.scaleToFit(650,1000);  //Ancho:650px, Largo:1000. El largo va de 0 a 1000, usaremos lo mas grnade.

                    //Alinear la imagen(objeto header)
                    //Mediante la clase Chunk se puede buscar un método segun el tipo de alineación que se quiera dar(cener, justified, bottom)
                    header.setAlignment(Chunk.ALIGN_CENTER);  //Para esta ocasión se alineara al centro

                    //Formaro de texto
                    Paragraph parrafo = new Paragraph();  //Crear objeto de clase Paragraph

                    //Alinear texto: para alinear texto se utiliza Paragraph y no Chunk(imágen)
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);  //Se alineara al centro el texto

                    //Agregar frase o texto que se quiere poner dentro del documento en PDF
                    parrafo.add("Formato creado por RodolfoMorquecho ® \n\n ");

                    //Agregar formato al texto(Tipo de fuente, tamaño, estilo y color)
                    //Se van asignar los requerimientos al texto mediante el método setFont(), el cual recibira como parametros:
                    //La clase "FontFactory" que recuperara a su vez los parametros mediante el método "getFont"
                    //Tipo de letra  |  Tamaño  |  Estilo  |  Color
                    parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));

                    //Titulo de la tabla
                    parrafo.add("Alumnos registrados \n\n");

                    //Indicar al programa que se deben de agregar la imagen y el texto al documento, despues de la apertura del documento
                    //--------------------------------------------------------------------------------------------------

                    documento.open();  //Abrir el documento

                    //Se agregam imagen y parrafo al documento
                    documento.add(header);
                    documento.add(parrafo);

                    PdfPTable tabla = new PdfPTable(3);  //Crear tabla con 3 columnas
                    tabla.addCell("Código");  //Titulo para la primer columna
                    tabla.addCell("Nombre de Alumno");  //Titulo para la segunda columna
                    tabla.addCell("Grupo");

                    //Conexxión a base de datos
                    try {
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_esc","root","");
                        PreparedStatement pst = cn.prepareStatement("select * from alumnos");

                        ResultSet rs = pst.executeQuery();  //Verificar si se encuentran los datos al ejecutar la instruccion a bd

                        if(rs.next()){  //Si "rs" contiene 1 o mas registros encontrados
                            do {  //Ejecutara la siguinente instrccion:
                                tabla.addCell(rs.getString(1));  //Agrega el ID en la columna 1, es donde corresponden
                                tabla.addCell(rs.getString(2));
                                tabla.addCell(rs.getString(3));  //Agrega el grupo en columna 3
                            }while (rs.next());  //Mientras rs encuentre un registro en la base de datos

                            documento.add(tabla);  //Se agrega la tabla llenada con info de la base de datos al documento pdf
                        }
                    }catch (DocumentException | SQLException exception){
                        System.out.println("Error de conexion "+ exception);
                    }
                    documento.close();  //Se cierra la edicion del documento

                    JOptionPane.showMessageDialog(null,"Reporte creado.");  //Mensaje para informar que el pdf esta listo
                }catch (DocumentException | FileNotFoundException | HeadlessException exception){
                    System.out.println("Error en PDF "+ exception);
                }catch (IOException exception){  //E necesario agregar esta excepción para quitar el error marcado al crear la instancia de la imágen
                    System.out.println("Error en la imagen: "+ exception);
                }
            }
        });
    }


    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroAlumnos().setVisible(true);
            }
        });
    }
}
