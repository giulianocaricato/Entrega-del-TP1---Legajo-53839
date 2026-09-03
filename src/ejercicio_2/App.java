package ejercicio_2;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // a. Se construya una lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("24001", "Juan Pérez"));
        estudiantes.add(new Estudiante("24002", "María López"));
        estudiantes.add(new Estudiante("24003", "Carlos Gómez"));

        // b. Se construyan eventos
        EventoUniversitario evento1 = new EventoUniversitario("EV-10", "Jornadas Tecnológicas UTN", 2500.0, false);
        EventoUniversitario evento2 = new EventoUniversitario("EV-20", "Taller Abierto de Empleo", 0.0, true);

        // c. Se asigne una sala cada evento
        Sala sala1 = new Sala(1, "Auditorio Campus");
        Sala sala2 = new Sala(2, "Laboratorio de Sistemas");
        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);

        // d. Se creen actividades propias de cada evento
        evento1.crearActividad(501, "Conferencia de IA", 2);
        evento1.crearActividad(502, "Mesa Debate: Ciberseguridad", 15);
        evento2.crearActividad(601, "Armado de Currículum", 20);

        // e. Se inscriban estudiantes en cada actividad
        Actividad conferenciaIA = evento1.getActividades().get(0);
        conferenciaIA.inscribir(estudiantes.get(0));
        conferenciaIA.inscribir(estudiantes.get(1));
        conferenciaIA.inscribir(estudiantes.get(2)); // Mostrará aviso de cupo lleno intencional

        Actividad tallerCV = evento2.getActividades().get(0);
        tallerCV.inscribir(estudiantes.get(2));

        // f. Se muestre el resumen de datos por cada evento creado
        System.out.println("\n>>> RESUMEN DE EVENTOS CREASDOS <<<");
        evento1.mostrarDatos();
        evento2.mostrarDatos();

        // g. Se muestre el total de eventos creados
        System.out.println("\n>>> INDICADORES GLOBALES <<<");
        System.out.println("Total global de eventos registrados: " + EventoUniversitario.getCantidadEventos());
    }
}
