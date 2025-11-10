public class HeapSortExample {
    // Convierte el subárbol con raiz en i en un Max-Heap
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;       // Inicializar mas grande como raíz
        int left = 2 * i + 1;  // índice del hijo izquierdo
        int right = 2 * i + 2; // índice del hijo derecho

        // Si el hijo izquierdo existe y es mayor que la raiz
        if (left < n && arr[left] > arr[largest]) { largest = left; }

        // Si el hijo derecho existe y es mayor que el más grande actual
        if (right < n && arr[right] > arr[largest]) { largest = right; }

        // Si el más grande no es la raíz, intercambiarlos y heapify recursivamente
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Construir un Max-Heap (reordenando el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--) { heapify(arr, n, i); }

        // Extraer elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Llamar heapify sobre la raíz reducida
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] datos = { 12, 11, 13, 5, 6, 7};
        heapSort(datos);
        // Imprimir arreglo ordenado
        for (int num : datos) {
            System.out.print(num + " ");
        }
    }
}
