/*
    CLASE 10 - Validacion de entradas numericas en Java

    OBJETIVO:
        Aprender a controlar que el usuario ingrese valores numericos correctos.
        Esto evita que el programa se bloquee o lance errores si el input no es valido.

    PROBLEMA COMUN:
        - Si usas scanner.nextInt() y el usuario escribe texto, el programa lanza excepcion
        - Para evitarlo, usamos scanner.hasNextInt() o hasNextDouble() antes de leer

    FLUJO:
        1. Mostrar mensaje
        2. Verificar si lo que se escribio es un numero valido
        3. Si no lo es -> mostrar mensaje de error y pedirlo de nuevo
        4. Si es valido -> leer y continuar
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
