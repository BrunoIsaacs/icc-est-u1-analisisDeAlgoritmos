public class Benchmark {

    public static Results medir(Runnable accion, String nombre){
        Long inicioNano = System.nanoTime();
        accion.run();
        Long finNano = System.nanoTime();
        Results results = new Results(nombre, finNano - inicioNano, "");

        return results;
    }
    
}
