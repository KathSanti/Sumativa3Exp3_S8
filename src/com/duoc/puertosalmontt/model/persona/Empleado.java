package com.duoc.puertosalmontt.model.persona;



public class Empleado extends Agentes {

    private String ApMaterno;
    private String ApPaterno;


    public Empleado(String rut, String nombre, String ApMaterno, String ApPaterno, String direccion, String telefono) {
        super(rut, nombre, direccion, telefono);
        this.ApMaterno = ApMaterno;
        this.ApPaterno = ApPaterno;
    }

    public String getApMaterno() {
        return ApMaterno;
    }

    public String getApPaterno() {
        return ApPaterno;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Nombre    : " + nombre);
        System.out.println("ApMaterno : " + ApMaterno);
        System.out.println("ApPaterno : " + ApPaterno);
        System.out.println("Direccion : " + direccion);
        System.out.println("Telefono  : " + telefono);

    }





}
