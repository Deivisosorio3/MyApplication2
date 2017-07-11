package com.example.pc.myapplication.modelo;

/**
 * Created by user on 08/07/2017.
 */

public class Propietario {

    private long cedula;
    private String nombre;
    private long telefono;
    private String nombre_m;

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getNombre_m() {
        return nombre_m;
    }

    public void setNombre_m(String nombre_m) {
        this.nombre_m = nombre_m;
    }

    public Propietario(long cedula, String nombre, long telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
