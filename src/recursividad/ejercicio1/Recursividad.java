package recursividad.ejercicio1;
/*
Recursividad:
La recursividad en programación, es una técnica la cual permite que un bloque de instrucciones codificadas se ejecute "n" veces.
Logrando en ocasiones remplazar a las estructuras repetitivas.

En java los métodos pueden llamarse a si mismos, esto es posible cuando dentro de un método existe la invocación a si mismo, y de
esta manera se considera que este método es recursivo.
 */

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
