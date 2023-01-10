package interfaz_grafica.graphics.grafica_circular;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
El método repaint() pertenece a la clase Component que se encuentra en el paquete java.awt. Este método se utiliza para llamar
al método update() internamente que llama al método paint() para volver a pintar el componente. Tanto paint() como repaint()
se utilizan para pintar un componente, pero el método repaint() llama internamente a paint() para pintar el componente.
 */

public class GraficaCircular extends JFrame{
    private JPanel panel1;
    private JLabel lblTitulo;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton botonGraf;
    private JLabel punto;
    private JLabel lblRojo;
    private JLabel lblVerde;
    private JLabel lblAzul;

    boolean bandera = false;  //Se inicializa bandera en "false"

    public GraficaCircular(){
        setContentPane(panel1);
        setTitle("Grafica Circular");
        setBounds(0,0,400,396);  //Tamaño de ventana
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        //Evento de boton Graficar
        botonGraf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bandera = true;  //Cambia el estado de la bandera
                repaint();  //Llama al metodo paint para pintar el componente
            }
        });
    }

    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {  //Permite actualizar los componenes con ayuda de un hilo
            @Override
            public void run() {
                new GraficaCircular().setVisible(true);
            }
        });
    }

    public void paint(Graphics g){  //Es obligatorio crear el método con el nombre "paint" para que repaint lo puede llamar
        super.paint(g);  //Se utiliza la palabra reservada "super" y se utilizara el método "paint" con el parametro creado arriba

        if(bandera == true){  //Cuando se presiona el boton "Graficar":
            String string_rojo = textField1.getText();  //Se recupera el texto que se ingreso en el campo de texto del color rojo
            String string_verde = textField2.getText();
            String string_azul = textField3.getText();

            //Se tienen que convertir los datos a enteros, para poder realizar calculos y dibujar la grafica
            int int_rojo = Integer.parseInt(string_rojo);  //Se realiza pareo para cambiar a tipo entero
            int int_verde = Integer.parseInt(string_verde);
            int int_azul = Integer.parseInt(string_azul);

            //Sumar el total de votos
            int total_votos = int_rojo + int_verde + int_azul;

            //Calcular los grados de los votos de cada color
            int grados_rojo = (int_rojo * 360) / total_votos;  //(votos de rojo * grados de un circjulo) / suma total de votos
            int grados_verde = (int_verde * 360) / total_votos;
            int grados_azul = (int_azul * 360) / total_votos;

            //Colores y coordenadas de la grafica

            //Votos Rojos
            g.setColor(new Color(255,0,0));
            g.fillArc(25,80,200,200,0,grados_rojo);  //pos:x  pos:y   ancho:   alto: anguloinicial:  angulo final:
            g.fillRect(250,120,20,20);  //Cuadrado que indica el color a un lado de la grafica
            g.drawString("Color Rojo",275,135);  //Texto con el nombre del color al lado del cuadro

            //Votos Verdes
            g.setColor(new Color(0,130,0));
            g.fillArc(25,80,200,200,grados_rojo,grados_verde);
            g.fillRect(250,150,20,20);
            g.drawString("Color Rojo",275,165);

            //Votos Azules
            g.setColor(new Color(0,0,255));
            g.fillArc(25,80,200,200,grados_rojo + grados_verde,grados_azul);
            g.fillRect(250,180,20,20);
            g.drawString("Color Rojo",275,195);
        }
    }
}
