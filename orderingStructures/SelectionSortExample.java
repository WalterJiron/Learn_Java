public class SelectionSortExample {

    // Metodo para aplicar el ordenamiento por selección
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Buscar el índice del elemento mínimo
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Intercambiar el elemento mínimo con el actual
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numeros = {29, 10, 14, 37, 13};
        System.out.println("Arreglo original:");
        for (int num : numeros)
            System.out.print(num + " ");

        selectionSort(numeros);

        System.out.println("\nArreglo ordenado:");
        for (int num : numeros)
            System.out.print(num + " ");
    }
}
