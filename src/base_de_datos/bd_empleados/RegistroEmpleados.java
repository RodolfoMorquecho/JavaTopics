package base_de_datos.bd_empleados;

//Importante modificar "toString" en los items, en caso de existir error

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;


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
    private JLabel label_work;


    public RegistroEmpleados(){
        this.setContentPane(panel1);
        setBounds(0,0,560,440);
        setTitle("Checador de Tiempo");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Método que agrega los 24 items de las horas
        listaDeHoras();

        //Registrar
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_emp","root","");
                    PreparedStatement pst = cn.prepareStatement("insert into empleados values(?,?,?,?)");

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
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_emp","root","");
                    PreparedStatement pst = cn.prepareStatement("select * from empleados where ID = ?");

                    pst.setString(1,txt_buscar.getText().trim());  //Asignar el ID a pst, dentro del campo "buscar"

                    ResultSet rs = pst.executeQuery();  //Se verifica si el valor buscado se encuentra en la tabla mediante el objeto rs

                    //LLenar los campos con la información buscada por el usuario, mediante el objeto rs de la calse ResultSet
                    if(rs.next()){  //Si se encuentra el resultado en la tabla:
                        txt_nombre.setText(rs.getString("NombreEmp"));  //nombre del campo
                        txt_entrada.setSelectedItem(rs.getString("HoraEnt"));
                        txt_salida.setSelectedItem(rs.getString("HoraSal"));

                        tiempoDeTrabajo();  //Se llama al método que indica las horas trabajadas por el empleado
                        label_status.setText("");

                        //Tambien se pueden escribir los valores mediante el numero de columna, como alternativa:
                        //txt_entrada.setSelectedItem(rs.getString(3));
                        //txt_salida.setSelectedItem(rs.getString(4));

                    }else {  //En caso de no estar el resultado en la tabla:
                        JOptionPane.showMessageDialog(null,"Empleado no registrado.");
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


    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroEmpleados().setVisible(true);
            }
        });
    }


    //Método para agregar los items del 0 al 23 en el comboBox
    public void listaDeHoras(){
        int horas = 24;
        for (int i=0;i<horas;i++){
            txt_entrada.addItem(i);
            txt_salida.addItem(i);
        }
    }

    //Método para calcular las horas de trabajo
    public void tiempoDeTrabajo(){
        int hTotal = 0;
        //Se Convierte de string a entero la opcion seleccionada del comboBox y se almacena en la variable "hEntrada" de tipo entero
        int hEntrada = Integer.parseInt(txt_entrada.getSelectedItem().toString());
        int hSalida = Integer.parseInt(txt_salida.getSelectedItem().toString());

        //Cuando la hora de entrada es mayor a la de salida, significa que la jornada empezo en el dia actual, pero termino el siguiente
        //Debido a que tenemos hasta 23 en el comboBox, se contaran las horas de ese dia y despues se suman las del otro día
        if(hEntrada > hSalida){
            int aux = 23 - hEntrada;  //Horas del primer día
            //Se suman aux:primer día, hSalida: va de 0 hasta la salida que indico el empleado y el "1" es la hora faltante en lista de 23 a 24
            hTotal = aux + hSalida + 1;
            label_work.setText("Trabajo "+ hTotal + " horas.");
        }else if(hEntrada < hSalida){  //Todas las horas se cumplen durante el mismo día
            hTotal = hSalida - hEntrada;
            label_work.setText("Trabajo "+ hTotal + " horas.");
        }else {    //No hay ninguna diferencia entre horaros
            label_work.setText("El empleado no trabajo");
        }
    }
}
