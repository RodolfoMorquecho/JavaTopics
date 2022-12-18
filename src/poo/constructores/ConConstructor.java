package poo.constructores;
//Tema 9: "Constructores"

/*
Constructor: Se puede definir como un método que se ejecuta inicialmente y de manera automática. Tiene las sig. caracteristicas:
 - Tiene el mismo nombre de la clase.
 - Es el primer método que se ejecuta.
 - No puede retornar datos.
 - Se ejecuta una única vez.
 - Tiene por objetivo inicializar atributos.
 -
 */

import java.util.Scanner;
public class ConConstructor {

    public ConConstructor(){  //todos los datos van dentro del constructor y no se implemente ningun metood fuera de él
        Scanner entrada = new Scanner(System.in);
        String color = "", deporte = "";

        System.out.print("\n\nDigita tu color favorito:");
        color = entrada.nextLine();
        System.out.print("Digita tu deporte favorito: ");
        deporte = entrada.nextLine();

        System.out.println("Sabemos que tu color favorito es "+color+" y el deporte que te gusta ver es el "+deporte);
    }
}
