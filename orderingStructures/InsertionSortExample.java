public class InsertionSortExample {

    // Metodo que implementa el ordenamiento por inserción
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Mover los elementos mayores que 'key' una posición adelante
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insertar 'key' en su posición correcta
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] numeros = {12, 11, 13, 5, 6};

        System.out.println("Arreglo original:");
        for (int num : numeros)
            System.out.print(num + " ");

        insertionSort(numeros);

        System.out.println("\nArreglo ordenado:");
        for (int num : numeros)
            System.out.print(num + " ");
    }
}
