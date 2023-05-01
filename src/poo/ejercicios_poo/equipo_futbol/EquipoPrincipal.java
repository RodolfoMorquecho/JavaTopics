package poo.ejercicios_poo.equipo_futbol;

import java.util.Scanner;
import java.util.jar.JarEntry;

public class EquipoPrincipal {
    public static void main(String[] args) {
        Futbolista [] jugador = new Futbolista;

        Scanner entrada = new Scanner(System.in);
        System.out.print("Cuantos jugadores tiene tu plantilla? ");  //11
        int players = entrada.nextInt();

        jugador = new Futbolista[players];

        //Futbolista jugador[0] = new Futbolista();
        jugador[0].setNombre("Zlatan");
        jugador[0].setSexo("Masculino");
        jugador[0].setEdad(42);
        jugador[0].setPosicion("Delantero");
        jugador[0].setDorsal(22);

        jugador[0].informacionPersonal();
        System.out.println("\n");
        jugador[0].concentrarse();


        jugador[1] = new Futbolista("Schevchenko","Masculino",46,"Delantero",16);
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

        Futbolista jugador5 = new Futbolista("Campos","Masculino",48,"Portero",1);
        System.out.println("\n");
        jugador5.informacionPersonal();
        System.out.println("\n");
        jugador5.jugarPartido();

        Futbolista jugador6 = new Futbolista("Puyol","Masculino",44,"Defensa",8);
        System.out.println("\n");
        jugador6.informacionPersonal();
        System.out.println("\n");
        jugador6.viajar();
        jugador6.entrenar();
        jugador6.jugarPartido();

        Futbolista jugador7 = new Futbolista();
        jugador7.setNombre("Karim Benzema");
        jugador7.setPosicion("Delantero");
        jugador7.setSexo("Masculino");
        jugador7.setEdad(34);
        jugador7.setDorsal(9);
        jugador7.concentrarse();
        jugador7.entrenar();
        jugador7.jugarPartido();

        /*Ordenar edades de menor a mayor
        int aux=0;
        for(int i=0; i<6; i++){
            if(jugador[i].getEdad() > jugador[i+1].getEdad()){
                aux = jugador[i].getEdad();
                jugador[i].getEdad() = jugador[i+1].getEdad();
                jugador[i+1].getEdad() = jugador[i].getEdad();

                System.out.print(jugador[i].getEdad());
            }
        }*/
    }
}
