package poo.arbol;

//centro = 5
//limIzq = centro-1
//limDer = centro+1
//imprimir de limIzq a limDer

//limIzq = limIzq-1
//limDer = limDer-1

public class arbolito {

    public static void main(String[] args) {
        int centro = 9, limIzq = centro, limDer= centro;
        for(int i=0;i<=7;i++){
            for(int j=0;j<=15;j++){
                if(j>=limIzq && j<=limDer && i==0){
                    System.out.print("*");
                }
                else if(j>=limIzq && j<=limDer && i<=5){
                    System.out.print("o");
                }
                else if((j==centro-1 && i>=6) || (j==centro+1 && i>=6)){
                    System.out.print("|");
                }
                /*else if(j==centro && i==7){
                    System.out.print("_");
                }*/
                else{
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            limIzq = limIzq - 1;
            limDer = limDer + 1;
        }
    }
}

