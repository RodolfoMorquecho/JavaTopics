package poo.setters_getters;
//Tema 4: Setters y Getters

/*
Los setters y getters, son métodos que permiten el acceso a los atributos de una clase, que etán encapsulados de manera privada.

- Método Setter: El método set("establecer"): nos sirve para asignar un valor a un atributo de nuestra clase, esto se hace de manera
directa con este método, como este método no retorna nada, debe contener la palabra void en su estructura, y siempre debe recibir
un parámetro de entrada.

- Método Getter: El método get("obtener"): accede a la clase para retornarnos el valor de algún atributo que queramos, este método
si debe de retornar un valor por lo cual la estructura de este método debe contener el tipo de valor que vamos a retornar con ese
método.
*/

//Detectar si el usuario busca un automovil de tipo coupe o una camioneta pick-up
public class Automovil {
    private int puertas = 0, ventanas = 0, cajaTrasera = 0, autoCoupe = 0, autoPick_up = 0;
    private String marca;

    //Constructor
    public Automovil(int puertas, int ventanas, String marca){
        this.puertas = puertas;
        this.ventanas = ventanas;
        this.marca = marca;
    }

    //Metodo de puetas que define si es un coupé
    private void tipoDeAuto(){
        if(puertas == 2){  //Si puertas es igual a 2, entra dentro de nuestros dos modelos especificos
            System.out.println("\nEl tipo de automovil que buscas es muy especifico, y suponemos que buscas ");
            if(ventanas == 2){  //si las ventanas es igual a 2, especifica mas el modelo buscado
                autoCoupe = 1;  //Cambia el valor(estado) de la variable, determinando de que se trata de un coupe
                System.out.println("un coupe, ya que suelen tener "+puertas+" puertas y "+ventanas+" ventanas");
            }
            else if(ventanas == 4){  //si las ventanas es igual a 4, especifica mas el modelo buscado
                autoPick_up = 1;  //Cambia el valor(estado) de la variable, determinando de que se trata de una pick up
                System.out.println("una camioneta pick-up, ya que suelen tener "+puertas+" puertas y "+ventanas+" ventanas");
            }
            else {  //En caso de que las ventanas no corresponda a ninguna de las opciones anteriores, manda el sig. mensaje:
                System.out.println("una bicicleta, pero eso no es un automovil ");
            }
        }
        else if (puertas == 4){  //Si puertas es igual a 4, entra dentro de la categoria de autos comunes
            System.out.println("\nEl automovil que buscas es muy comun");
        }
        else{  //Si puertas es distinto de las alternativas anteriores, mnanda el sig. mensaje:
            System.out.println("Son demasiadas puertas, podria ser el halcon milenario");
        }
    }

    public void marcaAuto(){
        tipoDeAuto();  //Se llama al método para utilizar el valor de las variables modificadas
        if(autoCoupe == 1){  //Si la var. "autoCoupe" vale 1, se le asigna la marca BMW automaticamente al vehiculo
            System.out.println("Marca: BMW");
        }
        if(autoPick_up == 1){  //Si la var. "autoPick_up" vale 1, se le asigna la marca Ford automaticamente al vehiculo
            System.out.println("Marca: Ford");
        }
        else if(autoCoupe == 0  && autoPick_up == 0){  //EN caso de que las variables valgan 0, se asigna la marca que el usuario ingreso
            System.out.println("Marca: "+marca);
        }
    }

    //Setters - Getters

    //public: para que el metodo este visible para otras clases que quieren modificar el valor del atributo
    //void: no devuelve algo
    //set: para indicar que el metodo esta configurado para establecer un valor, eguido del atributo con la primer letra en mayuscula
    //(int puertas): se pasa el parametro desde main con el tipo de dato que es, en este caso, es de tipo "int"
    public void setPuertas(int puertas){  //Se tendra acceso para modificar la variable "puertas"
        this.puertas = puertas;  //Se asigna el valor que viene como parametro a la variable de esta clase
    }

    //En el getter se especibica int ya que como "obtendremos" el valor, necesitamos que nos retorne el valor se debe especificar el tipo de dato
    //dentro del metodo solo se efectua el retorno
    public int getPuertas(){
        return puertas;
    }

}
