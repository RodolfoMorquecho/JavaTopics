package poo.ejercicios_poo.equipo_futbol;

public class Futbolista extends Persona{
    String posicion;
    int dorsal;

    public Futbolista(){}

    public Futbolista(String nombre, String sexo, int edad, String posicion, int dorsal){
        super(nombre, sexo, edad);
        this.posicion = posicion;
        this.dorsal = dorsal;
    }

    //Setters y Getters

    public String getPosicion(){
        return posicion;
    }

    public boolean setPosicion(String pos){
        if(!pos.isEmpty){
            posicion = pos;
            return true;
        }else{
            return false;
        }
    }

    public int getDorsal(){
        return dorsal;
    }

    public boolean setDorsal(int Dorsal){
        if(!dorsal.isEmpty()){
            this.dorsal = dorsal;
            return true;
        }else{
            return false;
        }
    }


    //Métodos de interface

    @Override
    public void concentrarse(){
        System.out.print("El jugador "+ nombre +" de la seleccion ##### debe de concentrarse en el hotel"
                + " previo a su juego del día de maniana");
    }
}