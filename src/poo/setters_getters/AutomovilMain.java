package poo.setters_getters;

import java.util.Scanner;

public class AutomovilMain {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("******** Buscamos un coupe o una camioneta ********");
        System.out.print("\nQue marca es el vehiculo? ");
        String marca = entrada.nextLine();
        System.out.print("Cuantas puertas tiene el vehiculo? ");
        int puertas = entrada.nextInt();
        System.out.print("Cuantas ventanas tiene el vehiculo? ");
        int ventanas = entrada.nextInt();

        Automovil buscador = new Automovil(puertas, ventanas, marca);
        //Aunque el usuario asigne un numero distinto a 2 de puertas, el programador ya establecio que siempre se tomaran 2 puerta como valor
        buscador.setPuertas(2);  //Debido a que puertas valdra 2 siempre, siempre tendremos acceso a los vehiculos especificos
        System.out.println("El numero de puertas es de "+buscador.getPuertas());  //Obtenemos el numero de puertas
        buscador.marcaAuto();
    }
}
