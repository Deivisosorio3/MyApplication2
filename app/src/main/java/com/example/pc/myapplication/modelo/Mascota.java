package com.example.pc.myapplication.modelo;

/**
 * Created by user on 08/07/2017.
 */

public class Mascota {


    private String cedula;
    private String nombre;
    private int edad;
    private String raza;
    private String nombreP;

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public Mascota(String cedula, String nombre, int edad, String raza) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
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
