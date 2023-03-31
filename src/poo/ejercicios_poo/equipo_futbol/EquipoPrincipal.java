package poo.ejercicios_poo.equipo_futbol;

import java.util.jar.JarEntry;

public class EquipoPrincipal {
    public static void main(String[] args) {
        Futbolista jugador1 = new Futbolista();
        jugador1.setNombre("Zlatan");
        jugador1.setSexo("Masculino");
        jugador1.setEdad(42);
        jugador1.setPosicion("Delantero");
        jugador1.setDorsal(22);

        jugador1.informacionPersonal();
        System.out.println("\n");
        jugador1.concentrarse();


        Futbolista jugador2 = new Futbolista("Shevchenko","Masculino",46,"Delantero",10);
        System.out.println("\n");
        jugador2.informacionPersonal();
        System.out.println("\n");
        jugador2.viajar();

        Futbolista jugador3 = new Futbolista("Ozil","Masculino",38,"Medio",18);
        System.out.println("\n");
        jugador3.informacionPersonal();
        System.out.println("\n");
        jugador3.jugarPartido();

        Futbolista jugador4 = new Futbolista("Drogba","Masculino",42,"Delantero",9);
        System.out.println("\n");
        jugador4.informacionPersonal();
        System.out.println("\n");
        jugador4.jugarPartido();

        //Ordenar edades de menor a mayor
        int aux=0;
        for(int i=0; i<5; i++){
            if(jugador[i].getEdad() > jugador[i+1].getEdad()){
                aux = jugador[i].getEdad();
                jugador[i].getEdad() = jugador[i+1].getEdad();
                jugador[i+1].getEdad() = jugador[i].getEdad();

                System.out.print(jugador[i].getEdad());
            }
        }
    }
}
