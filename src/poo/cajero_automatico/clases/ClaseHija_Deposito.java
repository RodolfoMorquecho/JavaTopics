package poo.cajero_automatico.clases;

public class ClaseHija_Deposito extends ClasePadre_Abstracta{

    @Override
    public void transaccion(){
        System.out.println("Cuanto desea depositar: ");
        depositar();

        transacciones = getSaldo();
        setSaldo(transacciones + deposito);
        System.out.println("------------------------------------");
        System.out.println("Depositaste: "+deposito);
        System.out.println("Tu saldo actual es de: "+getSaldo());
        System.out.println("------------------------------------");
    }
}
