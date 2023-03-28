package poo.ejercicios_poo.equipo_futbol;

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
    }
}
