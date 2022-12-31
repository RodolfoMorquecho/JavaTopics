package edd.lista_tipo_pila.prueba;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0;  //Para el menú
        int valorNodo = 0; //Para guardar el valor del nodo que ingresa el usuario
        ListaAlfa lista = new ListaAlfa();

        do {
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menu de Opciones\n\n"
                      + "1. Agregar un valor a la lista\n"
                      + "2. Salir"));

                switch (opcion){
                    case 1:
                        valorNodo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el valor "));
                        lista.agregarNodo(valorNodo);
                        break;
                    case 2:

                        break;
                    case 3:
                        opcion = 3;
                        break;
                }
            }catch (NumberFormatException n){
                JOptionPane.showMessageDialog(null,"Error: "+n);
            }
        }while (opcion != 3);
    }
}
