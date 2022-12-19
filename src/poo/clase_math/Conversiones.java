package poo.clase_math;

//Convertir valores en grados a radianes y viceversa
public class Conversiones {
    public static void main(String[] args) {
        double anguloEnGrados = 45;  //Siempre que se trabaja con la clase Math, es bueno utilizar variables double
        double anguloEnRadianes = Math.toRadians(anguloEnGrados);  //Se pasa como parametro el angulo en grados

        //Convertir de Grados a Radianes
        System.out.println("Deg a Rad: "+anguloEnGrados+" grados = "+anguloEnRadianes+" radianes");

        //Convertir de Radianes a Grados
        anguloEnGrados = Math.toDegrees(anguloEnRadianes);
        System.out.println("Rad a Deg: "+anguloEnRadianes+" radianes = "+anguloEnGrados+" grados");

    }
}
