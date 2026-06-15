/*
    CLASE 9 - BUCLES CON CONTADORES, ACUMULADORES Y VARIABLES DE TRABAJO

    OBJETIVO:
    Aprender a utilizar bucles junto con los tres roles de variables que se definieron
    en la CLASE 1 (VariableTypes.java):
        A) Variable de Trabajo (Auxiliar)
        B) Variable Acumuladora
        C) Variable Contadora

    Aquí las combinamos dentro de bucles, que es donde demuestran su verdadero poder.

    A) ¿QUÉ ES UNA VARIABLE DE TRABAJO (AUXILIAR)?
    Es una variable que almacena un valor INTERMEDIO o TEMPORAL necesario para
    realizar un cálculo durante UNA iteración del bucle.
    Su valor normalmente se usa para alimentar al acumulador y se sobreescribe en
    cada vuelta del ciclo. No guarda el resultado final, sino un paso intermedio.
    Ejemplo: Calcular el descuento de UN precio antes de sumarlo al total.

    B) ¿QUÉ ES UN ACUMULADOR?
    Es una variable que SUMA (o multiplica) valores de forma progresiva a lo largo
    de varias iteraciones del bucle. Acumula el resultado final.
    ¡Siempre debe inicializarse ANTES del bucle! (en 0 para sumas, en 1 para productos)
    Ejemplo: `suma += nota;` -> al final, 'suma' tiene el total de todas las notas.

    C) ¿QUÉ ES UN CONTADOR?
    Es una variable que INCREMENTA en una cantidad fija (normalmente +1) en cada
    iteración. Sirve para contar cuántas veces ocurrió algo.
    Ejemplo: `cantidadPositivos++;` -> al final, sabe cuántos números positivos se ingresaron.

    FORMAS TÍPICAS:
        contador++;        // suma 1 (equivale a: contador = contador + 1)
        acumulador += x;   // suma el valor de x (equivale a: acumulador = acumulador + x)
        auxiliar = valor;  // calcula un valor temporal en cada vuelta

    ALCANCE DE LAS VARIABLES (Variable Scope):
    Las variables declaradas DENTRO de un bucle (o en la declaración de un 'for', como 'int i=0')
    solo existen ("viven") dentro de ese bucle.
    Una vez que el bucle termina, esas variables se destruyen y no pueden ser usadas fuera de él.
    Si necesitas el resultado final (como un total o un promedio), debes declarar
    la variable ANTES de iniciar el bucle.

    VALORES CENTINELA (Sentinel Values):
    Es un valor especial ingresado por el usuario (o por el sistema) que se usa
    específicamente para INDICAR EL FIN de una secuencia de datos.
    Por ejemplo, si pides calificaciones (de 0 a 100), puedes establecer que si el
    usuario ingresa '-1', el bucle debe detenerse porque '-1' es el "centinela".
    Esto es súper útil cuando no sabes de antemano cuántos datos se ingresarán.
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

        // === EJEMPLO 3: CONTADOR, ACUMULADOR Y VALOR CENTINELA ===
        /*
            Vamos a pedir al usuario que ingrese numeros positivos.
            El ciclo termina si escribe un numero negativo (VALOR CENTINELA).
            Se mostrara:
              - La suma total de los numeros positivos
              - Cuantos numeros ingresó
        */

        double total = 0;
        int cantidadPositivos = 0;
        double numero; // Declarada AFUERA para usarla en la condición del while

        System.out.println("\nIngrese numeros positivos. Escriba un numero negativo para terminar (centinela).");

        do {
            System.out.print("Numero: ");
            numero = scanner.nextDouble();

            if (numero >= 0) {
                total += numero;         // acumulador
                cantidadPositivos++;     // contador
            }

        } while (numero >= 0); // Verifica el valor centinela

        System.out.println("Cantidad de numeros ingresados: " + cantidadPositivos);
        System.out.println("Suma total: " + total);

        // === EJEMPLO 4: ALCANCE DE VARIABLES (Scope) ===
        System.out.println("\n--- Alcance de las variables ---");
        
        for (int j = 1; j <= 2; j++) {
            // La variable 'temporal' NACE aquí en cada iteración
            int temporal = j * 10;
            System.out.println("Dentro del bucle, temporal = " + temporal);
            // La variable 'temporal' MUERE al terminar esta llave }
        }
        
        // Si intentamos hacer: System.out.println(temporal);  <-- ESTO DA ERROR DE COMPILACIÓN
        // Si intentamos hacer: System.out.println(j);         <-- ESTO TAMBIÉN DA ERROR (j solo existe dentro del for)

        // === EJEMPLO 5: LOS TRES ROLES JUNTOS (Trabajo + Acumulador + Contador) ===
        /*
            Este es el escenario más completo: los tres tipos de variables trabajando en equipo.
            Vamos a leer precios de productos, aplicarles un descuento del 10% (VARIABLE DE TRABAJO)
            y acumular el total ya descontado (ACUMULADOR), contando cuántos productos hubo (CONTADOR).
        */
        System.out.println("\n=== Los 3 Roles de Variables en un Bucle ===");
        System.out.print("¿Cuántos productos desea registrar?: ");
        int cantidadProductos = scanner.nextInt();

        double totalConDescuento = 0.0; // ACUMULADOR: suma de precios con descuento
        int productosContados = 0;      // CONTADOR: cuántos productos se procesaron

        for (int k = 1; k <= cantidadProductos; k++) {
            System.out.print("Precio del producto #" + k + ": ");
            double precioOriginal = scanner.nextDouble();

            // VARIABLE DE TRABAJO (AUXILIAR): calcula el descuento de ESTE producto
            // en esta sola iteración. Su valor se sobreescribe en la próxima vuelta.
            double precioConDescuento = precioOriginal * 0.90; // 10% de descuento

            totalConDescuento += precioConDescuento; // Alimenta al ACUMULADOR
            productosContados++;                     // Incrementa el CONTADOR
        }

        System.out.println("Productos procesados: " + productosContados);           // CONTADOR
        System.out.printf("Total con descuento del 10%%: %.2f%n", totalConDescuento); // ACUMULADOR

        /*
            RESUMEN DEL FLUJO EN CADA ITERACIÓN:
            1. Se lee el precio original.
            2. La variable de TRABAJO (precioConDescuento) lo transforma.
            3. El ACUMULADOR (totalConDescuento) lo suma al total.
            4. El CONTADOR (productosContados) registra que se procesó uno más.
        */

        scanner.close();
    }
}
