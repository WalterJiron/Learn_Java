/*
    CLASE 8 - Profundizacion en estructuras de repeticion (Mejor manejo de conceptos)

    OBJETIVO:
    Entender a fondo las diferencias, ventajas y usos de los bucles while, do-while y for.
    Ademas, introducir los comandos de control de flujo: break y continue.

    ¿QUE ES UN BUCLE?
    Es una estructura que repite un bloque de codigo mientras se cumpla una condicion (true).

    ¿POR QUE SON UTILES?
        - Evitan repetir codigo manualmente
        - Permiten procesar datos de manera masiva
        - Son la base de toda automatización

    TIPOS DE BUCLES:

        1) while       -> Bucle controlado por condición (puede no ejecutarse nunca)
        2) do-while    -> Igual que while, pero se ejecuta AL MENOS UNA vez
        3) for         -> Bucle controlado por un contador (inicio, condicion, incremento)

    COMANDOS DE CONTROL:
        - break      -> Sale completamente del bucle
        - continue   -> Salta a la siguiente iteración sin terminar el ciclo actual
*/

import java.util.Scanner;

public class LoopDeepDive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // === WHILE ===
        /*
            Ideal cuando:
                - No sabes cuantas veces se ejecutará el bucle
                - La condición depende de algo externo (teclado, sensor, etc)

            Riesgo: si la condicion nunca se vuelve falsa, el bucle es INFINITO
        */
        int intentos = 0;
        String clave = "";

        System.out.println("=== WHILE ===");
        while (!clave.equals("admin") && intentos < 3) {
            System.out.print("Ingrese la clave: ");
            clave = scanner.next();
            intentos++;
        }

        if (clave.equals("admin")) {
            System.out.println("Acceso permitido");
        } else {
            System.out.println("Acceso bloqueado");
        }

        // === DO-WHILE ===
        /*
            Ideal cuando:
            - Siempre queres ejecutar el bloque al menos una vez (validar entrada, mostrar menu, etc.)
        */
        int numero;

        System.out.println("\n=== DO-WHILE ===");
        do {
            System.out.print("Ingrese un numero mayor que 0: ");
            numero = scanner.nextInt();

            // Mandamos un mensaje de erro en caso que el numero se menor que 0
            if (numero <= 0){
                System.out.println("\nEl numero no puede ser negativo ni 0.\n");
            }
        } while (numero <= 0);

        System.out.println("Numero correcto: " + numero);

        // === FOR ===
        /*
            Ideal cuando:
                - Sabes exactamente cuántas veces se repite
                - Necesitas un contador que avance con cada ciclo
        */
        System.out.println("\n=== FOR ===");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteracion #" + i);
        }

        // === FOR con continue y break ===
        System.out.println("\n=== FOR con break y continue ===");

        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("\nSe salta el 5 (continue)\n");
                continue; // salta esta iteracion
            }
            if (i == 8) {
                System.out.println("\nSe rompe el ciclo en 8 (break)\n");
                break; // termina el ciclo por completo
            }
            System.out.println("i = " + i);
        }

        scanner.close();
    }
}
