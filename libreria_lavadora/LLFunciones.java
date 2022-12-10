package libreria_lavadora;
//Tema 3: "encapsulamiento"
//Funciones logicas de una lavadora

//1. Debe recibir los kilos de ropa y tipo de ropa a través de argumentos.
//2. Debe realizar las funciones de llenado de agua, lavado y secado.
//3. La clase debe de estar correctamente encapsulada, para evitar que otros programadores utilicen métodos
// o variables que no son necesarios.
//4. El unico método disponible para importar, debe ser "CicloFinalizado()".

public class LLFunciones {
    //Las funciones se inicializan en 0 para indicar que su ciclo no ha empezado
    //Las variables estan encapsuladas, estan declaradas como privadas y solo se pueden usar en esta clase
    private int kilos = 0, tipoDeRopa = 0, llenadoCompleto = 0, lavadoCompleto = 0, secadoCompleto = 0;

    //Aqui en el constructor es donde recibe los kilos y tipos de ropa por argumento
    public LLFunciones(int kilos, int tipoDeRopa){  //Se reserva el espacio donde llegaran los datos
        this.kilos = kilos;  //Se asigna el valor ingresado por el usuario desde otra clase a la variable kilos de esta clase
        this.tipoDeRopa = tipoDeRopa;  //se especifica con this , porque puede tener el mismo nombre la variable de otra clase
    }

    //Metodo encapsulado del llenado de lavadora
    private void llenado(){
        if(kilos <= 12){
            llenadoCompleto = 1;  //La variable cambia su estado a 1, significa que el llenado esta completo
            System.out.println("Llenando...");
            System.out.println("Llenado completo.");
        }
        else{
            System.out.println("La carga de ropa es muy pesada, reduce la carga");
        }
    }

    //Método encapsulado del lavado de ropa
    private void lavado(){
        llenado();  //Se llama al metodo lavado, porque trae la modificacion de variables que indica que avanza al siguiente proceso
        if(llenadoCompleto == 1){  //Para comenzar a lavar, se tiene que estar seguro de que el proceso de Llenado esta completado
            if(tipoDeRopa == 1){  //Cuando tipoDeRopa = 1, Significa que se lavara ropa blanca
                System.out.println("Ropa blanca / Lavado suave");
                System.out.println("Lavando...");
                lavadoCompleto = 1;  //Cambia el estado de lavadoCompleto como listo
            }
            else if(tipoDeRopa == 2){  //Cuando tipoDeRopa = 2, Significa que se lavara ropa de color
                System.out.println("Ropa de color / Lavado intenso");
                System.out.println("Lavando...");
                lavadoCompleto = 1;
            }
            else {
                System.out.println("El sistema no reconoce tu opcion");
                System.out.println("Se lavara como ropa de color / Lavado intenso");
                System.out.println("Lavando...");
                lavadoCompleto = 1;
            }
        }
    }

    //Método encapsulado del secado de ropa
    private void secado(){
        lavado();  //Se llama al metodo lavado por usar los valores de la variables
        if(lavadoCompleto == 1){
            System.out.println("Secando...");
            System.out.println("Tu ropa esta seca.");
            secadoCompleto = 1;  //Cambia el estado de "secadoCompleto" para indicar que esta listo
        }
    }

    //Metodo para avisar al usuario que su ropa esta lista
    //Este metodo no se encapsula ya que los requerimientos piden que este disponible para importar, por lo que se declara con "public"
    public void CicloFinalizado(){
        secado();
        if(secadoCompleto == 1){
            System.out.println("Tu ropa esta lista!");
        }
    }

    //La clase esta lista para ser exportada para que otro programador la importe en su propia clase y la prepare para el usuario final
}
