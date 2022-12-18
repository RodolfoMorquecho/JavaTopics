package poo.thread_sincronizacion;

public class Hilo2 implements Runnable{
    Thread t;
    @Override
    public void run() {
        for(int i=0;i<=4;i++){
            System.out.print("O");  //Imprime la letra O al arrancar "Hilo2" 5 veces
            try{
                t.sleep(1000);  //Al imprimir la primer O, se cortara el proceso durante 1 seg, hasta imprimir la segunda O
            }catch (InterruptedException e){
                System.out.println("Error en metodo run de Hilo 1:"+e);
            }
        }
    }
}
