package edd.lista_tipo_pila.analizador_sintactico.clases;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//el diseño de la interfaz se realiza con GUI Form
public class Interfaz extends JFrame {  //Heredamos desde JFrame para usar los componentes
    private JTextField txt_expresion;
    private JButton btnValidar;
    private JPanel mainPanel;  //Es necesario nombrar al Panel en GUI Form para que lo translade aqui

    public Interfaz(){
        setContentPane(mainPanel);  //Se agrega el mainPanel a la ventana o Frame
        setSize(400,130);  //Se asignan las medidas de la ventana
        setLocationRelativeTo(null);  //La ventana toma como posicion inicial el centro de la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);  //Se termine el programa cuando se cierre
        setVisible(true);  //Sera visible la interfaz

        /*Para agregar un oyente de accion al boton "Validar Expresion":
        1. En GUI Form(diseño de la interfaz) dar click derecho sobre el boton "Validar Expresion"
        2. Seleccionar "Create Listener" y aparecera otra ventana
        3. Seleccionar la primer opcion "ActionListener" y nos creara el metodo de abajo
        */
        btnValidar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comprobar = "hola mundo";

                if(e.getSource() == btnValidar){
                    String recuperar = txt_expresion.getText();
                    if(comprobar.equals(recuperar)){
                        JOptionPane.showMessageDialog(null,"Es correcta la contraseña");
                    }else {
                        JOptionPane.showMessageDialog(null,"Esta mal la contraseña");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
    }
}
