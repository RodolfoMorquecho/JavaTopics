package poo.cajero_automatico.clases;

public class ClaseHija_Retiro extends ClasePadre_Abstracta{

    @Override
    public void transaccion(){
        System.out.print("Cuanto deseas retirar: ");
        retirar();  //Se llama al metodo que tiene la variable que almacenara el monto a retirar
        if(retiro <= getSaldo()){  //validar que el retiro sea menor o igual a lo que tenemos de saldo
            transacciones = getSaldo();  //Se guarda el saldo a la variable transacciones que se hereda desde la clase padre
            setSaldo(transacciones - retiro);  //Se asigna el saldo mas actual, despues de ejecutar el retiro
            System.out.println("-------------------------------------");
            System.out.println("Retiraste: "+retiro);
            System.out.println("Tu saldo actual es de: "+ getSaldo());
            System.out.println("-------------------------------------");
        }else{
            System.out.println("No tienes suficiente dinero, intentalo de nuevo");
        }
    }
}
