package poo.palabra_super;
//Tema 7: Super

/*
La palabra reservada super se usa para acceder a un elemento en la clase padre.
Uno de los usos mas frecuentes que le damos a la palabra super, es poder invocar al constructor de la clase padre.
 */

public class ClasePrincipal {
    public static void main(String[] args) {
        Padre mensajeroP = new Padre();
        mensajeroP.saludar();

        Hija mensajeroH = new Hija();
        mensajeroH.saludar();
    }
}
