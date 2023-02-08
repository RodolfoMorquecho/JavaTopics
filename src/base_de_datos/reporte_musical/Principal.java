package base_de_datos.reporte_musical;

public class Principal extends CarpetaMusical{  //Se hereda el contenido de la clase "CarpetaMusical"
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CarpetaMusical().setVisible(true);
            }
        });
    }
}
