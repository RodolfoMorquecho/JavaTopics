package poo.constructores;
//Cuando no se usan constructores, se deben utilizar metodos que lleven esas tareas a cabo

import java.util.Scanner;
public class SinConstructor {
    private Scanner entrada = new Scanner(System.in);
    String nombre = "";

    public void pedirNombre(){
        System.out.print("Digita tu nombre: ");
        nombre = entrada.nextLine();
    }

    public void imprimir(){
        System.out.print("Tu nombre es "+nombre);
    }
}
