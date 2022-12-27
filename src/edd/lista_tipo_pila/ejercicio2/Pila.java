package edd.lista_tipo_pila.ejercicio2;
//Tema: Listas Tipo Pila

/*
Las listas, son un Tipo de Dato Abstracto que nos permiten almacenar datos de una forma organizada al igual que los vectores,
pero, a diferencia de estos, esta estructura es dinámica, por lo que no es necesario aber la cantidad de elementos que va
a contener.
En una lista, cada elemento apunta al siguiente elemento, excepto el último elemento, el cual no tiene un sucesor y por tal
motivo el valor del enlace es null.

En este caso, los elementos son registros que contienen el dato a almacenar y un enlace al siguiente elemento.
Los elementos de una lista, suelen recibir tambien el nombre de nodos de la lista. Cada Nodo tiene 2 campos:
 - Un campo. con información
 - Un campo, con un apuntador al siguiente Nodo de la lista.

 Representación gráfica de un Nodo:
     _________________________
    | informacion | apuntador | ----------> al siguiente Nodo
    |_____________|___________|

         <<<< Listas tipo Pila: >>>>
Una lista es tipo pila, cuando las inserciones y las extracciones se realizan por el mismo lado de la lista. Estas listas
tienen una caracteristica en particular, la cual consiste en que el ultimo elemento entrar a la lista, es el primero en salir.
Por esta razon, también se les llama listas LIFO (Last In First Out - Último en entrar primero en salir).

Por último, una pila al ser una lista puede almacenar en el campo de información de un Nodo cualquier tipo de valor:
valores enteros, valores flotantes, cadenas de caracteres, objetos, etc.
 */

public class Pila {
    private Nodo ultimoValorIngresado;
    int tamano = 0;
    String Lista = "";

    public Pila(){
        ultimoValorIngresado = null;  //Ya que aun no se agrega ningun Nodo, comienza apuntando null
        tamano = 0;  //La pila empieza con 0 Nodos insertados
    }

    //Método para saber cuando la pila esta vacia
    public boolean pilaVacia(){
        return ultimoValorIngresado == null;  //Si se cumple esta condicion retorna "true", lo que indica que esta vacia
    }

    //Método para insertar un Nodo en la Pila
    public void insertarNodo(int valor){  //valor es la informacion que va a recibir coo parametro el constructor al crear el Nodo
        Nodo nuevoNodo = new Nodo(valor);  //Se crea una var de tipo Nodo que apunte al nodo mas reciente creado
        //El campo siguiente del Nodo apunta a ultimoValorIngresado, pero para el caso donde no hay un nodo creado antes,
        //va a apuntar a null, ya que la variable esta inicializada en null
        nuevoNodo.siguiente = ultimoValorIngresado;
        //Ahora se referenciía a ultimoValorIngresado hacia el nodo creado recientemente, para que avence por todos los nodos
        ultimoValorIngresado = nuevoNodo;
        tamano++;  //Cada que cumpla un ciclo el método, aumentara de uno en uno el tamano
    }

    //Método para eliminar un Nodo de la pila
    public int eliminarNodo(){
        //Se guarda el dato del ultimo nodo ingresado, en la var auxiliar de tipo entero
        int auxiliar = ultimoValorIngresado.informacion;  //Se muestra el dato que sera eliminado
        ultimoValorIngresado = ultimoValorIngresado.siguiente;  //Vale el valor del Nodo anterior, ya no el actual
        tamano--;  //Se resta de 1 en 1 la cantidad de nodos que hay o el tamaño de la lista
        return auxiliar;  //Retorna el nodi(numero-valor) que se quita de la Lista
    }
}
