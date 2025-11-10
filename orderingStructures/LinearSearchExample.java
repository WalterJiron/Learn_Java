public class LinearSearchExample {
    // Busqueda lineal en un arreglo
    public static int linearSearch(int[] arr, int key) {
        // Recorrer cada elemento
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // encontrado
            }
        }
        return -1; // no encontrado
    }

    public static void main(String[] args) {
        int[] datos = {10, 20, 30, 40, 50};
        int key = 30;
        int index = linearSearch(datos, key);
        if (index == -1) {
            System.out.println("Elemento no encontrado");
        } else {
            System.out.println("Elemento encontrado en índice: " + index);
        }
    }
}
