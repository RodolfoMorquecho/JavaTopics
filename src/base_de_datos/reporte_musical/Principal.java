package base_de_datos.reporte_musical;

public class Principal extends CarpetaMusical{  //Se hereda el contenido de la clase "CarpetaMusical"
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                iniciarComponentes();
            }
        });
    }

    //Configuración de las caracteristicas de la interfaz
    private static void iniciarComponentes(){
        CarpetaMusical lista = new CarpetaMusical();
        lista.setContentPane(lista.panel1);
        lista.setVisible(true);
        lista.setBounds(0,0,600,450);
        lista.setLocationRelativeTo(null);
        lista.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
