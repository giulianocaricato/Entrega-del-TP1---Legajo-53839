package ejercicio_3;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // a. Se registren estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("24001", "mariano martin"));
        estudiantes.add(new Estudiante("24002", "Sofia Martínez"));

        // b. Se construyan eventos (uno pago y uno gratuito para comprobar la regla)
        EventoUniversitario eventoPago = new EventoUniversitario("EV-301", "Congreso de Programación", 1000.0, false);
        EventoUniversitario eventoGratis = new EventoUniversitario("EV-302", "Feria de Ciencias", 500.0, true);

        // c. Se asigne una sala a cada evento
        eventoPago.asignarSala(new Sala(10, "Aula Magna"));
        eventoGratis.asignarSala(new Sala(11, "Playón Central"));

        // d. Se creen actividades para cada evento del tipo Charla y/o Taller
        // Evento pago tiene una charla (gratis) y un taller con notebook ($5000)
        eventoPago.crearActividad(701, "Tendencias en Cloud", 30, "Charla", false);
        eventoPago.crearActividad(702, "Introducción a Docker", 10, "Taller", true);

        // Evento gratis tiene un taller sin notebook ($2000 en materiales, pero el evento final dará cero)
        eventoGratis.crearActividad(703, "Experimentos Básicos", 15, "Taller", false);

        // e. Se inscriban estudiantes en cada actividad
        eventoPago.getActividades().get(0).inscribirEstudiante(estudiantes.get(0));
        eventoPago.getActividades().get(1).inscribirEstudiante(estudiantes.get(1));

        // f. Se muestre el resumen de datos de cada evento y se recorran sus actividades
        System.out.println(">>> RESUMEN GENERAL DE EVENTOS (HERENCIA Y POLIMORFISMO) <<<");
        eventoPago.mostrarDatos();
        eventoGratis.mostrarDatos();

        // g. Se muestre el total de eventos creados
        System.out.println("\n>>> INDICADORES GLOBALES <<<");
        System.out.println("Total global de eventos registrados en Ejercicio 3: " + EventoUniversitario.getCantidadEventos());
    }
}
