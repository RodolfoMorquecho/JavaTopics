package poo.thread_parametro;


public class RepeticionPrincipal {
    public static void main(String[] args) {
        //Creación de hilos:
        //Debido a que no heredamos de Thread y solo se implemento Runable, primero se creara un objeto de la clase donde se realizo
        //esa implementacion junto con el parametro que pide el constructor(NombreHilo), despues desde ese objeto se accedera al
        //metodo "valorDeCondicion" con el que podemos asignar el limite del for dentro del metodo run().
        //Para finalizar Creamos el objeto hilo usando la clase Thread y para que reciba lo que se implemento se le pasara por parametro.

        Repeticion h1 = new Repeticion("Hilos1");  //Crear objeto de clase donde esta implementada la interface Runnable
        h1.valorDeCondicion(4);    //Establecer el limite del for dentro del metodo run()
        Thread t1 = new Thread(h1);  //Crear hilo, y pasar como parametro "h1" que contiene la logica planteada

        Repeticion h2 = new Repeticion("Hilo2");
        h2.valorDeCondicion(4);
        Thread t2 = new Thread(h2);

        t1.start();  //Inicia el funcionamiento del hilo
        t2.start();

    }
}
