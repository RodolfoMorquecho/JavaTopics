package poo.thread_estados;

public class HiloProceso implements Runnable{
    String nombre;
    Thread t;  //Variable de tipo "Thread" para crear un hilo que corte el proceso interno del for por un segundo

    public HiloProceso(String NombreHilo){  //Constructor para pasar nombre de Hilo
        this.nombre = NombreHilo;
    }
    @Override
    public void run(){
        for (int i=0;i<=5;i++){
            System.out.println(i +"-"+ nombre);

            try{
                t.sleep(1000);  //Se dentra un segundo entre cada numero
            }catch (InterruptedException e){
                System.out.println("Error!"+e);
            }
        }
    }
}
