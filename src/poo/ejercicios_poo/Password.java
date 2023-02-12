package poo.ejercicios_poo;

import java.util.Random;

public class Password {
    private int longitud = 8;
    private String contrasenia = "";

    public Password(){}  //Constructor por defecto

    public Password(int tamanio){  //Constructor con la longitud que se le pase. Generara una contraseña aleatoria con esa longitud.
        longitud = tamanio;
        generarPassword();
    }

    //Método que devuelve un booleano si es fuerte o no, para que sea fuerte debe tener mas de 2 mayúsculas, mas de 1 minúscula
    // y mas de 5 números.
    /*public boolean esFuerte(){

    }*/

    //Método que genera la contraseña del objeto con la longitud que tenga.
    public String generarPassword(){

        Random r = new Random();
        int numAleatorio = 0;
        String op_uno = "";
        char op_dos = ' ';
        char op_tres = ' ';

        for (int i=0; i<longitud; i++){
            numAleatorio = (int) (r.nextDouble() * 3+1);  //Asignara numeros entre 1 y 3
            //Si el valor aleatorio es 1, agregara un numero a la cadena que corresponde a la contraseña
            if (numAleatorio == 1){
                op_uno = String.valueOf((int)(r.nextDouble() * 9));  //Numeros entre 0 y 9
                contrasenia += op_uno;
            }else if (numAleatorio == 2){  //Si el valor aleatorio es 2, agregara letra minuscula a la cadena de contraseña
                op_dos = (char)(r.nextInt(123-97+1) + 97);
                contrasenia += op_dos;
            }else {  //Si el valor aleatorio es 3, agregara letra mayuscula a la cadena de contraseña
                op_tres = (char)(r.nextInt(91-65+1) + 65);
                contrasenia += op_tres;
            }
        }
        return contrasenia;
    }

    //Método set para longitud.
}
