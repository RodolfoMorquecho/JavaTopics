package recursividad.ejercicio2;

import java.util.Scanner;

public class ClasePrincipal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el numero para calcular su factorial: ");
        int valor = entrada.nextInt();

        FactorialRecursiva fact = new FactorialRecursiva();
        int operacion = fact.Factorial(valor);
        System.out.println("El resultado del factorial de valor " + valor + " equivale a: "+ operacion);
    }
}
