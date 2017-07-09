package com.example.pc.myapplication.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.pc.myapplication.R;
import com.example.pc.myapplication.RegistroMascota;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void registroMascotas(View v){
        Intent i = new Intent(this, RegistroMascota.class );
        startActivity(i);

    }
}
