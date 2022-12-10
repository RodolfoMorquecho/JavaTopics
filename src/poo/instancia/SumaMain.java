package poo.instancia;
//Tema 1: "instancias"

import java.util.Scanner;  //Permite usar scanner

public class SumaMain {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("******** Programa para sumar dos numeros ********");
        System.out.print("\nIngresa el primer numero: ");
        int primerNum = entrada.nextInt();  //el objeto "entrada" permite al usuario ingresar valores en pantalla
        System.out.print("Ingresa el segundo numero: ");
        int segundoNum = entrada.nextInt();  //Se declara en la misma linea donde recibe el valor del usuario

        //Se realiza una instancia de la clase "Suma" con el objeto "operacion"
        Suma operacion = new Suma(primerNum, segundoNum);  //Se mandaran como parametro los dos numeros al constructor "Suma"
        operacion.mostrarSuma();  //Se accede a la clase "Suma" mediante la instancia y se llama al metodo "mostrarSuma"
    }
}
