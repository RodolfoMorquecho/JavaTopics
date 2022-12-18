package poo.thread_sincronizacion;

public class Hilo3 implements Runnable{
    Thread t;
    @Override
    public void run() {
        for(int i=0;i<=4;i++){
            System.out.print("L");
            try{
                t.sleep(1000);  //Al imprimir la primer L, se cortara el proceso durante 1 seg, hasta imprimir la segunda L
            }catch (InterruptedException e){
                System.out.println("Error en metodo run de Hilo 1:"+e);
            }
        }
    }
}
