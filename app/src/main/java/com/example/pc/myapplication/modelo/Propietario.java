package com.example.pc.myapplication.modelo;

/**
 * Created by user on 08/07/2017.
 */

public class Propietario {

    private String cedula;
    private String nombre;
    private int telefono;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public Propietario(String cedula, String nombre, int telefono) {
        this.cedula = cedula;
        this.nombre = nombre;

        this.telefono = telefono;
    }
}
