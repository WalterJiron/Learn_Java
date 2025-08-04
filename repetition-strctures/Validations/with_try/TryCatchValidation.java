/*
    CLASE 12 - VALIDACIONES CON TRY-CATCH

    OBJETIVO:
    Aprender a validar entradas del usuario utilizando manejo de excepciones (try-catch)
    y entender por que es una herramienta poderosa y profesional.

    ¿QUE ES UNA EXCEPCION?
        - Es un error que ocurre en tiempo de ejecucion.
        - Si no se controla, puede hacer que el programa se detenga inesperadamente.

    ¿PARA QUE SIRVE try-catch?
        - Permite atrapar errores y seguir ejecutando el programa de forma segura.
        - Se usa cuando el codigo que estas por ejecutar y puede fallar.

    SINTAXIS BASICA:

        try {
            // Codigo que puede lanzar una excepcion
        } catch (TipoDeExcepcion nombreVariable) {
            // Codigo para manejar el error
        }

    NOTA:
        En este caso usamos InputMismatchException para detectar cuando el usuario
        escribe un dato que no corresponde al tipo esperado (por ejemplo: letras en vez de numeros).
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
