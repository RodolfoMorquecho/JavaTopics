package edd.lista_tipo_cola.ejercicio2.clases;

import javax.swing.*;

public class Cola {
    Nodo inicio, fin;
    String cola = "";

    public Cola(){
        inicio = null;
        fin = null;
    }

    //Método para verificar si la cola esta vacía
    public boolean colaVacia(){
        if (inicio == null){
            return true;
        }else
            return false;
    }

    //Método para insertar nodo a la cola
    public void insertar(int valor){
        Nodo nuevo = new Nodo(valor);  //Parametro "valor" lo asigna al campo "dato" del Nodo nuevo
        nuevo.siguiente = null;  //Cualquier Nodo nuevo que se ingrese apuntara a null
        if(colaVacia()){  //Cuando la cola esta vacía
            inicio = nuevo;  //Ambos Nodos de referencia apuntan al nuevo Nodo(Solo para el primer Nodo)
            fin = nuevo;
        }else {  //Cuando la cola tiene al menos un elemneto
            fin.siguiente = nuevo;  //El enlace del primer Nodo  creado, apunta al mas nuevo(2do Nodo creado)
            fin = nuevo;  //El nodo de referencia "fin" siempre apuntara al Nodo creado mas reciente
        }
    }

    //Método para eliminar un nodo a la cola
    public int eliminar(){
        int info = inicio.dato;  //Recupera el dato del primer nodo de la Cola
        if(!colaVacia()){  //Si la cola tiene al menos un elemento:
            if (inicio == fin){  //Si los Nodos de referencia apuntan al mismo Nodo significa que es el unico en la cola
                inicio = null;
                fin = null;
            }else {  //En caso de que haya 2 o mas nodos
                inicio = inicio.siguiente;  //Se elimina el primer nodo, y quede como primero el que le procedia
            }
            return info;  //Indica al usuario cual es el valor a eliminar(primer Nodo) de la cola
        }else {
            return Integer.MAX_VALUE;
        }
    }

    //Método para mostrar el contenido de la cola
    public void mostrarContenido(){
        Nodo recorrido = inicio;  //Apunta al primer elemento de la Cola para recorrer todos
        String colaInvertida = "";  //Variable en la que se acomodan los elementos(nodos) en orden

        while (recorrido != null){  //Mientrar Nodo "recorrido" sea diferente de null
            cola += recorrido.dato + " ";  //Almacena el dato de cada nodo y lo separa por un espacio
            recorrido = recorrido.siguiente;  //Avanza al siguiente Nodo para recuperar su dato
        }

        //Se almacenan los datos de la cola en un vector y se convierten en un elemento cada que hay un espacio, al usar split
        String cadena [] = cola.split(" ");  //Al invertir por ejem 10, no quedara 01, por que 10 es un solo elemento

        for (int i = cadena.length-1;i >= 0;i--){  //Se recorre desde el nodo al fondo(primer Nodo) de la cola al primero
            colaInvertida += " "+ cadena[i];  //Se almacenan en la variable "colaInvertida"
        }

        JOptionPane.showMessageDialog(null,colaInvertida);  //Se muestra en una ventana los resultados
        cola = ""; //Se limpian los valores para evitar una acumulacion de datos sobre escritos
    }

    //Método para sumar el valor de los nodos
    public int sumatoria(){
        int sumar = 0;  //Cada que se llame a la funcion dejara en sumar a 0 para evitar que se sume con la llamada anterior de la funcion
        Nodo almacenar = inicio;  //Nodo almacenar se posiciona en el inicio de la cola
        while (almacenar != null){  //Se repetiran las instrucciones hasta que se llegue al fin de la cola
            sumar += almacenar.dato;  //Se suman todos los valores de los nodos
            almacenar = almacenar.siguiente;  //Se recorren los nodos desde el primero al ultimo en la cola
        }
        JOptionPane.showMessageDialog(null, "La suma de los valores es igual a " + sumar);
        return sumar;  //Se retorna sumar, ya que es la que almacena el valor de la operacion entre los nodos
    }

}
