package poo.var_locales;

public class Rectangulo {
    int altura,base,area = 0;

    public Rectangulo(int base,int altura){
        this.base = base;
        this.altura = altura;
    }

    //Metodo que realiza la operacion para hallar el area
    private void calcularArea(){
        area = base * altura;
    }

    //Metodo que muestra el resultado
    public void mostrarArea(){
        calcularArea();
        System.out.println("\n  El area del rectangulo es: "+area);
    }
}
