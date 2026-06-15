/*
    CLASE 3 - Tipos de operadores en Java

    ¿QUÉ SON LOS OPERADORES?
    Son símbolos que permiten realizar operaciones aritméticas, lógicas o de comparación 
    entre variables o valores.

    TIPOS DE OPERADORES QUE VAMOS A VER:
        1) Aritméticos      -> Operaciones matemáticas (+, -, *, /, %, ++, --)
        2) Relacionales     -> Comparaciones (devuelven boolean: >, <, ==, !=, >=, <=)
        3) Lógicos          -> Combinan condiciones (&&, ||, !)
        4) Asignación       -> Asignan y actualizan valores (=, +=, -=, *=, /=, %=)
        5) Concatenación    -> Unen cadenas de texto (+)

    CONCEPTOS CLAVE COMPLEMENTARIOS:

    A) PRECEDENCIA DE OPERADORES:
       Determina el orden en el que Java evalúa una expresión mixta. El orden de mayor a menor prioridad es:
       1. Paréntesis `()` (¡Siempre evalúan primero!)
       2. Incremento/Decremento unario y negación (`++`, `--`, `!`)
       3. Multiplicación, División y Residuo (`*`, `/`, `%`)
       4. Suma y Resta (`+`, `-`)
       5. Relacionales (`>`, `>=`, `<`, `<=`)
       6. Igualdad (`==`, `!=`)
       7. Lógico AND (`&&`)
       8. Lógico OR (`||`)
       9. Asignaciones y operaciones compuestas (`=`, `+=`, `-=`, etc.)

    B) EVALUACIÓN DE CORTOCIRCUITO (Short-Circuit Evaluation):
       Los operadores lógicos `&&` y `||` son eficientes al evaluar condiciones:
       - Para `&&` (AND): Si el primer operando es false, el resultado final será false de todos modos,
         por lo que Java NO evalúa el segundo operando.
       - Para `||` (OR): Si el primer operando es true, el resultado final será true de todos modos,
         por lo que Java NO evalúa el segundo operando.

    C) INCREMENTO Y DECREMENTO (Prefijo vs Postfijo):
       - `x++` (Post-incremento): Devuelve el valor original de `x` y LUEGO incrementa `x` en 1.
       - `++x` (Pre-incremento): Incrementa `x` en 1 primero, y LUEGO devuelve el nuevo valor de `x`.

    D) DIVISIÓN POR CERO:
       - En números enteros: Dividir por 0 (ej. 10 / 0) provoca un error de ejecución inmediato
         llamado `ArithmeticException: / by zero`.
       - En números decimales: Dividir por 0.0 (ej. 10.0 / 0.0) NO da error, sino que produce valores especiales
         definidos por el estándar IEEE 754: `Infinity`, `-Infinity` o `NaN` (Not a Number, por ejemplo al dividir 0.0 / 0.0).

    E) ORDEN EN CONCATENACIÓN DE TEXTO:
       - La evaluación de la suma (+) ocurre de izquierda a derecha.
       - Si el primer operando es numérico y el segundo también, se realiza la suma matemática.
       - En cuanto se encuentra una cadena String, el operador + pasa a comportarse como concatenador de texto,
         e interpreta todo el resto de valores siguientes como texto.
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

        // Demostración de División por Cero
        double divisionPorCeroDouble = (double) a / 0.0;
        System.out.println("Division por 0.0 (double): " + divisionPorCeroDouble); // Imprime Infinity
        System.out.println("Division de 0.0 / 0.0 (double): " + (0.0 / 0.0));     // Imprime NaN
        // Nota: Si intentáramos "a / 0" con enteros, el programa fallaría con una ArithmeticException.


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

        String nombre = "Walter";
        String saludo = "\nHola, " + nombre + "!";
        System.out.println(saludo);

        // Demostración del orden de evaluación en la concatenación:
        // Evaluado de izquierda a derecha: 5 + 5 se suma matemáticamente (= 10), luego se concatena con el String.
        System.out.println("5 + 5 + \" texto\" = " + (5 + 5 + " texto")); // Imprime "10 texto"
        
        // Evaluado de izquierda a derecha: "texto " + 5 se convierte en String ("texto 5"), luego + 5 da ("texto 55").
        System.out.println("\"texto \" + 5 + 5 = " + ("texto " + 5 + 5)); // Imprime "texto 55"

        // === 6. OPERADORES DE INCREMENTO Y DECREMENTO (PREFIJO VS POSTFIJO) ===
        int c = 5;
        System.out.println("\n--- Operadores de Incremento ---");
        System.out.println("Valor inicial de c: " + c);
        
        // Post-incremento (c++): Primero se usa el valor en la expresión, luego se incrementa la variable.
        System.out.println("c++ (post-incremento): " + (c++)); // Imprime 5, pero c pasa a ser 6
        System.out.println("Valor de c despues de c++: " + c); // Imprime 6

        // Pre-incremento (++c): Primero se incrementa la variable, luego se usa el valor en la expresión.
        System.out.println("++c (pre-incremento): " + (++c));   // c pasa a ser 7, imprime 7
        System.out.println("Valor de c despues de ++c: " + c); // Imprime 7

        // === 7. PRECEDENCIA DE OPERADORES ===
        System.out.println("\n--- Precedencia de Operadores ---");
        // La multiplicación (*) tiene mayor prioridad que la suma (+):
        int resultadoSinParentesis = 5 + 3 * 2;   // 5 + (3 * 2) = 11
        int resultadoConParentesis = (5 + 3) * 2; // (8) * 2 = 16
        System.out.println("Resultado de 5 + 3 * 2 = " + resultadoSinParentesis);
        System.out.println("Resultado de (5 + 3) * 2 = " + resultadoConParentesis);

        // === 8. EVALUACIÓN DE CORTOCIRCUITO LÓGICO ===
        System.out.println("\n--- Evaluación de Cortocircuito ---");
        boolean condicion1 = false;
        boolean condicion2 = true;
        
        // En un AND (&&), si el primer valor es false, el segundo no se evalúa (porque el resultado ya es false).
        boolean resultadoAnd = condicion1 && condicion2;
        System.out.println("condicion1 && condicion2 = " + resultadoAnd);

        // En un OR (||), si el primer valor es true, el segundo no se evalúa (porque el resultado ya es true).
        boolean resultadoOr = condicion2 || condicion1;
        System.out.println("condicion2 || condicion1 = " + resultadoOr);
    }
}
