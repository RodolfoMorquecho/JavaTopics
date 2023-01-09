package interfaz_grafica.graphics.formas.ejercicio_formas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;

public class Formulario extends JFrame{
    //Se agregan los RadioButton a grupos de botones en la pestaña de diseño GUI Form
    private JPanel mainPanel;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JLabel etiqueta3;
    //bg1
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    //bg2
    private JRadioButton radio5;
    private JRadioButton radio6;
    private JRadioButton radio4;
    //bg3
    private JRadioButton radio7;
    private JRadioButton radio8;
    private JRadioButton radio9;
    private JButton boton1;
    private JLabel etiqueta4;
    private JLabel etiquetaRes;

    boolean bandera [] = new boolean[3];



    public Formulario(){
       setContentPane(mainPanel);
       setBounds(0,0,500,730);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int preguntas = 3;
                int aciertos = 0;  //Se inicializa aqui para que se resetee a 0 y no se acumulen sumas de formularios anteriores

                //Se inicializan las variables en 0
                int valor[] = new int[preguntas];
                for(int i=0;i< valor.length;i++){
                    valor[i] = 0;
                }

                //Se inicializan las banderas en estado "false"
                for (int i=0;i< valor.length;i++){
                    bandera[i] = false;  //Estas banderas al ser "true", activaran la figura para que se pinte en las respuestas correctas
                }

                //Debido a que hay 3 grupos de botones, solo se necesitan hacer 3 condicionales
                if(radio3.isSelected()){
                    bandera[0] = true;  //Al cambiar a true, manda el mensaje para que la figura se muestre
                    valor[0] = 1;  //Vale un punto, ya que acerto
                }else {
                    if(valor[0] == 1){
                        valor[0] = 0;
                    }
                }

                if(radio5.isSelected()){
                    bandera[1] = true;
                    valor[1] = 1;  //Vale un punto, ya que acerto
                }else {
                    if(valor[1] == 1){
                        valor[1] = 0;
                    }
                }

                if(radio7.isSelected()){
                    bandera[2] = true;
                    valor[2] = 1;  //Vale un punto, ya que acerto
                }else {
                    if(valor[2] == 1){
                        valor[2] = 0;
                    }
                }


                for (int i=0;i< valor.length;i++){
                    aciertos += valor[i];
                }
                etiquetaRes.setText("El numero de aciertos es "+aciertos);
            }
        });
    }

    //Método para dibujar las figuras, en las respuestas correctas
    public void paint(Graphics g){
        super.paint(g);
        //if(bandera[0] == true && (radio1.isSelected || radio2.isSelected)
        if(bandera[0] == true){
            g.setColor(Color.BLUE);
            g.drawRect(200,150,100,70);
        }

        if(bandera[1] == true){
            g.setColor(Color.GREEN);
            g.drawOval(210,315,60,100);
        }

        if(bandera[2] == true){
            g.setColor(Color.MAGENTA);

            int ejeX[] = {210,255,165};
            int ejeY[] = {480,580,580};

            g.drawPolygon(ejeX,ejeY,3);
        }
        /*else {
            if(radio1.isSelected() || radio2.isSelected()){
                g.setColor(Color.RED);
                g.drawString("Respuesta incorrecta",180,180);
            }
        } */

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Formulario().setVisible(true);
            }
        });

    }


}
