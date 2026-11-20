public class Metodos {
    public void sortBubble(int[] lista) {
        if (lista == null || lista.length <= 1) {
            return;
        }
        for (int i = 0; i < lista.length - 1; i++) {
            boolean cambio = false;
            //FOR J
            for (int j = 0; j < lista.length - i - 1; j++) {
                if (lista[j] > lista[j + 1]) {
                    int aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux;
                    cambio = true;
                }
            }
            if (!cambio) {
                break;
            }
        }
    }
}