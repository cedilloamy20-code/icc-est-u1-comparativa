
public class App {
    public static void main(String[] args) throws Exception {
        Generador g = new Generador();
        Benchmark b = new Benchmark();
        Metodos m = new Metodos();
        QuickSort qs = new QuickSort();

        //los 3 arreglos base
        //1000
        int[] lista1 = g.generate(10000);

        //50000
        int[] lista2 = g.generate(50000);

        //100000
        int[] lista3 = g.generate(100000);

        //1-> List<List<Integer>> listas = List.of(lista1, lista2, lista3);
        //2-> List<Integer>[] listas = new List<Integer>[] {lista1};
        int[][] listas = {lista1, lista2, lista3};
        int[] list1c1 = lista1.clone();
        int[] list2c1 = lista2.clone();
        int[] list3c1 = lista3.clone();

        int[] list1c2 = lista1.clone();
        int[] list2c2 = lista2.clone();
        int[] list3c2 = lista3.clone();

        int[] list1c3 = lista1.clone();
        int[] list2c3 = lista2.clone();
        int[] list3c3 = lista3.clone();

        int[] list1c4 = lista1.clone();
        int[] list2c4 = lista2.clone();
        int[] list3c4 = lista3.clone();

        
        //List<Integer> list2c1 = Arrays.copy0f(lista2, lista2.size());

        Results benGenList = b.medir(() -> m.sortBubble(list1c1), "sortBubble", "10.000");
        System.out.println(benGenList);
        Results benGenList2 = b.medir(() -> m.sortBubble(list2c1), "sortBubble", "50000");
        System.out.println(benGenList2);
        Results benGenList3 = b.medir(() -> m.sortBubble(list3c1), "sortBubble", "100000");
        System.out.println(benGenList3);
        // Un runnable siempre va con el ejecutar q es () y el lambda
        // el generate es un metodo y mientras lo sea puede entrar en el runnable
        Results benQs1 = b.medir(() -> qs.sort(list1c2), "QuickSort", "10.000");
        Results benQs2 = b.medir(() -> qs.sort(list2c2), "QuickSort", "50.000");
        Results benQs3 = b.medir(() -> qs.sort(list3c2), "QuickSort", "100.000");   


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
        
    }
}
