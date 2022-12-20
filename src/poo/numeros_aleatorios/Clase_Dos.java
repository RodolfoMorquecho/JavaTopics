package poo.numeros_aleatorios;

import java.util.Random;

public class Clase_Dos {
    public static void main(String[] args) {
        int aleatorio = 0;
        Random r = new Random();  //Crear objeto de tipo Random
        aleatorio = (int)(r.nextDouble() * 100);  //Se realiza casting para convertir el valor double a int
        System.out.println("Num Aleatorio: "+aleatorio);
    }
}
