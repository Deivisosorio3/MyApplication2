package com.example.pc.myapplication.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.myapplication.R;
import com.example.pc.myapplication.controlador.ControladorMascotas;
import com.example.pc.myapplication.controlador.ControladorPropietario;
import com.example.pc.myapplication.modelo.Mascota;
import com.example.pc.myapplication.modelo.Propietario;

public class RegistroMascota extends AppCompatActivity {
    ControladorPropietario controladorPropietario;
    ControladorMascotas controladorMascotas;
    Spinner tipo,raza,edad;
    EditText cedula,nombre,buscarP;
    TextView nombrePropietario,telefonoPropietario;
    Mascota mascota;
    Propietario propietario;
    String nombreP;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mascota);
        tipo=(Spinner)findViewById(R.id.spinner3);
        raza=(Spinner)findViewById(R.id.spinner2);
        edad=(Spinner)findViewById(R.id.spinner);
        cedula=(EditText)findViewById(R.id.editText2);
        nombre=(EditText)findViewById(R.id.editText);
        buscarP=(EditText)findViewById(R.id.editText3);
        nombrePropietario=(TextView)findViewById(R.id.nombrePropietario);
        telefonoPropietario=(TextView)findViewById(R.id.telefonoPropietario);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.Edad_Mascota,android.R.layout.simple_spinner_item) ;
        edad.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(this,R.array.RAZA,android.R.layout.simple_spinner_item) ;
        raza.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter2= ArrayAdapter.createFromResource(this,R.array.Tipo_de_mascota,android.R.layout.simple_spinner_item) ;
        tipo.setAdapter(adapter2);
        controladorMascotas=new ControladorMascotas(this);
        controladorPropietario =new ControladorPropietario(this);

    }







    public void buscarPropietario(View v){

        nombreP=buscarP.getText().toString();
        Log.e("nombreP", nombreP);
        propietario=controladorPropietario.consultarPropietario(nombreP);
        if (propietario == null){

            Toast.makeText(this, "El Propietario No Existe", Toast.LENGTH_SHORT).show();
        }else {

            nombrePropietario.setText(nombreP);
            telefonoPropietario.setText(String.valueOf(propietario.getTelefono()));
        }



    }
    public void registroMascota(View v){
        String cedulaMas=cedula.getText().toString();
        String nombreMas=nombre.getText().toString();
        int edadMas=Integer.parseInt(edad.getSelectedItem().toString());
        String tipoMas=tipo.getSelectedItem().toString();
        String razaMas=raza.getSelectedItem().toString();
        nombreP=buscarP.getText().toString();

        mascota=new Mascota(cedulaMas, nombreMas,tipoMas,edadMas,razaMas,nombreP);
        controladorMascotas.registrarMascota(mascota);
        if (mascota == null){

            Toast.makeText(this, " No Existe mascota", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "El Registro ha sido Exitoso", Toast.LENGTH_SHORT).show();
            telefonoPropietario.setText(String.valueOf(propietario.getTelefono()));
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }


    }


}
