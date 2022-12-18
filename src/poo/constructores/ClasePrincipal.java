package poo.constructores;

public class ClasePrincipal {
    public static void main(String[] args) {
        //Sin uso de constructor
        SinConstructor sn = new SinConstructor();
        sn.pedirNombre();  //Se llama al metodo mediante el objeto creado de la clase que lo contiene
        sn.imprimir();

        //Basta con crear el objeto para llamar al contructor que contiene todos los datos
        ConConstructor cc = new ConConstructor();
    }
}
