package poo.herencia;

//Esta clase sera importada a la clase de otro paquete para verificar que la herencia se haya llevado a cabo exitosamente.
//La clase se encuentra dentro del paquete "herencia_main" y se llama "Principal"

public class ClaseHija_Resta extends ClasePadre{
    //Metodo para ejecutar la operacion
    public void restar(){
        resultado = valor1 - valor2;
    }
}
