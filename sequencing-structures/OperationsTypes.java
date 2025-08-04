/*
    CLASE 3 - Tipos de operadores en Java

    ¿QUE SON LOS OPERADORES?
    Son simbolos que permiten realizar operaciones entre variables o valores.
    Existen varios tipos, cada uno con su proposito.

    TIPOS DE OPERADORES QUE VAMOS A VER:

        1) Aritmeticos  ->  Operaciones matematicas
        2) Relacionales ->  Comparaciones (devuelven true o false)
        3) Logicos  ->  Combinan condiciones (se usan en if)
        4) Asignacion   ->  Asignan valores
        5) Concatenacion    ->  Unen cadenas de texto
*/

import java.util.Scanner;

public class OperationsTypes {
    public static void main(String[] args) {
        // === 1. OPERADORES ARITMETICOS ===
        int a = 10;
        int b = 3;

        System.out.println("Suma: " + (a + b));            // 13
        System.out.println("Resta: " + (a - b));           // 7
        System.out.println("Multiplicacion: " + (a * b));  // 30

        /*
            DIVISION ENTRE ENTEROS:
            Si ambos operandos son enteros (int), Java hace una division entera.
            Es decir, NO incluye decimales. El resultado se redondea hacia abajo.

            Ejemplo: 10 / 3 = 3 (NO 3.33)
        */

        System.out.println("Division entera (a / b): " + (a / b)); // 3

        /*
            Para obtener un resultado decimal (3.33...), al menos uno de los dos operandos
            debe ser tipo float o double. Podemos hacer un "cast" (conversion de tipo).
        */

        System.out.println("Division decimal: " + ((float) a / b)); // 3.333...

        /*
            IMPORTANTE:
            - (float)(a / b) -> primero hace la division entera y luego convierte el 3 a 3.0 → MAL
            - (float)a / b   -> convierte 'a' a float antes de dividir -> BIEN
        */

        System.out.println("Residuo: " + (a % b)); // 1


        // === 2. OPERADORES RELACIONALES (devuelven boolean) ===

        // a es MAYOR QUE b
        System.out.println("\na > b: " + (a > b));   // true

        // a es MENOR QUE b
        System.out.println("a < b: " + (a < b));   // false

        // a is IGUAL a b
        System.out.println("a == b: " + (a == b)); // false

        // a es DIFERENTE que b
        System.out.println("a != b: " + (a != b)); // true

        // a es MAYOR O IGUAL QUE b
        System.out.println("a >= b: " + (a >= b)); // true

        // a es MENOR O IGUAL QUE b
        System.out.println("a <= b: " + (a <= b)); // false

        // === 3. OPERADORES LOGICOS ===
        /*
            Los operadores logicos se utilizan para combinar o negar condiciones booleanas.
            Siempre devuelven un resultado de tipo boolean (true o false).

            - && (AND): Devuelve true solo si AMBAS condiciones son verdaderas.
            - || (OR): Devuelve true si AL MENOS UNA condicion es verdadera.
            - !  (NOT): Invierte el valor booleano (true → false, false → true)

            Se usan principalmente dentro de estructuras condicionales como if/else.
        */

        boolean x = true;
        boolean y = false;

        System.out.println("\nx && y: " + (x && y)); // false (solo una es true)
        System.out.println("x || y: " + (x || y)); // true (al menos una es true)
        System.out.println("!x: " + (!x));         // false (niega el valor de x)

        // === 4. OPERADORES DE ASIGNACION ===
        /*
            El operador '=' se usa para asignar un valor a una variable.

            Ejemplo:
            int edad = 25; // la variable edad recibe el valor 25

            Existen combinaciones de asignacion que simplifican operaciones:
            - += : suma y asigna       -> x += 5;  (x = x + 5)
            - -= : resta y asigna      -> x -= 2;
            - *= : multiplica y asigna -> x *= 3;
            - /= : divide y asigna     -> x /= 2;
            - %= : modulo y asigna     -> x %= 4;

            Estas expresiones son utiles para actualizar el valor de una variable sin reescribir todo.
        */

        int numero = 5;
        numero += 3; // ahora numero es 8
        System.out.println("\nnumero += 3: " + numero);

        numero *= 2; // ahora numero es 16
        System.out.println("numero *= 2: " + numero);

        // Ejemplo adicional con saldo
        int saldo = 100;
        saldo += 50; // suma 50 -> 150
        saldo -= 20; // resta 20 -> 130
        System.out.println("Saldo final: " + saldo);

        // === 5. OPERADOR DE CONCATENACION ===
        /*
            El operador '+' tambien se puede usar para unir cadenas de texto (Strings).
            Si uno de los elementos es String, Java convierte lo demas a texto automaticamente.
        */

        String nombre = "\nWalter";
        String saludo = "Hola, " + nombre + "!";
        System.out.println(saludo);
    }
}
