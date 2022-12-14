package edd.lista_tipo_pila.ejercicio1.listas_enlazadas;


public class Lista {
    //Se van a crear 2 punteros(Obviamente de tipo Nodo) que tengan referencia al inicio y al fin de la lista
    protected Nodo inicio, fin;  //Punteros para saber donde esta el inicio y el final, estaran protegidos

    //Constructor para inicializar a los punteros
    public Lista(){
        //Con estos 2 punteros se tiene acceso a lo que contiene la clase Nodo(dato de tipo entero y un enlace de tipo Nodo)
        this.inicio = null;
        this.fin = null;
    }

    //Método para agregar un Nodo al inicio de la Lista
    public void agregarAlInicio(int elemento){
        //Creando al nodo
        //Dentro del new Nodo(), se tendra disponible los 2 constructores pero se usara el que recibe dato y el puntero
        inicio = new Nodo(elemento,inicio);  //Se envia el elemento y el puntero de inicio, para saber en donde esta ubicado
        if(fin == null){  //Quiere decir que aun no habian nodos en la Lista
            fin = inicio;  //Por lo que el fin se debe de apuntar al inicio(primer y unico Nodo existente)
        }
    }

    //Método para mostrar los datos
    public void mostrarLista(){
        //Nueva variable de tipo Nodo(que apuntara a Nodo)
        Nodo recorrer = inicio;  //recorrer va a estar apuntando a inicio
        System.out.println("");  //Salto de linea para separar cada visualizacion cuando se agrega un nuevo Nodo
        while (recorrer != null){  //Mientras recorrer no apunte a null, mostrar los nodos
            //Ya que recorrer esta apuntando a Nodo inicio, al imprimir mostrara el dato que hay en ese Nodo
            //Ya que recorrer esta apuntando a Nodo inicio, tambien tendra acceso a su enlace al siguiente Nodo
            System.out.print("["+recorrer.dato+"]--->");  //Se accede a la variable dato del Nodo recorrer y se muestra
            //Para que el ciclo muestre los demas nodos de la lista a los que se apunta, se asignara a recorrer pero con la var "siguiente"
            //Ya que siguiente esta apuntando al nodo posterior del nodo inicial(actual)
            recorrer = recorrer.siguiente;  //Cuando recorrer apunta a null se termina el condicional
        }
    }
}
