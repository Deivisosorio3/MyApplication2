package com.example.pc.myapplication.modelo;

import java.util.Date;

/**
 * Created by user on 08/07/2017.
 */

public class Vacuna {
    private String nombre;
    private String fecha;
    private String dosis;
    private String nombre_m;


    public Vacuna(String nombre, String fecha, String dosis) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.dosis = dosis;
    }

    public String getFecha() {

        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombre_m() {
        return nombre_m;
    }

    public void setNombre_m(String nombre_m) {
        this.nombre_m = nombre_m;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public Vacuna(String nombre, String fecha, String dosis, String nombre_m) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.dosis = dosis;
        this.nombre_m = nombre_m;
    }
}
