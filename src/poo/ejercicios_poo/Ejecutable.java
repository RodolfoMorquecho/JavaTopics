package poo.ejercicios_poo;

public class Ejecutable {
    public static void main(String[] args) {
        Password password = new Password();

        System.out.println("Contrasena generada: " + password.generarPassword());
    }
}
