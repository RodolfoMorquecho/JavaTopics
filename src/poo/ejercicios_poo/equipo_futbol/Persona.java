package poo.ejercicios_poo.equipo_futbol;

public class Persona {
    private String nombre, sexo;
    private int edad;

    public Persona(){}

    public Persona(String nombre, String sexo, int edad){
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }


//Setters y Getters

    public String getNombre(){
        return nombre;
    }

    public boolean setNombre(String nombre){
        if(!nombre.isEmpty()){
            this.nombre = nombre;
            return true;
        }else{
            return false;
        }
    }

    public String getSexo(){
        return sexo;
    }

    public boolean setSexo(String sexo){
        if(!sexo.isEmpty()){
            this.sexo = sexo;
            return true;
        }else{
            return false;
        }
    }

    public int getEdad(){
        return edad;
    }

    public boolean setEdad(int edad){
        if(!edad.isEmpty()){
            this.edad = edad;
            return true;
        }else{
            return false;
        }
    }
}
