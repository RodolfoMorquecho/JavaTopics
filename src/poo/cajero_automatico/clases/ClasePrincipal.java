package poo.cajero_automatico.clases;

public class ClasePrincipal {
    public static void main(String[] args) {
        //Se asignara un saldo inicial, para darla mas sentido al programa
        ClasePadre_Abstracta mensajero = new ClaseHija_Consulta();
        mensajero.setSaldo(500);  //Se asiga un saldo inicial de 500

        //Se llama al metodo operaciones, que contiene toda la logica del menu
        //No se necesita crear un objeto de la clase padre, ya que la clase hija heredo su contenido y se puede realizar la llamada de metodo
        mensajero.operaciones();
    }

}
