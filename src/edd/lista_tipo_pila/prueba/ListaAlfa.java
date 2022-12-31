package edd.lista_tipo_pila.prueba;

public class ListaAlfa {
    Nodo apuntadorUltimoValor;
    String listaNodos = "";

    public ListaAlfa(){
        apuntadorUltimoValor = null;
    }

    //Verificar si la pila esta vacia
    public boolean pilaVacia(){
        return apuntadorUltimoValor == null;  //Retorna "true" si la condicion se cumple(significa que esta vacia)
    }

    //Método para garegar un nodo
    public void agregarNodo(int valor){
        Nodo nodo_reciente = new Nodo(valor);
        if(pilaVacia()){
            nodo_reciente.siguiente = null;  //Apunta a null el enlace ya que la pila esta vacia
            apuntadorUltimoValor = nodo_reciente;  //ahora apunta al nodo mas reciente
        }else {
            nodo_reciente.siguiente = apuntadorUltimoValor;
            apuntadorUltimoValor = nodo_reciente;
        }
    }

    //Método para mostrar los nodes de la pila
    public void mostrarNodos(){
        Nodo iterar = apuntadorUltimoValor;
        listaNodos += iterar.dato + "\n";  //Almacenar el dato de cada nodo
        iterar = iterar.siguiente;
    }
}
