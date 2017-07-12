package com.example.pc.myapplication.vista;

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

import java.util.Calendar;

import static com.example.pc.myapplication.R.id.telefonoPropietario;

public class RegistroVacuna extends AppCompatActivity {
    ControladorVacuna controladorVacuna;
    ControladorMascotas controladorMascotas;
    EditText cedulaMas, fecha, dosis, nombreVa;
    Vacuna vacuna;
    ArrayAdapter<String> adapter;
    ListView listaVacun;

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
        vacuna=new Vacuna(nombreV,fecha1,dosisV);

        controladorVacuna.registrarVacuna(vacuna);



    }

    public void consultarMascota(View v) {





    }



}
