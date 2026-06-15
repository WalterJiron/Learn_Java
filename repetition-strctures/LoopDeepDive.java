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
        - break      -> Sale completamente del bucle inmediatamente.
        - continue   -> Salta el resto de código del ciclo actual y avanza a la siguiente iteración.

    BUCLES ANIDADOS (Nested Loops):
    Es posible colocar un bucle dentro del bloque de otro bucle.
    Regla principal: Por cada iteración del bucle EXTERNO, el bucle INTERNO 
    completa TODAS sus iteraciones.
    Son muy comunes para trabajar con matrices (filas y columnas) o generar figuras.

    ETIQUETAS (Labeled Statements):
    Cuando tienes bucles anidados y usas 'break' o 'continue', por defecto solo afectan 
    al bucle más interno donde se ejecutan.
    Si deseas detener o saltar iteraciones del bucle EXTERNO desde el interno, puedes 
    "etiquetar" el bucle externo (ej. 'exterior:') y llamarlo: `break exterior;`
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
        // === BUCLES ANIDADOS (Nested Loops) ===
        System.out.println("\n=== BUCLES ANIDADOS (Tabla de Multiplicar) ===");
        // Bucle externo (i): Controla las "filas" o la tabla actual
        for (int i = 1; i <= 3; i++) {
            System.out.println("Tabla del " + i + ":");
            // Bucle interno (j): Controla las multiplicaciones de la tabla actual.
            // Por CADA iteración de 'i', 'j' irá de 1 a 5.
            for (int j = 1; j <= 5; j++) {
                System.out.println("  " + i + " x " + j + " = " + (i * j));
            }
        }

        // === ETIQUETAS Y BUCLES ANIDADOS (Labeled break/continue) ===
        System.out.println("\n=== BUCLES ANIDADOS CON ETIQUETAS ===");
        
        // Etiquetamos el bucle externo con la palabra 'bucleExterno:'
        bucleExterno: 
        for (int fila = 1; fila <= 3; fila++) {
            for (int col = 1; col <= 3; col++) {
                // Si la columna es 2 en la fila 2, queremos SALIR por completo del bucle EXTERNO.
                if (fila == 2 && col == 2) {
                    System.out.println("  [Fila 2, Col 2] -> Hacemos 'break bucleExterno'");
                    break bucleExterno; // Si solo pusieramos 'break;', saldría del bucle 'col' pero seguiría con la fila 3.
                }
                System.out.println("Fila: " + fila + ", Columna: " + col);
            }
        }
        System.out.println("Salió del bucle etiquetado.");

        scanner.close();
    }
}
