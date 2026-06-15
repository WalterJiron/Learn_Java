/*
    CLASE 11 - Validaciones avanzadas de entradas con Scanner

    OBJETIVO:
    Aprender a validar correctamente los distintos tipos de datos que se ingresan por teclado,
    aplicando técnicas profesionales de control de flujo y procesamiento de cadenas.

    ¿POR QUÉ VALIDAR?
        - Para evitar errores o bloqueos si el usuario ingresa datos inesperados.
        - Para mejorar la experiencia del usuario y controlar el flujo del programa.
        - Para asegurarte de que los datos cumplen condiciones lógicas o de formato.

    NORMALIZACIÓN DE CADENAS:
    Cuando el usuario ingresa texto libre (ej. "Si", "SI", "sI"), las comparaciones
    directas con .equals() pueden fallar si el texto tiene distintas mayúsculas o espacios.
    La solución es NORMALIZAR el texto antes de compararlo:
        - .trim()         -> Elimina espacios en blanco al inicio y al final.
        - .toLowerCase()  -> Convierte todo a minúsculas para una comparación uniforme.
    Ejemplo: `respuesta.toLowerCase().trim().equals("si")`
    Esto aceptará "SI", "Si", " si ", etc. como respuestas válidas.

    EXPRESIONES REGULARES (Regex):
    Una expresión regular es un patrón que describe el formato que debe tener un texto.
    En Java, el método `.matches("patron")` de la clase String devuelve true si el texto
    completo coincide con el patrón dado.
    Ejemplo de patrón usado en esta clase:
        "[a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*"
        - [a-zA-ZáéíóúÁÉÍÓÚñÑ]+  -> Una o más letras (incluyendo acentos y ñ).
        - ( [a-zA-Z...]+)*         -> Cero o más grupos de: UN espacio seguido de más letras.
    Esto acepta "Juan", "Maria Jose", pero rechaza "123", "Pedro_Lopez", "a  b".

    VALIDACIONES CUBIERTAS:
        1) int     -> Número entero positivo con confirmación.
        2) double  -> Número decimal mayor o igual a cero.
        3) boolean -> Solo acepta true o false.
        4) String  -> No puede estar vacío y debe seguir un formato de nombre.
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

            // Limpiamos el buffer del Scanner desde la segunda vuelta en adelante.
            // Si no lo hacemos, el scanner intentaría leer el mismo dato inválido repetidamente.
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

            // Usamos una expresión regular (Regex) para validar que el formato del nombre
            // solo contenga letras (incluyendo acentuadas y ñ) separadas por un único espacio.
            if (!nombre.trim().matches("([a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*)")) {
                System.out.println("\nSolo puedes ingresar letras y un espacio por nombre o apellido.\n");
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