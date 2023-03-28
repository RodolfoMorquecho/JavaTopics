package poo.ejercicios_poo.equipo_futbol;

public class Futbolista extends Persona implements AccionesFutbolista{
    String posicion;
    int dorsal;

    public Futbolista(){}

    public Futbolista(String nombre, String sexo, int edad, String posicion, int dorsal){
        super(nombre, sexo, edad);
        this.posicion = posicion;
        this.dorsal = dorsal;
    }

    //Objeto para acceder a los metodos de la clase padre
    //Persona datos = new Persona();

    //Setters y Getters

    public String getPosicion(){
        return posicion;
    }

    public boolean setPosicion(String pos){
        if(!pos.isEmpty()){
            posicion = pos;
            return true;
        }else{
            return false;
        }
    }

    public int getDorsal(){
        return dorsal;
    }

    public boolean setDorsal(int dorsal){
        if(dorsal > 0){
            this.dorsal = dorsal;
            return true;
        }else{
            return false;
        }
    }


    //Métodos de interface
    @Override
    public void informacionPersonal(){
        System.out.print("<<<<<< Datos Personales del jugador >>>>>>"+
                "\n\nNombre: "+ getNombre() +
                "\nSexo: "+ getSexo() + "\t Edad: "+ getEdad() +
                "\nPosicion: "+ getPosicion() +
                "\nDorsal: "+ getDorsal());
    }

    @Override
    public void concentrarse(){
        System.out.print("El jugador "+ getNombre() +" de la seleccion ##### debe de concentrarse un dia antes en el hotel"
                + " previo a su juego siguiente\n\n");
    }

    @Override
    public void viajar() {
        System.out.print("En caso de que el club juegue como visitante, el jugador debe de realizar un viaje junto al equipo\n\n");
    }

    @Override
    public void jugarPartido() {
        System.out.print("Si el entrenador decide alinear desde el inicio al jugador "+ getNombre() + " podria jugar 90+ min\n\n");
    }

    @Override
    public void entrenar() {
        System.out.print("Todos los dias previos al siguiente partido, el jugador entrenara por al menos 5 horas\n\n");
    }
}