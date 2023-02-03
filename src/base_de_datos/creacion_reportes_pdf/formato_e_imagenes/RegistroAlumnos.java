package base_de_datos.creacion_reportes_pdf.formato_e_imagenes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

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
    private JPanel mainPanel2;

    public RegistroAlumnos(){
        setContentPane(mainPanel2);
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
                    PreparedStatement pst = cn.prepareStatement("insertt into alumnos values(?,?,?)");

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
        btnReportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
