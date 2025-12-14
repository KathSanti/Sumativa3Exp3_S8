package com.duoc.puertosalmontt.model.persona;

import com.duoc.puertosalmontt.model.Registrable;

public abstract class Agentes implements Registrable {

    protected String rut;
    protected String nombre;
    protected String direccion;
    protected String telefono;

    public Agentes(String rut, String nombre, String direccion, String telefono) {
        this. rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void mostrarResumen(){
            System.out.println("Nombre    : " + nombre);
            System.out.println("Direccion : " + direccion);
            System.out.println("Telefono  : " + telefono);
    }




    @Override
    public String toString() {
        return "\n Rut          : " + rut +
                "\n Nombre      : " + nombre +
                "\n Dirección   : " + direccion +
                "\n Telefono    : " + telefono;

    }
}
