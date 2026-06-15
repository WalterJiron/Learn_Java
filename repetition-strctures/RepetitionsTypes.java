/*
    CLASE 7 - Estructuras de repeticion

    ¿QUE SON LAS ESTRUCTURAS DE REPETICION?
    Son instrucciones que permiten ejecutar un bloque de codigo varias veces, de forma automatica.

    ¿PARA QUE SIRVEN?
        - Para repetir tareas sin escribir el mismo codigo muchas veces
        - Para procesar listas, validar datos, contar, acumular, etc.
        - Para automatizar procesos que dependen de una condicion

    TIPOS DE REPETICIÓN EN JAVA:

        1) WHILE       -> Repite MIENTRAS la condición sea verdadera. Se evalúa antes de entrar.
        2) DO-WHILE    -> Igual que while, pero la condición se evalúa al FINAL. Se ejecuta al menos UNA vez.
        3) FOR         -> Repite un número determinado de veces. Ideal cuando conoces el número de iteraciones.
        4) FOR-EACH    -> Bucle FOR mejorado (introducido en Java 5). Diseñado específicamente para recorrer arreglos (arrays) y colecciones de manera más limpia y segura.

    Todos evalúan una condición booleana (true/false) internamente.

    CONCEPTOS CLAVE Y ERRORES COMUNES:
    
        - BUCLES INFINITOS (Infinite Loops):
          Ocurren cuando la condición de un bucle nunca se vuelve falsa. Generalmente es un error (ej. olvidar incrementar el contador), provocando que el programa se cuelgue o consuma todos los recursos. Sin embargo, a veces son útiles intencionalmente (ej. en servidores o juegos) utilizando una condición `while (true)` y comandos de ruptura como `break`.
          
        - ERROR POR UNO (Off-by-one error):
          Es un error lógico muy común donde el bucle itera una vez de más o una vez de menos. Suele ocurrir al confundir operadores como `<` con `<=` al establecer el límite del contador. Por ejemplo, recorrer un arreglo de tamaño 5 usando `i <= 5` causará un error porque los índices válidos son del 0 al 4.
*/

import java.util.Scanner;

public class RepetitionsTypes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // === 1. WHILE ===
        /*
            Sintaxis:
            while (condicion) {
                // codigo que se repite
            }

            Se usa cuando NO sabes cuantas veces se repetirá.
        */
        int contador = 1;
        System.out.println("Contando del 1 al 5 con WHILE:");
        while (contador <= 5) {
            System.out.println("Contador: " + contador);
            contador++;
        }

        // === 2. DO-WHILE ===
        /*
            Sintaxis:
            do {
                // codigo que se repite
            } while (condicion);

            Se ejecuta al menos una vez, incluso si la condicion es falsa al inicio.
        */
        int numero;
        do {
            System.out.print("Ingrese un numero positivo: ");
            numero = scanner.nextInt();
        } while (numero <= 0);

        System.out.println("Ingresaste el numero: " + numero);

        // === 3. FOR ===
        /*
            Sintaxis:
            for (inicializacion; condicion; incremento) {
                // codigo que se repite
            }

            Se usa cuando SABES cuantas veces debe repetirse.
        */
        System.out.println("Contando del 10 al 1 con FOR:");
        for (int i = 10; i >= 1; i--) {
            System.out.println("i = " + i);
        }

        // === 4. FOR-EACH (Bucle FOR mejorado) ===
        /*
            Sintaxis:
            for (Tipo variable : arreglo_o_coleccion) {
                // codigo
            }
            
            Lee cada elemento uno por uno, desde el inicio hasta el fin, automáticamente.
            No necesitas manejar contadores (i) ni límites, evitando el error "off-by-one".
        */
        System.out.println("\nRecorriendo un arreglo con FOR-EACH:");
        String[] frutas = {"Manzana", "Banana", "Naranja", "Pera"};
        for (String fruta : frutas) {
            System.out.println("Me gusta la " + fruta);
        }

        // === EJEMPLOS DE ERRORES COMUNES (Comentados para no romper el programa) ===
        
        /* 
        ERROR 1: Bucle Infinito (Infinite Loop)
        int x = 1;
        while (x <= 5) {
            System.out.println(x);
            // Si olvidamos x++; ¡el bucle nunca termina porque x siempre será 1!
        }
        */

        /*
        ERROR 2: Error por uno (Off-by-one error)
        int[] numeros = {10, 20, 30}; // Índices válidos: 0, 1, 2. Longitud: 3.
        
        // El siguiente FOR causaría un "ArrayIndexOutOfBoundsException" 
        // porque la condición es i <= 3 (intentará acceder al índice 3 que no existe).
        // Lo correcto sería i < 3  o  i < numeros.length
        
        for (int i = 0; i <= numeros.length; i++) { 
            // System.out.println(numeros[i]); 
        }
        */

        scanner.close();
    }
}
