package com.example.pc.myapplication.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pc.myapplication.R;
import com.example.pc.myapplication.modelo.Propietario;
import com.example.pc.myapplication.modelo.Vacuna;

public class MainActivity extends AppCompatActivity {
Button regM,regVa,regPro,regis,sal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regM=(Button)findViewById(R.id.button6);
        regVa=(Button)findViewById(R.id.button3);
        regPro=(Button)findViewById(R.id.button4);
        sal=(Button)findViewById(R.id.button5);
        regis=(Button)findViewById(R.id.button2);
    }
    public void registroMascota(View v){
        Intent i = new Intent(this, RegistroMascota.class );
        startActivity(i);

    }
    public void registroVacuna(View v){
        Intent i = new Intent(this, RegistroVacuna.class );
        startActivity(i);

    }
    public void registroPropietario(View v){
       Intent i = new Intent(this,RegistroPropietario.class );
        startActivity(i);

    }
    public void detalles(View v){
        Intent i = new Intent(this, Detalles.class );
        startActivity(i);


    }

    public void reg(View v){
        Intent i = new Intent(this, Consultar.class );
        startActivity(i);

    }
    public void salir(View v){
        finish();
    }
}
