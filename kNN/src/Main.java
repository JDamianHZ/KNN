import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public class Main {

    // Generador de números aleatorios
    private static Random random = new Random();

    // Definición de los rangos mínimos y máximos para cada característica
    public static double[] minimos = {
        0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static double[] maximos = {
        20.0, 15.0, 130.0, 1100.0, 0.2, 0.3, 0.4, 0.2,
        0.25, 0.1, 1.2, 1.0, 9.0, 160.0, 0.01,
        0.1, 0.1, 0.02, 0.04, 0.01, 30.0,
        20.0, 200.0, 2020.0, 0.3, 0.8, 0.8, 0.3, 0.5, 1.2
    };

    // Array para almacenar los números generados
    public static double[] feature2 = new double[maximos.length];

    // Método para generar un número aleatorio entre min y max
    public static double generarNumeroAleatorio(double min, double max) {
        return min + (max - min) * random.nextDouble(); // Genera un número entre min y max
    }

    public static int k = 3;
    public static  int Repetir = 3;

    public static void main(String[] args) {
    for(int h = 0; h < Repetir; h++) {
        System.out.println();
        System.out.println(h+1 +" Repeticion");
            DataSet.LeerDatos(); // Suponiendo que este método lee datos necesarios

            // Llenar feature2 con números aleatorios dentro de los rangos especificados
            for (int i = 0; i < feature2.length; i++) {
                feature2[i] = generarNumeroAleatorio(minimos[i], maximos[i]);
            }

            System.out.print("Valores generados en feature2: ");
            for (int i = 0; i < feature2.length; i++) {
                // Formatear el número a 4 decimales y agregarlo a la salida
                System.out.printf("%.4f", feature2[i]);
                if (i < feature2.length - 1) { // No agregar coma al último elemento
                    System.out.print(", ");
                }
            }
            System.out.println(); // Agregar un salto de línea al final

            // Crear instancia de KNN con los datos leídos y el valor de k
            KNN knn = new KNN(k, DataSet.data); // Cambia 3 por el valor de K que desees
            KNN.calcularDistancias(feature2);
            
            // Obtener los K más cercanos
            List<DistanciaDiagnostico> kMasCercanos = knn.obtenerKMasCercanos();
            
            // Configurar el formato de los decimales
            DecimalFormat df = new DecimalFormat("#.####");
            System.out.println("Los K más cercanos:");
            int M = 0;
            int B = 0;
            for (DistanciaDiagnostico dd : kMasCercanos) {
                System.out.println("Diagnóstico: " + dd.getDiagnostico() + ", Distancia: " + df.format(dd.getDistancia()));
                if (dd.getDiagnostico().equals("M")) {
                    M++;
                } else {
                    B++;
                }
            }
            
            // Determinar el diagnóstico más frecuente
            if (M > B) {
                System.out.println("Diagnóstico: M");
            } else {
                System.out.println("Diagnóstico: B");
            }


    }


    }
}
