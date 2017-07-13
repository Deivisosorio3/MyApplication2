package com.example.pc.myapplication.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pc.myapplication.R;
import com.example.pc.myapplication.controlador.ControladorMascotas;
import com.example.pc.myapplication.controlador.ControladorVacuna;
import com.example.pc.myapplication.modelo.Mascota;
import com.example.pc.myapplication.modelo.Vacuna;

import java.util.ArrayList;
import java.util.Calendar;

import static com.example.pc.myapplication.R.id.telefonoPropietario;

public class RegistroVacuna extends AppCompatActivity {
    ControladorVacuna controladorVacuna;
    ControladorMascotas controladorMascotas;
    EditText cedulaMas, fecha, dosis, nombreVa;
    Vacuna vacuna;
    ArrayAdapter<String> adapter;
    ListView listaVacun;
    Mascota mascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        cedulaMas = (EditText) findViewById(R.id.edt_cedula_mascota);
        nombreVa = (EditText) findViewById(R.id.edt_nombre_vacuna);
        fecha = (EditText) findViewById(R.id.edt_fecha);
        dosis = (EditText) findViewById(R.id.edt_dosis);
        listaVacun=(ListView)findViewById(R.id.lista_vacuna);
        controladorVacuna=new  ControladorVacuna(this);
        controladorMascotas=new ControladorMascotas(this);
        Calendar calendar= Calendar.getInstance();

        CharSequence fechaAct= DateFormat.format("dd/mm/yyyy", calendar.getTime());
fecha.setText(fechaAct);

    }

    public void registroVacuna(View v) {

        String nombreV=nombreVa.getText().toString();
        String fecha1 = fecha.getText().toString();
        String dosisV = dosis.getText().toString();

        vacuna=new Vacuna(nombreV,fecha1,dosisV,mascota.getNombre());

        controladorVacuna.registrarVacuna(vacuna);
        Toast.makeText(this, "Vacuna Registrada Exitosamente", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();



    }

    public void consultarMascota(View v) {
        String cedulaM=cedulaMas.getText().toString();
        mascota=controladorMascotas.consultarMascota(cedulaM);
        if (mascota == null){

            Toast.makeText(this, " No Existe mascota", Toast.LENGTH_SHORT).show();
        }else {
            ArrayList<Vacuna>  vacunaTotal=controladorVacuna.consultarTodasVacuna(mascota.getNombre());
            if (vacunaTotal.size()>0){
                String[] vacu= new  String[vacunaTotal.size()];
                for (int f=0;f<vacu.length;f++){
                    vacu[f]=vacunaTotal.get(f).getNombre();
                }
                adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,vacu);
                listaVacun.setAdapter(adapter);

            }else {
                Toast.makeText(this, "No hay Vacunas Registradas", Toast.LENGTH_SHORT).show();
            }

        }





    }



}
