package poo.thread_estados;

public class HiloProceso implements Runnable{
    @Override
    public void run(){
        for (int i=0;i<=5;i++){
            System.out.println(i);
        }
        System.out.println("");
    }
}
