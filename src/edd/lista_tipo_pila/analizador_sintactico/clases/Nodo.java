package edd.lista_tipo_pila.analizador_sintactico.clases;
/*
Analizador Sintactico: Se encarga de analizar si una expresión esta correctamente escrita al momento de estar programando
Por ejemplo en Intellij, en un "for" si se llegara a eliminar una llave, el programa automaticamente indica que hay un error
y esta mas escrito:

  for (int i=0;i<10;i++)  <------ Falta llave de apertura
  }

Un analizador sintactico tiene la capacidad de detectar cuando falta algún elemento en una expresión, ya sean:
valores numericos, simbolos de operaciones, llaves, corechetes, parentesis, etc.

Ejercicio: Para este caso solo se centrara en trabajar con las llaves, parentesis o corchetes de apertura y cierre de la expresion,
asi como, los mismos de las expresiones internas, dejando completamente de fuera los simbolos para operaciones, los valores numericos
y los espacios.

    { 8 * (4-2) + {5+3} + [6-4] }  ----> En este caso el programa indica que esta escrita "corectamente"

    [ 8 * (4-2) + {5+3} + [6-4] }  ----> En este caso esta incorrecto, debido a que la apertura es con corchete pero cierra con llave
 */

public class Nodo {
    char informacion;  //Debido a que se analizara o evaluara un simbolo, se usara variable de tipo char
    Nodo siguiente;
}