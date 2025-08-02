/*
    CLASE 5 - Uso de operadores ternarios

    ¿QUE ES EL OPERADOR TERNARIO?
        Es una forma compacta de escribir una estructura if-else en una sola linea.
        En lugar de escribir varias lineas con if y else, podemos tomar una decision simple usando una sola linea.

    ¿PARA QUE SIRVE?
        - Para simplificar decisiones simples que asignan valores o imprimen resultados.
        - Mejora la legibilidad en casos cortos.
        - Se puede usar para imprimir, asignar variables o construir cadenas.

    SINTAXIS GENERAL:
        condicion ? valor_si_verdadero : valor_si_falso;

    EQUIVALENTE A:

        if (condicion) {
            x = valor_si_verdadero;
        } else {
            x = valor_si_falso;
        }

    ¿CUANDO USARLO?
        - Cuando solo hay UNA condicion simple
        - Cuando solo se quiere imprimir o asignar UN valor
        - Cuando queres reducir la cantidad de lineas sin perder claridad

    ¿CUANDO EVITARLO?
        - Cuando hay multiples condiciones o muchas instrucciones dentro del if/else
        - Cuando la logica es compleja y usar ternario la hace confusa

    EJEMPLOS EN ESTA CLASE:
        1) Determinar si una persona es mayor de edad
        2) Aplicar un descuento si el usuario es premium
        3) Imprimir directamente con una condicion en el mismo println
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

        scanner.close(); // buena practica cerrar el Scanner al final
    }
}
