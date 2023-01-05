package edd.lista_tipo_cola.ejercicio1.clases;

import javax.swing.*;

/*
Listas tipo cola

Las listas de tipo cola, son aquellas donde las inserciones se realizan al inicio de la lista y las extracciones se realizan
al final de la lista. A este tipo de listas también se les conoce como listas FIFO(First In First Out - primero en entrar,
primero en salir).
 */
public class Cola {
    private Nodo inicioCola, finalCola;  //Objetos de tipo Nodo que serviran como apuntadores a la posicion que se hacen referencia
    String cola = "";  //Variable que ayudara a saber cual es el contenido de la cola

    public Cola(){
        inicioCola = null;  //Se inicializan el null estos punteros, debido a que aun no hay un nodo en la cola
        finalCola = null;
    }

    //Método para saber si la cola esta vacia
    public boolean colaVacia(){
        if (inicioCola == null){
            return true;  //Significa que la cola esta vacía
        }else {
            return false;  //significa que la cola tiene al menos un Nodo
        }
    }

    //Método para insertar a la cola
    public void insertarNodo(int valor){
        Nodo nuevo_nodo = new Nodo();  //Crear objeto de tipo Nodo
        nuevo_nodo.informacion = valor;  //Se asigna el valor que viene por parametro, al campo de informacion del nodo
        nuevo_nodo.siguiente = null;  //Siempre que se agregue un nuevo_nodo apuntara a null
        if(colaVacia()){  //Este condicional solo se utiliza para el primer Nodo
            inicioCola = nuevo_nodo;  //El inicio de la cola siempre apuntara al primer nodo creado
            finalCola = nuevo_nodo;  //El final de la cola siempre apuntara al nuevo_nodo, al creado mas reciente
        }else {
            finalCola.siguiente = nuevo_nodo;  //La parte del enlace del primer nodo ingresado apuntara al nuevo_nodo(segundo)
            finalCola = nuevo_nodo;  //El final de la cola siempre apuntara al nuevo_nodo, al creado mas reciente
        }
    }

    /*
    Prueba del método insertarNodo() con los valores: 2, 4 , 88

    Nodo nuevo_nodo = new Nodo();
    nuevo_nodo.informacion = valor; //nuevo_nodo.informacion = 2 | 4 | 88
    nuevo_nodo.siguiente = null;  //nuevo_nodo.siguiente=null  siempre valdra null
    if(pilaVacia()){ //Este condicional solo se usa para el primer Nodo
        inicioCola = nuevo_nodo; //inicioCola = 2
        finalCola = nuevo_nodo; //finalCola = 2
    }else { //Este condicional solo se usa para el primer Nodo
           finalCola.siguiente = nuevo_nodo; // finalCola vale 2 pero su enlace vale lo que el nuevo nodo, osea 4 | ahora vale 88
                     2 -> null    |    2 -> 4 -> null   |    2 -> 4 -> 88 -> null
           finalCola = nuevo_nodo; // finalCola = 4 | 88
    }
    nuevo_nodo = 2 | nuevo_nodo = 4 | nuevo_nodo = 88
     */

    //Método para extraer nodo de la cola
    public int extraerNodo(){  //Va a retornar el valor que se extraera, siempre se empieza por el primer nodo que se ingreso
        int infotmacion = inicioCola.informacion;  //Se asigna a la variable informacion el valor de informacion del primer nodo de la cola
        if (!colaVacia()){  //Si la cola no esta vacia:
            if (inicioCola == finalCola){  //Significa que en este punto solo hay un nodo en la cola
                inicioCola = null;  //Los apuntadores del ultimo Nodo, solo pueden apuntar a null
                finalCola = null;
            }else {  //Hay mas de un nodo en la cola
                //El apuntador "inicioCola" apunta ahora al segundo Nodo, ya que el primero es extraido y toma su lugar como primero
                inicioCola = inicioCola.siguiente;  //Se recorre al segundo nodo ingresado y asi siucesivamente
            }
            return infotmacion;
        }else {  //En caso de que la cola este vacía
            //Las doa alternativas deben de retornar un valor de tipo entero
            return Integer.MAX_VALUE;  //Podría retornarse un "0", pero es mejor practica de programacion utilizar Integer
        }
    }

    //Método para mostrar el contenido de la cola
    public void mostrarContenido(){
        Nodo recorrido = inicioCola;  //Se creau un nodo que recorrera desde el inicio de la cola hasta el final de la misma
        String colaInvertida = "";  //Variable para recuperar los valores pero de forma invertida

        while (recorrido != null){  //Mientrar el Nodo "recorrido" no apunte a null, debe ejecutar las instrucciones dentro de llaves
            cola += recorrido.informacion + " ";  //Se almacena el valor del Nodo en la variable global "cola" y se agrega un espacio
            recorrido = recorrido.siguiente;  //Se recorre el Nodo "recorrido" hasta que apunte a null y se termine el ciclo
        }

        //Se crea una variable de tipo String que almacenara valores en un arreglo udimensional o vector
        //El método "split" recibirá como parámetro un carácter o grupo de carácteres que usará como patrón a la hora de
        //dividir la cadena para nutrir los diversos miembros del Array.
        String cadena [] = cola.split(" ");  //Cada que haya un espacio, guardara un nuevo elemento en el array
        //Si ingresamos: 10 20 30  al invertir la cadena nos quedarian 03 02 01 pero con split los maneja como un elemento por lo que
        //los acomodara: 30 20 10

        //Estructura repetitiva recorrera todos los elementos del array cadena, en orden del ultimo al primero
        for (int i= cadena.length-1; i>=0; i--){  //se utiliza el -1 en "cadena.lenght-1" para evitar el error null pointer
            colaInvertida += " "+ cadena[i];  //Almacenara los valores en el orden correcto
            //Por ejemplo:
            //Al ingresar 10, 20 y 30, los ordenara de la siguiente forma: 30 20 10

        }

        JOptionPane.showMessageDialog(null,colaInvertida);
        cola = "";  //Se limpian los nodos que contiene la cola para evitar los resultados anteriores cada que se solicite
    }
}
