/*
    CLASE 6 - Uso de operadores ternarios

    ¿QUÉ ES EL OPERADOR TERNARIO?
        Es una forma compacta de escribir una estructura if-else en una sola línea.
        En lugar de escribir varias líneas con if y else, podemos tomar una decisión
        simple usando tres partes: condición, valor si verdadero, y valor si falso.
        Se llama "ternario" porque trabaja con TRES operandos.

    SINTAXIS GENERAL:
        condicion ? valor_si_verdadero : valor_si_falso

    EQUIVALENTE A:
        if (condicion) {
            x = valor_si_verdadero;
        } else {
            x = valor_si_falso;
        }

    ¿CUÁNDO USARLO?
        - Cuando hay UNA sola condición simple.
        - Cuando solo se quiere imprimir o asignar UN valor en cada rama.
        - Cuando querés reducir líneas sin perder claridad.

    ¿CUÁNDO EVITARLO?
        - Cuando hay múltiples condiciones o muchas instrucciones por rama.
        - Cuando la lógica es compleja (usar if/else es más legible).

    COMPATIBILIDAD DE TIPOS:
        Las dos ramas del operador ternario (valor_si_verdadero y valor_si_falso)
        deben ser de tipos compatibles, porque el resultado se asigna a UNA variable.
        Java intenta promocionar automáticamente el tipo menor al mayor:
            - Si una rama es int y la otra double, el int se convierte a double.
            - Si los tipos son completamente incompatibles (ej. String e int sin conversión),
              el compilador lanzará un error.
        Ejemplo válido:
            double resultado = true ? 5 : 3.14; // 5 (int) se promueve a 5.0 (double)

    TERNARIOS ANIDADOS (Encadenados):
        Es posible colocar un operador ternario dentro de otro. Funciona igual que
        un if...else if...else, evaluando condiciones en cadena.

        Sintaxis:
            condicion1 ? "A" : condicion2 ? "B" : "C"

        ¡ADVERTENCIA! Anidar más de dos ternarios es considerado mala práctica
        porque el código se vuelve muy difícil de leer y mantener.
        Como regla general:
            - 1 ternario: perfecto, claro y conciso.
            - 2 ternarios anidados: aceptable con cuidado y buenos nombres.
            - 3+ ternarios anidados: reemplazá por if-else o switch.

    EJEMPLOS EN ESTA CLASE:
        1) Determinar si una persona es mayor de edad.
        2) Aplicar un descuento si el usuario es premium.
        3) Imprimir directamente con una condición en el mismo println.
        4) Compatibilidad de tipos en el resultado del ternario.
        5) Ternario anidado para clasificar una nota (y su equivalente if-else).
*/

import java.util.Scanner;

