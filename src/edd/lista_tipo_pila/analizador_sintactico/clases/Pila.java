package edd.lista_tipo_pila.analizador_sintactico.clases;

public class Pila {
    private Nodo ultimoValorIngresado;  //Apuntara al nodo mas reciente ingresado

    public Pila(){  //Constructor
        ultimoValorIngresado = null;  //Se inicializa apuntando a null, ya que no hay un nodo previo
    }

    //Método para insertar un nuevo nodo dentro de la Pila
    public void insertarNodo(char valor){
        Nodo nuevo_nodo = new Nodo();  //Se crea un nodo, y se guarda en la variabe de tipo Nodo llamada "nuevo_nodo"
        nuevo_nodo.informacion = valor;  //Se asigna el simbolo/valor en el campo de información del nuevo_nodo

        if(ultimoValorIngresado == null){  //Significa que la pila esta vacia
            nuevo_nodo.siguiente = null;  //Ya que la pila esta vacia, su enlace del nuevo nodo apunta a null
            ultimoValorIngresado = nuevo_nodo;  //El Nodo "ultimoValor.." ahora apunta nuevo_nodo, ya que es el ultimo valor ingresado
        }else {  //Significa que la pila tiene al menos un nodo en su contenido
            //El campo "siguiente" del nuevo Nodo apunta a "ultimoValorIngresado" que a su vez esta apuntando al nodo anterior
            nuevo_nodo.siguiente = ultimoValorIngresado;
            //Para recorrer de nodo, hacemos que ultimoValorIngresado apunte al nuevo nodo, o mas reciente
            ultimoValorIngresado = nuevo_nodo;
        }
    }

    //Método para extraer un nodo de la pila
    public char extraer(){  //Va a retornar una variable de tipo char
        if(ultimoValorIngresado != null){  //Significa que la pila tiene al menos algun Nodo
            char dato = ultimoValorIngresado.informacion;  //Almacena el caracter que esta en campo informacion del Nodo mas reciente
            //"ultimoValorIngresado" regresa a apuntar al nodo anterior ya que el que era mas reciente fue eliminado
            ultimoValorIngresado = ultimoValorIngresado.siguiente;
            return dato;  //Retorna el valor que fue eliminado de la Pila
        }else {  //Significa que la pila esta vacia y no hay nada que eliminar
            //Es necesario retornar un elemento de la clase "Character"
            return Character.MAX_VALUE;  //Se puede utilizar cualquier valor
        }
    }

    //Método para saber si la Pila esta vacía

    //Se usara boolean para que retorne true si la condicion interna se cumple y false cuando no lo hace
    public boolean pilaVacia(){
        return ultimoValorIngresado == null;
    }
}
