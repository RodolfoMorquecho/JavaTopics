package poo.matrices.multiplicacion;
//Tema 11: "Multiplicación de Matrices"
/*
En la multiplicación de matrices, las reglas a seguir cambian por completo, ya que, a diferencia de la suma y la multiplicación,
es necesario que el numero de columnas de la primera matriz, sea igual al numero de filas de la segunda matriz o viceversa.
Además, la operación de la multiplicación no se realiza posición por posición, con lo cual se obtiene una matriz resultante con
el número de filas de la primera matriz y el número de columnas de la segunda matriz.

      Matriz_uno       Matriz_dos       Matriz_resultante
      2 | 4 | 1        1 | 2               18  |  12
     ___|___|___   X  ___|___     =      ______|______
      0 | 3 | 5        3 | 2                   |
                      ---|---              29  |  6
                       4 | 0

 f1c1=(2*1)+(4*3)+(1*4) = 18    f1c2=(2*2)+(4*2)+(1*0) = 12
 f2c1=(0*1)+(3*3)+(5*4) = 29    f2c2=(0*2)+(3*2)+(5*0) = 6

Objetivo: Se va a tener 3 matrices, la primer matriz debe de tener 3 columnas y 2 filas, la segunda matriz debe tener 2 columnas
y 3 filas, por lo que la matriz resultante va a tener 2 filas y 2 columnas. Las 2 primeras matrices se van a llenar con
numeros aleatorios y multiplicar ambas matrices para obtener los valores que se van a guardar en la matriz resultante. Por
ultimo se imprimen las tres matrices.
 */

public class MultiplicacionDeMatrices {
    public static void main(String[] args) {
        int matriz_uno[][] = new int[2][3];  //Matriz con 2 filas y 3 columnas
        int matriz_dos[][] = new int[3][2];  //Matriz con 3 filas y 2 columnas
        int matriz_resultante[][] = new int[2][2];  //Matriz con 2 filas y 2 columas

        //Llenado de matriz_uno con numeros aleatorios
        for (int i=0;i< 2;i++){
            for (int j=0;j< 3;j++){
                matriz_uno[i][j] = (int)(Math.random() * 5);
            }
        }
        System.out.println("");
        //Llenado de matriz_dos con numeros aleatorios
        for (int i=0;i< 3;i++){
            for (int j=0;j< 2;j++){
                matriz_dos[i][j] = (int)(Math.random() * 5);
            }
        }

        //Llenado de matriz_resultante
        for (int i=0;i< 4;i++){  //Hasta 4, debido a que la matriz_resultante tiene dos filas y dos columnas(4 espacios)
            //Sebido a que la matriz resultante aun esta vacia, tiene todos sus valores en 0, asi que cuando se recorra el
            //for va a encontrar el primer condicional valido y av a entrar en el, la segunda iteracion del for, encontrara
            //como primera opcion el segundo condicional y sera verdadero por lo que entrara para obtener el valor.
            //Se guarda en temporal el valor de las operaciones y despues se asigna en el espacio [0][0]
            if(matriz_resultante[0][0] == 0){
                int temporal = (matriz_uno[0][0]*matriz_dos[0][0])
                        + (matriz_uno[0][1]*matriz_dos[1][0])
                        + (matriz_uno[0][2]*matriz_dos[2][0]);

                matriz_resultante[0][0] = temporal;  //fila 1 columna 1

            }else if(matriz_resultante[1][0] == 0){
                int temporal = (matriz_uno[1][0]*matriz_dos[0][0])
                        + (matriz_uno[1][1]*matriz_dos[1][0])
                        + (matriz_uno[1][2]*matriz_dos[2][0]);

                matriz_resultante[1][0] = temporal;  //fila 2 columna 1

            }else if(matriz_resultante[0][1] == 0){
                int temporal = (matriz_uno[0][0]*matriz_dos[0][1])
                        + (matriz_uno[0][1]*matriz_dos[1][1])
                        + (matriz_uno[0][2]*matriz_dos[2][1]);

                matriz_resultante[0][1] = temporal;

            }else if(matriz_resultante[1][1] == 0){
                int temporal = (matriz_uno[1][0]*matriz_dos[0][1])
                        + (matriz_uno[1][1]*matriz_dos[1][1])
                        + (matriz_uno[1][2]*matriz_dos[2][1]);

                matriz_resultante[1][1] = temporal;
            }
        }

        //Imprimiendo matrices
        for (int i=0;i< 3;i++){  //El numero de filas mayor que hay en cualquiera de las 3 matrices es de 3
            //MATRIZ_UNO
            if(i< 2){  //La primer matriz tiene 2 filas
                for (int j=0;j< 3;j++){  //La primer matriz tiene 3 columnas
                    System.out.print("[ "+ matriz_uno[i][j] +" ]");
                }
                if(i == 1){  //Cuando se ubique en la fila 1
                    System.out.print("   X   ");  //Imprime un espaciadp y el simbolo de multiplcar
                }else {
                    System.out.print("       ");  //Imprime un espaciadp entre matriz_uno y matriz_dos
                }
            }else{  //En caso de que i=3, se imprime un espacio debido a que la primer matriz no tiene 3 filas
                System.out.print("                      ");
            }

            //MATRIZ_DOS
            //La matriz si tiene 3 filas por lo que no se necesita implementae algun condicional
            for (int j=0;j< 2;j++){  //Se recorre hasta 2 el for interno, debido a que solo tiene 2 columnas
                System.out.print("[ "+ matriz_dos[i][j] +" ]");
            }
            if(i == 1){  //Cuando se ubique en la fila 1
                System.out.print("   =   ");  //Imprime un espaciadp y el simbolo de igual
            }else {
                System.out.print("       ");  //Imprime un espaciadp entre matriz_uno y matriz_resultante
            }

            //Matriz_resultante
            //La matriz_resultante tiene 2 filas y 2 columnas por lo que se pone el siguiente condicional
            if(i< 2){
                for (int j=0;j< 2;j++){  //Tiene 2 columnas
                    System.out.print("[ "+ matriz_resultante[i][j] +" ]");
                }
            }

            //Este sera el unico salto de linea en toda la estructura, ya que lo implementado anteriormente hara un recorrido
            //en horizontal de todas las matrices
            System.out.println("");
        }
    }
}
