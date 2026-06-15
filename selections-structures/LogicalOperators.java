/*
    CLASE 5 - Uso de los operadores lógicos en las estructuras de selección

    ¿QUÉ SON LOS OPERADORES LÓGICOS?
    Son símbolos que permiten combinar o invertir condiciones booleanas (true o false).
    Se usan para tomar decisiones más complejas dentro de un if, else if, o switch.

    OPERADORES DISPONIBLES:
        1) && (AND): TODAS las condiciones deben ser verdaderas para que el resultado sea true.
        2) || (OR):  Al menos UNA condición debe ser verdadera para que el resultado sea true.
        3) !  (NOT): Invierte el valor booleano de una condición (true -> false, false -> true).

    LEYES DE DE MORGAN:
    Son reglas matemáticas fundamentales de la lógica booleana que permiten transformar
    condiciones negadas complejas en formas equivalentes más simples.

        Primera Ley:  !(A && B)  es equivalente a  !A || !B
                      "NO (A y B)"  =>  "NO-A o NO-B"
                      Negar un AND convierte el AND en OR.

        Segunda Ley:  !(A || B)  es equivalente a  !A && !B
                      "NO (A o B)"  =>  "NO-A y NO-B"
                      Negar un OR convierte el OR en AND.

    ¿Para qué sirven?
        Son útiles para convertir condiciones de "cuando algo es válido" a
        "cuando algo es inválido" sin perder la lógica correcta.
        Ejemplo: si la condición de acceso es (esMiembro && estaActivo), entonces
        la condición de rechazo correcta es (!esMiembro || !estaActivo).

    PREVENCIÓN DE NullPointerException CON CORTOCIRCUITO:
    Un NullPointerException ocurre cuando intentamos invocar un método sobre una
    variable que vale null (no apunta a ningún objeto). Es uno de los errores más
    comunes en Java.

    La solución es usar el cortocircuito lógico como "guardia de nulo" (null guard):

        Con && (AND): Si la primera condición es false, Java NO evalúa la segunda.
        Aprovechamos esto poniendo la verificación de nulo en primer lugar:
            if (texto != null && texto.length() > 0) { ... }
        Si 'texto' es null, la primera condición devuelve false y Java nunca
        llama a texto.length(), evitando el error.

        Con || (OR): Si la primera condición es true, Java NO evalúa la segunda.
        Esto se usa para proveer un valor por defecto cuando algo es null:
            String nombre = (entrada != null) ? entrada : "Desconocido";

    Este patrón es práctica estándar en código profesional Java.
*/

import java.util.Scanner;

public class LogicalOperators {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // === EJEMPLO 1: operador && (AND) ===
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        System.out.print("Ingrese su salario mensual: ");
        double salario = scanner.nextDouble();

        if (edad >= 18 && salario >= 5000) {
            System.out.println("Calificas para el prestamo.");
        } else {
            System.out.println("No calificas para el prestamo.");
        }

        /*
            && se usa cuando AMBAS condiciones deben cumplirse.
            Si una sola es falsa, no entra al if.
        */

        // === EJEMPLO 2: operador || (OR) ===
        System.out.print("¿Tienes membresia premium? (true/false): ");
        boolean premium = scanner.nextBoolean();

        System.out.print("¿Tienes invitacion especial? (true/false): ");
        boolean invitacion = scanner.nextBoolean();

        if (premium || invitacion) {
            System.out.println("Acceso al evento concedido.");
        } else {
            System.out.println("Acceso denegado.");
        }

        /*
            || se usa cuando AL MENOS UNA condicion debe cumplirse.
        */

        // === EJEMPLO 3: operador ! (NOT) ===
        System.out.print("¿Eres menor de edad? (true/false): ");
        boolean menor = scanner.nextBoolean();

        if (!menor) {
            System.out.println("Eres mayor de edad.");
        }

        /*
            ! invierte el valor: !true es false, y !false es true.
            Se usa para negar una condición o simplificar la lógica de acceso.
        */

        // === EJEMPLO 4: LEYES DE DE MORGAN ===
        System.out.println("\n--- Leyes de De Morgan ---");

        boolean A = true;
        boolean B = false;

        // Primera Ley: !(A && B) es equivalente a (!A || !B)
        boolean ley1_original    = !(A && B);   // NOT (true AND false) = NOT false = true
        boolean ley1_equivalente = (!A || !B);  // (false OR true)               = true
        System.out.println("!(A && B)   = " + ley1_original);
        System.out.println("!A || !B    = " + ley1_equivalente);
        System.out.println("¿Son iguales? -> " + (ley1_original == ley1_equivalente)); // true

        // Segunda Ley: !(A || B) es equivalente a (!A && !B)
        boolean ley2_original    = !(A || B);   // NOT (true OR false) = NOT true = false
        boolean ley2_equivalente = (!A && !B);  // (false AND true)              = false
        System.out.println("!(A || B)   = " + ley2_original);
        System.out.println("!A && !B    = " + ley2_equivalente);
        System.out.println("¿Son iguales? -> " + (ley2_original == ley2_equivalente)); // true

        // === EJEMPLO 5: PREVENCIÓN DE NullPointerException (null guard) ===
        System.out.println("\n--- Guardia de Nulo (Null Guard) ---");

        String textoIngresado = null; // Simulamos una variable sin valor asignado

        // MAL: esto lanzaría NullPointerException porque textoIngresado es null
        // if (textoIngresado.length() > 0) { ... }  // ¡ERROR!

        // BIEN: verificamos que no sea null ANTES de acceder a su método
        // Gracias al cortocircuito &&, si la primera condición es false,
        // Java NO evalúa la segunda, evitando el error.
        if (textoIngresado != null && textoIngresado.length() > 0) {
            System.out.println("El texto es: " + textoIngresado);
        } else {
            System.out.println("El texto es nulo o está vacío. (Sin error gracias al null guard)");
        }

        // Ahora con un valor real para ver la diferencia:
        textoIngresado = "Hola, Java";
        if (textoIngresado != null && textoIngresado.length() > 0) {
            System.out.println("El texto es: " + textoIngresado);
        }

        scanner.close(); // buena practica
    }
}
