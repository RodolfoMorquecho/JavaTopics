package poo.cajero_automatico.clases;

import java.util.Scanner;

public abstract class ClasePadre_Abstracta { //se utliza la palabra abstract, debido a que la clase contiene metodos sin implementar
    protected int transacciones, retiro, deposito;  //Es buena practica protegerlas cuando se usara polimorfismo
    private static int saldo;    //Variables globales

    Scanner entrada = new Scanner(System.in);

    //Metodo para llevar a cabo la logica del mensaje en pantalla del cajero
    public void operaciones(){
        int bandera = 0;    //Variables locales que se deben inicializar
        int seleccion = 0;

        do {
            do {
                System.out.println("Por favor seleccione una opcion:");
                System.out.println("    1. Consulta el saldo.");
                System.out.println("    2. Retiro de efectivo.");
                System.out.println("    3. Deposito de efectivo.");
                System.out.println("    4. Salir.");
                seleccion = entrada.nextInt();  //Guara la opcion seleccionada por usuario

                //Comprobar las opciones validas
                if(seleccion>=1 && seleccion<=4){
                    bandera = 1;  //Al valer 1, el while se termina y avanza para ejejutar una de las acciones solicitadas
                }else{
                    System.out.println("-------------------------------------------------");
                    System.out.println("Opcion no disponible, vuelva a intentar porfavor.");
                    System.out.println("-------------------------------------------------");
                }
            } while (bandera == 0);  //Repetira lo que hay dentro de "do" mientras "bandera" siga valiendo 0

            //Opciones para los casos del cajero
            if (seleccion == 1) {
                //Se debe crear la instancia de la clase hija que se usa para esta seleccion
                //Objeto de clase tipo padre con constructo con referencia a clase hijaConsulta
                ClasePadre_Abstracta consulta = new ClaseHija_Consulta();
                consulta.transaccion();  //Se invoca al metodo que se quiere ejecutar, en este caso es "transacciones" que se implemento en la hija
            } else if (seleccion == 2) {
                ClasePadre_Abstracta retiro = new ClaseHija_Retiro();
                retiro.transaccion();
            } else if (seleccion == 3) {
                ClasePadre_Abstracta deposito = new ClaseHija_Deposito();
                deposito.transaccion();
            } else if (seleccion == 4) {
                System.out.println("-------------------------");
                System.out.println("Gracias!, vuelva pronto.");
                System.out.println("-------------------------");
                bandera = 2;  //Al valer eso bandera, se termina de repetir el bucle y deja de mostrar las opciones de menu
            }
        }while (bandera != 2); //Reperita lo que hay dentro de "do" minetras "bandera" sea diferente de 2
    }

    //Metodo para el retiro de efectivo
    public void retirar(){
        retiro = entrada.nextInt();
    }

    //Método para el deposito de efectivo
    public void depositar(){
        deposito = entrada.nextInt();
    }

    //Se declara el metodo ya que hara dos funciones distintas, las implementaciones se haran dentro de otras clases hijas
    public abstract void transaccion();

    //Crear metodos setter y getter para que se tenga acceso a obtener y asignar el saldo desde otras clases, ya que las variables etsan protegidas
    public int getSaldo(){
        return saldo;
    }

    public void setSaldo(int saldo){
        this.saldo = saldo;
    }
}
