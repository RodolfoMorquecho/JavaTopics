package base_de_datos.creacion_reportes_pdf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

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
