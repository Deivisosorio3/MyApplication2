package com.example.pc.myapplication.controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
        String registro="insert into "+Constantes.NOMBRE_TABLA_PROPIETARIOS +
                "("+Constantes.COLUMNA_CEDULA_PROPIETARIO+ " ,"+
                    Constantes.COLUMNA_NOMBRE_PROPIETARIO+"," +
                    Constantes.COLUMNA_TELEFONO_PROPIETARIO + ") values("+propietario.getCedula()+",'"+propietario.getNombre()+"',"+propietario.getTelefono()+")";
        sqLiteDatabase.execSQL(registro);
        sqLiteDatabase.close();
    }

    public ControladorPropietario(Context context) {
        this.context = context;
        baseD = new DataBase(context, Constantes.NOMBRE_BD, null, 1);

    }

    public Propietario consultarPropietario(String nombre){
        Log.e("nombre propietario", nombre);
        sqLiteDatabase= baseD.getWritableDatabase();
        String consultar="select * from "+Constantes.NOMBRE_TABLA_PROPIETARIOS+" where "+Constantes.COLUMNA_NOMBRE_PROPIETARIO+" ='"+nombre+"' ";

        Cursor cursor=sqLiteDatabase.rawQuery(consultar,null);

        if (cursor.moveToFirst()){
            Log.e("si hay", "registros");
            cursor.close();
        }else {
            Log.e("no hay", "registros");
            propietario = null;
        }

        sqLiteDatabase.close();
        return propietario;
    }
}
