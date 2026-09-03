package ejercicio_3;

import java.time.LocalDate;

public class Inscripcion {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante; // Usa el Estudiante de ejercicio_3

    public Inscripcion(LocalDate fecha, String estado, Estudiante estudiante) {
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
    }

    public void mostrarDatos() {
        System.out.println("  - [Inscripción] Estudiante: " + estudiante.getNombre() +
                " (Legajo: " + estudiante.getLegajo() + ") | Fecha: " + fecha + " | Estado: " + estado);
    }
}
