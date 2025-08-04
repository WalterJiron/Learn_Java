/*
    CLASE 7 - Estructuras de repeticion

    ¿QUE SON LAS ESTRUCTURAS DE REPETICION?
    Son instrucciones que permiten ejecutar un bloque de codigo varias veces, de forma automatica.

    ¿PARA QUE SIRVEN?
        - Para repetir tareas sin escribir el mismo codigo muchas veces
        - Para procesar listas, validar datos, contar, acumular, etc.
        - Para automatizar procesos que dependen de una condicion

    TIPOS DE REPETICION EN JAVA:

        1) WHILE       -> Repite mientras la condicion sea verdadera
        2) DO-WHILE    -> Igual que while, pero se ejecuta al menos una vez
        3) FOR         -> Repite un numero determinado de veces

    Todos evaluan una condicion booleana (true/false)
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

        scanner.close();
    }
}
