package poo.threads;

//Alternativa2
public class Proceso2 implements Runnable {  //Se implementa la interface "Runnable"
    @Override  //Se sobreescribe el metodo
    public void run() {
        for (int i=0;i<=5;i++){
            System.out.println("proceso2");
        }
    }
}
