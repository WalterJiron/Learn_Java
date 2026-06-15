/*
    CLASE 4 - Tipos de selección en Java

    ¿QUÉ SON LAS ESTRUCTURAS DE SELECCIÓN?
    Son instrucciones que permiten que un programa tome decisiones.
    Es decir, que elija ejecutar un bloque de código u otro dependiendo de si se cumple una condición (true o false).

    ¿PARA QUÉ SIRVEN?
        - Para controlar el flujo del programa
        - Para responder de forma distinta según los datos de entrada
        - Para comparar valores y ejecutar diferentes bloques de código

    ¿CUÁNDO USARLAS?
    Cuando querés evaluar una situación que puede tener una o varias respuestas posibles.

    TIPOS DE SELECCIÓN:

        1) SELECCIÓN SIMPLE (if):
           - El bloque de código solo se ejecuta si la condición es verdadera.
           - Si es falsa, el programa continúa sin hacer nada.
           Ejemplo:
               if (edad >= 18) {
                   System.out.println("Eres mayor de edad");
               }

        2) SELECCIÓN DOBLE (if...else):
           - Se ejecuta un bloque si la condición es verdadera, o el otro si es falsa.
           Ejemplo:
               if (nota >= 60) {
                   System.out.println("Aprobado");
               } else {
                   System.out.println("Reprobado");
               }

        3) SELECCIÓN MÚLTIPLE (if...else if...else o switch):
           - Permite manejar varias condiciones posibles evaluadas en orden.
           - En cuanto una condición se cumple, se ejecuta su bloque y se ignoran las demás.
           Ejemplo:
               if (nota >= 90) {
                   System.out.println("Excelente");
               } else if (nota >= 70) {
                   System.out.println("Aprobado");
               } else {
                   System.out.println("Reprobado");
               }

        4) SELECCIONES ANIDADAS:
           - Es posible colocar un if dentro de otro if. Esto se llama "anidación".
           - Se utiliza cuando una segunda condición solo tiene sentido evaluarla si
             la primera ya resultó verdadera.
           - Buena práctica: no anidar más de 2-3 niveles para mantener la legibilidad.
           Ejemplo:
               if (tieneEdad) {
                   if (estaRegistrado) {
                       System.out.println("Puede votar.");
                   } else {
                       System.out.println("Debe registrarse primero.");
                   }
               }

    COMPARACIÓN DE STRINGS: == vs .equals()
    ¡Importante! En Java los Strings son OBJETOS, no tipos primitivos.
    Existen dos formas de comparar Strings:

        - '==' compara REFERENCIAS: verifica si ambas variables apuntan al MISMO
          objeto en memoria (misma dirección), NO si tienen el mismo contenido.
        - '.equals()' compara CONTENIDO: verifica si el texto de ambos Strings
          es igual, independientemente de dónde están almacenados en memoria.

    ¿Qué es el String Pool?
        Java optimiza la memoria guardando literales de texto en una zona especial
        llamada "String Pool". Si dos variables tienen el mismo texto literal,
        pueden compartir la misma referencia en el Pool. Sin embargo, Strings
        creados dinámicamente (ej. con new String(...) o con Scanner) SIEMPRE
        se guardan en el Heap con una nueva referencia única.
        Esto hace que '==' pueda dar resultados inesperados con Strings.
        Regla de oro: para comparar contenido de Strings, SIEMPRE usa .equals().

    SWITCH MODERNO (Switch Expressions - Java 12+)
    El switch clásico tiene un peligro llamado "fall-through": si olvidás el
    'break', el programa ejecuta el caso siguiente también, sin que lo quieras.
    Desde Java 12+, se puede usar la sintaxis de FLECHA (->), que:
        - Elimina la necesidad de 'break'.
        - Previene el fall-through por diseño.
        - Permite asignar el resultado del switch directamente a una variable.
        - Soporta múltiples valores en un mismo 'case' separados por comas.
    Ejemplo:
        String dia = switch (numero) {
            case 1 -> "Lunes";
            case 2, 3 -> "Martes o Miércoles";
            default -> "Otro día";
        };

    OPERADORES DE COMPARACIÓN MÁS USADOS:
        1) ==  igual (solo para primitivos o referencias exactas)
        2) !=  distinto
        3) >   mayor
        4) <   menor
        5) >=  mayor o igual
        6) <=  menor o igual
*/


