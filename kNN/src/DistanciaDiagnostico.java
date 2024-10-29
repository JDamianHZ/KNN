

    public class DistanciaDiagnostico implements Comparable<DistanciaDiagnostico> {
    private String diagnostico;
    private double distancia;

    public DistanciaDiagnostico(String diagnostico, double distancia) {
        this.diagnostico = diagnostico;
        this.distancia = distancia;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public double getDistancia() {
        return distancia;
    }

    @Override
    public int compareTo(DistanciaDiagnostico otro) {
        return Double.compare(this.distancia, otro.distancia);
    }
}
