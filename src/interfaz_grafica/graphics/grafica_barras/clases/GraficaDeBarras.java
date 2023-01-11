package interfaz_grafica.graphics.grafica_barras.clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraficaDeBarras extends JFrame{
    private JPanel panel1;
    private JLabel titulo;
    private JButton botonGraf;
    private JTextField tfRojo;
    private JTextField tfVerde;
    private JTextField tfAzul;
    private JLabel lblRojo;
    private JLabel lblVerde;
    private JLabel lblAzul;

    boolean bandera = false;

    public GraficaDeBarras(){
        setContentPane(panel1);
        setBounds(0,0,520,350);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Método para el funcionamiento del boton
        botonGraf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bandera = true;
                repaint();
            }
        });
    }

    //Funcion principal
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraficaDeBarras().setVisible(true);
            }
        });
    }

    //Funcion para definir el valor mayor entre los votos de los 3 colores
    public int valor_Mayor(int valor_rojo, int valor_verde, int valor_azul){  //Parametros de referencia
        if(valor_rojo > valor_verde && valor_rojo > valor_azul){  //Si el valor rojo es mayor a  los otros dos
            return valor_rojo;
        }else if(valor_verde > valor_azul){  //En el condicional anterior se deduce que el valor verde es mayor al rojo, ya que no entro en el
            return valor_verde;
        }else {
            return valor_azul;  //En los condicionales anteriores se deduce que el valor azul es mayor a los otro dos
        }
    }

    //Método para pintar las graficas
    public void paint(Graphics g){
        super.paint(g);

        if(bandera == true){  //bandera cambio estado a true al presionar el boton "Graficar"

            //Se recupera el texto de los text field en las siguientes variables:
            String string_rojo = tfRojo.getText();
            String string_verde = tfVerde.getText();
            String string_azul = tfAzul.getText();

            //Se convierte a tipo entero el texto recuperado
            int int_rojo = Integer.parseInt(string_rojo);
            int int_verde = Integer.parseInt(string_verde);
            int int_azul = Integer.parseInt(string_azul);

            //Se llama a la funcion para definir al valor mayor y se asigna en la variable "ValorMayor"
            int ValorMayor = valor_Mayor(int_rojo, int_verde, int_azul);

            //Formula para definir la longitud de la barra de cada color
            //int_rojo: valor ingresado por usuario   |  400: limite de pixeles en el eje x de la barra
            int largo_rojo = (int_rojo * 400) / ValorMayor;
            int largo_verde = (int_verde * 400) / ValorMayor;
            int largo_azul = (int_azul * 400) / ValorMayor;

            //Rellenar las barras de cada color
            //Color Rojo
            g.setColor(new Color(255,0,0));
            g.fillRect(100,100,largo_rojo,40);
            g.setFont(new Font("Tahoma",Font.BOLD,12));  //Modifica el tipo de fuente, tamaño y grosor
            g.drawString("Color Rojo",20,125);

            //Color Verde
            g.setColor(new Color(0,150,0));
            g.fillRect(100,150,largo_verde,40);
            g.setFont(new Font("Tahoma",Font.BOLD,12));
            g.drawString("Color Verde",20,175);

            //Color Rojo
            g.setColor(new Color(0,0,255));
            g.fillRect(100,200,largo_azul,40);
            g.setFont(new Font("Tahoma",Font.BOLD,12));
            g.drawString("Color Azul",20,225);
        }
    }
}
