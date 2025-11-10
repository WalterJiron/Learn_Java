public class QuickSortExample {
    // Particiona el arreglo y devuelve el índice final del pivote
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // elegir el último elemento como pivote
        int i = low - 1; // índice del elemento menor

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual que el pivote, intercambiarlo
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Colocar el pivote en la posición correcta
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // QuickSort recursivo
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Particionar y obtener el índice del pivote
            int pi = partition(arr, low, high);
            // Ordenar recursivamente las dos particiones
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] datos = {10, 7, 8, 9, 1, 5};
        quickSort(datos, 0, datos.length - 1);
        // Imprimir arreglo ordenado
        for (int num : datos) {
            System.out.print(num + " ");
        }
    }
}
