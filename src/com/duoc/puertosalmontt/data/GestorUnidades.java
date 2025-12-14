package com.duoc.puertosalmontt.data;

import com.duoc.puertosalmontt.model.entidad.CentroCultivo;
import com.duoc.puertosalmontt.model.entidad.PlantaProceso;
import com.duoc.puertosalmontt.model.persona.Empleado;
import com.duoc.puertosalmontt.model.persona.Proveedor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestorUnidades {

    private List<CentroCultivo> listaCentro = new ArrayList<>();
    private List<PlantaProceso> listaPlanta = new ArrayList<>();
    private List<Empleado> listaEmpleado = new ArrayList<>();
    private List<Proveedor> listaProveedor = new ArrayList<>();

    public GestorUnidades() {
        // Inicializar centros de cultivo
        listaCentro.addAll(Arrays.asList(
                new CentroCultivo("Centro Norte", "Valparaíso, 55", 85),
                new CentroCultivo("Centro Sur", "Puerto Montt", 25),
                new CentroCultivo("Centro Andino", "Los Andes", 75)
        ));

        // Inicializar plantas de proceso
        listaPlanta.addAll(Arrays.asList(
                new PlantaProceso("Planta Procesadora A", "Santiago", 500),
                new PlantaProceso("Planta Procesadora B", "Concepción", 200)
        ));

        listaEmpleado.addAll(Arrays.asList(
                new Empleado("20983567-2", "Mercedes", "Carrasco", "Guerrero", "Zulamita #340, Puerto Octay", "995874567"),
                new Empleado("17456789-5", "Matias", "Avedaño", "Guajardo", "Intendente Saaveda 786, Rio Negro", "998887567")
        ));

        listaProveedor.addAll(Arrays.asList(
                new Proveedor("76407505-6", "Cugat S.A", "Avenida San Ramon 3202, Rancagua", "225678978", 001),
                new Proveedor("76407505-7", "Kiosko Don pepito", "Avenida los vientos 3782, Rancagua", "225557828", 002)
        ));
    }

    //Contadores con Intanceof

    public int contarCentros() {
        int contador = 0;
        for (CentroCultivo centroCultivo : listaCentro) {
            contador++;
        }
        return contador;
    }

    public int contarPlantas() {
        int contador = 0;
        for (PlantaProceso plantaProceso : listaPlanta) {
            contador++;
        }
        return contador;
    }

    public int contarEmpleados() {
        int contador = 0;
        for (Empleado empleado : listaEmpleado) {
            contador++;
        }
        return contador;
    }

    public int contarProveedores() {
        int contador = 0;
        for (Proveedor proveedor : listaProveedor) {
            contador++;
        }
        return contador;
    }



    // Métodos que retornan String para la interfaz gráfica
    public String listarCentrosString() {
        StringBuilder sb = new StringBuilder();

        // contamos  instanceof
        int contadorTotal = contarCentros();
        sb.append("Total de centros: ").append(contadorTotal).append("\n\n");

        for (CentroCultivo centroCultivo : listaCentro) {
            sb.append("──────────────────────────────────\n");
            sb.append("Nombre: ").append(centroCultivo.getNombre()).append("\n");
            sb.append("Comuna: ").append(centroCultivo.getComuna()).append("\n");
            sb.append("Toneladas: ").append(centroCultivo.getToneladas()).append("\n");
            sb.append("──────────────────────────────────\n\n");
        }

        return sb.toString();
    }

    public String listarPlantasString() {
        StringBuilder sb = new StringBuilder();

        // contamos  instanceof
        int contadorTotal = contarPlantas();
        sb.append("Total Plantas : ").append(contadorTotal).append("\n\n");

        for (PlantaProceso plantaProceso : listaPlanta) {
            sb.append("──────────────────────────────────\n");
            sb.append("Nombre: ").append(plantaProceso.getNombre()).append("\n");
            sb.append("Comuna: ").append(plantaProceso.getComuna()).append("\n");
            sb.append("Capacidad: ").append(plantaProceso.getCapacidad()).append("\n");
            sb.append("──────────────────────────────────\n\n");
        }
        return sb.toString();
    }

    public String listarEmpleadosString() {
        StringBuilder sb = new StringBuilder();

        // contamos  instanceof
        int contadorTotal = contarEmpleados();
        sb.append("Total empleados: ").append(contadorTotal).append("\n\n");

        for (Empleado empleado : listaEmpleado) {
            sb.append("──────────────────────────────────\n");
            sb.append("RUT: ").append(empleado.getRut()).append("\n");
            sb.append("Nombre: ").append(empleado.getNombre()).append("\n");
            sb.append("Apellido Paterno: ").append(empleado.getApPaterno()).append("\n");
            sb.append("Apellido Materno: ").append(empleado.getApMaterno()).append("\n");
            sb.append("Dirección: ").append(empleado.getDireccion()).append("\n");
            sb.append("Teléfono: ").append(empleado.getTelefono()).append("\n");
            sb.append("──────────────────────────────────\n\n");
        }
        return sb.toString();
    }

    public String listarProveedoresString() {
        StringBuilder sb = new StringBuilder();

        // contamos  instanceof
        int contadorTotal = contarProveedores();
        sb.append("Total proveedor: ").append(contadorTotal).append("\n\n");

        for (Proveedor proveedor : listaProveedor) {
            sb.append("──────────────────────────────────\n");
            sb.append("RUT: ").append(proveedor.getRut()).append("\n");
            sb.append("Nombre: ").append(proveedor.getNombre()).append("\n");
            sb.append("Dirección: ").append(proveedor.getDireccion()).append("\n");
            sb.append("Teléfono: ").append(proveedor.getTelefono()).append("\n");
            sb.append("Sucursal: ").append(proveedor.getSucursal()).append("\n");
            sb.append("──────────────────────────────────\n\n");
        }
        return sb.toString();
    }




    // Métodos para agregar nuevos elementos
    public void agregarCentro(CentroCultivo centro) {
        listaCentro.add(centro);
    }

    public void agregarPlanta(PlantaProceso planta) {
        listaPlanta.add(planta);
    }

    public void agregarEmpleado(Empleado empleado) {
        listaEmpleado.add(empleado);
    }

    public void agregarProveedor(Proveedor proveedor) {
        listaProveedor.add(proveedor);
    }

}