import java.util.Scanner;

public class SelectionsTypes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // === IF SIMPLE ===
        // Solo se ejecuta si la condicion es verdadera
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        if (edad >= 18) {
            System.out.println("Eres mayor de edad.");
        }

        /*
            ¿Que pasa si edad es menor a 18?
            No se imprime nada porque no hay "else".
            Este tipo de estructura se usa cuando solo te interesa una unica condicion.
        */

        // === IF - ELSE ===
        // Se ejecuta una opcion u otra segun la condicion
        System.out.print("Ingrese una contrasena: ");
        String pass = scanner.next();

        if (pass.equals("1234")) {
            System.out.println("Acceso permitido.");
        } else {
            System.out.println("Acceso denegado.");
        }

        /*
            ¡IMPORTANTE! Se usa .equals() y NO '==' para comparar Strings.
            '==' compara si ambas variables apuntan al mismo objeto en memoria (referencia).
            .equals() compara si el contenido del texto es el mismo (valor).
            Para comparación sin distinguir mayúsculas/minúsculas, usa .equalsIgnoreCase().

            Ejemplo de por qué '==' puede fallar con Strings:
               String a = new String("hola"); // Creado en el Heap (nueva referencia)
               String b = new String("hola"); // Creado en el Heap (otra referencia)
               a == b        -> false (distintas referencias en memoria)
               a.equals(b)   -> true  (mismo contenido)
        */

        // === IF - ELSE IF - ELSE ===
        // Permite evaluar multiples condiciones en orden
        System.out.print("Ingrese su nota final (0-100): ");
        int nota = scanner.nextInt();

        if (nota >= 90) {
            System.out.println("Excelente");
        } else if (nota >= 70) {
            System.out.println("Aprobado");
        } else if (nota >= 60) {
            System.out.println("Casi apruebas");
        } else {
            System.out.println("Reprobado");
        }

        /*
            Se evalua de arriba hacia abajo y se detiene cuando una condicion se cumple.
            En cuanto una rama se ejecuta, las demas se ignoran.
        */

        // === IF ANIDADO ===
        // Un if dentro de otro if. La condicion interna solo se evalua si la externa ya fue verdadera.
        System.out.print("¿Tiene edad para votar? (true/false): ");
        boolean tieneEdad = scanner.nextBoolean();

        System.out.print("¿Está registrado en el padrón? (true/false): ");
        boolean estaRegistrado = scanner.nextBoolean();

        if (tieneEdad) {
            if (estaRegistrado) {
                System.out.println("Puede ejercer su voto.");
            } else {
                System.out.println("Tiene edad pero debe registrarse primero.");
            }
        } else {
            System.out.println("No tiene edad suficiente para votar.");
        }

        /*
            La anidación de if permite evaluar condiciones dependientes.
            Si tieneEdad es false, el bloque interno ni siquiera se evalúa.
        */

        // === SWITCH CLÁSICO ===
        // Ideal para seleccionar entre varios valores exactos (enteros, chars, enums, Strings)
        System.out.print("Ingrese el numero del dia (1 a 7): ");
        int dia = scanner.nextInt();

        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sabado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Dia invalido");
                break;
        }

        /*
            El 'break' es obligatorio en el switch clásico para evitar el "fall-through":
            sin el break, el programa continua ejecutando los casos siguientes
            aunque no correspondan, hasta encontrar un break o llegar al final.
        */

        // === SWITCH MODERNO - SINTAXIS DE FLECHA (Java 12+) ===
        // No necesita 'break'. El resultado puede asignarse directamente a una variable.
        String nombreDia = switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miercoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sabado";
            case 7 -> "Domingo";
            default -> "Dia invalido";
        };
        System.out.println("Dia (switch moderno): " + nombreDia);

        // Con el switch moderno también se pueden agrupar varios casos en una sola línea:
        String tipoDia = switch (dia) {
            case 1, 2, 3, 4, 5 -> "Día de semana";
            case 6, 7 -> "Fin de semana";
            default -> "Inválido";
        };
        System.out.println("Tipo de día: " + tipoDia);

        /*
            El switch moderno (Java 12+) es más seguro y conciso:
            - No hay riesgo de fall-through.
            - No se necesita 'break'.
            - El resultado se puede guardar en una variable.
        */

        scanner.close(); // Cerramos el Scanner como buena practica
    }
}
