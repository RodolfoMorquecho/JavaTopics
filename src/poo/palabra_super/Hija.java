package poo.palabra_super;

public class Hija extends Padre{
    public void saludar(){
        //System.out.println("¡Hola, Yo soy la clase hija!");

        //El uso de la palabra super nos va a permitir el acceso al metodo de la clase padre sin importar que tengAa el mismo nombre
        super.saludar();
    }
}
