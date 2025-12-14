package com.duoc.puertosalmontt.model.entidad;

public class PlantaProceso extends UnidadOperativa {

    private int  capacidad;

    public PlantaProceso(String nombre, String comuna, int capacidad) {
        super(nombre, comuna);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public void mostrarResumen() {

        System.out.println("Nombre      : " + nombre);
        System.out.println("Comuna      : " + comuna);
        System.out.println("Capacidad   : " + capacidad);
    }





}
