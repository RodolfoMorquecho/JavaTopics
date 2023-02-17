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
                String resp = "";
                do {
                    System.out.print("Digita el numero de caracteres de tu contrasena: ");
                    tam = entrada.nextInt();

                    Password password2 = new Password(tam);
                    String clave = password2.generarPassword();  //Variable que contiene la contraseña generada por el método
                    System.out.println("<<<<< Contrasena generada: " + clave +" >>>>>");
                    boolean nivel = password2.esFuerte(clave);
                    if (nivel == true){
                        System.out.println("El nivel de seguridad es alto");
                    }else {
                        System.out.println("El nivel de seguridad es bajo");
                    }

                    System.out.println("Quieres generar una nueva contrasena? s/n");
                    resp = entrada.next();
                }while (resp.equals("s"));

            }else {
                System.out.println("XXXX Opcion invalida XXXX \n");
            }
        }while (opcion<1 || opcion>2);
    }
}
