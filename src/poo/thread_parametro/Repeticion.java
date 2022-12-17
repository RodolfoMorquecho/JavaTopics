package poo.thread_parametro;

//Es preferible utilizar este método, debido a que en java no existe la multi herencia, y en caso de que se debiera de
//heredar de alguna otra, ya no se podria heredar de Threads, por lo que es mejor implementar Runnable

public class Repeticion implements Runnable{
    int limite;
    String name;

    public Repeticion(String NombreHilo){  //Se crea constructor para que reciba como parametro el nombre del hilo
        this.name = NombreHilo;
    }
    @Override
    public void run(){
        for (int i=0;i<=limite;i++){
            System.out.println(i+" "+name);
        }
        System.out.println("");
    }

    public void valorDeCondicion(int valor){  //recibe el valor por parametro
        this.limite = valor;    //Se asigna el valor a la variable que condiciona el limite del for
    }
}
