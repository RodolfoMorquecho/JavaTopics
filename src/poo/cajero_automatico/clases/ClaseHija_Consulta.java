package poo.cajero_automatico.clases;

public class ClaseHija_Consulta extends ClasePadre_Abstracta{  //Se hereda de esta clase para implementar el metodo transaccion

    @Override    //Indica que se esta sobreescribiendo el método
    public void transaccion() {
        System.out.println("---------------------------------");
        System.out.println("Tu saldo actual es: "+getSaldo());  //La unica funcion es indicar cual es el saldo actual
        System.out.println("---------------------------------");
    }
}
