package poo.thread_estados;

public class HiloProceso implements Runnable{
    String nombre;
    public HiloProceso(String NombreHilo){
        this.nombre = NombreHilo;
    }
    @Override
    public void run(){
        for (int i=0;i<=5;i++){
            System.out.println(i +" "+ nombre);
        }
        System.out.println("");
    }
}
