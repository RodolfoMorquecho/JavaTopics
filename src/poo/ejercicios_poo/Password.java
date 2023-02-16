package poo.ejercicios_poo;

import java.util.Random;

public class Password {
    private int longitud = 8;
    private String contrasenia = "";

    public Password(){}  //Constructor por defecto, con longitud de 8 caracteres

    public Password(int tamanio){  //Constructor con la longitud que se le pase. Generara una contraseña aleatoria con esa longitud.
        longitud = tamanio;
    }

    //Método que devuelve un booleano si es fuerte o no, para que sea fuerte debe tener mas de 2 mayúsculas, mas de 1 minúscula
    // y mas de 5 números.
    public boolean esFuerte(String clave){
        int contNum = 0, contMin = 0, contMay = 0;

        for (int i=0; i<clave.length(); i++){  //Recorre el largo de la contraeña, caracter por caracter
            //Se usara el codigo ASCII, los numeros del 0 al 9 se ubican del caracter 48 al 57
            if (clave.charAt(i) >= 47 && clave.charAt(i) <= 58){  //Condicional al que se accede si los caracteres estan entre 47 y 58 ASCII
                contNum++;  //Aumenta el contador de los numeros
            }else if (clave.charAt(i) >= 96 && clave.charAt(i) <= 123){  //Condicional para determinar si se trata de una letra minuscula
                contMin++;  //Aumenta el contador que las minusculas
            }else if (clave.charAt(i) >= 64 && clave.charAt(i) <=91){
                contMay++;  ////Aumenta el contador que las mayusculas
            }
        }
        System.out.println("Numeros:"+contNum+"  Minusculas:"+contMin +"  Mayusculas:"+ contMay +"\n");
        if (contNum > 5 && contMin > 1 && contMay > 2){
            return true;
        }else {
            return false;
        }
    }

    //Método que genera la contraseña del objeto con la longitud que tenga.

    //Para generar las letras mayusculas y minusculas, se hara uso del código ASCII que van del 97 a 122 para minusculas
    //y del 65 al 90 para mayusculas, primero se genera un número random utilizando enteros(NextInt) entre los rangos anteriores
    // y despues se hace casting para convertir ese numero en un caracter(letra), para el numero simplemente se convierte en String
    public String generarPassword(){
        Random r = new Random();  //Crear objeto de tipo random
        int numAleatorio = 0;  //Acumulara algun número entre 1 y 3 segun el objeto random

        String op_uno = "";
        char op_dos = ' ';
        char op_tres = ' ';

        //Recorrera segun el numero de caracteres quiera el usuario en su contraseña, poe default se utilizan 8
        for (int i=0; i<longitud; i++){
            numAleatorio = (int) (r.nextDouble() * 3+1);  //Asignara numeros entre 1 y 3

            //Si el valor aleatorio es 1, agregara un número a la cadena que corresponde a la contraseña
            if (numAleatorio == 1){
                op_uno = String.valueOf((int)(r.nextDouble() * 10));  //Numeros entre 0 y 9
                contrasenia += op_uno;  //Se concatena el numero a el contenido que ya tiene la cadena o contraseña
            }else if (numAleatorio == 2){  //Si el valor aleatorio es 2, agregara letra minuscula a la cadena de contraseña
                op_dos = (char)(r.nextInt(122-97+1) + 97);  //Se hace casting para convertirlo a carcter y usar el código ASCII
                contrasenia += op_dos;
            }else {  //Si el valor aleatorio es 3, agregara letra mayuscula a la cadena de contraseña
                op_tres = (char)(r.nextInt(90-65+1) + 65);
                contrasenia += op_tres;  //Se concatena el caracter a la cadena/contraseña
            }
        }
        return contrasenia;
    }

    //Método set para longitud
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    //Método get para longitud
    public int getLongitud(){
        return longitud;
    }

    //Como se

}
