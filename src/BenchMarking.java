import java.util.concurrent.Callable;
import models.Results;

public class BenchMarking {

    public static Results medir_tiempo(Callable<Void> func, int sampleSize) {
        try {
            long inicio = System.nanoTime();
            func.call();
            long fin = System.nanoTime();

            return new Results(
                    sampleSize,
                    "funcion ejecutada",
                    (fin - inicio) / 1_000_000_000.0
            );

        } catch (Exception e) {
            throw new RuntimeException("Error al medir el tiempo de ejecución", e);
        }
    }
}
