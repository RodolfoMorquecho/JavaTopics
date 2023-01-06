package recursividad.ejercicio1;

public class Recursividad {
    //Método para sumar e imprimir una variable, sin utilizar una estructura como for o while
    public void imprimir(int valor){  //Método que pasa como parametro un valor entero
        if (valor <= 5){  //Si el parametro es menor o igual a 5, ejecutara las instrucciones del if
            System.out.print(" " + valor);
            imprimir(valor + 1);  //El método se llama a si mismo, solo modifica al parametro aumentandose 1
            //Cuando se llama a si mismo, vuelve a recorrer todas las instrucciones despues del if, solo con el parametro aumentado
        }
    }
}
