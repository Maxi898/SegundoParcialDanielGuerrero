package Controlador;

import Modelo.Profesor;
import Modelo.Estudiante;
import Vista.VistaColegio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorColegio {

    // Arreglos nativos con tamaño fijo
    private Profesor[] profesores;
    private int totalProfesores;

    private Estudiante[] estudiantes;
    private int totalEstudiantes;

    private VistaColegio vista;

    public ControladorColegio(VistaColegio vista) {
        this.vista = vista;
        this.profesores = new Profesor[100];
        this.estudiantes = new Estudiante[100];
        this.totalProfesores = 0;
        this.totalEstudiantes = 0;

        // Enlace de los cuatro botones declarados en la vista
        this.vista.setRegistrarProfesorListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarProfesor();
            }
        });

        this.vista.setRegistrarEstudianteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEstudiante();
            }
        });

        this.vista.setReporteNominaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReporteNomina();
            }
        });

        this.vista.setReporteGeneralListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReporteGeneral();
            }
        });
    }

    public void iniciar() {
        this.vista.setVisible(true);
    }

    private void registrarProfesor() {
        if (totalProfesores >= profesores.length) {
            vista.mostrarAlerta("No es posible registrar más profesores. Capacidad máxima alcanzada.");
            return;
        }

        // Validación de campos vacíos
        if (vista.getNombre().isEmpty() || vista.getDireccion().isEmpty() || 
            vista.getTelefono().isEmpty() || vista.getFechaNac().isEmpty() ||
            vista.getCedula().isEmpty() || vista.getArea().isEmpty()) {
            vista.mostrarAlerta("Diligencie todos los campos de Persona y Profesor.");
            return;
        }

        try {
            double vHora = vista.getValorHora();
            int horas = vista.getHorasDictadas();

            if (vHora <= 0 || horas <= 0) {
                vista.mostrarAlerta("El valor de la hora y las horas dictadas deben ser números mayores a cero.");
                return;
            }

            // Instancia usando un único constructor
            Profesor p = new Profesor(
                vista.getNombre(),
                vista.getDireccion(),
                vista.getTelefono(),
                vista.getFechaNac(),
                vista.getCedula(),
                vista.getArea(),
                vHora,
                horas
            );

            profesores[totalProfesores] = p;
            totalProfesores++;

            vista.mostrarAlerta("Profesor " + p.getNombre() + " registrado exitosamente.");
            vista.limpiarCampos();

        } catch (NumberFormatException ex) {
            vista.mostrarAlerta("El campo 'Valor Hora' y 'Horas Mes' deben contener únicamente valores numéricos.");
        }
    }

    private void registrarEstudiante() {
        if (totalEstudiantes >= estudiantes.length) {
            vista.mostrarAlerta("No es posible registrar más estudiantes. Capacidad máxima alcanzada.");
            return;
        }

        // Validación de campos vacíos
        if (vista.getNombre().isEmpty() || vista.getDireccion().isEmpty() || 
            vista.getTelefono().isEmpty() || vista.getFechaNac().isEmpty() ||
            vista.getCodigo().isEmpty() || vista.getGrado().isEmpty()) {
            vista.mostrarAlerta("Diligencie todos los campos de Persona y Estudiante.");
            return;
        }

        // Instancia usando un único constructor
        Estudiante est = new Estudiante(
            vista.getNombre(),
            vista.getDireccion(),
            vista.getTelefono(),
            vista.getFechaNac(),
            vista.getCodigo(),
            vista.getGrado()
        );

        estudiantes[totalEstudiantes] = est;
        totalEstudiantes++;

        vista.mostrarAlerta("Estudiante " + est.getNombre() + " registrado exitosamente.");
        vista.limpiarCampos();
    }

    // Reporte 1: Cálculo del pago total (+30% preparación) y prestaciones sociales (19%)
    private void generarReporteNomina() {
        if (totalProfesores == 0) {
            vista.mostrarAlerta("No existen profesores registrados para generar la nómina.");
            return;
        }

        String reporte = "========================================================================\n"
                       + "               REPORTE 1: NÓMINA Y PRESTACIONES DE PROFESORES          \n"
                       + "========================================================================\n";

        double granTotalSueldos = 0.0;
        double granTotalPrestaciones = 0.0;

        for (int i = 0; i < totalProfesores; i++) {
            Profesor p = profesores[i];
            double pagoMensual = p.calcularPagoMensual();
            double prestaciones = p.calcularPrestaciones();

            granTotalSueldos += pagoMensual;
            granTotalPrestaciones += prestaciones;

            reporte += (i + 1) + ". Cédula: " + p.getCedula() + "\n"
                    + "   Nombre: " + p.getNombre() + " | Área: " + p.getArea() + "\n"
                    + "   Horas Mes: " + p.getHorasDictadas() + " | Valor/H: $" + p.getValorHora() + "\n"
                    + "   Pago Total (+30% Prep): $" + pagoMensual + "\n"
                    + "   Prestaciones (19%):      $" + prestaciones + "\n"
                    + "------------------------------------------------------------------------\n";
        }

        reporte += "TOTAL NÓMINA A PAGAR:        $" + granTotalSueldos + "\n";
        reporte += "TOTAL PRESTACIONES COLEGIO:  $" + granTotalPrestaciones + "\n";
        reporte += "COSTO TOTAL INSTITUCIONAL:   $" + (granTotalSueldos + granTotalPrestaciones) + "\n";
        reporte += "========================================================================";

        vista.mostrarReporte("Nómina y Prestaciones Sociales", reporte);
    }

    // Reporte 2: Directorio y consolidado de Profesores y Estudiantes
    private void generarReporteGeneral() {
        if (totalProfesores == 0 && totalEstudiantes == 0) {
            vista.mostrarAlerta("No hay registros en el sistema escolar.");
            return;
        }

        String reporte = "========================================================================\n"
                       + "                     REPORTE 2: DIRECTORIO ESCOLAR                     \n"
                       + "========================================================================\n\n";

        reporte += "--- PROFESORES REGISTRADOS (" + totalProfesores + ") ---\n";
        if (totalProfesores == 0) {
            reporte += "Sin registros.\n";
        } else {
            for (int i = 0; i < totalProfesores; i++) {
                reporte += (i + 1) + ". " + profesores[i].toString() + "\n";
            }
        }

        reporte += "\n--- ESTUDIANTES REGISTRADOS (" + totalEstudiantes + ") ---\n";
        if (totalEstudiantes == 0) {
            reporte += "Sin registros.\n";
        } else {
            for (int i = 0; i < totalEstudiantes; i++) {
                reporte += (i + 1) + ". " + estudiantes[i].toString() + "\n";
            }
        }

        reporte += "\n========================================================================\n";
        reporte += "TOTAL PERSONAS EN EL SISTEMA: " + (totalProfesores + totalEstudiantes);

        vista.mostrarReporte("Directorio General Escolar", reporte);
    }
}