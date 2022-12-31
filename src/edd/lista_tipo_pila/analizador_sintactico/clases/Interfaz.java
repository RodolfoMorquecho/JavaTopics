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
        txt_expresion.setText("{3*(7-6)-{3*7}-[6-3]}");  //Se coloca la expresion para no estarla escribiendo

        /*Para agregar un oyente de accion al boton "Validar Expresion":
        1. En GUI Form(diseño de la interfaz) dar click derecho sobre el boton "Validar Expresion"
        2. Seleccionar "Create Listener" y aparecera otra ventana
        3. Seleccionar la primer opcion "ActionListener" y nos creara el metodo de abajo
        */
        btnValidar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarExpresion()){  //Si la validacion es "true"
                    JOptionPane.showMessageDialog(null,"La expresion esta escrita correctamente.");
                }else {
                    JOptionPane.showMessageDialog(null,"La expresion esta mal escrita.");
                }
            }
        });
    }


    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
    }

    //Método para la parte logica que va a permitir validar expresiones:
    //Mientras no existe algun false dentro de la validacion de las sentencias, la expresion estara correctamente escrita
    //pero si existe un false, nos indica que una de las operaciones no se esta cerrando correctamente o carece de un
    //simbolo de apertura, que indique el inicio de la operacion.
    public boolean validarExpresion(){
        //Se creara un objeto Pila, para que desde la interfaz se pueda comunicar con la clase Pila
        Pila pila = new Pila();
        String cadena = txt_expresion.getText();  //Variable para recuperar la expresion que el uuario ha ingresado en el textfield

        //Estructura repetitiva para recorrer cada carecter de la expresion ingresada en el text field
        for (int i=0; i<cadena.length(); i++){
            /*Estructura condicional:
            Sí un caracter de la expresion es igual a '(' ó '[' ó '{' , lo va a agregar a la pila

            */
            //Método "chartAt()" permite recuperar un caracter según la posicion que esta indicada dentro de los parentesis
            //Por lo que se recorreran todos los caractere que conforman a la expresion recuperada en  la var "cadena"
            if(cadena.charAt(i) == '(' || cadena.charAt(i) == '[' || cadena.charAt(i) == '{'){
                pila.insertarNodo(cadena.charAt(i));  //Inserta el caracter(nodo) a la pila

            }else {  //En caso de que los signos no sean los 3 anteriores que son de apertura
                if (cadena.charAt(i) == ')'){  //Pero si sea un parentesis de cierre
                    /*Si el elemento que retorna extraer es distinto al parentesis de apertura, indica que nunca existio un inicio
                    en la operacion, o que se esta utilizando otro simbolo de apertura, por lo que no se tiene registrado en la
                    pila o se tiene guardado otro que no coincide con el que deberia */

                    //Se elimina el ultimo valor guardado en la pila, pero retorna false si la condicion se cumple
                    //En caso de no cumplirse la condicion:
                    //Elimina el ultimo elemento al hacer la comparacion, lo que ayuda a ir dejando la pila vacia
                    if(pila.extraer() != '('){
                        //Se retorna false, por lo que "validarExpresion()" no se cumple e indica que la expresion esta mal escrita
                        return false;  //
                    }
                }else {
                    if(cadena.charAt(i) == ']'){  //Debido a que se esta comparando un caracter se utiliza la comilla simple
                        if(pila.extraer() != '['){
                            return false;
                        }
                    }else {
                        if(cadena.charAt(i) == '}'){  //Si el caracter es igual a la llave de cierre
                            if (pila.extraer() != '{'){  //Si el ultimo caracter a extraer(en la pila) es distinto de '{'
                                return false;  //retorna false porque no se cierra o abre la operacion correctamente
                            }
                        }

                    }

                }
            }
        }
        /*Si no hay un false hasta aqui, significa que la expresion esta escrita correctamente, pero si existe un error
        de escritura, va a existir un false dentro de las sentencias anteriores, lo que no va a permitir terminar de
        recorrer la estructura repetitiva y automaticamente le va a dar el valor de false al método "validarExpresion",
        hasta que no se corrija y se vuelva a ejecutar la accion al presionar el boton que dispara el actionListaner
        */
        System.out.println(pila.contador);
        return pila.pilaVacia();
    }
}
