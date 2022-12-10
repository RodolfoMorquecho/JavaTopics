package lavadora_uno;

//Este es otro proyecto donde se probara la clase de las funciones logicas de la lavadora, la cual debemos importar ya que la
//utilizaremos como una biblioteca, pegaremos la clase LLFunciones dentro del paquete "libreria_lavadora"

import libreria_lavadora.LLFunciones;  //De esta forma importamos la libreria para utilizar el metodo de LLFunciones
import java.util.Scanner;  //Libreria para pedir datos desde teclado

public class Lavadora_Uno {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("******** Lavadoras Enterprise ********");
        System.out.print("\nIngresa el numero de kilos que quieres lavar: ");
        int kilos = entrada.nextInt();
        System.out.print("Presiona: 1 Ropa blanca | 2 Ropa de color ");
        int tipoDeRopa = entrada.nextInt();

        //Crear objeto que mande los datos a la clase que contiene las funciones logicas
        LLFunciones mensajero = new LLFunciones(kilos, tipoDeRopa);  //Mediante parametros llegaran los datos al contructor
        mensajero.CicloFinalizado();  //Llamaremos a este metodo para ver el resultado, por cierto es el unico metodo visible ya que es publico
    }
}