public class TernaryOperators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // === EJEMPLO 1: determinar si es mayor de edad ===
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        // Usamos operador ternario para decidir entre dos posibles cadenas
        // Si edad >= 18, resultado = "Mayor de edad", si no, "Menor de edad"
        String resultado = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
        System.out.println("Resultado: " + resultado);

        // === EJEMPLO 2: aplicar descuento ===
        System.out.print("¿Tiene membresia premium? (true/false): ");
        boolean premium = scanner.nextBoolean();

        double precioOriginal = 100.0;

        // Si tiene membresia premium, se aplica un descuento: paga 80
        // Si no tiene, paga el precio completo
        double precioFinal = premium ? 80.0 : precioOriginal;

        System.out.printf("Precio a pagar: %.2f\n", precioFinal);

        // === EJEMPLO 3: resultado directo dentro de println ===
        // Se imprime directamente uno u otro mensaje segun el valor de premium
        System.out.println(premium ? "Gracias por ser cliente premium" : "Gracias por tu compra");

        // === EJEMPLO 4: compatibilidad de tipos en el ternario ===
        System.out.println("\n--- Compatibilidad de tipos ---");
        // Una rama es int (5) y la otra es double (3.14).
        // Java promueve automáticamente el int a double para que los tipos sean compatibles.
        double resultadoTipos = true ? 5 : 3.14;
        System.out.println("true ? 5 : 3.14  ->  " + resultadoTipos); // Imprime 5.0 (el int se convirtió a double)

        // === EJEMPLO 5A: ternario anidado en 2 niveles ===
        // Un ternario dentro del resultado FALSE de otro ternario.
        System.out.println("\n--- Ternario Anidado (2 niveles) ---");
        System.out.print("Ingrese una nota (0-100) para clasificar: ");
        int nota = scanner.nextInt();

        // Estructura del ternario anidado en 2 niveles:
        //   condicion1 ?  "resultado1"  :  condicion2 ?  "resultado2"  :  "resultado3"
        //   ─────────────────────────────  ─────────────────────────────────────────────
        //   Si nota>=90  -> "Excelente"    Si nota>=60 -> "Aprobado"   sino -> "Reprobado"
        String clasificacion = (nota >= 90) ? "Excelente"
                             : (nota >= 60) ? "Aprobado"
                             :                "Reprobado";
        System.out.println("Clasificacion: " + clasificacion);

        /*
            Su equivalente con if-else (más claro para lógicas complejas):

            if (nota >= 90) {
                clasificacion = "Excelente";
            } else if (nota >= 60) {
                clasificacion = "Aprobado";
            } else {
                clasificacion = "Reprobado";
            }
        */

        // === EJEMPLO 5B: ternario anidado en 3 niveles ===
        // Ternarios anidados dentro de ternarios dentro de ternarios.
        System.out.println("\n--- Ternario Anidado (3 niveles) ---");
        System.out.print("Ingrese otra nota (0-100) para clasificacion detallada: ");
        int notaDetallada = scanner.nextInt();

        // Estructura del ternario anidado en 3 niveles:
        //  condicion1  ?  "A"  :  condicion2  ?  "B"  :  condicion3  ?  "C"  :  "D"
        String notaDetalle = (notaDetallada >= 90) ? "Sobresaliente (90-100)"
                           : (notaDetallada >= 75) ? "Bueno (75-89)"
                           : (notaDetallada >= 60) ? "Suficiente (60-74)"
                           :                         "Reprobado (0-59)";
        System.out.println("Detalle de nota: " + notaDetalle);

        /*
            ¡ADVERTENCIA! Los ternarios de 3 o más niveles son difíciles de leer.
            Este mismo ejemplo con if-else es mucho más claro:

            String notaDetalle;
            if (notaDetallada >= 90) {
                notaDetalle = "Sobresaliente (90-100)";
            } else if (notaDetallada >= 75) {
                notaDetalle = "Bueno (75-89)";
            } else if (notaDetallada >= 60) {
                notaDetalle = "Suficiente (60-74)";
            } else {
                notaDetalle = "Reprobado (0-59)";
            }
        */

        // === EJEMPLO 5C: ternario anidado en ambas ramas (TRUE y FALSE) ===
        // Un ternario puede tener otro ternario tanto en la rama verdadera COMO en la falsa.
        System.out.println("\n--- Ternario Anidado en Ambas Ramas ---");
        boolean esMiembro = premium;  // reutilizamos la variable del ejemplo anterior
        int compras = 3;              // simulamos la cantidad de compras del usuario

        // Si es miembro: aplica descuento del 30% si tiene más de 5 compras, si no del 15%.
        // Si NO es miembro: paga precio completo si tiene más de 5 compras, si no hay recargo del 5%.
        double precio = 100.0;
        double precioFinalCalculado =
            esMiembro
                ? (compras > 5 ? precio * 0.70 : precio * 0.85)   // rama TRUE: dos opciones de descuento
                : (compras > 5 ? precio * 1.00 : precio * 1.05);   // rama FALSE: dos opciones de recargo

        System.out.printf("Precio final calculado: %.2f%n", precioFinalCalculado);

        /*
            Regla de oro para ternarios anidados:
            ─────────────────────────────────────
            1 nivel  -> Perfecto. Úsalo siempre que quieras.
            2 niveles -> Aceptable si los nombres de variable son claros.
            3+ niveles -> Evitarlo. Usa if-else o switch para mayor legibilidad.
        */

        scanner.close(); // buena practica cerrar el Scanner al final
    }
}
