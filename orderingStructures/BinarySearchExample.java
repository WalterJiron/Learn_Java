public class BinarySearchExample {
    // Busqueda binaria iterativa en un arreglo ordenado
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            // Calcular mid evitando overflow
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) { return mid; } // elemento encontrado

            if (arr[mid] < key) { low = mid + 1; } // buscar en mitad derecha

            else { high = mid - 1; } // buscar en mitad izquierda
        }

        return -1; // no encontrado
    }

    public static void main(String[] args) {
        int[] datos = {2, 3, 4, 10, 40};
        int key = 10;
        int resultado = binarySearch(datos, key);

        System.err.println(
                (resultado == -1) ?
                        "El elemento no está presente en el arreglo" :
                        "El elemento se encuentra en el índice: " + resultado
        );
    }
}
