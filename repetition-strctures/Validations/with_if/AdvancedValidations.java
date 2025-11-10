/*
    CLASE 11 - Validaciones avanzadas de entradas con Scanner

    OBJETIVO:
    Aprender a validar correctamente los distintos tipos de datos que se ingresan por teclado.

    ¿POR QUÉ VALIDAR?
        - Para evitar errores o bloqueos si el usuario ingresa datos inesperados
        - Para mejorar la experiencia del usuario y controlar el flujo del programa
        - Para asegurarte que los datos cumplen condiciones logicas o de formato

    VALIDACIONES CUBIERTAS:
        1) int    -> Numero entero positivo
        2) double -> Numero decimal mayor o igual a cero
        3) boolean -> Solo acepta true o false (y controla errores)
        4) String -> No puede estar vacío, puede tener restricciones personalizadas
*/

package Validations.with_if;

import java.util.Scanner;

public class AdvancedValidations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // === 1. VALIDAR ENTERO POSITIVO ===
        int edad = 0, contedad = 0;
        boolean entradaValida = true;

        while (entradaValida) {
            contedad ++;

            System.out.print("Ingrese su edad (entero positivo): ");

            // Para que se limple el buffer
            if (contedad > 1) {
                scanner.next();
            }

            if (scanner.hasNextInt()) {

                edad = scanner.nextInt();

                // Miramos que la edad no sea mayor que 0 para mostrar un error
                if (edad < 0) {
                    System.out.println("La edad debe ser mayor que cero.");
                    continue;
                }

                // Miramos que la edad sea correcta
                String respuesta;
                while (true) {
                    System.out.printf("Estas seguro que tienes %d años? (Si/No)", edad);
                    respuesta = scanner.nextLine();

                    respuesta = respuesta.toLowerCase().trim();

                    if (respuesta.equals("no") || respuesta.equals("si")) { break; }

                    // Si no ingreso si o no mandamos mensaje de error
                    System.out.println("\nLa respuesta tiene que ser si o no\n");
                }

                // Si es no que vuelva a ingresar la edad
                if (respuesta.equals("no")){ continue; }

                entradaValida = false;

            } else {
                System.out.println("Error: debe ingresar un numero entero.");
                scanner.nextLine(); // limpiar entrada incorrecta
            }
        }

        // === 2. VALIDAR DECIMAL (double >= 0) ===
        double salario = 0;
        entradaValida = true;

        while (entradaValida) {
            System.out.print("Ingrese su salario mensual (decimal): ");

            if (scanner.hasNextDouble()) {
                salario = scanner.nextDouble();

                if (!(salario >= 0)) {
                    System.out.println("El salario no puede ser negativo.");
                    continue;
                }

                entradaValida = false;
            } else {
                System.out.println("Error: debe ingresar un numero decimal.");
                scanner.next();
            }
        }

        // === 3. VALIDAR BOOLEAN (true o false) ===
        boolean esEstudiante = false;
        entradaValida = true;

        while (entradaValida) {
            System.out.print("¿Es estudiante? (true/false): ");

            if (scanner.hasNextBoolean()) {
                esEstudiante = scanner.nextBoolean();
                entradaValida = false;
            } else {
                System.out.println("Entrada invalida. Escriba solo 'true' o 'false'.");
                scanner.next();
            }
        }

        // === 4. VALIDAR STRING NO VACÍO ===
        scanner.nextLine(); // limpiar salto de linea pendiente
        String nombre = "";
        entradaValida = true;

        while (entradaValida) {
            System.out.print("Ingrese su nombre: ");
            nombre = scanner.nextLine();

            // Usamos una exprecion regular para que siga el formato de un nombre
            if (!nombre.trim().matches("([a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*)")) {
                System.out.println("\nSolo puedes ingrsar letras y un espacios por nombre u aplleido\n");
                continue;
            }

            if (nombre.trim().isEmpty()) {
                System.out.println("El nombre no puede estar vacio.");
                continue;
            }

            entradaValida = false;
        }

        // === MOSTRAR DATOS FINALES ===
        System.out.println("\n--- DATOS REGISTRADOS ---");
        System.out.println("Nombre: " + nombre.trim());
        System.out.println("Edad: " + edad);
        System.out.printf("Salario: %.2f\n", salario);
        System.out.println("¿Es estudiante?\n" + (esEstudiante ? "Si":"No"));

        scanner.close();
    }
}