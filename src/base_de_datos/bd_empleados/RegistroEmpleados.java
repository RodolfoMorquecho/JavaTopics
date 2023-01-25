package base_de_datos.bd_empleados;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class RegistroEmpleados extends JFrame{
    private JTextField txt_nombre;
    private JButton btnRegistro;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JTextField txt_buscar;
    private JButton btnBustar;
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
