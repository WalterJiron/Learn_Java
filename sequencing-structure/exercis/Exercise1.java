/*
     RETO 1: Detecta los tipos y corrige errores
    Lee el siguiente fragmento de código y:

        1) Identificá el tipo de cada variable

        2) Decime si hay algún error o mala práctica

        3) Proponé una mejor versión si encontrás algo mejorable
*/

package exercis; // Por que usar esto
/*
    Explicacion:

    Cuando un archivo .java esta dentro de una carpeta que no es la principal, se declara
    'package NombreDirectorioSecundario;' al inicio del archivo porque:

    1. Organizacion:
       - Los packages corresponden fisicamente a carpetas en la estructura de directorios
       - Mantienen el codigo organizado y modularizado

    2. Namespace:
       - Evita conflictos de nombres entre clases
       - Permite tener clases con mismo nombre en packages diferentes

    3. Control de acceso:
       - Ayuda a gestionar la visibilidad de clases mediante modificadores
       - Las clases en mismo package tienen acceso especial entre ellas

    4. Requisito de Java:
       - Cuando una clase esta en carpeta, debe declarar su package correspondiente
       - El compilador espera esta correspondencia entre package y estructura de directorios

    Nota: El nombre del package DEBE coincidir exactamente con la ruta de carpetas
    desde el directorio raiz del proyecto.
*/

public class Exercise1 {
    public static void main(String[] args) {
        var edad = 25;
        var nombre = "Luis";
        var altura = 1.8;
        System.out.print("Hola " + nombre + ", tu edad es: " + edad + " y mides: " + altura);

    }
}
