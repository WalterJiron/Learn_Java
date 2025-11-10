public class BusquedaLineal {

    public static int busquedaLineal(int[] array, int objetivo) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == objetivo) {
                return i; // Encontrado, devuelve la posicion
            }
        }
        return -1; // No encontrado
    }

    public static void main(String[] args) {
        int[] numeros = {4, 2, 8, 1, 9, 5, 7};
        int buscar = 9;

        System.out.println("Array: " + java.util.Arrays.toString(numeros));
        System.out.println("Buscando: " + buscar);

        int resultado = busquedaLineal(numeros, buscar);

        if (resultado != -1) {
            System.out.println("Encontrado en posicion: " + resultado);
        } else {
            System.out.println("No encontrado");
        }

        // Buscar un numero que no existe
        buscar = 3;
        resultado = busquedaLineal(numeros, buscar);
        System.out.println("\nBuscando: " + buscar);
        System.out.println("Resultado: " + (resultado == -1 ? "No encontrado" : "Encontrado"));
    }
}