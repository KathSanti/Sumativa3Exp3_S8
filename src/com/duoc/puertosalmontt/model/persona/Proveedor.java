package com.duoc.puertosalmontt.model.persona;

public class Proveedor extends Agentes {

    private int sucursal;

    public Proveedor(String rut, String nombre, String direccion, String telefono, int sucursal) {
        super(rut, nombre, direccion, telefono);
        this.sucursal = sucursal;
    }

    public int getSucursal() {
        return sucursal;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Nombre    : " + nombre);
        System.out.println("Direccion : " + direccion);
        System.out.println("Telefono  : " + telefono);
        System.out.println("Sucursal  : " + sucursal);

    }






}
