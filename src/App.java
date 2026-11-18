import java.util.ArrayList;
import java.util.List;

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
        Generador g = new Generador();
        Benchmark b = new Benchmark();

        List<Integer> list = g.generate(100);

        System.out.println(list);
        
        Results benGenResults = b.medir(
            () -> g.generate(100), "Generar lista");
            System.out.println(benGenResults);
    }

}
