package poo.excepciones;
//Tema 8: Excepciones

/*
Son el medio que ofrecen algunos lenguajes de programación, para tratar situaciones anómalas que pueden suceder cuando
ejecutamos un programa. La forma en que el programador trate esta anómalia es lo que se conoce generalmente como
manejo o gestión de la excepción.
 */

import java.util.Scanner;

public class Division {
    public static void main(String[] args){
        try{    //Intentara correr el programa hasta no capturar un error o anomalia
            int valor1, valor2, resultado;
            Scanner entrada = new Scanner(System.in);

            System.out.println("******** Division ********");
            System.out.print("\nDigite el valor del numerador: ");
            valor1 = entrada.nextInt();
            System.out.print("Digite el valor del denominador: ");
            valor2 = entrada.nextInt();
            resultado = valor1 / valor2;
            System.out.print("\nEl resultado es: "+resultado);
        }catch(Exception e){  //Captura el error, se debe crear un objeto de la clase "Excepcion" que sirve para obtener el error especifico
            System.out.println("Error !!!"+e);  //Comportamiento en caso de que se genere un error que no se tuvo la precaucion de validar
        }finally {  //Permite ejecutar un bloque de código sin importar el resultado del programa
            System.out.println("\nOperacion concluida!");
        }
    }
}
