/*
    CLASE 2 - Entrada y salida de datos en Java

    En esta clase vamos a:
    - Imprimir datos con: print, println, printf (ya vimos un ejemplo basico en la clase pasada)
    - Leer datos con: Scanner (desde teclado) USAREMOS LA CLASE Scanner

    Herramientas:
    - System.out -> salida estandar (pantalla)
    - Scanner -> entrada estandar (teclado)

    Scanner es una CLASE de Java (del paquete java.util)
    Cuando usamos: Scanner entrada = new Scanner(System.in);
    Estamos creando una INSTANCIA (objeto) de esa clase, que lee desde el teclado (System.in)
*/

// Primero tenemos que importar la clase Scanner
import java.util.Scanner;

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

        // === 2. LEER DATOS DESDE EL TECLADO ===

        // Creamos un objeto Scanner (instancia de la clase Scanner)
        Scanner entrada = new Scanner(System.in); // System.in es el teclado (Obtener todo lo que se escriba en la terminal)

        // Leemos un String (linea completa)
        System.out.print("Ingresa tu nombre: ");
        String nombre = entrada.nextLine();   // lee toda la linea como texto

        // Leemos un entero
        System.out.print("Ingresa tu edad: ");
        int edad = entrada.nextInt();         // lee un numero entero

        // Mostramos el resultado usando printf
        System.out.printf("Hola %s, tienes %d anios.\n", nombre, edad);

        // Cerramos el Scanner (buena practica)
        entrada.close();
    }
}
