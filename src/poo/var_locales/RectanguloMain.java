package poo.var_locales;
//Tema 2: "this"
import java.util.Scanner;

public class RectanguloMain {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("******** Encuentra el area de un rectangulo ********");
        System.out.print("\nDigita el tamanio de la base: ");
        int base = entrada.nextInt();
        System.out.print("Digita el tamanio de la altura: ");
        int altura = entrada.nextInt();

        //Crear objeto de la clase "Rectangulo" para acceder a su constructor, etc.
        Rectangulo operacion = new Rectangulo(base,altura);  //Enviar lo datos de base y altura mediante el objeto "operacion"
        operacion.mostrarArea();
    }
}
