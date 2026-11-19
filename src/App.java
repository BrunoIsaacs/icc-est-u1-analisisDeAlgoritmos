import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        /*
        long nanoTime = System.nanoTime();
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("nanotime: " + nanoTime);
        System.out.println("currentTimeMillis: " + currentTimeMillis);

        Runnable x = () -> {
            System.out.println("Ejecutando tarea 1");
            System.out.println("Ejecutando tarea 2");
        };

        List<Integer> list = new ArrayList<>();
        MetodosOrd mO = new MetodosOrd();
        mO.burbuja(list);
        Runnable burbujaOrden = () -> mO.burbuja(list);

        x.run();
        */

        /*
        Generador g = new Generador();
        List<Integer> list = g.generate(100);
        System.out.println(list);
        */
       /* 
        Generador g = new Generador();
        Benchmark b = new Benchmark();
        
        List<Integer> list = g.generate(100);

        System.out.println(list);
        
        Results benGenResults = b.medir(
            () -> g.generate(100), "Generar lista");
            System.out.println(benGenResults);
        */
        //Los 3 arreglos base 
        //10000
        
        int[] tamanos = {10000, 50000, 100000};
        
        // Lista que acumulará los 12 resultados (3 tamaños x 4 métodos)
        List<Results> resultados = new ArrayList<>(); // Cambia 'Resultado' por el tipo que devuelva Benchmark.medir()
        
        // Instanciamos el criterio una sola vez
        Comparator<Integer> comparador = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b); // Ascendente para igualar el criterio de los demás
            }
        };

        Random rand = new Random();
        // Si no le pones 'static' a sortBubble en Metodos, usa esta instancia:
        Metodos metodos = new Metodos(); 

        // 2. Bucle único para los 3 tamaños (genera y mide los 12 casos automáticamente)
        for (int n : tamanos) {
            // Generamos el arreglo base desordenado de tamaño 'n'
            int[] base = new int[n];
            for (int i = 0; i < n; i++) {
                base[i] = rand.nextInt(100000);
            }

            // Clonamos automáticamente para cada método (4 copias por cada tamaño = 12 en total)
            int[] copia1 = base.clone();
            int[] copia2 = base.clone();
            int[] copia3 = base.clone();
            Integer[] copia4 = Arrays.stream(base).boxed().toArray(Integer[]::new);

            // Medimos los 4 métodos
            resultados.add(Benchmark.medir(() -> metodos.sortBubble(copia1), "V1 - Bubble Sort"));
            resultados.add(Benchmark.medir(() -> Metodos.sortQuick(copia2), "V2 - Quick Sort"));
            resultados.add(Benchmark.medir(() -> Metodos.sortPrimitivo(copia3), "V3 - Arrays.sort(int[])"));
            resultados.add(Benchmark.medir(() -> Metodos.comparatorSort(copia4, comparador), "V4 - Arrays.sort(Integer[])"));
        }

        // 3. Imprimimos los 12 resultados acumulados con un for
        System.out.println("=== RESULTADOS DEL BENCHMARK (12 EJECUCIONES) ===");
        for (Results r : resultados) {
            System.out.println(r);
        }
    }

}
