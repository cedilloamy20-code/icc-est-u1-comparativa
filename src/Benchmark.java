public class Benchmark {
    //Ejecuta las acciones cronometradas de inicio a fin en nanosegundos
    
    public static Results medir(Runnable accion, String nombre, String sample) {
        // tiempo actual
        Long tiempoInicial = System.nanoTime();
        // accion a medir
        accion.run();
        // tiempo final
        Long tiempoFinal = System.nanoTime();
        //instancia de la clase Results
        Results results = new Results(nombre, (tiempoFinal - tiempoInicial), sample);

        // retornar el tiempo de duracion
        return results;
    }
    
}
