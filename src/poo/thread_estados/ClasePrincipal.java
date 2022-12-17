package poo.thread_estados;

/*
Un hilo presenta distintos estados desde su creación, hasta el final de su ejecución. Estos estados son los siguientes:
- New: El hilo, ha sido creado pero no inicializado, es decir, no se ha ejecutado todavía el metodo start()
Nota: se producira un mensaje de error(IllegalThreadStateException) si se intenta ejecutar cualquier método de la clase Thread,
excepto con el método "start()".

- Ejecutable(Runnable): Cuando el método "start()" crea los recursos del sistema necesarios para ejecutar el hilo, programa el
thread para ejecutarse, y llama al método run() del thread. En este punto el hilo está en el estado "Ejecutabable".

- Bloqueado(Blocked o Not Runnable): En este estado, el hilo se encuentra en ejecución, pero existe una tarea o actividad
del mismo hilo que lo impide.

- Muerto(Dead)/Finalizado:
Un hilo puede morir de dos formas: por causas naturales o siendo asesinado(parado). Una muerte natural se produce cuando su
método run() termina normalmente, mientras que una muerte provocada se produce cuando existe una instrucción que obligue al hilo
a finalizar sin haber concluido su tarea por completo.
 */

public class ClasePrincipal {
    public static void main(String[] args){
        //Primer estado
        Thread t1 = new Thread(new HiloProceso("Thread1"));  //El hilo ha sido creado pero no inicializado.
        Thread t2 = new Thread(new HiloProceso("Thread2"));
        Thread t3 = new Thread(new HiloProceso("Thread3"));
        //Segundo estado
        t1.start();  //El hilo se inicializa/arranca ya que el metodo start() crea los recursos del sistema necesarios para ekjecutar
        t2.start();
        t3.start();

        t2.stop();  //Se provoca la finalizacion del hilo t2
        //Tercer estado
        //Es necesario que el metodo sleep se ejecute dentro del try, en general de una excepcion
        try {
            t1.sleep(2000);  //El hilo sigue en ejecución pero se impide durante 2 seg. con el metodo "sleep()"
            t2.sleep(3000);
            t3.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Error" + e);
        }

        //Cuarto estado
        t1.stop();  //Con este método se obliga al hilo a finalizar
        t3.stop();
    }
}
