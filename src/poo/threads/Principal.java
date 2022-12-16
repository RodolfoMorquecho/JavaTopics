package poo.threads;
//Tema 9: "Thread"

/*
Un hilo, es un flujo de control dentro de un programa, el cual permite tener múltiples procesos corriendo de forma simultánea.
Es decir, con ayuda de los hilos podemos ejecutar dos o más procesos al mismo tiempo, sin tener que esperar a que finalice un
proceso para poder ejecutar el siguiente.
 */
public class Principal {
    public static void main(String[] args){
        //Crear objetos para correr los procesos
        Proceso1 hilo1 = new Proceso1();  //Cuando se hereda directamente la classe Threads la cual esta dentro del JDK

        //Cuando se implementa la interface Runnable, se crea el objeto llamando a la clase "Thread" y se pasa como parametro la clase
        Thread hilo2 = new Thread(new Proceso2());  //Se usa como parametro(constructor) la clase donde encontrara el proceso2

        //Para que los procesos trabajen simultaneamente, primero se tienen que crear todos los objetos o instancias
        //y despues se deben iniciar(correr).

        hilo1.start();  //Arrancara hilo1 con el metodo start()
        hilo2.start();  //Arrancara hilo2
    }
}
