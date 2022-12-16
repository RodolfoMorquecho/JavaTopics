package poo.threads;

//Alternativa1
public class Proceso1 extends Thread{  //Hereda de la clase Thread el metodo "run" el cual se sobreescribe
    @Override  //Cuando se usa poliomrfismo, se debe indicar "@Override"
    public void run(){
        for (int i=0;i<=5;i++){
            System.out.println("proceso1");
        }
    }
}
