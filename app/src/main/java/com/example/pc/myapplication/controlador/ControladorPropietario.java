package com.example.pc.myapplication.controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pc.myapplication.constantes.Constantes;
import com.example.pc.myapplication.modelo.DataBase;
import com.example.pc.myapplication.modelo.Mascota;
import com.example.pc.myapplication.modelo.Propietario;
import com.example.pc.myapplication.modelo.Vacuna;

/**
 * Created by user on 09/07/2017.
 */

public class ControladorPropietario {
    private Propietario propietario;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private DataBase baseD;

    public void registrarPropietario(Propietario propietario){
        sqLiteDatabase= baseD.getWritableDatabase();
        String registro="insert into "+Constantes.NOMBRE_TABLA_PROPIETARIOS+"('"+Constantes.COLUMNA_CEDULA_PROPIETARIO+ "' ,'"+Constantes.COLUMNA_NOMBRE_PROPIETARIO+"'," +Constantes.COLUMNA_TELEFONO_PROPIETARIO+ "' ,'"+Constantes.COLUMNA_NOMBRE_MASCOTA+"') values('"+propietario.getCedula()+"','"+propietario.getNombre()+"','"+propietario.getTelefono()+"')";
        sqLiteDatabase.execSQL(registro);
        sqLiteDatabase.close();
    }

    public ControladorPropietario(Context context) {
        this.context = context;
        DataBase baseD = new DataBase(context, Constantes.NOMBRE_BD, null, 1);
        sqLiteDatabase= baseD.getWritableDatabase();
        sqLiteDatabase.close();
    }

    public Propietario consultarPropietario(String nombre){
        sqLiteDatabase= baseD.getWritableDatabase();
        String consultar="select * from "+Constantes.NOMBRE_TABLA_PROPIETARIOS+" where "+Constantes.COLUMNA_NOMBRE_PROPIETARIO+" ='"+propietario.getNombre()+"' ";
        sqLiteDatabase.close();
        Cursor cursor=sqLiteDatabase.rawQuery(consultar,null);
        if (cursor.moveToFirst()){
            propietario=new Propietario(cursor.getInt(0),cursor.getString(1),cursor.getInt(2));
        }else {

            propietario = null;
        }

        sqLiteDatabase.close();
        return propietario;
    }
}
