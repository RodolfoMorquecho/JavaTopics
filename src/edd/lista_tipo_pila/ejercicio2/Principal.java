package edd.lista_tipo_pila.ejercicio2;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0, nodo = 0;
        Pila pila = new Pila();  //Crear objeto de la calse Pila

        //Menú de opciones - se cicla hasta que el usuario indique que quiere salir
        //Lo mejor seria crear una Interfaz gráfica pero por practicidad y velocidad se hara uso de JOptionPane
        do {
            try {  //Captura de errores
                //Se mostrara una ventana con las opciones y se guardara en la variable "opcion" de tipo entero la seleccion
                // del usuario, esa seleccion se pasara a entero con el parseInt
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menú de Opciones\n\n"
                                + "1. Insertar un nodo\n"
                                + "2. Eliminar un nodo\n"
                                + "3. ¿La pila esta vacia?\n"
                                + "4. ¿Cual es el último valor ingresado en la Pila?\n"
                                + "5. ¿Cuantos nodos tiene la Pila?\n"
                                + "6. Vaciar Pila\n"
                                + "7. Mostrar contenido de la Pila\n"
                                + "8. Salir.\n\n"));

                //Se validara cada caso, segun la opcion seleccionada
                switch (opcion){
                    case 1:
                        //Se almacena en la variable de tipo entero "nodo" el valor ingresasdo por el usuario(string)
                        nodo = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el valor a guardar en el nodo: "));

                        pila.insertarNodo(nodo);  //Se accede al método insertarNodo y se pasa como parametro lo que el usuario ingreso
                        break;
                    case 2:  //Eliminar nodo
                        if(!pila.pilaVacia()){
                            JOptionPane.showMessageDialog(null,
                                    "Se ha eliminado el nodo con valor "+pila.eliminarNodo()+" de la Lista");
                        }else {
                            JOptionPane.showMessageDialog(null,"No existe nodo para eliminar");
                        }
                        break;
                    case 3:  //La pila esta vacia?
                        if (pila.pilaVacia()){
                            JOptionPane.showMessageDialog(null,"La pila esta vacia");
                        }else {
                            JOptionPane.showMessageDialog(null,"La pila no esta vacia");
                        }
                        break;
                    case 4:  //Ultimo valor ingresado en la pila
                        if(!pila.pilaVacia()){
                            JOptionPane.showMessageDialog(null,
                                    "El ultimo valor ingreado es "+pila.mostrarUltimoValorIngresado());
                        }else {
                            JOptionPane.showMessageDialog(null,"Aun no hay nodos en la pila");
                        }
                        break;
                    case 5:  //Cuantos nodos hay en la pila
                        if(!pila.pilaVacia()){
                            JOptionPane.showMessageDialog(null,
                                    "La pila tiene "+pila.tamanoDePila()+ "nodos");
                        }else {
                            JOptionPane.showMessageDialog(null,"La pila no tiene ningun nodo");
                        }
                        break;
                    case 6:  //Vaciar pila
                        if(!pila.pilaVacia()){  //Si la pila no esta vacia, o su enlace no esta apuntando a null
                            pila.vaciarPila();  //Vaciar la pila, se accede al método mediante el objeto creado en esta clase
                            JOptionPane.showMessageDialog(null,"Se ha vaciado la pila correctamente");
                        }else {
                            JOptionPane.showMessageDialog(null,"La pila ya esta vacia");
                        }
                        break;
                    case 7:  //Mostrar contenido
                        pila.mostrarValores();  //Mediante el objeto tipo Pila, se accede al método que muestra los valores
                        break;
                    case 8:  //Salir
                        opcion = 8;  //Con esta asignacion se deja de cumplir la sentencia del while que contiene toda la estructura
                        break;
                    default:  //En caso de que se ingrese un numero mayor a 8 y menor a 1
                        JOptionPane.showMessageDialog(null,"Opcion incorrecta, vuelve a intentar nuevamente.");
                }
            }catch (NumberFormatException n){  //Captura de errores
                JOptionPane.showMessageDialog(null,"Error"+n.getMessage());
            }

        }while (opcion != 8);  //cuando opcion sea igual a 8 se termina el programa
    }
}
