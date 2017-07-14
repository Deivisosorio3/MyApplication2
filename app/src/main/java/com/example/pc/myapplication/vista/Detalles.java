package com.example.pc.myapplication.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.myapplication.R;
import com.example.pc.myapplication.controlador.ControladorVacuna;
import com.example.pc.myapplication.modelo.Vacuna;

import java.util.ArrayList;
import java.util.List;

public class Detalles extends AppCompatActivity {
    Vacuna vacuna;
    TextView nombre,fecha,dosis;
    ControladorVacuna controladorVacuna;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        nombre=(TextView)findViewById(R.id.txv_nombre_vacuna);
        fecha=(TextView)findViewById(R.id.txv_fecha);
        dosis=(TextView)findViewById(R.id.txv_dosis);

        controladorVacuna=new ControladorVacuna(Detalles.this);
        String nombreV=getIntent().getStringExtra("nombre");
        if (nombreV == null){
            Log.e("nombre fecha dosis", "Vacuna es nulo");
        }else {Log.e("nombre fecha dosis", nombreV);}

        vacuna=controladorVacuna.verDetalles(nombreV);

        if (vacuna ==null){
            Toast.makeText(this, "La Vacuna No Existe", Toast.LENGTH_SHORT).show();
        }else {


            nombre.setText(vacuna.getNombre());
            fecha.setText(vacuna.getFecha());
            dosis.setText(vacuna.getDosis());
        }

    }


}
