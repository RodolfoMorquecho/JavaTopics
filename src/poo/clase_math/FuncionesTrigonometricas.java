package poo.clase_math;

import poo.var_locales.Rectangulo;

//Las funciones trigonometricas en "Math" aceptan y devuelven los angulos en radianes, por lo que si tenemos un angulo en grados
//debemos pasarlo a radianes forzosamente.
public class FuncionesTrigonometricas {
    public static void main(String[] args) {
        double resultado = 0;
        double anguloEnGrados = 45;
        double anguloEnRadianes = Math.toRadians(anguloEnGrados);

        //Obtener el Seno de 45°
        resultado = Math.sin(anguloEnRadianes);
        System.out.println("El seno de "+anguloEnGrados+" grados = "+resultado);

        //Obtener el Coseno de 45°
        resultado = Math.cos(anguloEnRadianes);
        System.out.println("El coseno de "+anguloEnGrados+" grados = "+resultado);

        //Obtener la Tangente de 45°
        resultado = Math.tan(anguloEnRadianes);
        System.out.println("El seno de "+anguloEnGrados+" grados = "+resultado);

        //Obtener el Arco Coseno
        double valorIngresado = 0.707;
        anguloEnRadianes = Math.acos(valorIngresado);
        anguloEnGrados = Math.toDegrees(anguloEnRadianes);
        System.out.println("El Arco Coseno de "+valorIngresado+" = "+anguloEnGrados+" grados");

        //Obtener el Arco Seno
        anguloEnRadianes = Math.asin(valorIngresado);
        anguloEnGrados = Math.toDegrees(anguloEnRadianes);
        System.out.println("El Arco Seno de "+valorIngresado+" = "+anguloEnGrados+" grados");

        //Obtener el Arco Tangente
        anguloEnRadianes = Math.atan(valorIngresado);
        anguloEnGrados = Math.toDegrees(anguloEnRadianes);
        System.out.println("El Arco Tangente de "+valorIngresado+" = "+anguloEnGrados+" grados");
    }
}
