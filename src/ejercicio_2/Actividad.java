package ejercicio_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Actividad {
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

    public Inscripcion inscribir(Estudiante estudiante) {
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
        System.out.println(" Actividad: " + titulo + " (ID: " + id + ")");
        if (inscripciones.isEmpty()) {
            System.out.println("  No hay alumnos inscriptos.");
        } else {
            for (Inscripcion ins : inscripciones) {
                ins.mostrarDatos();
            }
        }
    }
}

