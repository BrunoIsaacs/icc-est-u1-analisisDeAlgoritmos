import java.util.Arrays;
import java.util.Comparator;

public class Metodos {
    //bubble
    public void sortBubble(int[] arr){
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length -i -1; j++) {
                if (arr [j] > arr [j+1]) {
                    int aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+ 1] = aux;

                    
                }
                
            }
        }

    }

    //quick sort
    public static void sortQuick(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = 0;
        try {
            pivotIndex = partition(arr, low, high);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    //sort primitivo 
    public static void sortPrimitivo(int[] arr) {
        Arrays.sort(arr);
    }

    //sort comparator instanciando un criterio 
    public static void comparatorSort(Integer[] arr, Comparator<Integer> comp){
        Arrays.sort(arr, comp);
    }


}
