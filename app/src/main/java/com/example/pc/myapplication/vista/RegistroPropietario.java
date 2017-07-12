package com.example.pc.myapplication.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.myapplication.R;
import com.example.pc.myapplication.controlador.ControladorMascotas;
import com.example.pc.myapplication.controlador.ControladorPropietario;
import com.example.pc.myapplication.modelo.Mascota;
import com.example.pc.myapplication.modelo.Propietario;

public class RegistroPropietario extends AppCompatActivity {
    EditText cedula,telefono,nombre;
    ControladorPropietario controladorPropietario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_propietario);
        cedula=(EditText)findViewById(R.id.edt_cedula_propietario);
        telefono=(EditText)findViewById(R.id.edt_telefono_propietario);
        nombre=(EditText)findViewById(R.id.edt_nombre_propietario);
        controladorPropietario=new ControladorPropietario(this);

    }
    public void registrarPropietario(View v){
        Propietario p;
        long cedulaP=Long.parseLong(cedula.getText().toString());
        long telefonoP=Long.parseLong(telefono.getText().toString());
        String nombreP=nombre.getText().toString();

        p=new Propietario(cedulaP,nombreP,telefonoP);

        Log.e("nombre", p.getNombre());
        controladorPropietario.registrarPropietario(p);
        Toast.makeText(this, "El Registro ha sido Exitoso", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();


    }
}
