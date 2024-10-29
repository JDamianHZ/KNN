import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KNN {
    public static List<DistanciaDiagnostico> distanciasConDiagnosticos = new ArrayList<>();

    public int K;
    public List<DataSet> data;

    public KNN(int K, List<DataSet> data) {
        this.K = K;
        this.data = data;
    }

    public static double CalcularPrueba(double[] feature, double[] feature2) {
        double suma = 0;    
        for (int i = 0; i < feature.length; i++) {
            suma += Math.pow(feature[i] - feature2[i], 2); // Corregido: suma += en vez de asignar
        }
        return Math.sqrt(suma);
    }

    // Método para calcular distancias entre un paciente y cada registro del dataset
    public static void calcularDistancias(double[] feature2) {
        for (DataSet d : DataSet.data) {
            double distancia = CalcularPrueba(feature2, d.getFeatures());  // Calcula la distancia
            // Agregar la distancia y el diagnóstico a la lista
            distanciasConDiagnosticos.add(new DistanciaDiagnostico(d.getDiagnosis(), distancia));
        }
    }

    // Método para obtener los K más cercanos
    public List<DistanciaDiagnostico> obtenerKMasCercanos() {
        Collections.sort(distanciasConDiagnosticos); // Ordenar por distancia
        return distanciasConDiagnosticos.subList(0, Math.min(K, distanciasConDiagnosticos.size())); // Retornar los K más cercanos
    }
}
