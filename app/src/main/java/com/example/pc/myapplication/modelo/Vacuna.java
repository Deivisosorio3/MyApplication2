package com.example.pc.myapplication.modelo;

import java.util.Date;

/**
 * Created by user on 08/07/2017.
 */

public class Vacuna {
    private String nombre;
    private String nueVacuna;
    private Date fecha;
    private String dosis;

    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNueVacuna() {
        return nueVacuna;
    }

    public void setNueVacuna(String nueVacuna) {
        this.nueVacuna = nueVacuna;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public void Vacuna(String nombre, String nueVacuna, Date fecha,String dosis) {

        this.nombre = nombre;
        this.nueVacuna = nueVacuna;
        this.fecha = fecha;
        this.dosis = dosis;

    }
}
