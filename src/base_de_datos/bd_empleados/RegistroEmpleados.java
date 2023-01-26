package base_de_datos.bd_empleados;

//Importante modificar "toString" en los items, en caso de existir error

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class RegistroEmpleados extends JFrame{
    private JTextField txt_nombre;
    private JButton btnRegistro;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JTextField txt_buscar;
    private JButton btnBuscar;
    private JComboBox txt_entrada;
    private JComboBox txt_salida;
    private JPanel panel1;
    private JLabel label_status;


    public RegistroEmpleados(){
        this.setContentPane(panel1);
        setBounds(0,0,550,440);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        listaDeHoras();

        //Registrar
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_emp","root","");
                    PreparedStatement pst = cn.prepareStatement("insert into empleados values(?,?,?)");

                    pst.setString(1,"0");
                    pst.setString(2,txt_nombre.getText().trim());
                    pst.setString(3,txt_entrada.getSelectedItem().toString());
                    pst.setString(4,txt_salida.getSelectedItem().toString());

                    pst.executeUpdate();  //Ejecutar instrucciones hacia la base de datos

                    //Limpiar campos
                    txt_nombre.setText("");
                    txt_entrada.setSelectedItem("");
                    txt_salida.setSelectedItem("");

                    label_status.setText("Registro exitoso.");

                }catch (Exception exception){

                }
            }
        });

        //Leer-Buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://loclahost/bd_emp","root","");
                    PreparedStatement pst = cn.prepareStatement("select * from empleados where ID = ?");

                    pst.setString(1,txt_buscar.getText().trim());  //Asignar el ID a pst, dentro del campo "buscar"

                    ResultSet rs = pst.executeQuery();  //Se verifica si el valor buscado se encuentra en la tabla mediante el objeto rs

                    //LLenar los campos con la información buscada por el usuario, mediante el objeto rs de la calse ResultSet
                    if(rs.next()){  //Si se encuentra el resultado en la tabla:
                        txt_nombre.setText(rs.getString("NombreEmp"));  //nombre del campo
                        txt_entrada.setSelectedItem(rs.getString("HoraEnt"));
                        txt_salida.setSelectedItem(rs.getString("HoraSal"));
                        //label_status.setText("");
                    }else {  //En caso de no estar el resultado en la tabla:
                        JOptionPane.showMessageDialog(null,"Emleado no registrado.");
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
                    String ID = txt_buscar.getText().trim();  //Se obtiene el registro dentro del campo "buscar" y se asigna a la variable ID

                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_emp","root","");
                    PreparedStatement pst = cn.prepareStatement("update empleados set NombreEmp=?,HoraEnt=?,HoraSal=? where ID = "+ID);

                    pst.setString(1,txt_nombre.getText().trim());
                    pst.setString(2,txt_entrada.getSelectedItem().toString());
                    pst.setString(3,txt_salida.getSelectedItem().toString());

                    pst.executeUpdate();  //Se ejecuta la instrucciones previas hacia la base de datos

                    label_status.setText("Modificacion exitosa.");
                }catch (Exception exception){

                }
            }
        });

        //Eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_emp","root","");
                    PreparedStatement pst = cn.prepareStatement("delete from empleados where ID = ?");  //Eliminar de la tabla donde ID =?

                    pst.setString(1,txt_buscar.getText().trim());  //Desde el campo buscar

                    pst.executeUpdate();

                    //Limpiar los campos del ID eliminado
                    txt_nombre.setText("");
                    txt_entrada.setSelectedItem("");
                    txt_salida.setSelectedItem("");

                    label_status.setText("Registro Eliminado");
                }catch (Exception exception){

                }
            }
        });
    }

    public void listaDeHoras(){
        int horas = 24;
        for (int i=0;i<horas;i++){
            txt_entrada.addItem(i);
            txt_salida.addItem(i);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroEmpleados().setVisible(true);
            }
        });
    }

}
