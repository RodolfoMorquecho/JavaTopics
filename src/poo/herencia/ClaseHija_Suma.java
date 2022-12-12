package poo.herencia;

public class ClaseHija_Suma extends ClasePadre{  //Para heredar los metodos y atributos de "ClasePadre" utilizamos extends previo a la clase
    //Metodo para ejecutar la operacion
    public void Sumar(){
        resultado = valor1 + valor2;  //Estas variables son heredas, como se observa nunca fueron declaradas en esta clase
    }
}
