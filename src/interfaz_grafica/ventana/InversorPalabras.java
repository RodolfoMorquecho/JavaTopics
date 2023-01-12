package interfaz_grafica.ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InversorPalabras extends JFrame{
    private JTextField textField1;
    private JLabel etiquetaRes;
    private JButton botonInv;
    private JPanel mainPanel;

    boolean bandera = false;
    int tamCadena = 0;

    public InversorPalabras(){
        this.setContentPane(mainPanel);
        setTitle("Inversor de Texto");
        setBounds(0,0,400,180);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        botonInv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bandera = true;  //Se desencadena el evento para invertir la palabra
                invertir();  //Se llama al metdoo que contiene esa bandera
            }
        });
    }

    public static void main(String[] args) {
        InversorPalabras invertir = new InversorPalabras();
    }

    //Método para invertir la palabra
    public void invertir(){
        String inversa = "";
        String cadena = "";
        if(bandera == true){
            cadena = textField1.getText();  //Recuperar palabra ingresada en el campo de texto
            tamCadena = cadena.length();  //Se asigna el numero de letras que contiene la cadena

            while (tamCadena != 0){  //Mientras no valga 0
                inversa += cadena.substring(tamCadena -1,tamCadena);  //Se recupera el ultimo caracter de la cadena y se acumula
                tamCadena--;  //Se resta 1 en cada iteracion para recorrer toda la palabra
            }
            etiquetaRes.setText(inversa);  //Se muestra la palabra inversa en la etiquetaRes
        }
    }
}
