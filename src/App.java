import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Generador g = new Generador();
        Benchmark b = new Benchmark();
        Metodos m = new Metodos();
        QuickSort qs = new QuickSort();

        //los 3 arreglos base
        //1000
        int[] lista1 = Generador.generate(10000);

        //50000
        int[] lista2 = Generador.generate(50000);

        //100000
        int[] lista3 = Generador.generate(100000);

        // Referencias ordenadas fuera del cronometro para validar cada salida
        int[] ref1 = lista1.clone();
        Arrays.sort(ref1);
        int[] ref2 = lista2.clone();
        Arrays.sort(ref2);
        int[] ref3 = lista3.clone();
        Arrays.sort(ref3);

        //1-> List<List<Integer>> listas = List.of(lista1, lista2, lista3);
        //2-> List<Integer>[] listas = new List<Integer>[] {lista1};
        int[][] listas = {lista1, lista2, lista3};

        //Copias de Bubble Sort
        int[] list1c1 = lista1.clone();
        int[] list2c1 = lista2.clone();
        int[] list3c1 = lista3.clone();

        //Copias de QuickSort
        int[] list1c2 = lista1.clone();
        int[] list2c2 = lista2.clone();
        int[] list3c2 = lista3.clone();

        // Copias para (Arrays.sort con int[])
        int[] list1c3 = lista1.clone();
        int[] list2c3 = lista2.clone();
        int[] list3c3 = lista3.clone();

        // Copias para (Arrays.sort con Comparator -> debe ser Integer[])
        Integer[] list1c4 = convertirAInteger(lista1);
        Integer[] list2c4 = convertirAInteger(lista2);
        Integer[] list3c4 = convertirAInteger(lista3);

        Comparator<Integer> comparador = (a, c) -> Integer.compare(a, c);

        // Lista para guardar los 12 resultados
        List<Results> resultados = new ArrayList<>();

        //Bubble Sort
        Results benGenList = Benchmark.medir(() -> m.sortBubble(list1c1), "sortBubble", "10.000");
        validar(list1c1, ref1, "sortBubble", "10.000");
        resultados.add(benGenList);

        Results benGenList2 = Benchmark.medir(() -> m.sortBubble(list2c1), "sortBubble", "50.000");
        validar(list2c1, ref2, "sortBubble", "50.000");
        resultados.add(benGenList2);

        Results benGenList3 = Benchmark.medir(() -> m.sortBubble(list3c1), "sortBubble", "100.000");
        validar(list3c1, ref3, "sortBubble", "100.000");
        resultados.add(benGenList3);

        //QuickSort
        Results benQs1 = Benchmark.medir(() -> qs.sort(list1c2), "QuickSort", "10.000");
        validar(list1c2, ref1, "QuickSort", "10.000");
        resultados.add(benQs1);

        Results benQs2 = Benchmark.medir(() -> qs.sort(list2c2), "QuickSort", "50.000");
        validar(list2c2, ref2, "QuickSort", "50.000");
        resultados.add(benQs2);

        Results benQs3 = Benchmark.medir(() -> qs.sort(list3c2), "QuickSort", "100.000");
        validar(list3c2, ref3, "QuickSort", "100.000");
        resultados.add(benQs3);

        //Arrays.sort (int[]) -> Collectors
        Results benArr1 = Benchmark.medir(() -> Arrays.sort(list1c3), "Arrays.sort", "10.000");
        validar(list1c3, ref1, "Arrays.sort", "10.000");
        resultados.add(benArr1);

        Results benArr2 = Benchmark.medir(() -> Arrays.sort(list2c3), "Arrays.sort", "50.000");
        validar(list2c3, ref2, "Arrays.sort", "50.000");
        resultados.add(benArr2);

        Results benArr3 = Benchmark.medir(() -> Arrays.sort(list3c3), "Arrays.sort", "100.000");
        validar(list3c3, ref3, "Arrays.sort", "100.000");
        resultados.add(benArr3);

        //Arrays.sort con Comparator (Integer[]) -> Collectors V2
        Results benComp1 = Benchmark.medir(() -> Arrays.sort(list1c4, comparador), "Arrays.sort Comparator", "10.000");
        validarInteger(list1c4, ref1, "Arrays.sort Comparator", "10.000");
        resultados.add(benComp1);

        Results benComp2 = Benchmark.medir(() -> Arrays.sort(list2c4, comparador), "Arrays.sort Comparator", "50.000");
        validarInteger(list2c4, ref2, "Arrays.sort Comparator", "50.000");
        resultados.add(benComp2);

        Results benComp3 = Benchmark.medir(() -> Arrays.sort(list3c4, comparador), "Arrays.sort Comparator", "100.000");
        validarInteger(list3c4, ref3, "Arrays.sort Comparator", "100.000");
        resultados.add(benComp3);

        // Imprimir la lista completa al final
        for (Results r : resultados) {
            System.out.println(r);
        }
    }

    // Método auxiliar para convertir int[] a Integer[] fuera del cronómetro
    private static Integer[] convertirAInteger(int[] lista) {
        Integer[] copia = new Integer[lista.length];
        for (int i = 0; i < lista.length; i++) {
            copia[i] = lista[i];
        }
        return copia;
    }

    // Validar orden y conservar de elementos para int[]
    private static void validar(int[] obtenido, int[] esperado, String metodo, String sample) {
        if (!Arrays.equals(obtenido, esperado)) {
            throw new IllegalStateException("Error de ordenamiento en " + metodo + " con sample=" + sample);
        }
    }

    // Validar orden y conservar de elementos para Integer[]
    private static void validarInteger(Integer[] obtenido, int[] esperado, String metodo, String sample) {
        if (obtenido.length != esperado.length) {
            throw new IllegalStateException("Tamaño incorrecto en " + metodo + " con sample=" + sample);
        }
        for (int i = 0; i < esperado.length; i++) {
            if (obtenido[i] == null || obtenido[i] != esperado[i]) {
                throw new IllegalStateException("Error de ordenamiento en " + metodo + " con sample=" + sample);
            }
        }
    }
}

        /* 
        -----------------------------NOTAS DE INTRODUCCION-----------------------------
        //nanoTime : Es un cronometro de alta resolucion en nanosegundos.
        long nanoTime = System.nanoTime();
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(" Tiempo actual en nanoseconds: " + nanoTime);
        System.out.println(" Tiempo actual en milliseconds: " + currentTimeMillis);

        // funcion de ejecucion que ejecuta la funcion lambda
        Runnable funcion = () -> System.out.println("Ejecutando la Tarea ");
        System.out.println("Ejecucion de la funcion runnable"); 
        funcion.run();
        */
        // funcion de ejecucion que ejecuta la funcion lambda con metodo burbuja
        /* 
        List<Integer> list = new ArrayList<>();
        MetodosOrd m0 = new MetodosOrd();
        m0.burbuja(list);
        Runnable funcion2 = () -> m0.burbuja(list); 
        //Runnable  
        System.out.println("Ejecucion de la funcion runnable con metodo burbuja");
        funcion2.run();
        */
        // funcion de ejecucion que ejecuta la funcion lambda con metodo insercion