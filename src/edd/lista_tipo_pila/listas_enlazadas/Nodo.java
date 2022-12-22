package edd.lista_tipo_pila.listas_enlazadas;

//Nodo no es una palabra reservada, es el nombre que se le da a la clase para tener mejor entendimiento a la hora de usarla
public class Nodo {
    public int dato;  //El nodo puede tener mas informacion, pero solo se usara una variable llamada "dato" de tipo int
    //variable del tipo de esta misma clase "Nodo" llamada siguiente
    //Al decir que es de este mismo tipo de la clase, apunta hacia el mismo, hacia Nodo
    public Nodo siguiente;  //Actuara como un puntero de enlace, es decir, para conectar o encadenar los siguientes nodos

    //Constructor por defecto, contructor para insertar al final
    public Nodo(int d){  //Recibe como parametro un dato de tipo entero
        this.dato = d;
    }

    //Constructor que ayudara a insertar al inicio de la lista
    public Nodo(int d, Nodo n){  //Recibe el dato y un puntero(el inicio de la lista)
        this.dato = d;
        this.siguiente = n;
    }
}
