package poo.limitar_decimales;

import java.text.DecimalFormat;  //Importamos libreria para usar la clae DecimalFormat
import java.math.BigDecimal;  //importamos libreria para usar la ultima alternativa de esta clase
import java.math.RoundingMode;  //importamos libreria para usar la ultima alternativa de esta clase

public class LimitarDecimales {
    public static void main(String[] args){

        double numero = 2;
        double raiz = Math.sqrt(numero);  //con "Math.sqrt()" se calcula la raiz del numero que tiene como parametro
        System.out.println("La raiz cuadrada de "+numero+" es: "+raiz);
        //Al calcular la raiz del numero, nos arroja demasiados decimales pero podemos reducirlos a nuestra conveniencia

        //Utilizando la clase DecimallFormat
        //Crear objeto de la clase, el numemero de ceros en el parametro, indica el numero de decimales
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("La raiz cuadrada de "+numero+" es: "+df.format(raiz));  //Se accede al método format y como parametro la raiz

        //Utilizando String format
        System.out.println("La raiz cuadrada de "+numero+" es: "+String.format("%.4f",raiz));
        //Dentro del metodo format se deben pasar dos parametros, a diferencia de la forma anterior
        //Primer parametro: va un "%" seguido de un punto despues el numero de decimales, en este caso(4) y la "f" de format
        //Segundo parametro: unicamente va la variable del resultado que se quiere mostrar (raiz)

        //Utilizando la clase "Math.round()"
        System.out.println("La raiz cuadrada de "+numero+" es: "+(double)Math.round(raiz * 1000d) / 1000);
        //Primero se debe hacer casting(procedimiento para convertir una variable primitiva de un tipo a otro) a double
        //Acceder al método round() desde la clase Math
        //Dentro del parametro la var que contiene el resultado en decimales multiplicado por 100 y una "d"
        //Fuera del parentesis del método round, se divide entre 100.
        //Para decidir la cantidad de decimales se aumentan el mismo numero de ceros en la multiplicación y la división

        //Utilizando la clase BigDecimal
        BigDecimal bd = new BigDecimal(raiz);  //Se crea objeto de clase BigDecimal y se pasa la var con resultado en decimales
        bd = bd.setScale(5,RoundingMode.HALF_UP);  //Se asigna al objeto, la cantidad de decimales(5) y HALF_UP de RoundingMode
        System.out.println("La raiz cuadrada de "+numero+" es: "+bd.doubleValue());  //Se accede al metodo doubleValue desde el objeto
    }
}
