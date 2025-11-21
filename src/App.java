import controllers.SortMethods;
import java.util.concurrent.Callable;
import models.Results;

public class App {

    public static void main(String[] args) throws Exception {
        int[] originalArray = generate(500000);

        int[] array1000 = new int[1000];
        System.arraycopy(originalArray, 0, array1000, 0, 1000);

        int[] array5000 = new int[5000];
        System.arraycopy(originalArray, 0, array5000, 0, 5000);

        int[] array10000 = new int[10000];
        System.arraycopy(originalArray, 0, array10000, 0, 10000);

        int[] array100000 = new int[100000];
        System.arraycopy(originalArray, 0, array100000, 0, 100000);

        int[][] arrays = {array1000, array5000, array10000, array100000};
        SortMethods sorter = new SortMethods();

        for (int[] array : arrays) {
            int size = array.length;
            Callable<Void> funCallable = () -> {
                sorter.sortBubble(array.clone());
                return null;
            };
            Results result = BenchMarking.medir_tiempo(funCallable, size);
            result.setFuntionName("Bubble Sort");
            System.out.println(result);
        }

        for (int[] array : arrays) {
            int size = array.length;
            Callable<Void> funCallable = () -> {
                sorter.sortBubbleOptimized(array.clone());
                return null;
            };
            Results result = BenchMarking.medir_tiempo(funCallable, size);
            result.setFuntionName("Bubble Sort Optimizado");
            System.out.println(result);
        }

        for (int[] array : arrays) {
            int size = array.length;
            Callable<Void> funCallable = () -> {
                sorter.sortShell(array.clone());
                return null;
            };
            Results result = BenchMarking.medir_tiempo(funCallable, size);
            result.setFuntionName("Shell Sort");
            System.out.println(result);
        }

        for (int[] array : arrays) {
            int size = array.length;
            Callable<Void> funCallable = () -> {
                sorter.sortMerge(array.clone());
                return null;
            };
            Results result = BenchMarking.medir_tiempo(funCallable, size);
            result.setFuntionName("Merge Sort");
            System.out.println(result);
        }

    }

    public static int[] generate(int size) {
        int[] numeros = new int[size];
        for (int i = 0; i < size; i++) {
            numeros[i] = (int) (Math.random() * 10000);
        }
        return numeros;
    }
}
