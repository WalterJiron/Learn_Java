public class BubbleSortExample {

    // Metodo para aplicar el ordenamiento burbuja
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Recorre todo el arreglo
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Comparaciones adyacentes
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambio de elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Si no hubo intercambios, el arreglo ya está ordenado
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] numeros = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Arreglo original:");
        for (int num : numeros)
            System.out.print(num + " ");

        bubbleSort(numeros);

        System.out.println("\nArreglo ordenado:");
        for (int num : numeros)
            System.out.print(num + " ");
    }
}
