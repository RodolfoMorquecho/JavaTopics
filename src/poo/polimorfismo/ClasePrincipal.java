package poo.polimorfismo;

public class ClasePrincipal {
    public static void main(String[] args) {
        //Creamos objeto de tipo "Operaciones_ClasePadre" y el constructor hace referencia con la clase de la que va a tener el comportamiento
        //El objeto hereda "operacione()" de Operaciones_ClasePadre y se comunica con Suma_ClaseHija
        Operaciones_ClasePadre ocp = new Suma_ClaseHija();
        ocp.pedirDatos();
        ocp.operaciones();  //Debido a que el objeto fue creado con referencia a clase Suma, ejecutara esa operacion
        System.out.print("El resultado de la suma es: ");
        ocp.mostrarResultado();

        System.out.print("\n\n");

        //Se creara el objeto y llamados que referencian a la operacion que ejecutara la resta
        Operaciones_ClasePadre ocp2 = new Resta_ClaseHija();
        ocp2.pedirDatos();
        ocp2.operaciones();
        System.out.print("El resultado de la resta es: ");
        ocp2.mostrarResultado();
    }
}
