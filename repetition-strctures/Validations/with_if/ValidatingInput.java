/*
    CLASE 10 - Validación de entradas numéricas en Java

    OBJETIVO:
        Aprender a controlar que el usuario ingrese valores numéricos correctos.
        Esto evita que el programa se bloquee o lance errores si el input no es válido.

    PROBLEMA COMÚN:
        Si usas `scanner.nextInt()` y el usuario escribe texto (ej. "abc"),
        el programa lanza una `InputMismatchException` y se detiene abruptamente.
        Para evitarlo, usamos `scanner.hasNextInt()` o `scanner.hasNextDouble()`
        ANTES de leer, para verificar que el dato en el buffer sea del tipo esperado.

    EL BUFFER DEL SCANNER:
        El Scanner funciona con un "buffer" (memoria temporal). Cuando el usuario
        escribe algo y presiona Enter, ese texto queda en el buffer esperando ser leído.
        Si llamamos a `scanner.nextInt()` y el texto en el buffer NO es un entero,
        la lectura falla PERO el texto incorrecto sigue en el buffer.
        Esto provoca que en la siguiente iteración del bucle, el scanner intente
        leer lo mismo de nuevo -> ¡bucle infinito!

        LA SOLUCIÓN: Llamar a `scanner.next()` (o `scanner.nextLine()`) después
        del error para LIMPIAR el buffer y descartar el texto inválido.
        De esta forma, en la siguiente iteración el usuario puede escribir de nuevo.

    FLUJO DE VALIDACIÓN CORRECTO:
        1. Mostrar mensaje al usuario.
        2. Verificar con hasNextInt() / hasNextDouble() si el dato es válido.
        3. Si NO es válido -> mostrar error, limpiar buffer con scanner.next() y reintentar.
        4. Si es válido -> leer con nextInt() / nextDouble() y continuar.
*/
package Validations.with_if;

import java.util.Scanner;

public class ValidatingInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int edad = 0;
        boolean entradaValida = false;

        // === VALIDACION DE ENTERO CON WHILE ===
        while (!entradaValida) {
            System.out.print("Ingrese su edad (entero): ");

            if (scanner.hasNextInt()) {
                edad = scanner.nextInt(); // ahora es seguro leerlo
                if (edad > 0) {
                    entradaValida = true; // correcto
                } else {
                    System.out.println("La edad debe ser mayor que 0.");
                }
            } else {
                System.out.println("Entrada invalida. Debe ingresar un numero entero.");
                scanner.next(); // limpia lo que escribio mal
            }
        }

        System.out.println("Edad ingresada correctamente: " + edad);

        // === VALIDACION DE DECIMAL (double) ===
        double salario = 0;
        entradaValida = false;

        while (!entradaValida) {
            System.out.print("Ingrese su salario (decimal): ");

            if (scanner.hasNextDouble()) {
                salario = scanner.nextDouble();
                if (salario >= 0) {
                    entradaValida = true;
                } else {
                    System.out.println("El salario no puede ser negativo.");
                }
            } else {
                System.out.println("Entrada invalida. Debe ingresar un numero decimal.");
                scanner.next(); // descarta el texto incorrecto
            }
        }

        System.out.printf("Salario registrado: %.2f\n", salario);

        scanner.close();
    }
}
