public class Benchmark {

    public static long medir(){
        long inicio = System.nanoTime();
        // Código a medir
        long fin = System.nanoTime();
        return fin - inicio;
    }
    
}
