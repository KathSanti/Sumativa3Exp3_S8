package com.duoc.puertosalmontt.model.entidad;

public class CentroCultivo extends UnidadOperativa{

    private float toneladas;

    public CentroCultivo(String nombre, String comuna, float toneladas) {
        super(nombre, comuna);
        this.toneladas = toneladas;
    }

    public float getToneladas() {
        return toneladas;
    }

    @Override
    public void mostrarResumen() {

        System.out.println("Nombre      : " + nombre);
        System.out.println("Comuna      : " + comuna);
        System.out.println("Toneladas   : " + toneladas);
    }




}
