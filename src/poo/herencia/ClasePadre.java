package poo.herencia;
//Tema 5: Herencia

/*
La herencia en java, es el procedimiento utilizado para reutilizar código cuando creamos nuevas clases.
Pues lo único que se hace, es indicar al programa que queremos utilizar la variables y funciones de una clase que ya hemos
creado anteriormente.

Cuando se usa la "herencia", existen dos términos peculiares para referirse a las clases:
 -Clase padre o clase base
 -Clase hija o clase derivada

Clase Padre: es la clase que se debe crear primero, donde se encuentra el código que contiene a las variables y métodos
que se van a reutilizar.

Clase Hija: es la nueva clase, donde vamos a reutilizar los métodos y atributos, que se crearon en la clase padre sin
necesidad de volver a escribir el mismo código para poder utilizarlos.

Herencia Simple: Consiste en que una clase hija solo puede heredar los atributos y métodos de una única clase padre
 */

import java.util.Scanner;

public class ClasePadre {
    protected int valor1, valor2, resultado;  //Es buena practica declarar los atributos como protected en una clase padre
    Scanner entrada = new Scanner(System.in);

    //Metodo para pedir informacion al usuario
    public void pedirDatos(){
        System.out.print("\nDigita el valor del primer numero: ");
        valor1 = entrada.nextInt();
        System.out.print("Gigite el valor del segundo numero: ");
        valor2 = entrada.nextInt();
    }

    //Metodo para capturar el resultado
    public void mostrarResultado(){
        System.out.println(resultado);
    }
}
