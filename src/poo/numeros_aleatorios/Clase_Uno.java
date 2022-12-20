package poo.numeros_aleatorios;

public class Clase_Uno {
    public static void main(String[] args) {
        int aleatorio = 0;

        //Con el metodo random de la clase Math se puede generar un numero aleatorio
        aleatorio = (int)(Math.random() * 100);  //Se hace casting(int) para transformar el numero de tipo double a int
        System.out.println(aleatorio);
    }
}
