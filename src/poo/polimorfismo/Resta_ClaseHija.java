package poo.polimorfismo;

public class Resta_ClaseHija extends Operaciones_ClasePadre{
    @Override
    public void operaciones(){
        resultado = valor1 - valor2;
    }
}
