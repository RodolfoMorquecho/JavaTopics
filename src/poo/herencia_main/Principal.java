package poo.herencia_main;

//Para utilizar las clases de otro paquete, es necesario importarlas, indicando el nombre del paquete y clase.
//No es necesario exportar a la clase padre, ya que las hijas heredaron el contenido de ella y sería muy redundante hacerlo.
import poo.herencia.ClaseHija_Suma;
import poo.herencia.ClaseHija_Resta;

public class Principal {
    public static void main(String[] args){
        ClaseHija_Suma cs = new ClaseHija_Suma();  //Creamos un objeto de tipo ClaseHija_Suma para acceder a sus metodos
        cs.pedirDatos();  //Llamamos al metodo perteneciente a la ClasePadre que se heredo en ClaseHija_Suma
        cs.Sumar();  //Llamamos al metodo que ejecuta la operacion, el cual si es propio de la clase hija
        System.out.print("El resultado de la suma es: ");
        cs.mostrarResultado();  //Se muestra el resultado

        ClaseHija_Resta cr = new ClaseHija_Resta();
        cr.pedirDatos();
        cr.restar();
        System.out.print("El resultado de la resta es: ");
        cr.mostrarResultado();
    }
}
