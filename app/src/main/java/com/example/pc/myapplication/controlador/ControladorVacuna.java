package com.example.pc.myapplication.controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pc.myapplication.constantes.Constantes;
import com.example.pc.myapplication.modelo.DataBase;
import com.example.pc.myapplication.modelo.Mascota;
import com.example.pc.myapplication.modelo.Vacuna;

import java.util.ArrayList;

/**
 * Created by user on 09/07/2017.
 */

public class ControladorVacuna {
    private Vacuna vacuna;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private DataBase baseD;
    Mascota mascota;

    public void registrarVacuna(Vacuna vacuna){
        sqLiteDatabase= baseD.getWritableDatabase();
        String registroVa="insert into "+Constantes.NOMBRE_TABLA_VACUNAS+" values (' "+vacuna.getNombre()+" ','"+vacuna.getFecha()+"','"+vacuna.getDosis()+"','"+vacuna.getNombre_m()+"')";
sqLiteDatabase.execSQL(registroVa);
        sqLiteDatabase.close();

    }
    public Vacuna verDetalles(String nombre){

        sqLiteDatabase= baseD.getWritableDatabase();
        String consultar="select * from "+Constantes.NOMBRE_TABLA_VACUNAS+" where "+Constantes.COLUMNA_NOMBRE_VACUNA+" ='"+nombre+"'";
        Cursor cursor=sqLiteDatabase.rawQuery(consultar,null);
        if (cursor.moveToFirst()){
            vacuna=new Vacuna(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        }else {
           vacuna=null;
        }


        sqLiteDatabase.close();
        return vacuna;
    }





    public  ArrayList<Vacuna> consultarTodasVacuna(String nombre) {
        ArrayList<Vacuna> vacunasT = new ArrayList<>();
        sqLiteDatabase = baseD.getWritableDatabase();
        String consultar = "select * from " + Constantes.NOMBRE_TABLA_VACUNAS + " where " + Constantes.COLUMNA_MASCOTA_VACUNA + " ='" + nombre + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(consultar, null);
        if (cursor.moveToFirst()) {
            do {
                vacunasT.add(vacuna = new Vacuna(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));

            } while (cursor.moveToNext());
        } else {
            vacuna = null;
        }


        sqLiteDatabase.close();
        return vacunasT;


    }
    public ControladorVacuna(Context context) {
        this.context = context;
         baseD = new DataBase(context, Constantes.NOMBRE_BD, null, 1);
        sqLiteDatabase= baseD.getWritableDatabase();
        sqLiteDatabase.close();
    }
}
