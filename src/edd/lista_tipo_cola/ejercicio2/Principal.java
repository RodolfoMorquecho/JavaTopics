package edd.lista_tipo_cola.ejercicio2;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        int seleccion = 0, agregar = 0;
        Cola cola2 = new Cola();

        do{
            try {
                seleccion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Selecciona una funcion:\n\n"
                + "1. Agrega un nodo\n"
                + "2. Elimina un nodo\n"
                + "3. Verifica los nodos de la cola\n"
                + "4. Sumar valores\n"
                + "5. Salir."));

                switch (seleccion){
                    case 1:
                        agregar = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el valor del nodo"));
                        cola2.insertar(agregar);
                        break;
                    case 2:
                        if (!cola2.colaVacia()){  //Si la cola no esta vacia:
                            JOptionPane.showMessageDialog(null,
                                    "Se elimino el nodo "+cola2.eliminar());
                        }else {
                            JOptionPane.showMessageDialog(null,"La cola esta vacía");
                        }
                        break;
                    case 3:
                        cola2.mostrarContenido();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,
                                "La suma de los valores es igual a " + cola2.sumatoria());
                        //cola2.sumar = 0;
                        break;
                    case 5:
                        seleccion = 5;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Esta opcion no existe");
                        break;
                }
            }catch (NumberFormatException n){
                JOptionPane.showMessageDialog(null,""+n);
            }
        }while (seleccion != 5);
    }
}
