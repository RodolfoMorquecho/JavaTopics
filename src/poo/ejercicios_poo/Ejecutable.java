package poo.ejercicios_poo;

import java.util.Scanner;

public class Ejecutable {
    public static void main(String[] args) {
        int tam = 0, opcion = 0;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.print("\t\t Tamano de contrasena \n\n" +
                    "1. Usar el tamano predeterminado de caracteres(8)\n" +
                    "2. Elegir el numero de caracteres.\n" +
                    "opcion: ");
            opcion = entrada.nextInt();

            if(opcion == 1){
                Password password = new Password();
                System.out.println("<<<<< Contrasena generada: " + password.generarPassword() +" >>>>>");
            }else if(opcion == 2){

                System.out.print("Digita el numero de caracteres de tu contrasena: ");
                tam = entrada.nextInt();

                Password password = new Password(tam);

                System.out.println("<<<<< Contrasena generada: " + password.generarPassword() +" >>>>>");
            }else {
                System.out.println("Opcion invalida \n");
            }
        }while (opcion<1 || opcion>2);
    }
}
