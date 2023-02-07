package base_de_datos.reporte_musical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

    public CarpetaMusical(){
    }

   private void agregarBandas(){
       btnAgregar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

           }
       });
   }
}
