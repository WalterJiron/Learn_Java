/*
    CLASE 2 - Entrada y salida de datos en Java

    En esta clase vamos a:
    - Imprimir datos con: print, println, printf
    - Leer datos con: Scanner (desde teclado)

    CONCEPTOS CLAVE:
    
    1. SALIDA DE DATOS:
       - System.out: Objeto que representa el flujo de salida estándar (normalmente la consola de comandos).
       - print(): Imprime el contenido en la consola sin realizar ningún salto de línea al final.
       - println(): Imprime el contenido y añade automáticamente un salto de línea (\n o %n) al finalizar.
       - printf(): Imprime texto con formato (similar al estilo de C). Permite formatear cadenas utilizando especificadores:
         * %s -> Cadenas de texto (String).
         * %d -> Números enteros (byte, short, int, long).
         * %f -> Números decimales (float, double).
         * %.2f -> Número decimal formateado y redondeado a 2 decimales.
         * %c -> Un único carácter (char).
         * %b -> Valores booleanos (boolean).
         * %n -> Salto de línea portable (funciona igual en Windows, Linux y Mac).

    2. ENTRADA DE DATOS (Scanner):
       - Scanner entrada = new Scanner(System.in);
       - La clase Scanner (del paquete java.util) permite leer e interpretar flujos de texto del teclado (System.in).
       - Métodos de lectura más comunes:
         * nextLine() -> Lee una línea completa de texto (incluidos los espacios) hasta que se pulsa Enter.
         * next()     -> Lee una sola palabra (se detiene al encontrar el primer espacio en blanco).
         * nextInt()  -> Lee un número entero.
         * nextDouble() -> Lee un número con punto decimal de doble precisión.

    3. EL PROBLEMA CLÁSICO DEL BUFFER EN SCANNER:
       - Métodos como nextInt(), nextDouble(), nextBoolean(), etc., leen únicamente el valor numérico/lógico,
         dejando el salto de línea ('\n') (generado al presionar Enter) "atrapado" en el buffer del teclado.
       - Si inmediatamente después se intenta usar nextLine(), este lee ese salto de línea residual y finaliza
         de inmediato, retornando una cadena vacía y haciendo que parezca que el programa "se salta" la lectura.
       - SOLUCIÓN: Limpiar el buffer llamando a entrada.nextLine() justo después de leer el número y antes del nextLine() real.

    4. SYSTEM.OUT VS SYSTEM.ERR:
       - System.out: Representa el flujo de salida estándar (mensajes normales).
       - System.err: Representa el flujo de salida de errores. Se utiliza para reportar fallas y advertencias,
         y en la consola suele distinguirse (por ejemplo, con texto en rojo).

    5. CONFIGURACIÓN DE LOCALE (CONFIGURACIÓN REGIONAL) EN SCANNER:
       - nextDouble() y nextFloat() dependen del idioma del sistema operativo. En español esperan una coma (ej. 1,75).
         Si ingresas un punto (1.75), Java lanzará una excepción InputMismatchException.
       - Para solucionar esto y forzar a que siempre se use el punto decimal (estándar de EE.UU.), se usa
         `entrada.useLocale(Locale.US);`.
*/

// Primero tenemos que importar las clases necesarias
import java.util.Scanner;
import java.util.Locale;

public class PrintAndRead {

    public static void main(String[] args) {

        // === 1. IMPRIMIR DATOS ===

        System.out.print("Hola ");           // imprime en la misma linea
        System.out.println("mundo!");        // imprime y salta de linea

        // Tambien se puede usar \n para hacer saltos de linea manuales
        System.out.print("Hola \n\n");
        System.out.print("mundo!\n");

        // printf permite imprimir con formato, como en el lenguaje C
        System.out.printf("El numero pi es %.2f\n", 3.1416); // %.2f -> 2 decimales

        // System.err permite imprimir mensajes de error (usualmente en rojo en consola)
        System.err.println("Mensaje de error simulado con System.err.");

        // === 2. LEER DATOS DESDE EL TECLADO ===

        // Creamos un objeto Scanner (instancia de la clase Scanner)
        Scanner entrada = new Scanner(System.in); // System.in es el teclado (Obtener todo lo que se escriba en la terminal)

        // Forzamos el uso de punto decimal en lugar de coma decimal (Locale US)
        entrada.useLocale(Locale.US);

        // Leemos un String (linea completa)
        System.out.print("Ingresa tu nombre: ");
        String nombre = entrada.nextLine();   // lee toda la linea como texto

        // Leemos un entero
        System.out.print("Ingresa tu edad: ");
        int edad = entrada.nextInt();         // lee un numero entero

        // Leemos un decimal (double)
        System.out.print("Ingresa tu estatura (ej. 1.75 con punto decimal): ");
        double estatura = entrada.nextDouble(); // gracias a Locale.US, espera un punto '.'

        // Mostramos el resultado usando printf
        System.out.printf("Hola %s, tienes %d anios y mides %.2f metros.\n", nombre, edad, estatura);

        // === 3. DEMOSTRACIÓN DEL PROBLEMA DEL BUFFER (Y SU SOLUCIÓN) ===
        // Dado que acabamos de leer un entero (nextInt()), queda un '\n' residual en el buffer.
        // Si no lo limpiamos, la siguiente lectura con nextLine() se leerá vacía de inmediato.
        System.out.println("\n--- Demostración de Limpieza de Buffer ---");
        
        // Consumimos el salto de línea que quedó en el buffer después de nextInt():
        entrada.nextLine(); // Limpia el buffer (consume el salto de línea residual)
        
        System.out.print("Ingresa tu ciudad de origen: ");
        String ciudad = entrada.nextLine(); // Ahora sí esperará a que escribas
        
        System.out.printf("¡Qué bien! Tu ciudad es %s.%n", ciudad);

        // Cerramos el Scanner (buena practica)
        entrada.close();
    }
}
