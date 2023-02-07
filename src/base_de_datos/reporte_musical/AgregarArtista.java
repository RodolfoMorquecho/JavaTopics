package base_de_datos.reporte_musical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AgregarArtista extends JFrame {
    JButton btnAdd;

    public AgregarArtista(){
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = Conexion.conectar();  //Se llama al método que contiene los datos de conexión, Mediante la clase "Conexion"
                    PreparedStatement pst = cn.prepareStatement("insert into artistas values(?,?,?,?,?,?)");

                    pst.setString(1,"0");
                }catch (Exception exception){

                }
            }
        });
    }
}
