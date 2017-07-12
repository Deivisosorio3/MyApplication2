package com.example.pc.myapplication.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pc.myapplication.constantes.Constantes;

/**
 * Created by user on 08/07/2017.
 */

public class DataBase extends SQLiteOpenHelper{

        String crearTablaMascota="create table "+ Constantes.NOMBRE_TABLA_MASCOTAS+" ("+Constantes.COLUMNA_CEDULA_MASCOTA+" text , "+Constantes.COLUMNA_NOMBRE_MASCOTA+" text,"+Constantes.COLUMNA_TIPO_MASCOTA+" text, "+Constantes.COLUMNA_EDAD_MASCOTA+" long,"+Constantes.COLUMNA_RAZA_MASCOTA+" text,"+Constantes.NOMBRE_PROPIETARIO+" text)";
        String crearTablaVacuna="create table "+Constantes.NOMBRE_TABLA_VACUNAS+" ("+Constantes.COLUMNA_NOMBRE_VACUNA+" text,"+Constantes.COLUMNA_FECHA_VACUNA+" text ,"+Constantes.COLUMNA_DOSIS_VACUNA+" text)";
        String crearTablaPropietario="create table "+Constantes.NOMBRE_TABLA_PROPIETARIOS+
                " ("+Constantes.COLUMNA_CEDULA_PROPIETARIO+" long , "+
                Constantes.COLUMNA_NOMBRE_PROPIETARIO+" text,"+
                Constantes.COLUMNA_TELEFONO_PROPIETARIO+" long)";

        public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(crearTablaMascota);
            db.execSQL(crearTablaVacuna);
            db.execSQL(crearTablaPropietario);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists "+Constantes.NOMBRE_TABLA_MASCOTAS);
            db.execSQL(crearTablaMascota);
            db.execSQL("drop table if exists "+Constantes.NOMBRE_TABLA_VACUNAS);
            db.execSQL(crearTablaVacuna);
            db.execSQL("drop table if exists "+Constantes.NOMBRE_TABLA_PROPIETARIOS);
            db.execSQL(crearTablaPropietario);

        }
    }
