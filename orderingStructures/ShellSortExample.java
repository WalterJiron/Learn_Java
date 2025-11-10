public class ShellSortExample {
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Empezar con un gap grande y reducirlo progresivamente
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Realizar un "insertion sort" con el gap actual
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                // Mover elementos que son mayores que temp
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                // Colocar temp en su ubicación correcta
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] datos = {12, 34, 54, 2, 3};
        shellSort(datos);
        // Imprimir arreglo ordenado
        for (int num : datos) {
            System.out.print(num + " ");
        }
    }
}
