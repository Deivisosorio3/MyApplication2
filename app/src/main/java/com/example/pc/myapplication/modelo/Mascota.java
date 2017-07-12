package com.example.pc.myapplication.modelo;

/**
 * Created by user on 08/07/2017.
 */

public class Mascota {


    private String cedula;
    private String nombre;
    private String tipo;
    private int edad;
    private String raza;
    private String nombreP;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public Mascota(String cedula, String nombre, String tipo, int edad, String raza, String nombreP) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.raza = raza;
        this.nombreP = nombreP;
    }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }


}
