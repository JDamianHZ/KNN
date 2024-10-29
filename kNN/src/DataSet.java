import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataSet {
    static String csvFile = "D:\\semetres\\7mo\\IA\\kNN\\Cancer_Data.csv";
    public static ArrayList<DataSet> data = new ArrayList<DataSet>();
    
    String id, diagnosis;
    double[] features;

    public DataSet(String id, String diagnosis, double[] features) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.features = features;
    }

    public String getId() {
        return id;
    }
    
    public String getDiagnosis() {
        return diagnosis;
    }
    
    public double[] getFeatures() {
        return features;
    }

    public static void LeerDatos() {
        String line;
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Leer y descartar la primera línea (encabezados)
            br.readLine();
            while ((line = br.readLine()) != null) {
                // Dividir la línea en componentes
                String[] values = line.split(cvsSplitBy);
                String id = values[0]; // ID en la primera columna
                String diagnosis = values[1]; // M o B en la segunda columna
                
                // Comienza en la columna 3
                double[] features = new double[values.length - 2];
                for (int i = 2; i < values.length; i++) {
                    features[i - 2] = Double.parseDouble(values[i]);
                }

                // Guardar en arraylist
                data.add(new DataSet(id, diagnosis, features));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir un número: " + e.getMessage());
        }
    }
    
    public static void imprimirDatos() {
        for (DataSet d : data) {
            System.out.print("ID: " + d.getId() + ", Diagnosis: " + d.getDiagnosis() + ", Features: ");
            for (double feature : d.getFeatures()) {
                System.out.print(feature + " ");
            }
            System.out.println(); // Nueva línea después de cada objeto
        }
    }

    public static void imprimirArray(ArrayList<DataSet> datos){
        for(DataSet d: datos){
            System.out.println(d.getId()+d.getDiagnosis()+"features");
            for(double feature: d.getFeatures()){
                System.out.print(feature+" ");
            }

        }

    }

    


}
