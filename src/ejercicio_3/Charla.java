package ejercicio_3;

public class Charla extends Actividad {
    private String disertante;

    public Charla(int id, String titulo, int cupoMaximo, String disertante) {
        super(id, titulo, cupoMaximo); // Llama al constructor de Actividad
        this.disertante = disertante;
    }

    @Override
    public double calcularCostoMateriales() {
        return 0.0; // Las charlas no suelen requerir costo de materiales
    }

    @Override
    public String getTipo() {
        return "Charla";
    }

    public String getDisertante() {
        return disertante;
    }
}
