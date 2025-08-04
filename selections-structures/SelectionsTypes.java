/*
    CLASE 4 - Tipos de seleccion en Java

    ¿QUE SON LAS ESTRUCTURAS DE SELECCION?
    Son instrucciones que permiten que un programa tome decisiones.
    Es decir, que elija ejecutar un bloque de codigo u otro dependiendo de si se cumple una condicion (true o false).

    ¿PARA QUE SIRVEN?
        - Para controlar el flujo del programa
        - Para responder de forma distinta segun los datos de entrada
        - Para comparar valores y ejecutar diferentes bloques de codigo

    ¿CUANDO USARLAS?
    Cuando queres evaluar una situacion que puede tener una o varias respuestas posibles

    TIPOS DE SELECCION:

        1) SELECCION SIMPLE:
           - Se utiliza solo un "if"
           - El bloque de codigo solo se ejecuta si la condicion es verdadera
           - Si la condicion es falsa, el programa simplemente sigue

               Ejemplo:
               if (edad >= 18) {
                   System.out.println("Eres mayor de edad");
               }

        2) SELECCION DOBLE:
           - Usa "if...else"
           - Se ejecuta un bloque si la condicion es verdadera, o el otro si es falsa

               Ejemplo:
               if (nota >= 60) {
                   System.out.println("Aprobado");
               } else {
                   System.out.println("Reprobado");
               }

        3) SELECCION MULTIPLE:
           - Usa "if...else if...else" o "switch"
           - Permite manejar varias condiciones posibles

               Ejemplo con if...else if:
               if (nota >= 90) {
                   System.out.println("Excelente");
               } else if (nota >= 70) {
                   System.out.println("Aprobado");
               } else {
                   System.out.println("Reprobado");
               }

               Ejemplo con switch:
               switch (opcion) {
                   case 1:
                       System.out.println("Lunes");
                       break;
                   case 2:
                       System.out.println("Martes");
                       break;
                   default:
                       System.out.println("Opcion invalida");
               }

    OPERADORES DE COMPARACION MAS USADOS:
        1) ==  igual
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
            Se usa cuando hay solo dos caminos posibles: verdadero o falso.
            Usamos equals() porque estamos comparando Strings (no se usa == con textos).
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
            Este tipo se usa cuando hay mas de dos posibilidades.
            Se evalua de arriba hacia abajo, y se detiene cuando una condicion se cumple.
        */

        // === SWITCH ===
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
            Se recomienda usar switch cuando estas comparando un valor fijo contra varias opciones conocidas.
            El "break" es obligatorio para evitar que los siguientes casos se ejecuten.
        */

        scanner.close(); // Cerramos el Scanner como buena practica
    }
}
