package base_de_datos.creacion_reportes_pdf;
import java.sql.*;
import javax.swing.*;

public class RegistroEstudiante extends JFrame{
    private JTextField txt_nombre;
    private JTextField txr_grupo;
    private JButton btnRegistrar;
    private JButton btnReportes;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JTextField txt_buscar;
    private JButton btnBuscar;
    private JPanel mainPanel;

    //Constructor
    public RegistroEstudiante(){
        this.setContentPane(mainPanel);
        setTitle("Generador de reportes estudiantil");  //Titulo de interfaz
        setBounds(0,0,600,450);  //Medidas de interfaz
        setLocationRelativeTo(null);  //Centrar interfaz
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
