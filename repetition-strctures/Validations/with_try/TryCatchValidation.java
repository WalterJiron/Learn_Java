/*
    CLASE 12 - VALIDACIONES CON TRY-CATCH

    OBJETIVO:
    Aprender a validar entradas del usuario utilizando manejo de excepciones (try-catch)
    y entender por qué es una herramienta poderosa y profesional en comparación
    con el enfoque de `hasNextInt()` / `hasNextDouble()`.

    ¿QUÉ ES UNA EXCEPCIÓN?
        Una excepción (Exception) es un evento anormal que interrumpe el flujo
        normal de un programa durante su ejecución. Si no se controla (no se "atrapa"),
        el programa imprime un error en pantalla y se termina abruptamente.

    TIPOS DE EXCEPCIONES RELEVANTES AQUÍ:
        - InputMismatchException: El Scanner no pudo convertir el texto ingresado
          al tipo de dato esperado (ej. el usuario escribió "hola" cuando se esperaba un int).
        - NumberFormatException: Ocurre al intentar convertir manualmente un String
          a número con `Integer.parseInt()` o `Double.parseDouble()`, si el texto no es válido.

    ¿PARA QUÉ SIRVE try-catch?
        Permite "atrapar" (catch) un error que ocurrió en el bloque `try` y
        ejecutar un código alternativo de recuperación en el bloque `catch`,
        de forma que el programa no se detenga y pueda seguir funcionando.

    SINTAXIS BÁSICA:
        try {
            // Código que PUEDE fallar
        } catch (TipoDeExcepcion e) {
            // Código que se ejecuta SI ocurre el error
            // 'e' contiene información sobre el error (ej. e.getMessage())
        }

    ¡PELIGRO! EL BUCLE INFINITO EN EL CATCH:
    Cuando se lanza una InputMismatchException, el texto inválido del buffer
    del Scanner NO se consume automáticamente. Si en el bloque `catch` no
    limpiamos el buffer con `scanner.nextLine()`, en la siguiente iteración del
    bucle el Scanner encontrará el mismo texto inválido, volverá a lanzar la
    excepción, y así indefinidamente -> ¡bucle infinito!

    La solución SIEMPRE es limpiar el buffer en el catch:
        catch (InputMismatchException e) {
            System.out.println("Dato inválido.");
            scanner.nextLine(); // ← INDISPENSABLE: limpia el buffer
        }

    VENTAJA vs hasNextInt():
    El enfoque try-catch maneja automáticamente la conversión. El código en
    el bloque `try` es más limpio y directo (sin el `if` de verificación previo).
    Es el estilo preferido en código Java profesional.
*/
package Validations.with_try;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchValidation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // === 1. VALIDAR ENTERO POSITIVO CON CONFIRMACION ===
        int edad = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese su edad (entero positivo): ");
                edad = scanner.nextInt();

                if (edad < 0) {
                    System.out.println("La edad debe ser mayor que cero.");
                    continue;
                }

                scanner.nextLine(); // Limpiar el buffer del enter

                // Confirmacion con si/no
                String respuesta;
                while (true) {
                    System.out.printf("¿Estás seguro que tienes %d años? (si/no): ", edad);
                    respuesta = scanner.nextLine().trim().toLowerCase();

                    if (respuesta.equals("si")) {
                        entradaValida = true;
                        break;
                    } else if (respuesta.equals("no")) {
                        System.out.println("Volvamos a intentarlo...\n");
                        break;
                    } else {
                        System.out.println("Respuesta invalida. Debe ser: SI o NO.");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida: se esperaba un numero entero.");
                scanner.nextLine(); // limpiar entrada erronea
            }
        }

        // === 2. VALIDAR DOUBLE MAYOR O IGUAL A 0 ===
        double salario = 0;
        entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese su salario mensual (decimal): ");
                salario = scanner.nextDouble();

                if (salario < 0) {
                    System.out.println("El salario no puede ser negativo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida: se esperaba un numero decimal.");
                scanner.nextLine();
            }
        }

        // === 3. VALIDAR BOOLEANO (true/false) ===
        boolean esEstudiante = false;
        entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("¿Es estudiante? (true/false): ");
                esEstudiante = scanner.nextBoolean();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida: escriba solo 'true' o 'false'.");
                scanner.nextLine();
            }
        }

        // === 4. VALIDAR STRING NO VACIO CON REGEX ===
        scanner.nextLine(); // limpiar el salto de linea
        String nombre = "";
        entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese su nombre completo: ");
                nombre = scanner.nextLine().trim();

                // Validar que no este vacio y que solo contenga letras y espacios
                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacio.");
                    continue;
                }

                if (!nombre.matches("([a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*)")) {
                    System.out.println("Solo se permiten letras y un espacio por palabra.");
                    continue;
                }

                entradaValida = true;

            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado al leer el nombre.");
                scanner.next();
            }
        }

        // === RESUMEN FINAL DE DATOS ===
        System.out.println("\n--- DATOS REGISTRADOS ---");
        System.out.println("Nombre: " + nombre.toUpperCase());
        System.out.println("Edad: " + edad);
        System.out.printf("Salario: %.2f\n", salario);
        System.out.println("¿Es estudiante?: " + (esEstudiante ? "Sí" : "No"));

        scanner.close();
    }
}
