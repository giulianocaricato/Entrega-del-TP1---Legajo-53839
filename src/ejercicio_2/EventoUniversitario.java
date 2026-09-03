package ejercicio_2;

import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala sala;
    private List<Actividad> actividades;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = gratuito ? 0 : costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public double calcularCostoEstimado() {
        return this.costoBase;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupo) {
        Actividad nuevaActividad = new Actividad(id, titulo, cupo);
        this.actividades.add(nuevaActividad);
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void mostrarDatos() {
        System.out.println("\n=======================================");
        System.out.println("EVENTO: " + titulo + " [ID: " + id + "]");
        System.out.println("Costo Base: $" + costoBase + " | Gratuito: " + (gratuito ? "Sí" : "No"));
        System.out.println("Sala Asignada: " + (sala != null ? sala.getNombre() : "Ninguna"));
        System.out.println("--- Agenda de Actividades ---");

        if (actividades.isEmpty()) {
            System.out.println(" No hay actividades registradas.");
        } else {
            for (Actividad act : actividades) {
                act.mostrarInscripciones();
            }
        }
        System.out.println("=======================================");
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }
}
