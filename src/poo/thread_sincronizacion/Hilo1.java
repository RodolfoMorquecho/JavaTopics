package poo.thread_sincronizacion;

public class Hilo1 implements Runnable{
    Thread t;  //Crear hilo, ya que no hemos heredad de la clase thread solo hemos implementado su interface
    @Override
    public void run() {
        for(int i=0;i<=4;i++){
            System.out.print(i+": H");  //Imprime la letra H al arrancar "Hilo1" 5 veces
            try{
                t.sleep(1000);  //Al imprimir la primer H, se cortara el proceso durante 1 seg, hasta imprimir la segunda H
            }catch (InterruptedException e){
                System.out.println("Error en metodo run de Hilo 1:"+e);
            }
        }
    }
}
