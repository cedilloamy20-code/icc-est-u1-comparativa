import java.util.List;

public class Metodos {
    public void sortBubble(int [] lista) {
        for (int i = 0; i < lista.length; i++) {
            boolean cambio = false;
            //FOR J
            for (int j = 0; j < lista.length - i - 1; j++) {
                if (lista[j] > lista[j + 1] ) {
                    int aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux  ;
                    cambio = true;
                }
            }
            if (!cambio) {
                break;
            }
        }
    }
}