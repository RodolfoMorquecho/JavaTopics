package interfaz_grafica.graphics.formas;

import javax.swing.*;
import java.awt.*;

public class Formas extends JFrame{
    private JPanel mainPanel;

    public Formas(){
        setContentPane(mainPanel);  //Se agrega el mainPanel a la ventana o Frame
        setBounds(0,0,600,400);  //Se asignan las medidas de la ventana
        setLocationRelativeTo(null);  //La ventana toma como posicion inicial el centro de la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);  //Se termine el programa cuando se cierre
    }

    public static void main(String[] args){
        /*
        La clase "Graphics" requiere actualizar los componentes para poder dibujar dentro de ellos, ya sean las formas o las lineas
        Si no se utiliza el método y clase que se encuentran adelante, no es posible realizar el pintado de las formas
        Clase: "EventQueue - Método: invokeLater
         */
        java.awt.EventQueue.invokeLater(new Runnable() {  //Permite actualizar los componenes con ayuda de un hilo
            @Override
            public void run() {
                new Formas().setVisible(true);  //Hara visible la ventana/interfaz
            }
        });
    }

    //Método para utilizar a la clase "Graphics"
    //Es obligatorio que el método se llame "paint"
    public void paint(Graphics g){  //Es necesario que se pase como parametro un objeto de la clase Graphics
        super.paint(g);  //Se utiliza la palabra reservada "super" y se utilizara el método "paint" con el parametro creado arriba

        g.setColor(Color.BLUE);  //Método para asignar el color de las formas
        g.drawLine(0,70,100,70);//Método para dibuar linea,x1-y1 posicion del inicio x2-y2 posicion del final de linea
        g.drawRect(150,70,50,70);  //Método para dibujar rectangulo
        g.drawRoundRect(250,70,50,70,10,10);  //Método para dibujar rectangulo con las esquinas redondeadas
        g.drawOval(350,70,50,70);  //Método para dibujar un ovalo

        //Dibujar un poligono(Triangulo), es necesario usar vectores que marquen los puntos de union del poligono
        int vectorX [] = {480, 445, 515};  //Vector del eje X
        int vectorY [] = {70, 140, 140};  //Vector del eje Y
        g.drawPolygon(vectorX,vectorY,3);  //Método para dibujar poligono, con los ejes como parametros y el numero de puntos


        //Pintar las mismas figuras pero rellenas
        g.setColor(Color.GREEN);  //Se cambia el color a verde
        g.fillRect(150,270,50,70);
        g.fillRoundRect(250,270,50,70,10,10);
        g.fillOval(350,270,50,70);

        int vector2X [] = {480, 445, 515};  //Vector del eje X
        int vector2Y [] = {270, 340, 340};  //Vector del eje Y
        g.fillPolygon(vector2X,vector2Y,3);
    }
}
