package recursividad.ejercicio2;

public class FactorialRecursiva {
    public int Factorial(int parametro){
        if (parametro > 0){
            //Se multiplica el parametro por la llamada de la misma funcion con el parametro restandole 1, hasta que valga 1
            int resultado = parametro * Factorial(parametro - 1);  //Se almacena el valor final en la var "resultado"
            return resultado;
        }
        //Es necesario retornar un valor cuando la función/método es de tipo int, float, char, etc
        return 1;  //Para evitar que retorne numeros negativos, Se indica que retorne 1
    }
}
