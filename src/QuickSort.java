public class QuickSort {

    // 1. Punto de entrada (el único que llamas desde App.java)
    public void sort(int[] lista) {
        if (lista == null || lista.length <= 1) {
            return;
        }
        quickSort(lista, 0, lista.length - 1);
    }

    // 2. Divide el arreglo y se llama a sí mismo para cada mitad
    private void quickSort(int[] lista, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionar(lista, inicio, fin);

            // Ordena los que quedaron a la izquierda del pivote
            quickSort(lista, inicio, indicePivote - 1);

            // Ordena los que quedaron a la derecha del pivote
            quickSort(lista, indicePivote + 1, fin);
        }
    }

    // 3. Acomoda menores a la izquierda, mayores a la derecha y ubica el pivote
    private int particionar(int[] lista, int inicio, int fin) {
        int pivote = lista[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (lista[j] <= pivote) {
                i++;
                intercambiar(lista, i, j);
            }
        }

        intercambiar(lista, i + 1, fin);
        return i + 1;
    }

    // 4. Cambia de posición dos números en el arreglo
    private void intercambiar(int[] lista, int a, int b) {
        int aux = lista[a];
        lista[a] = lista[b];
        lista[b] = aux;
    }
}