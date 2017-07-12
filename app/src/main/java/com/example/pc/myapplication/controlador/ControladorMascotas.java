package com.example.pc.myapplication.controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pc.myapplication.constantes.Constantes;
import com.example.pc.myapplication.modelo.DataBase;
import com.example.pc.myapplication.modelo.Mascota;

/**
 * Created by user on 09/07/2017.
 */

public class ControladorMascotas {
    private Mascota mascota;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private DataBase baseD;

    public ControladorMascotas(Context context) {
        this.context = context;
        baseD = new DataBase(context, Constantes.NOMBRE_BD, null, 1);
        sqLiteDatabase=baseD.getWritableDatabase();
    }
    public void registrarMascota(Mascota m){
        sqLiteDatabase= baseD.getWritableDatabase();
        String registro="insert into "+Constantes.NOMBRE_TABLA_MASCOTAS+"(cedula,nombre,tipo,edad,raza,nombre_p) values('"+ m.getCedula()+ "' ,'"+m.getNombre()+"','"+m.getTipo()+"'," +m.getEdad()+ " ,'"+m.getRaza()+"','"+m.getNombreP()+"')";
        sqLiteDatabase.execSQL(registro);
        sqLiteDatabase.close();

    }
    public Mascota consultarMascota(String cedula){
        sqLiteDatabase= baseD.getWritableDatabase();
        String consultar="select * from "+Constantes.NOMBRE_TABLA_MASCOTAS+" where "+Constantes.COLUMNA_CEDULA_MASCOTA+" ='"+cedula+"'";

        Cursor cursor=sqLiteDatabase.rawQuery(consultar,null);
        if (cursor.moveToFirst()){
            mascota=new Mascota(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getString(4),cursor.getString(5));
        }else {
            mascota=null;
        }
        sqLiteDatabase.close();
        return mascota;

    }

    public void eliminararMascota(String cedula){
        sqLiteDatabase= baseD.getWritableDatabase();
        String eliminar="delete from "+Constantes.NOMBRE_TABLA_MASCOTAS+" where "+Constantes.COLUMNA_CEDULA_MASCOTA+"=  '"+cedula+"'";
        sqLiteDatabase.execSQL(eliminar);
        sqLiteDatabase.close();

    }
}
