package com.example.pc.myapplication.modelo;

/**
 * Created by user on 08/07/2017.
 */

public class Propietario {

    private int cedula;
    private String nombre;
    private int telefono;
    private String nombre_m;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre_m() {
        return nombre_m;
    }

    public void setNombre_m(String nombre_m) {
        this.nombre_m = nombre_m;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Propietario(int cedula, String nombre, int telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
