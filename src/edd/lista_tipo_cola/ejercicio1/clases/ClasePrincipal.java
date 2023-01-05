package edd.lista_tipo_cola.ejercicio1.clases;

import javax.swing.*;

public class ClasePrincipal {
    public static void main(String[] args) {
        int opcion = 0, nodo_informacion = 0;
        Cola cola = new Cola();

        do{
            try{
                //Se almacena la opcion seleccionada para
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menú de opciones\n\n"
                                + "1. Insertar un nodo\n"
                                + "2. Extraer un nodo\n"
                                + "3. Mostrar el contenido de la Cola\n"
                                + "4. Salir.\n\n"));

                switch (opcion){
                    case 1:
                        nodo_informacion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Por favor ingresa el valor a guardar en el nodo."));
                        cola.insertarNodo(nodo_informacion);  //Se pasa como parametro el valor del nodo_informacion
                        break;
                    case 2:
                        if (!cola.colaVacia()){  //Si la cola no esta vacía
                            JOptionPane.showMessageDialog(null,
                                    "Se extrajo un nodo con el valor: "+cola.extraerNodo());
                        }else {
                            JOptionPane.showMessageDialog(null,"La cola esta vacía");
                        }
                        break;
                    case 3:
                        cola.mostrarContenido();
                        break;
                    case 4:
                        opcion = 4;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opcion no disponible");
                        break;
                }
            }catch (NumberFormatException n){
                JOptionPane.showMessageDialog(null,""+n);
            }
        }while(opcion != 4);
    }
}
