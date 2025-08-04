/*
    CLASE 5 - Uso de los operadores logicos en las estructuras de seleccion

    ¿QUE SON LOS OPERADORES LOGICOS?
    Son simbolos que permiten combinar condiciones booleanas (true o false).

    ¿PARA QUE SE USAN?
    Para tomar decisiones complejas donde se necesita verificar
    MAS DE UNA CONDICION a la vez dentro de un if, else if o switch.

    OPERADORES DISPONIBLES:
        1) && (AND): todas las condiciones deben ser verdaderas
        2) || (OR): al menos UNA condicion debe ser verdadera
        3) !  (NOT): invierte el valor booleano de una condicion
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
            Se usa para negar una condicion.
        */

        scanner.close(); // buena practica
    }
}
