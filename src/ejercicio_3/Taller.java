package ejercicio_3;

public class Taller extends Actividad {
    private boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    @Override
    public double calcularCostoMateriales() {
        // Regla de negocio de la imagen
        return requiereNotebook ? 5000.0 : 2000.0;
    }

    @Override
    public String getTipo() {
        return "Taller";
    }
}
