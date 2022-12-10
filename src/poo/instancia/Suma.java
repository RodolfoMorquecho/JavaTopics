package poo.instancia;

public class Suma {
    private int valorUno, valorDos, resultado;  //Variables globales con las que solo se trabajara dentro de esta clase

    //Los parametros de la instancia llegan aqui, ya que en el constructor se reserva el espacio para manejar con los valores
    public Suma(int primerNum,int segundoNum){
        this.valorUno = primerNum;    //"this" hace referencia a que es una variable de esta clase
        this.valorDos = segundoNum;    //A la variable de esta clase se le asignara el valor que trae como parametro la instancia
    }

    //Metodo para suamr valores
    public void sumar(){
        resultado = valorUno + valorDos;
    }

    //Metodo para imprimir el resultadio en pantalla
    public void mostrarSuma(){
        sumar();  //Se llama al metodo que contiene el resultado, yq que este metodo lo necesita para mostrar
        System.out.println("\nLa suma de "+valorUno+" y "+valorDos+" es: "+resultado);
    }
}
