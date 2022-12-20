package poo.numeros_aleatorios;

import java.util.Scanner;
import java.util.Random;
public class Adivinar {
    public static void main(String[] args) {
        int numAleatorio = 0;
        int numUser = 0;
        int contador = 0;

        Scanner entrada = new Scanner(System.in);
        System.out.println("******** Adivina el numero aleatorio ********");

        Random r = new Random();
        numAleatorio = (int)(r.nextDouble() * 10);

        do {
            do {
                System.out.print("\nDigita un numero entre 0 y 10: ");
                numUser = entrada.nextInt();
                contador++;
            } while (numUser > 10 || numUser < 0);  //repetira la estructura anterior mientras se cumpla la condicion de los parentesis
            if(numUser == numAleatorio){
                System.out.println("Eres un mago! el numero "+numAleatorio+" es correcto.");
                System.out.println("Despues de "+contador+" intentos");
            }else{
                System.out.println("Intentalo de nuevo");
            }
        }while(numUser != numAleatorio);  //Hasta que no se adivine el numero, el programa seguira repitiendo la secuencia
    }
}
