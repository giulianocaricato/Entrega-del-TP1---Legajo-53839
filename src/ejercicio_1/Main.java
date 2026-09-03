package ejercicio_1;

public class Main {
    public static void main(String[] args) {
        // a. Se crean uno o más eventos universitarios
        EventoUniversitario evento1 = new EventoUniversitario("EV-001", "Hackathon IA 2026", 1500.0, false);
        EventoUniversitario evento2 = new EventoUniversitario("EV-002", "Charla de Orientación", 0.0, true);

        // b. Se cree una copia de cada evento creado utilizando el constructor de copia
        EventoUniversitario copiaEvento1 = new EventoUniversitario(evento1);
        EventoUniversitario copiaEvento2 = new EventoUniversitario(evento2);

        // c. Se muestren los datos de los eventos creados y su copia
        System.out.println("=== EVENTOS ORIGINALES ===");
        evento1.mostrarDatos();
        evento2.mostrarDatos();

        System.out.println("\n=== COPIAS DE LOS EVENTOS ===");
        copiaEvento1.mostrarDatos();
        copiaEvento2.mostrarDatos();

        // Probar métodos adicionales
        System.out.println("\n=== PRUEBA DE MÉTODOS ===");
        Sala salaA = new Sala("Auditorio Principal");
        evento1.asignarSala(salaA);
        evento1.crearActividad(101, "Taller de Git", 30);

        // d. Se muestre el contador de eventos con la totalidad de eventos creados
        System.out.println("\n=== TOTAL DE EVENTOS ===");
        System.out.println("Total de eventos registrados en el sistema: " + EventoUniversitario.getCantidadEventos());
    }
}
