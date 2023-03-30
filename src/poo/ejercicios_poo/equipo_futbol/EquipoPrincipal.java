package poo.ejercicios_poo.equipo_futbol;

import java.util.jar.JarEntry;

public class EquipoPrincipal {
    public static void main(String[] args) {
        Futbolista jugador = new Futbolista();
        jugador.setNombre("Zlatan");
        jugador.setSexo("Masculino");
        jugador.setEdad(42);
        jugador.setPosicion("Delantero");
        jugador.setDorsal(22);

        jugador.informacionPersonal();
        System.out.println("\n");
        jugador.concentrarse();


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
        //if(jugador.getEdad() <= jugador2.getEdad() || jugador.getEdad() <= jugador3.getEdad()){

        //}
    }
}
