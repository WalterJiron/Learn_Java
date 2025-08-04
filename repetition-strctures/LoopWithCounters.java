/*
    CLASE 9 - BUCLES CON CONTADORES Y ACUMULADORES

    OBJETIVO:
    Aprender a utilizar bucles junto con contadores y acumuladores,
    que son fundamentales para procesar datos, calcular totales o promedios,
    y realizar tareas repetitivas con control numérico.

    ¿QUE ES UN CONTADOR?
    Es una variable que aumenta en cada iteracion (normalmente +1)
    Se usa para contar cuántas veces se repite algo

    ¿QUE ES UN ACUMULADOR?
    Es una variable que suma (o acumula) valores en cada iteración

    ¿DONDE SE USAN?
    En bucles como while, do-while y for, junto con condiciones

    FORMAS TIPICAS:
        contador++;        // suma 1
        acumulador += x;   // suma el valor de x
*/

import java.util.Scanner;

public class LoopWithCounters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // === EJEMPLO 1: CONTADOR simple con FOR ===
        System.out.println("Contar de 1 a 5:");
        int contador = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteracion " + i);
            contador++; // cuenta las repeticiones
        }

        System.out.println("Total de repeticiones: " + contador);

        // === EJEMPLO 2: ACUMULADOR de suma ===
        System.out.print("\n¿Cuantas notas desea ingresar?: ");
        int cantidad = scanner.nextInt();

        double suma = 0; // acumulador
        int i = 1;

        while (i <= cantidad) {
            System.out.print("Ingrese nota #" + i + ": ");
            double nota = scanner.nextDouble();
            suma += nota; // acumula el valor ingresado
            i++;
        }

        double promedio = suma / cantidad;
        System.out.printf("Promedio final: %.2f\n", promedio);

        // === EJEMPLO 3: CONTADOR y ACUMULADOR combinados con validacion ===
        /*
            Vamos a pedir al usuario que ingrese numeros positivos.
            El ciclo termina si escribe un numero negativo.
            Se mostrara:
              - La suma total de los numeros positivos
              - Cuantos numeros ingresó
        */

        double total = 0;
        int cantidadPositivos = 0;
        double numero;

        System.out.println("\nIngrese numeros positivos. Escriba un numero negativo para terminar.");

        do {
            System.out.print("Numero: ");
            numero = scanner.nextDouble();

            if (numero >= 0) {
                total += numero;         // acumulador
                cantidadPositivos++;     // contador
            }

        } while (numero >= 0);

        System.out.println("Cantidad de numeros ingresados: " + cantidadPositivos);
        System.out.println("Suma total: " + total);

        scanner.close();
    }
}
