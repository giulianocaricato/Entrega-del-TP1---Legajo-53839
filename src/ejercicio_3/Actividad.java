package ejercicio_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;
    private final int CUPO_MINIMO = 5;
    private List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public Inscripcion inscribirEstudiante(Estudiante estudiante) {
        if (inscripciones.size() < cupoMaximo) {
            Inscripcion nuevaInscripcion = new Inscripcion(LocalDate.now(), "Confirmada", estudiante);
            inscripciones.add(nuevaInscripcion);
            return nuevaInscripcion;
        } else {
            System.out.println("No se pudo inscribir a " + estudiante.getNombre() + ". Cupo máximo alcanzado.");
            return null;
        }
    }

    public void mostrarInscripciones() {
        if (inscripciones.isEmpty()) {
            System.out.println("    No hay alumnos inscriptos.");
        } else {
            for (Inscripcion ins : inscripciones) {
                ins.mostrarDatos();
            }
        }
    }

    public final void mostrarIdentificacion() {
        System.out.println("Actividad Tipo [" + getTipo() + "] - ID: " + id + " - Título: " + titulo);
    }

    public abstract double calcularCostoMateriales();
    public abstract String getTipo();

    public String getTitulo() {
        return titulo;
    }
}
