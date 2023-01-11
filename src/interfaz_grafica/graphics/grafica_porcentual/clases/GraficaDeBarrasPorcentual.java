package interfaz_grafica.graphics.grafica_porcentual.clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraficaDeBarrasPorcentual extends JFrame {
    private JPanel panel1;
    private JTextField tfRojo;
    private JTextField tfVerde;
    private JTextField tfAzul;
    private JButton botonGraf;

    boolean bandera = false;

    public GraficaDeBarrasPorcentual(){
        this.setContentPane(panel1);
        setTitle("Grafica de Barras Porcentual");
        setBounds(0,0,480,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        botonGraf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bandera = true;  //Se activa la bandera
                repaint();
            }
        });
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraficaDeBarrasPorcentual().setVisible(true);
            }
        });
    }

    public void paint(Graphics g){
        super.paint(g);

        if(bandera == true){
            //Recuperar datos de los text field
            String string_rojo = tfRojo.getText();
            String string_verde = tfVerde.getText();
            String string_azul = tfAzul.getText();

            //Se convierten en tipo entero
            int int_rojo = Integer.parseInt(string_rojo);
            int int_verde = Integer.parseInt(string_verde);
            int int_azul = Integer.parseInt(string_azul);

            //Se consigue el total de votos
            int total = int_rojo + int_verde + int_azul;

            //Largo horizontal de la barra de cada color
            int largo_rojo = int_rojo * 400 / total;  //400 es el maximo de pixeles que tenemos como limite horizontal
            int largo_verde = int_verde * 400 / total;
            int largo_azul = int_azul * 400 / total;

            //Porcentaje de cada barra con respecto al total de votos
            int porcentaje_rojo = int_rojo * 100 / total;  //100 es el 100% de los votos entre los 3 colores
            int porcentaje_verde = int_verde * 100 / total;
            int porcentaje_azul = int_azul * 100 / total;

            //Pintado y distribucion de las barras
            //Barra Roja
            g.setColor(new Color(255,0,0));  //Color rojo
            g.fillRect(50,120,largo_rojo,50);  //Pintado de barra roja
            g.setColor(new Color(255,255,255));  //Se cambia a color blanco para poner el porcentaje dentro de la barra
            g.drawString(porcentaje_rojo + "%",55,140);

            //Barra Verde
            g.setColor(new Color(0,150,0));  //Color verde
            g.fillRect(50 + largo_rojo,120,largo_verde,50);  //Pintado de barra verde
            g.setColor(new Color(255,255,255));  //Se cambia a color blanco para poner el porcentaje dentro de la barra
            g.drawString(porcentaje_verde + "%",55 + largo_rojo,140);

            //Barra Azul
            g.setColor(new Color(0,0,250));  //Color azul
            g.fillRect(50 + largo_rojo + largo_verde,120,largo_azul,50);  //Pintado de barra azul
            g.setColor(new Color(255,255,255));  //Se cambia a color blanco para poner el porcentaje dentro de la barra
            g.drawString(porcentaje_azul + "%",55 + largo_rojo + largo_verde,140);
        }
    }
}
