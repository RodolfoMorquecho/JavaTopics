package edd.lista_tipo_pila.listas_enlazadas;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        //Se va a crear un menú
        int opcion = 0;  //Variable para seleccionar la opcion dentro del menú
        int element;
        //Se crea un objeto de lista para tener acceso a los métodos agregarAlIniocio() y mostrarLista()
        Lista listita = new Lista();
        do{
            try {  //Para validar en caso de algún error
                //Se hara uso de Integer.pasrseInt para convertir a numero entero, la opcion ingresada en el cuadro de dialogo
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un elemento al inicio de la lista\n"+  //Se ingresan las 3 opciones disponibles al user
                                "2. Mostrar los datos de la lista\n"+
                                "3. Salir", "Menú de Opciones",3));  //Menú de opciones, es el titulo de la ventana

                //Se hara uso de switch para validar cada caso, según la opción seleccionada
                switch (opcion){
                    case 1:  //Se va a solicitar al dato
                        try {  //Se validara en caso de error, como ingreso de letras en lugar de numeros
                            //Se almacena en "element" el valor del elemento ingresado
                            element = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    //Nombre de la ventana y Tipo de mensaje(3) Question
                                    "Ingrea el elemento: ","Insertando al Inicio",3));

                            //Se llama al método para agregar elemento de la clase Lista, mediante el objeto listita de esta clase
                            //Y se pasa como parametro element, para que se añada.
                            listita.agregarAlInicio(element);

                        }catch (NumberFormatException n){  //Muestra el error en ventana
                            JOptionPane.showMessageDialog(null, "Error! "+ n.getMessage());
                        }
                        break;
                    case 2:  //Se mostraran los datos de los nodos enlazados
                        //Se llama al método mostrarLista(), en la opción 2
                        listita.mostrarLista();
                        break;
                    case 3:  //Aqui sale del programa, por lo que basta con el break para cumplir con la opción
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error! "+ e.getMessage());
            }
        }while (opcion != 3);  //Hasta que valga 3 se repetira el do, ya que la opcion 3 es salir del programa
    }
}
