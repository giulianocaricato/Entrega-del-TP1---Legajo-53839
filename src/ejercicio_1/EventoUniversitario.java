package ejercicio_1;

public class EventoUniversitario {
        // Atributos privados
        private final String id;
        private String titulo;
        private double costoBase;
        private boolean gratuito;

        // Atributo estático para contar la totalidad de eventos creados
        private static int cantidadEventos = 0;

        // Constructor principal
        public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
            this.id = id;
            this.titulo = titulo;
            this.costoBase = gratuito ? 0 : costoBase; // Si es gratuito, el costo base es 0
            this.gratuito = gratuito;
            cantidadEventos++; // Incrementa el contador global
        }

        // Constructor de copia
        public EventoUniversitario(EventoUniversitario otro) {
            this.id = otro.id;
            this.titulo = otro.titulo;
            this.costoBase = otro.costoBase;
            this.gratuito = otro.gratuito;
            cantidadEventos++; // Las copias también cuentan como nuevos objetos evento
        }

        // Métodos de la clase
        public double calcularCostoEstimado() {
            return this.costoBase;
        }

        public void asignarSala(Sala sala) {
            System.out.println("ejercicio_1.Sala '" + sala.getNombre() + "' asignada al evento: " + this.titulo);
        }

        public void crearActividad(int id, String titulo, int cupo) {
            System.out.println("Actividad creada: [" + id + "] " + titulo + " (Cupo: " + cupo + ")");
        }

        public void mostrarDatos() {
            System.out.println("--- Datos del Evento ---");
            System.out.println("ID: " + id);
            System.out.println("Título: " + titulo);
            System.out.println("Costo Base: $" + costoBase);
            System.out.println("Gratuito: " + (gratuito ? "Sí" : "No"));
            System.out.println("------------------------");
        }

        // Método estático para obtener la cantidad total de eventos
        public static int getCantidadEventos() {
            return cantidadEventos;
        }
    }

