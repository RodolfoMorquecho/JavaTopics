package poo.polimorfismo;

//Heredaremos atributos y metodos de "Operacione_ClasePadre" usando la palabra reservada "extends"
public class Suma_ClaseHija extends Operaciones_ClasePadre{
    @Override        //Se utiliza @Override para indicar que se va a "sobreescribir" el metodo para ser definido
    public void operaciones(){  //Se hereda el metodo desde la clase padre
        resultado = valor1 + valor2;  //Para esta clase se define la operacion suma
    }
}
