package poo.polimorfismo;
//Tema 6: Polimorfismo
/*
El polimorfismo en la programación orientada a objetos, es la capacidad que se le da a un método, de comportarse de maneras
diferente de acuerdo a la instancia creada. Es decir, dependiendo de la clase con la que se este interactuando, será la
función que va a ejecutar el método.

 */

import java.util.Scanner;

//Se utiliza la palabra reservada "abstract" para indicar que tiene metodos sin definir y solo lo encontraremos declatrado
//Por lo que en otra clase se tienen que definir para ser utilizados
public abstract class Operaciones_ClasePadre {
    protected int valor1, valor2, resultado;
    Scanner entrada = new Scanner(System.in);

    public void pedirDatos(){
        System.out.print("Digita el primer numero: ");
        valor1 = entrada.nextInt();
        System.out.print("Digita el segundo numero: ");
        valor2 = entrada.nextInt();
    }

    public abstract void operaciones();  //Debido a que el método hara la misma accion pero la ejecucion sera distinta para cada clase que lo llame

    public void mostrarResultado(){
        System.out.print(resultado);
    }

}
