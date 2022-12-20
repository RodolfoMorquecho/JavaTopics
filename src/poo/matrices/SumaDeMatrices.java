package poo.matrices;
//Tema 11: "Suma de Matrices"
/*
La suma de matrices solo se puede realizar entre matrices de la misma dimensión, es decir, la mismas filas y las mismas
columnas, por tal motivo la matriz resultante tiene las mismas dimensiones.
La suma se efectúa en cada uno de los elementos correspondiente a cada matriz en su posición actual, es decir, se sumará
la posición matrizUno[0,0] con la posición matrizDos[0,0] y el resultado se guardara en matrizResultado[0,0].

    Matriz 1       Matriz 2       Matriz Resultante
    1 | 2           1 | 2              2 | 4
   ___|___    +    ___|___    =       ___|___
    3 | 4           3 | 4              6 | 8

Objetivo: Realizar la suma de 2 matrices que tengan 3 filas y 3 columnas y los valores de cada posicion deben de ser
llenados con numeros aleatorios entre 0 - 5 y el resultado guardarlo en las posiciones de una 3er matriz resultante
 */

public class SumaDeMatrices {
    public static void main(String[] args) {
        int filas = 3, columnas = 3;
        int matriz_uno [][] = new int[filas][columnas];
        int matriz_dos [][] = new int[filas][columnas];
        int matriz_resultante [][]= new int[filas][columnas];

        //Llenado de la primer matriz con numeros aleatorios
        for(int i=0;i< matriz_uno.length;i++){
            for (int j=0;j< matriz_uno.length;j++){
                matriz_uno[i][j] = (int)(Math.random() * 5);
            }
        }

        System.out.println("");
        //Llenado de la segunda matriz con numeros aleatorios
        for (int i=0;i< matriz_dos.length;i++){
            for (int j=0;j< matriz_dos.length;j++){
                matriz_dos[i][j] = (int)(Math.random() * 5);
            }
        }

        //Suma de matrices
        for (int i=0;i<matriz_uno.length;i++){
            for (int j=0;j< matriz_dos.length;j++){
                matriz_resultante[i][j] = matriz_uno[i][j] + matriz_dos[i][j];
                //matriz_resultante[i][j] = matriz_uno[i][j] - matriz_dos[i][j];  Resta
            }
        }

        //Imprimir matrices
        for (int i=0;i< matriz_uno.length;i++){
            for (int j=0;j< matriz_uno.length;j++){    //Impresion de matriz_uno
                System.out.print("["+matriz_uno[i][j]+"]");
            }

            //Espacio entre la matriz_uno y la matriz_dos
            if(i==1){  //Cuando se este recorriendo la segunda fila(horizontal) en la distancia que separa a las matrices:
                System.out.print("  +  ");  //Insertara el simbolo "+"
            }else {
                System.out.print("     ");  //En cualuier otro caso solo se plasman los espacios
            }

            //Impresion matriz_dos
            for (int j=0;j<matriz_dos.length;j++){    //Impresion de matriz_uno
                System.out.print("["+matriz_dos[i][j]+"]");
            }

            //Espacio entre la matriz_dos y la matriz_resultante
            if(i==1){  //Cuando se este recorriendo la segunda fila(horizontal) en la distancia que separa a las matrices:
                System.out.print("  =  ");  //Insertara el simbolo "+"
            }else {
                System.out.print("     ");  //En cualuier otro caso solo se plasman los espacios
            }

            //Impresion matriz resultante
            for (int j=0;j< matriz_resultante.length;j++){
                System.out.print("["+matriz_resultante[i][j]+"]");
            }
            System.out.println("");
        }
    }
}
