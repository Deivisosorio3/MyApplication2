package com.example.pc.myapplication.controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pc.myapplication.constantes.Constantes;
import com.example.pc.myapplication.modelo.DataBase;
import com.example.pc.myapplication.modelo.Mascota;
import com.example.pc.myapplication.modelo.Vacuna;

/**
 * Created by user on 09/07/2017.
 */

public class ControladorVacuna {
    private Vacuna vacuna;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private DataBase baseD;

    public void registrarVacuna(Vacuna vacuna){
        sqLiteDatabase= baseD.getWritableDatabase();

        sqLiteDatabase.close();

    }
    public Vacuna consultarVacuna(String nombre){

        sqLiteDatabase= baseD.getWritableDatabase();
        String consultar="select * from "+Constantes.NOMBRE_TABLA_VACUNAS+" where "+Constantes.COLUMNA_NOMBRE_VACUNA+" ='"+vacuna.getNombre()+"'";
        sqLiteDatabase.close();
        Cursor cursor=sqLiteDatabase.rawQuery(consultar,null);
        if (cursor.moveToFirst()){
            vacuna=new Vacuna(cursor.getString(0),cursor.getString(1),cursor.getString(2));
        }else {
           vacuna=null;
        }


        sqLiteDatabase.close();
        return vacuna;
    }





    public ControladorVacuna(Context context) {
        this.context = context;
        DataBase baseD = new DataBase(context, Constantes.NOMBRE_BD, null, 1);
        sqLiteDatabase= baseD.getWritableDatabase();
        sqLiteDatabase.close();
    }
}
