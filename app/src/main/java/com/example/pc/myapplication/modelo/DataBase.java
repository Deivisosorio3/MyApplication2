package com.example.pc.myapplication.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 08/07/2017.
 */

public class DataBase {

    public class BaseDatos  extends SQLiteOpenHelper {

        String crearTablaMascota="create table mascota (cedula text , nombre text, edad int,raza text)";
        String crearTablaVacuna="create table vacuna (nombre text , nueVacuna text, edad int,fecha Date ,dosis text)";
        String crearTablaPropietario="create table propietario (cedula text , nombre text, telefono int)";

        public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
            db.execSQL("drop table if exists mascota");
            db.execSQL(crearTablaMascota);
            db.execSQL("drop table if exists vacuna");
            db.execSQL(crearTablaMascota);
            db.execSQL("drop table if exists propietario");
            db.execSQL(crearTablaPropietario);

        }
    }
}
