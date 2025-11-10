import java.util.Arrays;

public class MergeSortExample {
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return; // Base: arreglo de tamaño 0 o 1 ya está ordenado
        }
        // Dividir el arreglo en dos mitades
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Ordenar recursivamente cada mitad
        mergeSort(left);
        mergeSort(right);

        // Fusionar las dos mitades ordenadas
        merge(arr, left, right);
    }

    // Fusiona dos subarreglos ordenados en el arreglo original
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        // Combinar elementos de left[] y right[] en arr[]
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        // Copiar elementos restantes
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] datos = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(datos);

        for (int num : datos) {
            System.out.print(num + " ");
        }
    }
}
