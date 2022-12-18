package poo.thread_sincronizacion;
/*
Objetivo:
Habran 4 clases y cada una correspondera a un hilo y letra de la palabra "HOLA", como sabemos los hilos al arrancar corren
de manera simultanea, por lo que se debe de controlar y sincronizar para formar la palabra con el uso del método sleep()
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        //Crear hilos con respecto a las clases
        Thread h1 = new Thread(new Hilo1());
        Thread h2 = new Thread(new Hilo2());
        Thread h3 = new Thread(new Hilo3());
        Thread h4 = new Thread(new Hilo4());

        //Arranque de priemr hilo, que contiene la letra "H"
        h1.start();
        try{
            h1.sleep(10);  //Detendra el hilo1 durante 10 milisegundos, osea a la primer "H"
        }catch (InterruptedException e){
            System.out.println("Error en hilo 1"+e);
        }

        //Arranca el segundo hilo, que contiene la letra "O", en este punto ya pasaron 10 ms en el primer hilo
        h2.start();
        try{
            h2.sleep(10);
        }catch (InterruptedException e){
            System.out.println("Error en hilo 2"+e);
        }

        //Arranca el tercer hilo, que contiene la letra "L", en este punto ya pasaron 20 ms entre el primer y segundo hilo
        h3.start();
        try{
            h3.sleep(10);
        }catch (InterruptedException e){
            System.out.println("Error en hilo 3"+e);
        }

        //Arranca el tercer hilo, que contiene la letra "A", en este punto ya pasaron 30 ms entre el primer y tercer hilo
        h4.start();
        try{
            h4.sleep(10);
        }catch (InterruptedException e){
            System.out.println("Error en hilo 4"+e);
        }

        //En este punto ya pasaron 40 ms entre el primer y cuarto hilo, pero dentro del metodo run(), la primer impresion de las
        //letras estan detenidas durante un segundo, por lo que a:
        // "H": le restan 960 ms para iterar, "O": le restan 970 ms para iterar, "L":le restan 980 ms para iterar, etc.
    }
}
