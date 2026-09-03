package ejercicio_3;

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

    // Lógica fiscal exacta requerida por la imagen
    public double calcularCostoEstimado() {
        if (this.gratuito) {
            return 0.0;
        }

        double sumaCostos = this.costoBase;
        for (Actividad act : actividades) {
            sumaCostos += act.calcularCostoMateriales(); // Polimorfismo puro
        }

        return sumaCostos * 1.21; // Agrega el 21% de impuestos
    }

    // Modificado para poder pasar si el taller requiere notebook desde la creación
    public void crearActividad(int id, String titulo, int cupo, String tipoActividad, boolean parametroExtra) {
        Actividad nuevaActividad;
        if (tipoActividad.equalsIgnoreCase("Charla")) {
            // Para charla, el parámetro extra se usa como el nombre del disertante
            nuevaActividad = new Charla(id, titulo, cupo, "Disertante Invitado");
        } else if (tipoActividad.equalsIgnoreCase("Taller")) {
            // Para taller, el parámetro extra define si lleva notebook o no
            nuevaActividad = new Taller(id, titulo, cupo, parametroExtra);
        } else {
            System.out.println("Tipo de actividad no reconocido.");
            return;
        }
        this.actividades.add(nuevaActividad);
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void mostrarDatos() {
        System.out.println("\n=======================================");
        System.out.println("EVENTO: " + titulo + " [ID: " + id + "]");
        System.out.println("¿Es Gratuito?: " + (gratuito ? "Sí" : "No"));
        System.out.println("Costo Base sin IVA: $" + costoBase);
        System.out.println("Costo Final Calculado (con IVA): $" + calcularCostoEstimado());
        System.out.println("Sala Asignada: " + (sala != null ? sala.getNombre() : "Ninguna"));
        System.out.println("--- Agenda de Actividades Polimórficas ---");

        for (Actividad act : actividades) {
            act.mostrarIdentificacion(); // Llama al método final
            act.mostrarInscripciones();
        }
        System.out.println("=======================================");
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }
}

