package edd.lista_tipo_pila.ejercicio2;

public class Nodo {
    int informacion;
    Nodo siguiente;

    //Constructor
    public Nodo(int valor){  //Cuando se creé un Nodo, mandara el valor de la informacion aquí
        this.informacion = valor;
        this.siguiente = null;  //Comienza apuntando a null
    }
}
