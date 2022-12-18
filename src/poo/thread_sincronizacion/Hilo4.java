package poo.thread_sincronizacion;

public class Hilo4 implements Runnable {
    Thread t;
    @Override
    public void run() {
        for(int i=0;i<=4;i++){
            System.out.println("A");  //Se deja este salto de linea para que se corte justo donde se forma "HOLA"
            try{
                t.sleep(1000);  //Al imprimir la primer A, se cortara el proceso durante 1 seg, hasta imprimir la segunda A
            }catch (InterruptedException e){
                System.out.println("Error en metodo run de Hilo 1:"+e);
            }
        }
    }
}
