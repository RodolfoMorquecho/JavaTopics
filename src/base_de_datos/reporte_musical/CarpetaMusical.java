package base_de_datos.reporte_musical;

//Base de datos: bd_music
//Tabla: artistas

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Import que daran acceso a las clases que nos proporciona "ITEXT"
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

//Import para integrar imagenes al formato PDF
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;  //Para dar un color al texto
import com.itextpdf.text.Font;

public class CarpetaMusical extends JFrame{
    private JPanel panel1;
    private JTextField txt_nombre;
    private JTextField txt_genero;
    private JTextField txt_pais;
    private JTextField txt_album;
    private JTextField txt_numAlbum;
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnReporte;
    private JTextField txt_buscar;
    private JButton btnBuscar;
    private JLabel label_status;

    public CarpetaMusical(){  //Constructor
        agregarArtista();
        buscarArtista();
        modificarInfoDeArtista();
        eliminarArtista();
        generarReporteDeLista();
    }

    //                                                  CÓDIGO DE LOS BOTONES

    //Método para añadir un artista a la base de datos
    private void agregarArtista(){
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = Conexion.conectar();  //Los datos para conectar a la bd, estan dentro del método "conectar"
                    PreparedStatement pst = cn.prepareStatement("insert into artistas values(?,?,?,?,?,?)");

                    pst.setString(1,"0");
                    pst.setString(2,txt_nombre.getText().trim());
                    pst.setString(3,txt_genero.getText().trim());
                    pst.setString(4,txt_pais.getText().trim());
                    pst.setString(5,txt_album.getText().trim());
                    pst.setString(6,txt_numAlbum.getText().trim());

                    pst.executeUpdate();

                    //Limpiar campos de interfaz
                    limpiezaDeInterfaz();

                    label_status.setText("Artista añadido a tu lista");
                }catch (Exception exception){
                    System.out.println("Error de conexión "+ exception);
                }
            }
        });
    }

    //Método para buscar o leer la información de un artista almacenado en la base de datos
    private void buscarArtista(){
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("select * from artistas where ID = ?");

                    pst.setString(1,txt_buscar.getText().trim());

                    ResultSet rs = pst.executeQuery();

                    if(rs.next()){
                        txt_nombre.setText(rs.getString("NombreArtista"));
                        txt_genero.setText(rs.getString("Genero"));
                        txt_pais.setText(rs.getString("Pais"));
                        txt_album.setText(rs.getString("Album"));
                        txt_numAlbum.setText(rs.getString("NumAlbums"));
                    }else {
                        JOptionPane.showMessageDialog(null,"Artista no encontrado.");
                    }

                }catch (Exception exception){
                    System.out.println("Error de conexión "+ exception);
                }
            }
        });
    }

    //Método para modificar la información de un artista almacenado en la base de datos
    private void modificarInfoDeArtista(){
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID = txt_buscar.getText().trim();
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "update artistas set NombreArtista = ?, Genero = ?, Pais = ?, Album = ?, NumAlbums = ? where ID ="+ ID);

                    pst.setString(1,txt_nombre.getText().trim());
                    pst.setString(2,txt_genero.getText().trim());
                    pst.setString(3,txt_pais.getText().trim());
                    pst.setString(4,txt_album.getText().trim());
                    pst.setString(5,txt_numAlbum.getText().trim());

                    pst.executeUpdate();

                    //Limpiar campos de interfaz
                   limpiezaDeInterfaz();

                    label_status.setText("Cambios realizados.");
                }catch (Exception exception){
                    System.out.println("Error de conexión "+ exception);
                }
            }
        });
    }

    //Método para eliminar el artista de la base de datos
    private void eliminarArtista(){
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("delete from artistas where ID = ?");

                    pst.setString(1,txt_buscar.getText().trim());

                    pst.executeUpdate();
                    limpiezaDeInterfaz();

                    label_status.setText("Artista eliminado de la lista");

                }catch (Exception exception){
                    System.out.println("Error de conexión "+ exception);
                }
            }
        });
    }

    //Método para crear el reporte de la lista de artistas en el escritorio de la PC
    private void generarReporteDeLista(){
        btnReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document documento = new Document();
                try {
                    String ruta = System.getProperty("user.home");
                    PdfWriter.getInstance(documento,new FileOutputStream(ruta + "/Desktop/ListaMusical.pdf"));

                    documento.open();

                    PdfPTable tabla = new PdfPTable(6);
                    tabla.addCell("Código");
                    tabla.addCell("Artista");
                    tabla.addCell("Género");
                    tabla.addCell("País");
                    tabla.addCell("1° Album");
                    tabla.addCell("Núm. de Albums");

                    try {
                        Connection cn = Conexion.conectar();
                        PreparedStatement pst = cn.prepareStatement("select * from artistas");  //seleccionar tod0 de la tabla artistas

                        ResultSet rs = pst.executeQuery();

                        if(rs.next()){
                            do {
                                tabla.addCell(rs.getString(1));
                                tabla.addCell(rs.getString(2));
                                tabla.addCell(rs.getString(3));
                                tabla.addCell(rs.getString(4));
                                tabla.addCell(rs.getString(5));
                                tabla.addCell(rs.getString(6));
                            }while (rs.next());  //Mientras exista una fila con info de algun artista, se repetira la inserción en el doc.

                            documento.add(tabla);  //Añadir la tabla con toda la información al objeto de tipo Document
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    documento.close();  //Se cierra el documento, ya que se termino la edición
                    JOptionPane.showMessageDialog(null,"Lista musical creada.");

                }catch (DocumentException | FileNotFoundException exception){

                }
            }
        });
    }

    //Método que se reutilizara para limpiar los campos de la interfaz
    private void limpiezaDeInterfaz(){
        txt_nombre.setText("");
        txt_genero.setText("");
        txt_pais.setText("");
        txt_album.setText("");
        txt_numAlbum.setText("");
    }
}
